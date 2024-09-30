
//※원격에서 페치한 데이타로 추후 작업을 해야하는 경우 비동기를 동기처럼 구현하기
//  async/await패턴으로 구현한다(Promise반환)
import axios from "axios";


const dataFetch = async (url)=>{
    try{
        const response = await axios.get(url);
        console.log('(dataFetch.js)원격에서 받은 데이타:',response.data);
        return response.data; //반환값은 Promise의 then의 인자로 전달된다
    }
    catch(err){
         console.log(err);
    }
};
export default dataFetch;