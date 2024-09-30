import { useOutletContext, useParams } from "react-router-dom"
import User from "./user";
import UserProfile from "./userprofile";

export default function Users(){    

    //컨텍스트의 사용자목록 가져오기
    const {users} = useOutletContext();
    console.log('(users.js)users:',users);

    //URL 파라미터 : useParamter
    const params = useParams();
    const user = params.id ? users[0].filter(user=>user.id===params.id)[0]:null;
    //URL 파라미터 예: /users/id값 에 포함된 id로 필터링해서 해당 사용자 얻기
    console.log('users.js- user:',user);
    //if(user) window.alert();

    return <>
        <div>
            <h1 className="mt-4 p-5 rounded" id="lime">
                회원목록
            </h1>
        </div>
        {user && <UserProfile user={user} />}
        <div className="row mt-5">
            {users[0].map(user=><div className="col-sm-4" key={user.username}><User user={user}/></div>)}
        </div>
    </>
}