/*
    폼의 요소를 제어하는 로직(커스텀 훅함수)은 폼을 사용하는 모든 컴포넌트에서 공통으로 사용하는 로직

    커스텀 훅 함수 : 함수형 컴포넌트에서 필요한 값 반환
    아래 함수는 폼 화면이 있는 모든 컴포넌트에서 재사용할 수 있다.

    useState부분(입력요소를 state로 처리하는 로직)과 handleInputs(입력 요소의 onChange이벤트 핸들러)을 커스텀 훅으로 만들자
    단, 공통로직을 만들때는 폼이 있는 각 컴포넌트마다 폼의 하위요소명이 다름으로 구조분해는 제외한다.(요소가 다르기때문에)

*/

import { useState } from "react";

//1. use시작하는 함수
export default function useFormcontrol(initialState){

    //2. 함수안에서 리액트 훅 함수 호출
    const [inputs,setInputs] = useState(initialState);
    // onChange 이벤트 처리 로직(입력값을 inputs라는 이름의 state로 업데이트하는 로직)
    const handleChange = e=>{
      const{name,value}  = e.target;
      setInputs({...inputs,[name]:value});  //state 변경
    };

    //3. 폼UI가 있는 함수형 컴포넌트로 데이터 반환
    // [State(폼의 하위 요소), setter(state 변경용 함수), change event 함수]
    return [inputs,setInputs,handleChange];  //배열로 반환할 것이다.
}