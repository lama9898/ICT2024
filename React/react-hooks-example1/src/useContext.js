import { useContext, useReducer } from "react";
import CreateUser from "./components/context/createUser";
import Header from "./components/context/header";
import Users from "./components/context/users";
import { UsersContext } from "./components/context/usersContext";

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

function UseContext_(){
    // 하위 컴포넌트에서는 useContext(context객체) 훅 함수 호출로 데이터를 받는다(props 미사용)
    const [usersInfo,dispatch] = useReducer(usersReducer,initialState);
    // 현재 컴포넌트는 useContext() 훅 함수 호출 의미가 없다
    // => 현재 컴포넌트인 UseContext_는 컨텍스트 객체.provier 컴포넌트로 감싸지 않아서 컨텍스트를 사용할 수 없다
    // React.createContext(defaultValue) 함수의 인자값이 defaultValue가 반환된다

    const context = useContext(UsersContext);
    console.log('(useContext_.js) context: '+context);

    const nextId = getNextId(usersInfo.users);

    return <>
    {/* 
        ★ Props를 하위 컴포넌트로 내릴 필요 없음
        하위 컴포넌트에서는 value에 지정한 값을 const 값 = useContext(UsersContext);
    */}
    
        <UsersContext.Provider value={{usersInfo,dispatch,id:nextId}}>
            <Header/>
            <CreateUser/>
            <Users/>
        </UsersContext.Provider>
    
    </>
}

export default UseContext_;