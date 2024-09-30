import React from "react";
import useFormcontrol from "./useFormHook";

function CreateUser(){




    // 커스텀 훅 함수를 사용한 폼 요소 제어
    // 1. 커스텀 훅 함수 호출 : 커스텀 훅 함수는 [폼요소 state, state변경용 setter함수, 핸들러함수] 형태의 배열반환
    // 폼요소값을 state로 관리할때
    const [inputs,setInputs,handleChange]=useFormcontrol({username:'',password:'',age:''});
    const {username,password,age}=inputs;


    console.log('자식인 createuser 컴포넌트 랜더링됐슈');
    return <>
    
    <div className="form-group">
            <label>아이디:</label>
            <input type="text" name="username"   className="form-control" value={username} onChange={handleChange} />
        </div>
        <div className="form-group">
            <label>비밀번호:</label>
            <input  type="text" name="password"   className="form-control" value={password} onChange={handleChange} />
        </div>
        <div className="form-group">
            <label>나이:</label>
            <input  type="number" name="age"  className="form-control" value={age} onChange={handleChange}/>
        </div>
        <button className='btn btn-info' onClick={()=>{
            setInputs({username:'',password:'',age:''})
        }}>클리어</button>
    
    </>

}

// 자식에서는 부모의 state를 사용하지 않지만
// 부모의 state가 변경되면 자식도 무조건 렌더링이 일어난다
// react.memo(자식컴포넌트)로 성능 최적화하기
//  부모가 렌더링이 일어나도 자식 컴포넌트인 CreateUser는 랜더링이 일어나지 않는다.
export default React.memo(CreateUser);
