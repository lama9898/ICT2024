import { useEffect, useRef } from "react"

//방법1 : 아이디 변경용 함수 props로 전달
//export default function CreateUser({dispatch,id,updateNextId}){

//방법2 : 아이디 변경용 함수 props로 전달 불필요
export default function CreateUser({dispatch,id}){

    const usernameRef=useRef('');
    const ageRef=useRef('');

    useEffect(()=>{ usernameRef.current.focus(); },[]);
    console.log('다음 아이디값:',id);
    const createUser =(e)=>{
        //방법1: 다음 아이디 구하는 함수 호출
        //updateNextId();
        //방법2: 함수호출 안해도됨

        dispatch({type:'CREATE',payload:{id,username:usernameRef.current.value, age:ageRef.current.value}});
        //입력값 클리어
        usernameRef.current.value="";
        ageRef.current.value="";
    };
    return <>
        <div className="form-group">
        <label>이름:</label>
        <input ref={usernameRef} type="text" name="username" className="form-control"  />
        </div>
        <div className="form-group">
        <label>나이:</label>
        <input ref={ageRef} type="number" name="age"  className="form-control" />
        </div>
        <button className='btn btn-info mt-2 rounded-5' onClick={createUser}>등록</button>
    
    </>
}