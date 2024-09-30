import { useCallback, useContext, useEffect, useRef, useState } from "react"
import { UsersContext } from "../context/usersContext";



export default function CreateUserState(){

    const spanRef = useRef('');

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

    //아래 함수를 메모이제이션 테스트(리렌더링시 아래 함수 다시 정의된다)
    // 컴포넌트 안에 정의하자
    /*
    setAdult()함수를 메모이제이션 하기전 성인 판별과 관계없은 이름을 입력해도 리렌더링이 일어남
    리렌더링시마다 매번 setAdult가 다시 정의된다.

    useEffect() 훅 함수의 두번째 인자인 의존성 배열요소 setAdult()가 다시 정의 된다.(주소가 바뀜)
    [setAdult]가 변할때마다 useEffect() 훅 함수의 첫 번째 인자인 콜백함수가 호출된다.


    const setAdult =()=>{
        console.log('isAdult() 함수 호출');
        //age.length === 0? ref.current.textContent='':parseInt(age) >19?ref.current.textContent='성인':ref.current.textContent='미성년자';
        spanRef.current.textContent=age.length === 0?'':parseInt(age) >19?'성인':'미성년자';
    }
    */

    // setAdult()함수를 메모이제이션 하기전
    // 함수를 메모이제이션 한다. 즉 이름이 변할때는 메모이제이션된 함수를 사용하고
    // 나이가 변할때는 다시 함수가 정의된다(컴포넌트 성능 최적화)
    const setAdult = useCallback(()=>{
        console.log('isAdult()함수 호출');
        spanRef.current.textContent= age.length === 0?'':parseInt(age) >19?'성인':'미성년자';
    },[age]);

    useEffect(()=>{
        console.log('setAdult 함수의 주소가 변경되었습니다. 즉,함수가 다시 생성되었습니다.');
        setAdult();
    }
    ,[setAdult]);
    // useEffect의 콜백함수는 마운트될때와 의존성 배열의 요소가 변경되었을 때 호출됨.

    return <>
        <div className="form-group">
        <label>이름:</label>
        <input type="text" name="username" className="form-control" value={username} onChange={handleInputs} />
        </div>
        <div className="form-group">
        <label>나이:</label>
        <input type="number" name="age"  className="form-control" value={age} onChange={handleInputs}/>
        <span ref={spanRef}></span>
        </div>
        <button className='btn btn-info mt-2 rounded-5' onClick={createUser} >등록</button>
    
    </>
}