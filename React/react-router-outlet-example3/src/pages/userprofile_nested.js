import { useParams } from "react-router-dom";
import NotFound from "./notfound";

// B. 중첩 라우터로 구성시
const UserProfileNested=({user})=>{

    const params = useParams();
    console.log('(userprofile_nested.js)params:',params);

    //없는 아이디로 url 요청시(users는 undefined)
    if(!user) return <NotFound/>
        

    return <>
        <h2 className="mt-5">{user.name}의 상세 정보</h2>
        <table className="table table-bordered">
            <tbody>
            <tr>
                <th className='w-25 bg-dark text-white text-center'>아이디</th>
                <td>{user.id}</td>
            </tr>
            <tr>
                <th className='w-25 bg-dark text-white text-center'>이 름</th>
                <td>{user.name}</td>
            </tr>
            <tr >
                <th className='w-25 bg-dark text-white text-center'>프로필</th>
                <td>{user.profile}</td>
            </tr>
            </tbody>
        </table>
    </>
};
export default UserProfileNested;