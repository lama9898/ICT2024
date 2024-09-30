/* 
    useContext_.js와 동일한 UI
    단, cretaeUser.js만 callback폴더 생성해서 useCallback()훅함수 테스트
    createUser.js에 나이에 따른 성일/미성년자 판별 UI<span> 컴포넌트 추가하자

*/

import { useReducer } from "react";
import Header from "./components/context/header";
import Users from "./components/context/users";
import { UsersContext } from "./components/context/usersContext";
import CreateUserState from "./components/callback/createUserState";

const initialState={
    count:2,
    users:[
      {id:1,username:'가길동',age:20},
      {id:2,username:'나길동',age:30}
    ]
};

const usersReducer =(state,action)=>{
    console.log('state:',state);
    switch(action.type){
        case 'CREATE':
            return {count:state.count+1,users:[{...action.payload},...state.users]};
        case "DELETE":
            return {count:state.count-1,users:state.users.filter(user=>user.id !=action.id)};
        default:
            return state;
    }

};

function getNextId(users){
    if(users.length==0) return 1;
    const ids = users.map(user=>user.id);
    return Math.max(...ids)+1;
}

export default function UseCallback_(){
    const [usersInfo,dispatch] = useReducer(usersReducer,initialState);
    const nextId = getNextId(usersInfo.users);

    return <>
        <UsersContext.Provider value={{usersInfo,dispatch,id:nextId}}>
            <Header/>
            {/* useMemo 훅 함수 불필요 */}
            {/* CreateUserNoState */}
            {/* useMemo 훅 함수 필요 */}
            <CreateUserState/>
            <Users/>
        </UsersContext.Provider>
    </>
}