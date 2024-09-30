//페이징 적용 버전
//페이징 구현하기
//React Pagination Component.
//https://www.npmjs.com/package/rc-pagination
//index.js에 import 'rc-pagination/assets/index.css';추가

import { Navigate,  Route, Routes, useNavigate } from "react-router-dom"
import List from "./list";
import Form from "./form.js";
import View from "./view.js";
import useFetch from "../../hooks/useFetch.js";
import {AUTH_KEY, URL} from "../../config/constants.js";
import axios from "axios";
import EditForm from "./editForm.js";
import { useEffect, useState } from "react";
import dataFetch from "../../utils/dataFetch.js";
const BbsRoutes =()=>{

    //0.게시글 등록/수정/삭제 처리후 이동을 위한 useNavigate()훅 함수 객체 생성    
    const navigate = useNavigate();
    //1.페이징시 보여줄 글 수 만큼 가져오기
    const pageSize =2; //페이지당 보여줄 글 갯수
    const [totalSize,setTotalSize] = useState(0);   //총 글수
    const [nowPage,setNowPage] = useState(1);   //현재 페이지
    // _page=페이지번호&_per_page=한페이지에 보여줄 글수
    // 페이징 구현시에는 마운트 될때 그리고 페이지 번호(nowPage)가 변할때마다 글 가져오기(의존성 배열:[nowPage])
    // 페이징 미 구현시에는 마운트 될때만 전체 목록 가져오기(의존성 배열:[]) 
    
    const[bbsPaging,setBbsPaging] = useState([]);


    /*
        페이징 구현을 위해 글 목록 요청 시 URL의 쿼리스트링에
        _limit은 [{},{},{},...] 형태로 반환됨
        _per_page는
            {
                "first": 1,
                "prev": null,
                "next": 2,
                "last": 2,
                "pages": 2,
                "items": 4,
                "data": [{},{},{},...]
            }형태이다.
            즉 글 목록을 가져올때는 "data"키로 접근.
            dataFetch()함수에서 res.data로 반환하자
    */

    const fetchPagingBbs = async()=>{
        const response = await dataFetch(`${URL.BBS}?_sort=-id&_page=${nowPage}&_per_page=${pageSize}`);
        setBbsPaging(prevState=>[...response.data]);
    }
    //함수호출

    useEffect(()=>{
        fetchPagingBbs();
    },[nowPage]);

    // 2. 총 글수 설정하기
    // 글 등록하거나 삭제 시 총 글수를 다시 업데이트
    useEffect(()=>{
        dataFetch(`${URL.BBS}`)
        .then(res=>{
            console.log('총 글수:',res.length);
            //총 글수 state변경
            setTotalSize(res.length);
        })
        .catch(err=>console.log(err));
    },[bbsPaging]);

    //※JSON-SERVER는 id를 if missing, 자동으로 랜덤하게 생성해 준다.
    //단,문자열이라 정렬시 문제가 된다(문자열을 순차적으로 비교한다)

    //3.게시글 등록 함수-Form 컴포넌트로 Props로 내린다
    const createBbs=(title,content)=>{
        //등록 데이타       
        //※최신 버전의 JSON-SERVER의 id는 문자열이다.
        //  반드시 문자열로 변환해줘야 
        //  GET /posts/:id 요청시 404 에러(Not Found)가 안난다

        //let id = bbsAll.length !==0 ?Math.max(...bbsAll.map(bbs=>bbs.id))+1  : 1;
        dataFetch(`${URL.BBS}?_sort=-id`)
        .then(res=>{
            let id = res.length !==0 ?Math.max(...res.map(bbs=>bbs.id))+1  : 1;
            id=id.toString();//반드시 문자열로 변환(JSON-SERVER 사용시)
        
            console.log('게시글의 다음 글번호:',id);
            const username=sessionStorage.getItem(AUTH_KEY.USERNAME);
            const date = new Date();   
                
            const postDate = `${date.getFullYear()}-${date.getMonth()+1}-${date.getDate()}`;
            //글 등록
            axios
            .post(URL.BBS,{id,title,content,username,postDate,views:0})
            .then(res=>{
                //글 등록후 1페이지에 해당하는 데이터 가져오기
                dataFetch(`${URL.BBS}?_sort=-id&_page=1&_per_page=${pageSize}`)
                .then(res=>{
                    //다시 paging 데이터 state를 변경해줘야함
                    setBbsPaging(res.data);
                    //현재 페이지 번호 state변경
                    setNowPage(1);
                })
                .catch(e=>console.log(e))
   
                //※등록시는 배열의 concat()함수 혹은 전개 연산자(...)로 새로운 글 추가            
                
                //등록 후 목록으로 이동           
                navigate('/bbs');

                //※State 미 변경시 등록후 목록으로 이동하더라도
                //  등록된 글이 보이지 않는다
                //  data.json은 JSON-SERVER에 의해 등록 처리 되어 있다
                //  State를 변경해야 리 렌더링이 일어나 등록된 글이 반영 된다
                //  그래서 반드시 State를 변경 해줘야 한다
            })
            .catch(e=>console.log(e));
        })
        .catch(e=>console.log(e));

        
    };
     
    //4.게시금 수정 함수:EditForm 컴포넌트로 내린다
    const updateBbs=(bbs)=>{
       //※반드시 id로 전달해야 JSON-SERVER가 요청을 받아 수정한다
       //https://www.npmjs.com/package/json-server
       //PUT /posts/:id
       axios
       .put(`${URL.BBS}/${bbs.id}`,bbs)//JSON-SERVER가 data.json에서 게시글 수정
       .then(res=>{            
            //※수정시는 배열의 map()함수로 수정
            //setBbsPaging(prevState=>prevState.map(prevBbs=>prevBbs.id===bbs.id?{...prevBbs,title:bbs.title,content:bbs.content} : prevBbs));
            //수정후 상세보기로 이동
            navigate(`/bbs/${bbs.id}`);
       })
       .catch(e=>console.log(e));
    };

    //5.게시글 삭제 함수:View컴포넌트로 내린다
    const deleteBbs =(id)=>{
        axios
        .delete(`${URL.BBS}/${id}`)
        .then(res=>{
            const totalSizeAfterDelete = totalSize-1;
            const totalPage = Math.ceil(totalSizeAfterDelete/pageSize);
            let newNowpage = 0;
            //삭제 후 현재 페이지 번호 얻기
            if(totalPage<nowPage){
                newNowpage=totalPage;
            }
            else newNowpage = nowPage;
            setNowPage(newNowpage);
            dataFetch(`${URL.BBS}?_sort=-id&_page=${newNowpage}&_per_page=${pageSize}`)
            .then(res=>{setBbsPaging(res.data)})
            .catch(err=>console.log(err))
            //삭제후 목록로 이동
            navigate(`/bbs`); 
        })
        .catch(e=>console.log(e));
    };

    //리스트 컴포넌트에 페이징과 관련된 값들을 list컴포넌트에 내린다.
    //setNowpage는 list컴포넌트에서 페이지 번호를 누를 때 nowPage 스테이트를 변경하기 위해

   
    return <>
        {/* 게시글과 관련된 컴포넌트로 라우팅*/}
        <Routes>
            {/* path=""는 /bbs와 같다 */}
            <Route path="" element={<List bbsPaging={bbsPaging} pagingData={{pageSize,totalSize,nowPage,setNowPage}} />}/>
            {/* 입력폼으로 라우팅 */}
            <Route path="/form" element={<Form createBbs={createBbs}/>}/>
            {/* 수정폼으로 라우팅 */}
            <Route path="/form/:id" element={<EditForm updateBbs={updateBbs}/>}/>
            {/* 상세보기로 라우팅 */}
            <Route path="/:id" element={<View deleteBbs={deleteBbs}/>}/>
            {/* 위 URL패턴에 해당하지 않은 경우 List 컴포넌트로 리다이렉션*/}
            <Route path="*" element={<Navigate to="" replace={true}/>}/>
        </Routes>
    </>
};
export default BbsRoutes;