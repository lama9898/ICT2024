//페이징 적용 버전
//페이징 구현하기
//React Pagination Component.
//https://www.npmjs.com/package/rc-pagination
//index.js에 import 'rc-pagination/assets/index.css';추가

import { Navigate,  Route, Routes, useNavigate } from "react-router-dom"
import List from "./list";
import Form from "./form.js";
import View from "./view.js";
import {AUTH_KEY, BBS, URL} from "../../config/constants.js";
import axios from "axios";
import EditForm from "./editForm.js";
import { useEffect, useReducer, useState } from "react";
import dataFetch from "../../utils/dataFetch.js";
import bbsReducer from "../../reducers/bbsReducer.js";
import BbsContext from "../../context/bbsContext.js";

const initialState={
    loading:true,
    bbsPaging:[],
    totalSize:0,
    nowPage:1
}

const BbsRoutes =()=>{

    //0.게시글 등록/수정/삭제 처리후 이동을 위한 useNavigate()훅 함수 객체 생성    
    const navigate = useNavigate();

    // 1.useReducer로 state관리
    const [bbsInfo,dispatch] = useReducer(bbsReducer,initialState);
    const pageSize=3;;//페이지당 보여줄 글 갯수
    const {totalSize,nowPage} = bbsInfo;


    //함수 정의
    const fetchPagingBbs = async ()=>{
        const response=await dataFetch(`${URL.BBS}?_sort=-id&_page=${nowPage}&_per_page=${[pageSize]}`);
        dispatch({type:BBS.PAGING_ALL,bbsPaging:response.data})
    };
    //함수 호출
    useEffect(()=>{
        fetchPagingBbs();       
    },[nowPage]);

    //2.총 글수 설정하기
    //※글 등록하거나 삭제시 총 글수를 다시 업데이트 하기 위함
    useEffect(()=>{
        dataFetch(`${URL.BBS}`)
        .then(res=>{
            console.log('총 글수:',res.length);
            //총 글수 State 변경
            dispatch({type:BBS.TOTAL_SIZE,totalSize:res.length});
        })
        .catch(e=>console.log(e));
    },[bbsPaging]);
    

    //3.게시글 등록 함수-Form 컴포넌트로 Props로 내린다
    const createBbs=(title,content)=>{
        //등록 데이타       
        dataFetch(`${URL.BBS}?_sort=-id`)
        .then(res=>{
            let id = res.length !==0 ?Math.max(...res.map(bbs=>bbs.id))+1  : 1;
            id=id.toString();//반드시 문자열로 변환(JSON-SERVER 사용시)
            console.log('게시글의 다음 글 번호:',id);
            const username=sessionStorage.getItem(AUTH_KEY.USERNAME);
            const date = new Date();                 
            const postDate = `${date.getFullYear()}-${date.getMonth()+1}-${date.getDate()}`;
            //글 등록
            axios
            .post(URL.BBS,{id,title,content,username,postDate,views:0})
            .then(res=>{ 

                //글 등록후 1페이지에 해당하는 데이타 가져오기
                dataFetch(`${URL.BBS}?_sort=-id&_page=1&_per_page=${pageSize}`)     
                .then(res=>{
                    //페이징 데이타 스테이트 변경       
                    setBbsPaging(res.data);
                    dispatch({type:BBS.WRITE,bbsPaging:res.data});
                })
                .catch(e=>console.log(e))                
                dispatch({type:BBS.NOWPAGE,nowPage:1})
                //등록 후 목록으로 이동           
                navigate('/bbs');
                
            })
            .catch(e=>console.log(e));
        })
        .catch(e=>console.log(e));       
    };
     
    //3.게시금 수정 함수:EditForm 컴포넌트로 내린다
    const updateBbs=(bbs)=>{
       //※반드시 id로 전달해야 JSON-SERVER가 요청을 받아 수정한다
       //https://www.npmjs.com/package/json-server
       //PUT /posts/:id
       axios
       .put(`${URL.BBS}/${bbs.id}`,bbs)//JSON-SERVER가 data.json에서 게시글 수정
       .then(res=>{ 
            //※수정시는 배열의 map()함수로 수정 안해도 ㄱㅊ, 대신 bbs전달해서 다시 fetch하기
            //setBbsPaging(prevState=>prevState.map(prevBbs=>prevBbs.id===bbs.id?{...prevBbs,title:bbs.title,content:bbs.content} : prevBbs));
            //수정후 상세보기로 이동
            const updateBbsPaging = bbsInfo.bbsPaging.map(prevBbs=>prevBbs.id ===bbs.id?{...prevBbs,title:bbs.title, content:bbs.content}:prevBbs);
            dispatch({type:BBS.UPDATE,bbsPaging:[...updateBbsPaging]})
            navigate(`/bbs/${bbs.id}`);
       })
       .catch(e=>console.log(e));
    };

    //4.게시글 삭제 함수:View컴포넌트로 내린다
    const deleteBbs =(id)=>{
        axios
        .delete(`${URL.BBS}/${id}`)
        .then(res=>{
            //삭제후 총 페이지 수 구하기
            const totalSizeAfterDelete = totalSize-1;
            const totalPage = Math.ceil(totalSizeAfterDelete/pageSize);
            let newNowpage=0;
            //삭제후 현재 페이지 번호 얻기
            if(totalPage < nowPage){
                newNowpage = totalPage;
            }
            else{
                newNowpage = nowPage;
            }

            dataFetch(`${URL.BBS}?_sort=-id&_page=${newNowpage}&_per_page=${pageSize}`)
            .then(res=>{dispatch({type:BBS.DELETE, bbsPaging:res.data})})
            .catch(e=>console.log(e));
            //삭제후 목록로 이동
            navigate(`/bbs`); 
        })
        .catch(e=>console.log(e));
    };

    //※List컴포넌트에 페이징과 관련된 값들을 List컴포넌트에 내린다
    //  setNowPage는 List컴포넌트에서 페이지 번호 누를때 nowPage 스테이트를 변경하기 위함
   
    return <>
    <BbsContext.Provider value={{bbsInfo, pageSize, dispatch,createBbs,updateBbs,deleteBbs}} >
        {/* 게시글과 관련된 컴포넌트로 라우팅*/}
        <Routes>
            {/* path=""는 /bbs와 같다 */}
            <Route path="" element={<List />}/>
            {/* 입력폼으로 라우팅 */}
            <Route path="/form" element={<Form/>}/>
            {/* 수정폼으로 라우팅 */}
            <Route path="/form/:id" element={<EditForm/>}/>
            {/* 상세보기로 라우팅 */}
            <Route path="/:id" element={<View/>}/>
            {/* 위 URL패턴에 해당하지 않은 경우 List 컴포넌트로 리다이렉션*/}
            <Route path="*" element={<Navigate to="" replace={true}/>}/>
        </Routes>
    </BbsContext.Provider>
    </>
};
export default BbsRoutes;