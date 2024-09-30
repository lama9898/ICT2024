import { useContext, useEffect, useRef } from "react"
import { UsersContext } from "../context/usersContext";


// 1) 입력값(이름 및 나이)을 state로 미 관리시(Ref)
// 2) Ref객체로 제어
// 이때는 특별히 useMemo 훅 함수로 컴포넌트 성능 최적화 불필요
const isAdult =age=>{
    console.log('isAdult() 함수 호출');
    return parseInt(age) >19?'성인':'미성년자';
}

export default function CreateUserNoState(){

    const usernameRef=useRef('');
    const ageRef=useRef('');
    const spanRef=useRef('');

    const {dispatch} = useContext(UsersContext);
    const id = useContext(UsersContext);

    const createUser = e=>{
        dispatch({type:"CREATE",payload:{id,username:usernameRef.current.value, age:ageRef.current.value}});
        usernameRef.current.value="";
        age:ageRef.current.value="";
    }

    const handleAge=(e)=>{
        //console.log(isAdult(e.target.value));
        spanRef.current.textContent = isAdult(e.target.value);
    };

    return <>
        <div className="form-group">
        <label>이름:</label>
        <input ref={usernameRef} type="text" name="username" className="form-control"  />
        </div>
        <div className="form-group">
        <label>나이:</label>
        <input ref={ageRef} type="number" name="age"  className="form-control" onChange={handleAge} />
        <span> 성인 유무</span>
        </div>
        <button ref={spanRef} className='btn btn-info mt-2 rounded-5' onClick={createUser} >등록</button>
    
    </>
}