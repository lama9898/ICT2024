import { useOutletContext, useParams } from "react-router-dom";
import User from "./user";
import UserProfileNested from "./userprofile_nested";

export default function Users(){
    // Context에 지정한 데이터 사용
    const {users,likes} = useOutletContext();

    //중첩 라우팅(라우터속의 라우터)으로 사용자 목록위에 사용자 프로필을 보여주기 위해
    const params = useParams();
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