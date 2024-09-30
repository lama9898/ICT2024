/*
    컴포넌트의 리렌터링(함수호출) 되는 조건
        - 자식 state가 변경될 때
        - 부모에서 받은 props가 변경될때
        - 부모 컴포넌트가 리랜더링 되는 경우
*/

import { useState } from "react";

export default function UseState1(){

    console.log('컴포넌트인 함수안의 this:',this);  //undefined,함수형 컴포넌트에서 this는 undefined
    //컴포넌트 안에서는 사용하지 말자

    // 1. state가 아닌 (그냥)함수의 변수
    // 버튼 클릭시 counter 변경하더라도 리랜더링이 일어나지 않음(함수호출X) == 브라우저의 값(화면)이 변하지 않는다.
    // useState1()함수가 호출이 안되서 JSX가 리턴이 안된다. 브라우저에 화면이 변하지 않는다.
    //let counter =0;

    // 2. 변하는 데이터인 counter를 state로 만든 경우
    // 구조분해 전
    //const returnValue = useState(0);
    //console.log('useState()훅 함수의 반환값:',returnValue); // (2) [0, ƒ]
    // 구조분해 후
    //state는 setter를 통해 변경하자~ (안쓰면 1번과 같아보임)
    let [counter,setCounter] = useState(0);
   
    
    const handleplus = ()=>{
        // 3. counter를 state로 설정 후, setter를 이용해 설정하지 않는 경우, 화면이 바뀌지 않는다.
        //      반드시 setter를 이용해서 state를 변경해야 화면이 변경된다(랜더)

        // 4. state인 counter와 state변경 함수(setCount)를 통해 변경된 값을 비교하여 변경된 경우 리랜더링함.
        //      따라서 state의 값은 변경하지 말자(state는 immutable해야함)
        //  (리액트는 정의시의 내용과 setCounter()의 내용 비교하여 랜더링)
        //console.log('counter 증가:',++counter);
        //setCounter(counter);  //비추천

        // 5. setter(state 대체값)을 통해서 state인 counter를 변경하기(리랜더링 일어나면 변경됨)
        //setCounter(counter+1);
        //console.log('counter:',counter);

        //이전 state값이 아닐 수도 있음 -> 보장을 위해 콜백함수 사용
        // 6. setter(콜백함수)로 state인 counter를 변경 시 이전 state를 콜백함수의 인자로 받을 수 있다
        //      setCounter(counter+1)로 변경시 counter는 이전의 state가 아닐 수 있음
        //      콜백 함수는 100% 이전 state 값을 보장함.
        // 이를 테스트하기 위해 setCounter(counter+1);와 setCounter(previousState=>previousState+1);를 두번씩 호출하면 확인가능
        setCounter(previousState=>previousState+1);
        console.log('counter:',counter);

    };
    const handleminus = ()=>{
        //console.log('counter 감소:',--counter);
        //setCounter(counter);

        //setCounter(counter-1);
        //console.log('counter:',counter);

        setCounter(previousState=>previousState-1);
        console.log('counter:',counter);
    };
    return <>
        <h4>Counter : {counter}</h4>
        <button className="btn btn-info" onClick={handleplus}> + </button> <button className="btn btn-warning" onClick={handleminus}> - </button>
        
    </>
}