import { useContext } from "react"
import { UsersContext } from "./usersContext";

export default function User({user}){ 

    const {dispatch} = useContext(UsersContext);

    return <>
        <li className="list-group-item">
            <kbd>이 름</kbd> {user.username}
            <kbd className="ms-2">나 이</kbd> {user.age}
            <button className="btn btn-danger ms-2" onClick={()=>dispatch({type:"DELETE",id:user.id})}>회원탈퇴</button>
        </li>
    </>
}