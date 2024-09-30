import { Link, NavLink, useNavigate,redirect } from "react-router-dom";
import { AUTH_KEY } from "../config/constants";

export default function Header({isAuth,processLogout}){    
    const activeStyle={color:'yellow',fontWeight:'bold'};

    //to={!isAuth?"/login":"/bbs"}로 설정시 인증 여부에 따라 이동은 잘 된다
    //단,로그인이 안된 경우 "로그인" 및 "게시판" 메뉴가 to="/login"이기 때문에
    //어느 한쪽을 클릭(활성화)하더라도 두 메뉴에 active클래스명이 추가 된다
    //그래서 동시에 activeStyle이 적용된다
    const redirectLoginOrBbs=(e)=>{
        e.preventDefault();
        if(!isAuth){
            alert("로그인후 이용 바랍니다");
            //redirect("/login");
            window.location.replace("/login");
        }
        else window.location.replace("/bbs");
    };

    return <>
        <nav className="navbar navbar-expand-sm navbar-dark bg-dark fixed-top">
            <div className="container-fluid">
               
                <Link className="navbar-brand" to="/">
                    <img src="/images/home_icon.png" style={{width:'40px'}} className="img-thumbnail"/>
                </Link>
                <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
                <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="mynavbar">
                    <ul className="navbar-nav ms-auto">
                        <li className="nav-item">                            
                            {/*로그아웃 클릭시 이벤트 처리후 to속성에 지정한 URL로 이동한다*/}
                            {!isAuth ?                           
                            <NavLink className="nav-link" to="/login" style={({isActive})=>isActive?activeStyle:null}>로그인</NavLink> 
                            :
                            <NavLink className="nav-link" to="/" onClick={()=>processLogout()} style={({isActive})=>isActive?activeStyle:null}>로그아웃</NavLink>    
                            }
                        </li>
                        <li className="nav-item">
                            <NavLink className="nav-link" to="/users" style={({isActive})=>isActive?activeStyle:null}>회원({sessionStorage.getItem(AUTH_KEY.USERNAME)})</NavLink>   
                        </li>
                        <li className="nav-item">
                            {/* 회원제 게시판으로 비 로그인 상태에서 클릭시 로그인 화면으로 이동*/}
                            {/* 
                                클릭 이벤트의 콜백 메소드 실행후 to속성에 지정한 URL로 이동
                                단, to 속성을 onClick속성 보다 앞에 위치 시키자                             
                            */}
                            <NavLink className="nav-link"  to="/bbs" onClick={(e)=>redirectLoginOrBbs(e)} style={({isActive})=>isActive?activeStyle:null}>게시판</NavLink> 
                        </li>   
                        <li className="nav-item">
                            <NavLink className="nav-link" to="/photos" style={({isActive})=>isActive?activeStyle:null}>사진앨범</NavLink> 
                        </li>
                        
                    </ul>                
                </div>
            </div>
            </nav>
    
    </>

}