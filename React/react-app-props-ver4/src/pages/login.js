import { useRef } from "react";
import { useOutletContext } from "react-router-dom";

export default function Login(){

    const usernameRef = useRef(null);
    const passwordRef = useRef(null);

    //context에 있는 processAuth 함수(로그인처리) 가져오기
    const {processAuth} = useOutletContext();

    //로그인 버튼의 클릭 이벤트 처리 함수
    const handleLogin = (e)=>{
        console.log('서버로 제출할게욤');
        // <button> 의 기본적인 제출(submit) 막기 (새로고침되니까)
        e.preventDefault();

        //isAuth는 state, 여기서 못바꾸고 상위 컴포넌트에 요청해야함
        // 데이터를 가지고 있는 app컴포넌트에 로그인처리하도록 함수 호출 (세션스토리지 저장 및 isAuth값 변경)
        processAuth(usernameRef.current.value,passwordRef.current.value);
    };

    return <>
        <div>
            <h1 className="mt-4 p-5 rounded" id="lime">
                로그인 페이지 입니다.
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
                    <button className="btn btn-dark" onClick={handleLogin}>로그인</button>
                </div>
            </div>
        </form>
    </>

}