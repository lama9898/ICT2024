import { Link, useNavigate, useOutletContext, useParams } from "react-router-dom"
import useFetch from "../../hooks/useFetch";
import { URL } from "../../config/constants";
import axios from "axios";
import React, { useEffect, useState } from "react";
import Loading from "../../components/loading";
import Error_ from "../../components/error";
import { toBeVisible } from "@testing-library/jest-dom/matchers";

/*
비동기 데이타 JSX에 뿌려주기

JSX1. 뿌려줄 데이타를 State로 설정한다 
    const [data,setData]=useState(null);
JSX2.useEffect(()=>{비동기 코드},[]);로 마운트시 콜백(()=>{비동기 코드})을 한번 만 호출
JSX3.비동기 코드에서 원격(REST API)에서 받은 데이타(data)를 
  State의 세터(setData)로 변경한다
  
    비동기 코드 예(REST API로 데이타를 받는 함수)
    const fetchData=async ()=>{
        const res=await axios.get(URL);
        setData(prevState=>{res.data속성으로 스테이트 변경});
    };
    //비동기 함수 호출 즉 마운트 될때 REST API에서 데이터 받는후
    //State를 변경함으로 리 렌터디링이 일어난다
    fetchData();
JSX4. 1번에서 설정한 State인 data로 JSX에 뿌려준다
*/

export default function View({deleteBbs}){
    
    //수정/삭제/목록 버튼 클릭시 이동을 위한 훅 함수
    const navigate = useNavigate();
    //1.URL파라미터로 넘어오는 게시글의 키(id)값 받기
    const params = useParams();
    console.log('(view.js)params:',params);

    //2. 모든 사용자 목록을 컨텍스트에서 가져오기
    const {users} = useOutletContext();     
    //3.id에 해당하는 글 읽어 오기 
    //JSX1
    const [bbs,setBbs] = useState(null);    
    //※로딩 화면은 데이타가 많거나 비동기 요청이 여러 개인 경우 주로 사용
    const [loading,setLoading] = useState(true);
    const [error,setError] = useState(null);
    //JSX2
    useEffect(()=>{
        //JSX3
        const fetchBbs = async () => {
            try{

                //Error_컴포넌트 테스트를 위한 강제 에러 발생
                //throw new Error('에러가 발생했어요(테스트용)');

                const response=await axios.get(`${URL.BBS}/${params["id"]}`);
                const bbsById = response.data;
                console.log('bbsById:',bbsById);
                console.log('(view.js)사용자 목록:',users);
                //게시글을 작성한 사용자 정보 가져오기
                const userByUsername=users.filter(user=>user.username===bbsById.username);
                console.log('글 작성자:',userByUsername[0]);
                //사용자 아이디 대신 사용자 이름을 뿌려주기위해
                //bbsById에 name키로 사용자 이름을 추가해서 변경
                setBbs(prevState=>({...bbsById,name:userByUsername[0].name}));
                setLoading(false);
            }
            catch(err){
                console.log(err);
                setError(err);
                setLoading(false);
            }
        };
        fetchBbs();
    },[]);     
   
    //로딩 화면 보여주기
    if(loading) return <Loading/>;
    //에러 발생시 에러 내용 보여주기
    if(error) return <Error_ error={error.message}/>
    return <>
        
        <div className="p-5 bg-warning text-white rounded">
            <h1>
                게시판 상세
            </h1>
        </div>
        {/* bbs는 마운트시 null 즉 마운트때 데이타 요청후
            받은 데이타와 name키를 추가해서 스테이트 변경(리렌더링)
        */}
        {bbs && (<><table className="table table-bordered mt-3">
            <tbody>
                <tr>
                    <th className="w-25 text-center bg-dark text-white">번호</th>
                    <td>{bbs.id}</td>                    
                </tr>
                <tr>
                    <th className="w-25 text-center bg-dark text-white">글쓴이</th>
                    <td>{bbs.name}</td>                    
                </tr>
                <tr>
                    <th className="w-25 text-center bg-dark text-white">작성일</th>
                    <td>{bbs.postDate}</td>                    
                </tr>
                <tr>
                    <th className="w-25 text-center bg-dark text-white">제목</th>
                    <td>{bbs.title}</td>                    
                </tr>
                <tr>
                    <th className="w-25 text-center bg-dark text-white">조회수</th>
                    <td>{bbs.views}</td>                    
                </tr>
                <tr>
                    <th className="text-center bg-dark text-white" colSpan="2">내용</th>
                               
                </tr>
                <tr>
                    {/*
                    ※https://reactjs.org/docs/dom-elements.html
                      XSS공격을 막기 위해 코드로 '\n'을 '<br/>'문자열로 변경시 
                      태그가 아닌 문자열로 렌더링
                      즉 <td colSpan="2">내용입니다1{"<br/>"}내용입니다2</td>
                    */}
                    {/*<td colSpan="2">내용입니다1{"<br/>"}내용입니다2</td>*/}
                    {/*
                    줄바꿈이 일어나지 않고 태그가 그대로 브라우저에 보인다
                    내용입니다1<br/>내용입니다2
                    */}
                    {/*<td colSpan="2">{bbs.content.replace('\n','<br/>')}</td>*/}
                    {/*
                     줄바꿈이 일어나지 않고 객체 주소가 그대로 브라우저에 보인다
                     내용입니다1[object Object]내용입니다2
                    */}
                    {/*<td colSpan="2">{bbs.content.replace('\n',<br/>)}</td>*/}
                    {/* 
                     해결책)줄바꿈이 일어난다
                     즉 <br/> JSX컴포넌트를 그대로 반환해야 한다
                     예:
                     Step1)"내용1\n내용2"를 \n으로 분리(즉 배열로 만든다)
                     Step2)배열에 맵을 적용해서 문자열<br/>문자열 형태로 변형한다   
                    */}
                    {/*<td colSpan="2">내용입니다1<br/>내용입니다2</td>*/}
                    <td colSpan="2">{bbs.content && bbs.content.split('\n').map((element,index)=><React.Fragment key={index}>{element}<br/></React.Fragment>)}</td>
                </tr>
            </tbody>
        </table>
        <div className="text-center">
            {/* 
            수정폼 컴포넌트에서 URL파라미터로 받은 게시글 아이디로 
            해당 글을 가져와도 되지만
            navigate()함수의 두번째 인자에 현재 게시글을 전달하자
            
            */}
            <button className="btn btn-success" onClick={()=>navigate(`/bbs/form/${bbs.id}`,{state:bbs})}>수정</button>
            <button className="btn btn-success mx-2" onClick={()=>{
                //※JSX에서 confirm()을 사용시에는 반드시 앞에 window객체를 붙인다
                if(window.confirm('정말로 삭제 하시겠습니까?')) deleteBbs(bbs.id);
            }}>삭제</button>
            <button className="btn btn-success" onClick={()=>navigate('/bbs')}>목록</button>
            <Link to="/bbs" className="btn btn-warning ms-2">목록</Link>
        </div></>)
        }
    </>
}