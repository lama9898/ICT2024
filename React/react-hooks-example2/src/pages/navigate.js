import { useNavigate } from "react-router-dom";

export default function Navigate(){
    // Route 컴포넌트를 사용한 라우팅으로 페이지 이동이 아니다.
    // 함수호출로 페이지 이동(컴포넌트 전환시)을 위해 사용하는 훅함수
    const navigate = useNavigate();
    console.log('navigate:',navigate);
    return <>
        <h1 className="display-4 mt-5">useNavigate() 훅 함수</h1>

        {/* navigate('URL패턴'); = location.href='URL' 과 같다.) */}
        <button className="btn btn-success me-2 mt-3" onClick={()=>navigate('/users',{replace:true})}>NO HISTORY(replace:true 옵션 테스트)</button>
        
        {/* navigate('/URL패턴',{state:데이타}) ※URL패턴에 매핑된 컴포넌트로 데이타 전달시   */}
        <button className="btn btn-danger mt-3" onClick={()=>navigate('/search?param1=useNavigate&param2=1',{state:{name:'ICT'}})} >DATA TRANSFER(State전달 테스트)</button>
        
    </>
}