import { Link, NavLink, redirect, useNavigate, useOutletContext } from "react-router-dom";
import { AUTH_KEY } from "../config/constants";

export default function Header({isAuth,processLogout}){

    const activeStyle={color:'#FFFFFF',fontWeight:'bold'};
    
    //to={!isAuth?"/login":"/bbs"}로 설정시 인증여부에 따라 이동은 잘된다
    //단, 로그인이 안된 경우 "로그인" 및 "게시판" 메뉴가 to="/login"
    //어느 한쪽을 클릭(활성화)하더라도 두 메뉴가 모두 활성화됨(active Syle 적용)
    const redirectLoginOrBoard=(e)=>{
        e.preventDefault();
        if(!isAuth){
            alert("로그인후 이용 바랍니다.");
            window.location.replace("/login");
        }
        else{
            window.location.replace("/board");
        }
    }

    const navigate = useNavigate();

    return <>
    <nav className="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
        <div className="container-fluid">
            <Link className="navbar-brand" to="/">
                <img src="/images/tornado.svg" style={{width:'40px'}}/>
            </Link>
            <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span className="navbar-toggler-icon"></span>
            </button>
            <div className="collapse navbar-collapse" id="mynavbar">
            <ul className="navbar-nav ms-auto ">
                <li className="nav-item">
                    {/* 로그인 되면 "로그인" 메뉴는 안보이기 때문에 style은 의미 없다 */}
                    {/* 로그아웃 클릭시 이벤트 처리 후 to속성에 지정한 url로 이동한다 */}
                    {(isAuth===null)?
                        <NavLink className="nav-link" to="/login" style={({isActive})=>isActive?activeStyle:null}> 로그인 </NavLink>
                        :
                        <NavLink className="nav-link" to="/logout" style={({isActive})=>isActive?activeStyle:null} onClick={()=>processLogout()}> 로그아웃 </NavLink>
                    }
                </li>
                <li className="nav-item">
                    <NavLink className="nav-link" to="/users" style={({isActive})=>isActive?activeStyle:null}> 회원({sessionStorage.getItem(AUTH_KEY.USERNAME)}) </NavLink>
                </li>
                {/* 회원제 게시판으로 비 로그인 상태에서 클릭시 로그인 화면으로 이동
                    클릭 이벤트의 콜백 메소드 실행후 to속성에 지정한 url로 이동함
                    단, to 속성을 onClick속성보다 앞에 위치시키기
                */}
                <li className="nav-item">
                    <NavLink className="nav-link" to="/board" onClick={(e)=>redirectLoginOrBoard(e)} style={({isActive})=>isActive?activeStyle:null}> 게시판 </NavLink>
                </li>
                <li className="nav-item">
                    <NavLink className="nav-link" to="/photos" style={({isActive})=>isActive?activeStyle:null}> 사진 </NavLink>
                </li>
                
            </ul>
            
            </div>
        </div>
    </nav>
    </>
}