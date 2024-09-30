//※첫번째 인자로 전달된 url주소에서 데이타([] 배열 혹은 {})를 

import axios from "axios";
import { useEffect, useState } from "react";

//  가져오는 커스텀 훅 함수
const useFetch=(url,deps=[])=>{
    const [data,setData] = useState([]);
    useEffect(()=>{
        console.log('원격에서 글을 페치합니다');
        axios
            .get(url)
            .then(res=>{
               //목록(사용자,게시판)을 반환 할때는 [{},{},...]형태,
               //하나를 반환할때(게시판 상세보기) {}형태
               //즉 []나 {}에 따라 스프레드 연산을 달리해야 한다 
                console.log('res.data(원격에서 페치한 데이타):',res.data);       
               //원격에서 받은 데이타로 State 변경
               res.data instanceof Array ? setData(prevState=>[...res.data]) : setData(prevState=>({...res.data}));
            })
            .catch(err=>console.log(err));
        

    },deps);//useEffect()
    //호출한 컴포넌트로 데이타 반환(배열 반환 [State,setState])
    //즉 리액트의 useState()훅 함수가 반환하는 값과 동일한 형태로
    //값을 반환하는 커스텀 훅 함수다
    return [data,setData];
};


export default useFetch;