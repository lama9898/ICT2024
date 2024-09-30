import { useParams } from "react-router-dom";
import User from "./user";
import UserProfileNested from "./userprofile_nested";

export default function Users({users,likes}){

    //중첩 라우팅(라우터속의 라우터)으로 사용자 목록위에 사용자 프로필을 보여주기 위해
    const params = useParams();
    console.log('(users.js)params:',params.id===undefined);
    console.log('(users.js)params:',Object.keys(params).length);
    //회원 메뉴 클릭시 params는 {}, 프로필 버튼 클릭시 params 는 {id:'kim'}
    // 즉 회원 메뉴 클릭시는 params.id는 undefined(false다)
    const user = params.id?users.filter(user=>user.id===params.id)[0]:null;
    console.log('프로필 사용자:', user);
    // 중첩 라우팅에 필요한 코드 끝

    return <>
        {user && <UserProfileNested user={user} /> }
        <div className="row mt-5">
            {users.map(user=><div className="col-sm-3 my-3" key={user.id}><User user={user} likes={likes} /></div>)}
        </div>
    </>
}