import { Navigate, Route, Routes, useNavigate } from "react-router-dom";
import Template from "./pages/template";
import Home from "./pages/home";
import Login from "./pages/login";
import Users from "./pages/users";
import UserProfile from "./pages/userProfile";

import BbsRoutes from "./pages/bbs/bbsRoutes";
import Photos from "./pages/photos";
import NotFound from "./pages/notFound";

import { AUTH_KEY, URL, USERS } from "./config/constants";
import { useEffect, useReducer, useState } from "react";
import axios from "axios";
import dataFetch from "./utils/dataFetch";
import usersReducer from "./reducers/usersReducer";
import { UsersContext } from "./context/usersContext";

//※Application State를 useState()훅 함수가 아닌  
//  useReducer() 훅 함수를 사용해서 관리하자

const initialState={
  users:[],//모든 사용자 목록 저장
  isAuth:null,//로그인한 사용자 아이디 저장
  error:null//에러 저장
};

function App() {

  //0.로그인 처리후 화면 이동용(useNavigate는 항상 최상단에 위치시키자)
  const navigate= useNavigate();

  //1.initialState를 State로 관리하기 위한 리듀서 생성
  const [usersInfo,dispatch] = useReducer(usersReducer,initialState);

  //2.모든 사용자 목록 가져오기
  //동기식(원격에서 받은 데이타로 사용자 목록 State변경)함수 정의 
  async function fetchUsers(){
    try{
      const response = await dataFetch(URL.USERS);   
      console.log('(App.js)사용자 목록:',usersInfo.users);
      //원격에서 받은 데이터로 사용자 목록 스테이트를 변경하기 위해 
      //dispatch({액션})호출
      dispatch({type:USERS.ALL,users:response,isAuth:sessionStorage.getItem(AUTH_KEY.USERNAME)});
    }
    catch(e){
      dispatch({type:USERS.ERROR,error:e});
    }    
  }
  //위 동기식 함수 호출 
  useEffect(()=>{fetchUsers()},[]);

  //2-1.로그인 처리 함수
  const processAuth=(username,password)=>{
    console.log('사용자 입력 아이디:%s,비밀번호:%s',username,password);   
    dataFetch(URL.USERS)
    .then(response=>{      
        
      if(response.length !=0){//회원이 1명 이상 있는 경우        
         const user=response.filter(user=>user.username===username && user.password===password);
         
         if(user.length === 1){//회원인 경우
            //로그인 처리:세션 스토리지에 'username'키로 사용자 아이디 저장
            sessionStorage.setItem(AUTH_KEY.USERNAME,username);
            //로그인 상태 변경하기 위해 dispatch({액션})호출
            dispatch({type:USERS.LOGIN,isAuth:username});
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
      //로그인 상태 null로 변경하기위해 dispatch호출
      dispatch({type:USERS.LOGOUT});
  };


  return <>
    <UsersContext.Provider value={{usersInfo,processAuth,processLogout}}>
      <Routes>
        {/*레이아웃용 컴포넌트(Template)를 부모로 */}
        <Route element={<Template/> }>
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
    </UsersContext.Provider>
  </>
}

export default App;
