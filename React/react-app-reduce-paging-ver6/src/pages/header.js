import { Link, NavLink, useNavigate,redirect } from "react-router-dom";
import { AUTH_KEY } from "../config/constants";
import { useContext } from "react";
import { UsersContext } from "../context/usersContext";

export default function Header(){   
    //리액트의 컨텍스트에서 데이타 가져오기
    const {usersInfo,processLogout}=useContext(UsersContext);
    const {isAuth} = usersInfo;
    const activeStyle={color:'yellow',fontWeight:'bold'};

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