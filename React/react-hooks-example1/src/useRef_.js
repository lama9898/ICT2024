import { useEffect, useRef, useState } from "react"

export default function UseRef_(){

    // 폼 요소의 사용자 입력값을 state로 유지시
    // 전제 조건
    // 폼의 입력 요소에
    // (1) value={state변수명} 그리고 (2)onChange={(e)=>set변수명(e.target.value)} 추가
    // (1)번만 추가시 해당 입력 요소는 읽기 전용(경고 메세지 나옴)
    // (2)번만 추가시에는 정상작동

    const [username,setUsername] = useState('');

    // 1. Ref 객체 : {current:초기값} 형태의 객체
    // Ref객체.current 는 참조하려는 DOM 요소(태그), 단 해당 요소에 ref속성을 추가하여 연결해야한다.(바인딩)
    // Ref객체의 요소 값이 변해도 리렌더링이 일어나지 않는다
    // 또한 state가 변경되서 re rendering이 되더라도 ref객체의 값이 유지된다.
    const refVar = useRef(0);
    //console.log('refVar:',refVar);  // {current: 0}

    // 2. 지역변수
    let localVar = 0;
    //console.log('localVar:',localVar);  // localVar: 0

    const updateRef = (e)=>{
        // 지역변수 및 Ref객체의 current 키값 변경
        localVar++;
        refVar.current++;
        console.log(localVar,refVar.current);
    };

    //Ref 객체로 DOM 요소에 접근하기
    // 1. Ref 객체 생성
    // 2. Ref 객체로 참조하기 위해서 DOM 요소에 ref={Ref객체} 속성 추가 (ref={refText})
    const refText = useRef('');
    console.log('refText.current[1]:',refText.current);
    //refText.current.focus();  //is not a function, 마운트(돔에 출력되기전)에 접근불가
    // [ 요소 제어 작업1] 화면 최초 로드시 폼 입력 요소에 포커스 주기(useEffect 훅함수와 ref객체 사용)
    useEffect(()=>{
        // 화면에 컴포넌트(useRef_)가 생길때(보일때, 마운트될때) 부가적인 효과를 focus 주기
        // 반드시 마운트 된 후 Ref객체.current로 참조한다
        refText.current.focus();
        console.log('refText.current[2]:',refText.current);
    },[]);   //마운트 될때만 호출

    // [ 요소 제어 작업2]

    const clearText = (e)=>{
        // ref객체는 dom api처럼 vDOM 요소에 접근할 수 있는 참조 객체
        console.log(refText.current.value);
        refText.current.value='';
        refText.current.focus();
    };


    console.log('UseRef_.js re-rendering이 발생~!');
    return <>
        <kbd className="me-3">ref객체 :{refVar.current}</kbd>
        <kbd> 로컬(지역) 변수 :{localVar}</kbd>
        <div className="form-group mt-3">
        <label>이름 : </label>
        {/* 사용자 입력값 state로 유지시-값 입력시마다 렌더링 */}
        <input placeholder='리랜더링 발생 >> Ref객체 값 유지 확인용' value={username} onChange={(e)=>setUsername(e.target.value)} type="text" className="form-control" />
        {/* 사용자 입력 요소를 Ref객체로 참조시 -값 입력시마다 렌더링이 일어나지 않는다 */}
        {/* Ref객체로 참조하기 위해서는 해당 DOM 요소에 ref={Ref객체} 속성 추가 */}
        <input ref={refText} placeholder="ref객체로 참조" type="text" className="form-control mt-1" />
        </div>
        <button className="btn btn-info my-3" onClick={updateRef}>Ref변경 및 지역변수 변경(Ref객체 테스트용)</button>
        <button className="btn btn-info" onClick={clearText}>입력값 클릭어하고 포커스 주기(Ref객체로 요소 제어용)</button>
    </>
}