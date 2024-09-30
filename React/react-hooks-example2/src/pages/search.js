import { useLocation, useSearchParams } from "react-router-dom";

const Search = ()=>{

    //쿼리 스트링(혹은 useNavigate() 훅 함수로 이동시에도)은 useLocation()훅 함수로 받는다
    const location = useLocation();
    //{pathname: '/search', search: '?param1=react&param2=1998', hash: '', state: null, key: 'zakre4i8'}
    console.log('search.js location:', location);
    const {pathname,search, state} = location;

    /*
     state는 쿼리스트링을 받을때는 무조건 null이다
     단,<Route/>컴포넌트가 아닌 useNavigate("/URL패턴",{state:props혹은 state값})로
     컴포넌트 전환(이동)시에는 state키에 지정한 값이 된다.
    */

    console.log('pathname: %s, search:%s, state:%s',pathname,search,state);

    //아래는 navigate.js의 "DATA TRANSFER" 버튼 테스트용 코드
    console.log('useNavigate()훅 함수 테스트용(데이터 전달)',state && state.name);

    // 쿼리 스트링을 파싱 하기위해 별도의 라이브러리가 필요 없다(v6에서)
    // useSearchParams() 훅 함수를 사용하여 쉽게 쿼리 스트링의 파라미터를 파싱할 수 있다.
    const searchParams = useSearchParams();
    console.log('searchParams:',searchParams);
    // [URLSearchParams, f]
    // URLSearchParams 객체로 쿼리 스트링으로 넘어온 값을 쉽게 꺼낼수 있다.
    // 이때 이 값은 컴포넌트의 state가 된다 ★
    // f는 함수로 state를 변경하는 세터다

    const [urlSearchParams,setUrlSearchParams] = searchParams;
    console.log('urlSearchParams:',[...urlSearchParams]);   // 구조분해 후
    // [...urlSearchParams]는 [Array(2), Array(2)] 파라미터가 2개임으로 2개의 요소를 배열로 가지는 배열이다.
    // 요소인 각각의 배열은 ['파라미터명', '파라미터 값']을 갖는다
    //
    const param1 = urlSearchParams.get("param1");
    const param2 = urlSearchParams.get("param2");

    return <>
    <br></br>
    <h2 className="mt-5"><kbd>쿼리 스트링</kbd></h2>
        <p>첫번째 파라미터 : {param1}</p>
        <p>두번재 파라미터:{param2}</p>
        <button className="btn btn-info" onClick={()=>{
            console.log(typeof param2); //string
            const nextParam2 = parseInt(param2)+1;
            //setUrlSearchParams()는 urlSearchParams의 setter, setter 사용불가
            
            let prevState = [...urlSearchParams].map(([parameterName,parameterValue])=>({[parameterName]:parameterValue}));
                // 변수를 key로 할때는 반드시 []로 감싸기
            console.log('prevState:',prevState);
            prevState = prevState.reduce((acc,obj)=>({...acc,...obj}));
            // acc: 차원을 줄임
            // == const prevState = {param1,param2};와 같다
            console.log(prevState);

            setUrlSearchParams({...prevState,param2:nextParam2});
        }}>두번째 파라미터 숫자 증가</button>
    
    </>
}
export default Search;