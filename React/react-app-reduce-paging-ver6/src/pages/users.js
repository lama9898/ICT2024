import { useOutletContext, useParams } from "react-router-dom"
import User from "./user";
import UserProfile from "./userProfile";
import { useContext } from "react";
import { UsersContext } from "../context/usersContext";

export default function Users(){  

   
    //리액트의 컨텍스트의 사용자 목록 가져오기
    const {usersInfo}=useContext(UsersContext);
    const {users}= usersInfo;
    console.log('(users.js)users:',users);

     //URL파라미터 받기
     const params = useParams();
     console.log('(users.js)params:',params);
     //URL파라미터(예:/users/8a58)에 포함된 id로 필터링해서 해당 사용자 얻기 
     const user = params.id ? users.filter(user=>user.id===params.id)[0] : null;
     console.log('(users.js)user:',user);
     //브라우저 상단으로 스크롤링하기
     if(user) window.scrollTo(0,0);
    return <>
        <div className="p-5 bg-warning text-white rounded">
            <h1>
                회원 목록
            </h1>
        </div>
        {user && <UserProfile user={user}/>}
        <div className="row mt-5">
            {users.map(user=><div className="col-sm-4" key={user.username}><User user={user}/></div>)}
        </div>
    </>
}