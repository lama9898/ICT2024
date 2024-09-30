import { useReducer, useState } from "react";
import Header from "./components/reducer/header";
import CreateUser from "./components/reducer/createUser";
import Users from "./components/reducer/users";

const initialState={
    count:2,
    users:[
      {id:1,username:'가길동',age:20},
      {id:2,username:'나길동',age:30}
    ]
};


//사용자 정보(객체) state를 변경하는 reducer 함수
/* CreateUser컴포넌트에서 dispatch호출 시 인자로 전달할 객제 즉 액션의 구조
    {
        type:"CREATE", payload:{id:3,username:'다길동',age:25}
    }
        state: 현재 state값
        action: {type:"CREATE",payload:{id:3,username:'다길동',age:40}}

*/
const usersReducer =(state,action)=>{
    console.log('state:',state);
    switch(action.type){
        case 'CREATE': //사용자 생성 (spread 연산자 / 배열의 concat 함수 사용)
            console.log('추가할 사용자:',action.payload);
            console.log('반환할 state(create):',{count:state.count+1,users:[{...action.payload},...state.users]})
            return {count:state.count+1,users:[{...action.payload},...state.users]};
        case "DELETE": //사용자 삭제 (filter 함수, 삭제하려는 id를 제외한 요소로 필터링하여 배열 생성)
        // 1. Users에 dispatch 내리기
        // 2. Users에서 dispatch 호출해서 action이랑 id넘기기
            //return state.users.filter(user=>user.id !=action.id);   //[{},{},{},...,{}]의 형태로 배열 반환
                                                                      // => 오류남(state 형태로 반환되지 않아서)
            // 해결책: state형태 반환
            return {count:state.count-1,users:state.users.filter(user=>user.id !=action.id)};

            //수정은 map()함수로 순회하면서 키로 찾아 수정
            // 배열.map(item=>item.key===key? {...item, 변경객체키:변경값} :item)
        default:
            return state;   //현재 state반환
    }

};

//사용자 아이디 생성 함수
function getNextId(users){
    if(users.length==0) return 1;
    const ids = users.map(user=>user.id);
    return Math.max(...ids)+1;
}

export default function UseReducer2(){

    // initailState를 리듀서로 상태 관리하고 props로 하위 컴포넌트에 값 전달
    const [usersInfo,dispatch] = useReducer(usersReducer,initialState);
    // 방법1: id값(state로 별도 관리): 다음 아이디값용
    // 계속 초기화 해주기 위해서 (사용자를 계속 추가해도 nextID는 변하지 않는다.-> 키가 중복됬다는 warning 뜸)
    //const [nextId,setNextId] = useState(()=>getNextId(usersInfo.users));    //마운트 될때만(한번만) 호출이 됨 -> 아이디값 안바뀜
    //const [nextId,setNextId] = useState(getNextId(usersInfo.users));    // 마운트 및 리랜더링 시 호출됨
    // useState()로 초기화는 딱 한번만(마운트될때) state가 초기화 된다. 리랜더링 될때는 초기화가 안일어남 -> 값을 바꿀때는 setter로 바꿔야함
    // 초기화는 어차피 두 방법 다 한번만 이루어지기 때문에 한번만 getNextId()를 호출하는 첫번째 코드가 성능상 좋음.

    //해결책 : nextId를 setter로 변경하기 (<- 자식에게 setter를 props로 넘겨준다)
    // nextId를 변경하는 props로 내릴 함수정의
    //const updateNextId =()=>{   setNextId(nextId+1);    }

    // 방법2: 지역변수에 다음 아이디 값을 바로 설정(State인 usersInfo는 변경되니까)
    const nextId = getNextId(usersInfo.users);

    //하위 컴포넌트로 속성(props)을 통해 state를 내려보낼때 속성명은 임의다(내맘), props의 키가 된다
    // => props는 항상 객체다
    return <>
        <Header totalUsers={usersInfo.count}/>
        {/* dispatch 전달 시 reducer 호출됨 */}
        {/* 방법 1: nextId를 변경함수도 함께 props로 전달 */}
        {/* <CreateUser dispatch={dispatch} id={nextId} updateNextId={updateNextId}/> */}
        <CreateUser dispatch={dispatch} id={nextId}/>
        <Users dispatch={dispatch} users={usersInfo.users}/>
    </>
}