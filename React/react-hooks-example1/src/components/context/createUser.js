import { useContext, useEffect, useRef } from "react"
import { UsersContext } from "./usersContext";


export default function CreateUser(){

    const usernameRef=useRef('');
    const ageRef=useRef('');

    const {dispatch} = useContext(UsersContext);
    const id = useContext(UsersContext);

    const createUser = e=>{
        dispatch({type:"CREATE",payload:{id,username:usernameRef.current.value, age:ageRef.current.value}});
        usernameRef.current.value="";
        age:ageRef.current.value="";
    }

    return <>
        <div className="form-group">
        <label>이름:</label>
        <input ref={usernameRef} type="text" name="username" className="form-control"  />
        </div>
        <div className="form-group">
        <label>나이:</label>
        <input ref={ageRef} type="number" name="age"  className="form-control" />
        </div>
        <button className='btn btn-info mt-2 rounded-5' onClick={createUser} >등록</button>
    
    </>
}