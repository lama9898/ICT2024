import { Navigate, Route, Routes, useNavigate } from "react-router-dom";
import Template from "./pages/template";
import Home from "./pages/home";
import Login from "./pages/login";
import Users from "./pages/users";
import UserProfile from "./pages/userProfile";

import BbsRoutes from "./pages/bbs/bbsRoutes";
import Photos from "./pages/photos";
import NotFound from "./pages/notFound";
import useFetch from "./hooks/useFetch";
import { AUTH_KEY, URL } from "./config/constants";
import { useEffect, useState } from "react";
import axios from "axios";
import dataFetch from "./utils/dataFetch";
/*
  [리액트에서 인증하기]
  1.아이디와 비번을 서버로 전송 이때 fetch나 axios와 같은 
    라이브러리를 사용하여 HTTP 요청

  2.서버는 사용자가 제출한 아이디와 비밀번호를 확인
    인증에 성공하면 JWT(JSON Web Token) 또는 세션 ID 
    와 같은 인증 토큰이나 사용자 아이디를 클라이언트로 반환
    회원이 아닌 경우는 null등 반환

  3.로그인 처리 : 클라이언트는 서버로부터 받은 토큰을 localStorage 또는 sessionStorage에 저장
    로그인 여부 판단 : localStorage 또는 sessionStorage 저장 여부 파악
    로그아웃처리 : localStorage 또는 sessionStorage 저장에 된 인증관련 데이타 삭제
  
  4.리액트 애플리케이션에서 전역으로 인증 상태를 State로 관리  
    즉 토큰이나 혹은 아이디를
    스테이트 값으로 하고 이를 사용하여 사용자의 인증 상태를 유지

  만약 사용자가 인증되지 않은 상태에서 인증이 필요한 라우트에 접근하려고
  하면 로그인 페이지로 리다이렉트
  (react-router-dom v6의 Navigate컴포넌트 혹은 redirect()함수 사용) 한다


*/

function App() {

  //0.로그인 처리후 화면 이동용(useNavigate는 항상 최상단에 위치시키자)
  const navigate= useNavigate();

  //1.모든 사용자 목록 가져오기:반환값은 [상태(사용자 목록),세터]형태이다
  const [users,setUsers] = useState([]);
  //const users = useFetch(URL.USERS);  //react-app-props-ver4

  //동기식(서버에서 받은데이터로 사용자 목록 state변경) 함수 정의
  async function fetchUsers(){
    const response = await dataFetch(URL.USERS);
    console.log('App.js- 사용자 목록:',users);
    //서버에서 받은 데이터로 사용자 상태 변경
    setUsers(response);
  }

  //위 동기 식 함수호출을 useEffect로(랜더링 어쩌구??)
  // useEffect는 return하면 안됨 => useFetch()를 {}로 감싸 return을 안시킴
  //useEffect(()=>useFetch(),[]);
  useEffect(()=>{fetchUsers()},[]);

  /*
  (App)사용자 목록: (2) [Array(0), ƒ] :App() 함수가 처음 호출되었을때(마운트 되었을때)
  (App)사용자 목록: (2) [Array(1), ƒ]: 서버로부터 데이타를 받아 State가 변경되서 리렌더링 즉 App() 다시 호출되서
  */
  console.log('(App.js)사용자 목록:',users);

  //2.로그인 상태를 Application State(전역)로 관리 - 세션 스토리지에서 로그인 정보 읽기
  //  즉 로그인(인증) 상태가 필요한 모든 하위 컴포넌트로 Props로 내린다
  //  Local State로 관리하면 안됨 즉 각 컴포넌트마다 로그인 상태가 다르다는 의미임으로..
  const [isAuth,setIsAuth] = useState(sessionStorage.getItem(AUTH_KEY.USERNAME));
  console.log('(App.js)isAuth:',isAuth);//비 로그인시 isAuth은 null
  //2-1.로그인 처리 함수
  const processAuth=(username,password)=>{
    console.log('사용자 입력 아이디:%s,비밀번호:%s',username,password);
    dataFetch(URL.USERS)
    .then(response=>{      
      console.log(response);

     
      if(response.length !=0){//회원이 1명 이상 있는 경우
        
         const user=response.filter(user=>user.username===username && user.password===password);
         console.log('user:',user);
         if(user.length === 1){//회원인 경우
            //로그인 처리:세션 스토리지에 'username'키로 사용자 아이디 저장
            sessionStorage.setItem(AUTH_KEY.USERNAME,username);
            //로그인 상태(State)를 아이디로 변경 
            setIsAuth(username);
            //{replace:true} 미 지정시 로그인 후 뒤로가기 클릭시 로그인 화면으로 이동한다
            //로그인 후 메인으로 이동
            //navigate('/',{replace:true});
            //로그인 후 상세 프로필로 이동
            navigate(`/users/${user[0].id}`,{replace:true});
          }
          else{
            window.alert('아이디와 비번 불일치');
          }
      }
      else{//회원이 없는 경우
        window.alert('가입한 회원이 없어요');
      }
    })
    .catch(error=>console.log(error));
  };

  //2-2.로그아웃 처리 함수
  const processLogout = ()=>{
      //세션 스토리지에 "username"이라는 키 삭제
      sessionStorage.removeItem(AUTH_KEY.USERNAME);
      //로그인 상태(State)를 null로 변경 
      setIsAuth(null);
  };


  return <>
    <Routes>
      {/*레이아웃용 컴포넌트(Template)를 부모로 */}
      <Route element={<Template users={users} isAuth={isAuth} processAuth={processAuth} processLogout={processLogout}/>}>
        <Route path="/" element={<Home/>}/>
        <Route path="/login" element={<Login/>}/>
        <Route path="/users" element={<Users/>}>
          <Route path=":id" element={<UserProfile/>}/>
        </Route>
        {/* 페이징 적용 버전 게시판 */}
        <Route path="/bbs/*" element={<BbsRoutes/>}/>

        <Route path="/photos" element={<Photos/>}/>
        {/*<Route path="*" element={<NotFound/>}/>*/}
        <Route path="*" element={<Navigate to="/" replace={true} />}/>
      </Route>
    </Routes>
  </>
}

export default App;
