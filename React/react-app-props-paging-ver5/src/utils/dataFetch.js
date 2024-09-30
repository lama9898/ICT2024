
//원격에서 패치한 데이터로 추후 작업을 해야하는 경우 비동기를 동기처럼 구현
// async/await 패턴으로 구현한다(promise 반환)

import axios from "axios";

const dataFetch = async(url)=>{
    try{
        const response = await axios.get(url);
        console.log('원격(서버)에서 받은 데이터:',response.data);
        return response.data;   //promise의 then의 인자로 전달된다
    }
    catch(err){
        console.log(err);
    }
};
export default dataFetch;