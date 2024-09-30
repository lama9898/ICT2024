import { useReducer } from "react";

// reducer : state를 변경하는 함수로, 인자를 두개 받는다
//      state: 컴포넌트의 현재 state
//      action: state변경 정보를 담은 객체. {} 형태
//      현재 state를 받아 action에 따라 state를 변경해 새로운 state를 반환한다

/*
const ACTION = {INCREASE:'INCREASE',DECREASE:'DECREASE'};
const counterReducer=(currentState,action)=>{
    console.log('dispatch(action) 호출할때마다 리듀서가 호출된다');
    console.log(currentState,action);
    switch(action.type){
        case ACTION.INCREASE:return currentState+1;
        case ACTION.DECREASE:return currentState-1;
        default: return new Error('액션이 없어요');
    }


    return currentState;
    // 새로운 state를 반환하지 않으면 undefined나옴 ◆
};
*/
//별도의 외부 파일 .js로 분리한 리듀서 import
import {counterReducer} from "./components/reducer/countReducer"


export default function UseReducer1(){

    //state를 useReducer() 훅 함수로 설정하기
    const [counter,dispatch]=useReducer(counterReducer,0);
    // 새로운 state를 반환하지 않으면 undefined나옴 ◆
    console.log('counter:%s, dispatcher:%s', counter, dispatch)
    const handleIncrease =e=>{
        //dispatch(action)는 state를 변경해줘라는 요청함수
        dispatch({type:'INCREASE'});
        //액션전달
    };

    const handleDecrease =e=>{
        dispatch({type:'DECREASE'});
    };

    return <>
        <h4>Counter : {counter}</h4>
        <button className="btn btn-info me-2" onClick={handleIncrease}>+</button>
        <button className="btn btn-info" onClick={handleDecrease}>-</button>
    
    </>
}