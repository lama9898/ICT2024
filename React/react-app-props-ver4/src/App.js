import { Navigate, Route, Routes, useNavigate } from 'react-router-dom';
import Template from './pages/template';
import Home from './pages/home';
import Login from './pages/login';
import Users from './pages/users';
import UserProfile from './pages/userprofile';
import List from './pages/board/list';
import BoardRoute from './pages/board/boardRoute';
import Photos from './pages/photos';
import NotFound from './pages/notFound';
import useFetch from './hooks/useFetch';
import { AUTH_KEY, URL } from './config/constants';
import { useState } from 'react';
import axios from 'axios';
/*
  1.아이디와 비번을 서버로 전송
    이 때 fetch나 axios와 같은 라이브러리를 사용하여 HTTP 요청

  2.서버는 사용자가 제출한 아이디와 비밀번호를 확인
    인증에 성공하면 JWT(JSON Web Token) 또는 세션 ID와 같은 인증 토큰이나 사용자 아이디를 클라이언트로 반환

  (인증처리=로그인처리)
  3.클라이언트는 서버로부터 받은 토큰을 localStorage 또는 sessionStorage에 저장 
    인증 여부 판단 : localStorage 또는 sessionStorage 저장 여부 파악
    로그아웃 처리 : storage 저장된 인증관련 데이터(토큰 등) 삭제

  4.리액트 애플리케이션에서 전역으로 인증 상태를 State로 관리  즉 토큰을 스테이트 값으로 하고 이를 사용하여 사용자의 인증 상태를 유지
    만약 사용자가 인증되지 않은 상태에서 인증이 필요한 라우트에 접근하려고 하면 로그인 페이지로 리다이렉트한다
    (redirect : react-router-dom v6 Navigate 컴포넌트 / redirect 함수 사용 한다)
*/

function App() {

  // 0. 로그인 처리 후 화면 이동용(useNavigate는 항상 최상단에 위치시키자)
  const navigate = useNavigate();

  // 1. 모든 사용자 목록 가져오기: 반환값은 [상테(사용자 목록),세터] 형태이다
  const users = useFetch(URL.USERS,[]);  //[] 생략가능(기본값으로 넣어줫으니까)
  console.log('(App.js) 사용자 목록:',users );
  // state 변경되면서 리랜더링 => promise를 반환하게 해주어 그 안에서 콘솔 찍게 하기
  //  (App.js) 사용자 목록: (2) [Array(0), ƒ] : App() 함수가 처음 호출되었을때(마운트 되었을때)
      // 기다리지 않고 바로 콘솔이 실행되기때문에
  //  (App.js) 사용자 목록: (2) [Array(1), ƒ] : 서버로부터 데이터를 받아 state가 변경되면서 리랜더링(App 다시 호출)

  // 2. 로그인 상태를 application state(전역으로)로 관리 - 세션 스토리지에서 로그인 정보 읽기
  //  즉 로그인 상태(인증)가 필요한 모든 하위 컴포넌트로 props로 내리기
  //  Local state로 관리하면 안됨, 즉 각 컴포넌트마다 로그인 상태가 다르다는 의미
  const [isAuth,setIsAuth] = useState(sessionStorage.getItem(AUTH_KEY.USERNAME));
  console.log('(App.js)Login:',isAuth);  //비 로그인 시: null

  // 2-1. 로그인 처리 함수
  const processAuth=(username,password)=>{
    console.log('로그인 처리 함수 호출');
    console.log(username,password);
    axios
    //.post(URL.USERS,{username,password})
      .get(URL.USERS)
      .then(response=>{
        console.log(response);
        if(response.data.length!=0){ // 회원이 있는 경우
          const user = response.data.filter(user=>user.username===username && user.password===password);
          console.log('user:',user);
          if(user.length!==0){  //회원
            //회원 -> 로그인 처리 : 세션스토리지에 'username'키로 사용자 아이디 저장
            sessionStorage.setItem(AUTH_KEY.USERNAME,username);
            setIsAuth(username);
            //navigate('/',{replace:true}); //replace 미 지정시 로그인 후 뒤로가기 클릭시 다시 로그인 화면으로 이동
            navigate(`/users/${user[0].id}`,{replace:true});
          }
          else{
            //회원 불일치
            window.alert('아이디와 비번 불일치');
          }
        }
        else{
          //회원 X
          window.alert('없는 아이디');
        }
        
      })
      .catch(error=>console.log(error));
  }

  // 2-2. 로그아웃 처리 함수
  const processLogout = ()=>{
    //세션 스토리지에 "username"이라는 키 삭제
    sessionStorage.removeItem(AUTH_KEY.USERNAME);
    //로그인 상태를 null로
    setIsAuth(null);

  }

  return <>
    <Routes>
      {/* 레이아웃용 컴포넌트를 부모로 */}
      <Route element={<Template users={users} isAuth={isAuth} processAuth={processAuth} processLogout={processLogout}/>}>
        <Route path="/" element={<Home/>} ></Route>
        <Route path="/login" element={<Login/>} ></Route>
        <Route path='/users' element={<Users/>}>
          <Route path=':id' element={<UserProfile/>} />
        </Route>
        {/* 방법1. 게시글 목록으로 바로 라우팅 */}
        {/* <Route path="/board" element={<List/> } /> */}
        {/*  */}
        {/* 방법2. 게시글 관련 컴포넌트들의 컴포넌트를 생성 -> 별도의 라우팅용 컴포넌트를 생성해서 라우팅시키기 */}
        {/* 즉 App의 하위 컴포넌트인 BoardRoute에서 라우팅 설정
          ★★ 이때는 path 속성에 /특정url패턴/* 로 설정해야한다.
        */}
        <Route path="/board/*" element={<BoardRoute/>}/>
        <Route path="/photos" element={<Photos/>}/>
        {/* <Route path="*" element={<NotFound/>} /> */}
        <Route path="*" element={<Navigate to="/" />} />
      </Route>
    </Routes>
  </>
}

export default App;
