import { Link, NavLink, useNavigate } from "react-router-dom";

export default function Header(){

    //NavLink의 style속성에 사용할 CSS 스타일
    const activeStyle={color:'#FFFFFF',fontWeight:'bold'};
    
    //NavLink 클릭시 {isActive:boolean} 형태의 객체를 NavLink 컴포넌트가 받는다
    // 즉 반드시 isActive라는 키로 값을 받아야 style이 적용된다.
    // 렌더링시 isActive 클래스 속성이 추가된다
    // 그리고 to속성에 지정한 URL로 컴포넌트가 변경된다

    const navigate = useNavigate();

    return <>
    <nav className="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
        <div className="container-fluid">
            {/* 화면 깜빡임 -> 쓰지 말자
                <a className="navbar-brand" href="/">
                    <img src="/images/house-door.svg" width="40px" fill="white" class="text-warning" />
                </a>
            */}
            <Link className="navbar-brand" to="/">
                <img src="/images/tornado.svg" style={{width:'40px'}}/>
            </Link>
            <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span className="navbar-toggler-icon"></span>
            </button>
            <div className="collapse navbar-collapse justify-content-end " id="mynavbar">
            <ul className="navbar-nav ms-auto ">
                <li className="nav-item">
                    {/* <Link className="nav-link" to="/about"> 회사소개 </Link> */}
                    <NavLink className="nav-link" to="/about" style={({isActive})=>isActive?activeStyle:null}> 회사소개 </NavLink>
                </li>
                <li className="nav-item">
                    <NavLink className="nav-link" to="/users" style={({isActive})=>isActive?activeStyle:null}> 회원 </NavLink>
                </li>
                <li className="nav-item">
                    <NavLink className="nav-link" to="/search?param1=react&param2=1998" style={({isActive})=>isActive?activeStyle:null}> 쿼리스트링 </NavLink>
                </li>
                <li className="nav-item">
                    <NavLink className="nav-link" to="/navigate" style={({isActive})=>isActive?activeStyle:null}> Navigate </NavLink>
                </li>
                {/* 
                    navigate(음수/양수); history.go(음수/양수) 
                    즉 navigate(-1)은 history.back()과 같다
                    useNavigate() 훅 함수의 반환값인 함수로 컴포넌트 이동시
                    함수('URL패턴,{replace:true}) 테스트용 버튼 UI
                */}
                <button className="btn btn-info" onClick={()=>navigate(-1)}>Back</button>
                
            </ul>
            
            </div>
        </div>
    </nav>
    </>
}