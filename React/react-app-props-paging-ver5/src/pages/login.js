import { useRef } from "react"
import { useOutletContext } from "react-router-dom";

export default function Login(){

    const usernameRef = useRef(null);
    const passwordRef = useRef(null);

    //컨텍스트에 있는 로그인 처리 함수 가져오기
    const {processAuth}=useOutletContext();

    //로그인 버튼의 클릭 이벤트 처리 함수
    const handleLogin = (e)=>{
        console.log('아뒤&비번을 서버로 제출합니다');
        //<button>의 기본적인 기능인 제출(submit)기능 막기
        e.preventDefault();
        //데이타를 갖고 있는 App컴포넌트의 
        //로그인 처리(세션 스토리지에 저장 및 isAuth값 변경) 함수 호출
        processAuth(usernameRef.current.value,passwordRef.current.value);
    };
    return <>
        <div className="p-5 bg-warning text-white rounded">
            <h1>
                로그인
            </h1>
        </div>
        <form>
            <div className="row mt-3 d-flex justify-content-center">
                <div className="col-3">
                    <input ref={usernameRef} type="text" className="form-control" placeholder="아이디를 입력하세요" name="username"/>
                </div>
                <div className="col-3">
                    <input ref={passwordRef} type="password" className="form-control" placeholder="비밀번호를 입력하세요" name="password"/>
                </div>
                <div className="col-auto">
                    <button className="btn btn-danger" onClick={handleLogin}>로그인</button>
                </div>
            </div>
        </form>
    </>
}