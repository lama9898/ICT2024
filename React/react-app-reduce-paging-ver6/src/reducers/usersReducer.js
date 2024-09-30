
//리듀서(사용자 정의 함수)의 목적은 State변경
//리듀서:현재 State를 인자로 받아 dispatch가 전달하는 action의 type(요청 종류)에 따라 
//State를 변경해서 새로운 State를 반환 한다

import { USERS } from "../config/constants";

//action은 {type:'all',users:[{},{},...]....}혹은 {type:'login',...} 형태다
const usersReducer =(state,action)=>{

    switch(action.type){
        case USERS.ALL://모든 사용자 목록 
            //isAuth추가:로그인 한 경우 새로 고침시 로그아웃(즉 State가 초기화되서) 
            return {...state,users:action.users,isAuth:action.isAuth};
        case USERS.LOGIN://로그인 처리
            return {...state,isAuth:action.isAuth};
        case USERS.LOGOUT://로그 아웃 처리
            return {...state,isAuth:null};
        case USERS.ERROR://에러 발생시
            return {...state,error:action.error};
        default:
            throw new Error(`존재하지 않는 액션 타입입니다:${action.type}`);
    }
};
export default usersReducer;