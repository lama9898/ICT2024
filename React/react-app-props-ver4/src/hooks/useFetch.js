//첫번째 인자로 전달된 url주소에서 데이터(배열 혹은 객체)를 가져오는 커스텀 훅 함수

import axios from "axios";
import { useEffect, useState } from "react";

//가져오는 커스텀 훅 함수
const useFetch=(url,dependency=[])=>{
                // 의존성 배열

    const [data,setData] = useState([]);
    useEffect(()=>{
        console.log('DB에서 글을 fetch(가져옵)합니다');
        axios
            .get(url)
            .then(response=>{
                //응답바디의 내용이 데이터에 저장되어있음, 데이터는 객체 형태
                // axios 웹사이트-응답 스키마

                // 목록(사용자/게시판)을 반환할때는 [{},{},...] 형태, 하나(게시판 상세보기)를 반환할때는 {} 형태
                // [] 나 {}에 따라 스프레드 연산을 다르게 해야함
                console.log('response.data:',response.data);

                //원격에서 받은 데이터로 state 변경, 배열인지 객체인지 구분하기 : instance of 로 구분(Array)
                response.data instanceof Array ? setData(previous=>[...response.data]):setData(previous=>({...response.data}));

            })
            .catch(err=>console.log(err));

    },dependency);

    // 호출한 컴포넌트로 데이터 반환(배열반환 [state,setState])
    return [data,setData];
    // useState 처럼 변수와 세터함수를 반환하는 훅함수를 만듦
    
    //호출한 컴포넌트로 데이타 반환(배열 반환[State,setState])
    //즉 리액트의 useState() 훅 함수가 반환하는 값과 동일한 형태로 
    //값을 반환하는 커스텀 훅 함수다

};

export default useFetch;