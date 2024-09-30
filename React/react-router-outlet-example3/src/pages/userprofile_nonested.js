import { useParams } from "react-router-dom";
import NotFound from "./notfound";

// A. 중첩 라우팅이 아닌 별도의 라우터로 구성시
const UserProfileNoNested=({users})=>{

// B. 중첩 라우터로 구성시

    // url 파라미터를 읽어오는 훅 함수: useParams()
    const params = useParams();
    // {url파라미터변수(id):url파라미터값} 즉 {id:'kim'}
    console.log('(userprofile.js)params: ',params);
    const user =users.filter(user=>user.id===params.id)[0]; //filter 새로운 배열을 만듦
    console.log('(userprofile.js)user: ',user);
    
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
export default UserProfileNoNested;