import { useContext, useEffect, useMemo, useRef, useState } from "react"
import { UsersContext } from "../context/usersContext";


// 1) 입력값(이름 및 나이)을 state로 관리시(Ref)
// 2) Ref객체로 미 제어
// 이때는 특별히 useMemo 훅 함수로 컴포넌트 성능 최적화 필요
const isAdult =age=>{
    console.log('isAdult() 함수 호출');
    return age.length === 0? '':parseInt(age) >19?'성인':'미성년자';
}

export default function CreateUserState(){

    const {dispatch,id} = useContext(UsersContext);
    //입력값을 state로 설정
    const [inputs,setInputs] = useState({username:'',age:''});  //input에 저장됨
    const {username,age} = inputs;

    const createUser = e=>{
        dispatch({type:"CREATE",payload:{id,username, age}});

    }

    const handleInputs =e=>{
        const {name,value} = e.target;
        setInputs({...inputs,[name]:value})
    }
    //성인 판별과 관계없는 이름 입력할때마다 리랜더링이 일어남
    //const adult = isAdult(age);
    //useEffect는 반환값이 없다 -> 사용불가 ㅠ -> useMemo사용하기
    // []을 인자로 전달시 컴포넌트가 마운트 되었을 때만 콜백함수가 호출된다.항상 마운트시 메모이제이션 값('')을 항상 사용하게 된다.(X)
    //const adult = useMemo(()=>isAdult(age),[]);

    // 이름(state) 입력시 리랜더링이 일어나지만 의존성배열에 지정한 age가 변할때만 콜백함수(첫번째 인자)가 호출된다.
    // == 컴포넌트 최적화
    //이름이 변할때는 메모이제이션이 된 값이 사용된다.
    const adult = useMemo(()=>isAdult(age),[age]);
    
    console.log('adult:',adult);

    return <>
        <div className="form-group">
        <label>이름:</label>
        <input type="text" name="username" className="form-control" value={username} onChange={handleInputs} />
        </div>
        <div className="form-group">
        <label>나이:</label>
        <input type="number" name="age"  className="form-control" value={age} onChange={handleInputs}/>
        <span> {adult}</span>
        </div>
        <button className='btn btn-info mt-2 rounded-5' onClick={createUser} >등록</button>
    
    </>
}