import { useEffect, useState } from "react"

export default function UseEffect1(){

    //카운터용 state
    const [counter,setCounter] = useState(0);
    //state니까 값 변경되면 re rendering 되면서 새로 호출되기때문에 const 가능

    const [username,setUsername] = useState('');
        
    //console.log('useEffect1.js 랜더링이 일어났어요');
    //console.log('username:',username);

    /*
    // 형식 1: useEffect(콜백함수) : 인자인 콜백함수는 마운트 된 후(최초랜더링) 혹은 리랜더링(state나 props) 업데이트 된 후
    //componentDidMout() + componentDidUpdate() 라이프 사이클 함수와 동일
    useEffect(()=>{
        console.log("useEffect() 훅 함수 : 마운트 된 후 + state/props 업데이트 된 후");
        // 콜백함수에서는 state를 변경해서는 안된다!
        //setCounter(previous=>previous+1); //무한루프 돌게됨!
    });
    */

    // 형식2: useEffect(콜백함수,[]):인자인 콜백함수는 마운트 된 후(최초 랜더링) 딱한번만 호출된다
    // 즉 이후에 state나 props가 변경되도 콜백함수는 호출되지 않는다
    // componentDidMount()
    // useEffect(()=>{
    //     console.log("형식2 useEffect() 훅 함수 : 마운트 된 후");
    // },[]);

    // 형식3: useEffect(콜백함수,[의존성 배열 요소들]): 인자인 콜백함수는 마운트 된 후(최초 렌더링)
    // 의존성 배열의 요소로는 state나 props를 요소로 그래야 콜백함수가 의존한다
    // useEffect(()=>{
    //     console.log("형식3 useEffect() 훅 함수 : 마운트 된 후 + 의존성 배열 요소가 변경된 경우");
    // },[counter,username]);

    // 형식4: useEffect(()=>{... return ()=>{} }):클린업 함수 호출 테스트
    // 클린업 함수는 언마운트 될때 호출된다
    // 혹은 해당 컴포넌트가 마운트 된 후 다시 리렌더링 될때
    // useEffect() 훅 함수의 인자인 콜백함수가 호출되기전에 클린업 함수가 호출된다
    useEffect(()=>{
        console.log("형식4 useEffect() 훅 함수의 콜백함수 호출됨");
        //클린업 함수 반환
        return ()=>console.log('형식4 useEffect() 훅 함수의 콜백함수가 반환하는 클린업 함수 호출됨');
    })

    return <>
    <h4>Counter : {counter}</h4>
        <button className="btn btn-info" onClick={()=>{setCounter(previous=>previous+1)}}>+</button>
        <button className="btn btn-info ml-2" onClick={()=>{setCounter(previous=>previous-1)}}>-</button>
        <div className="form-group">
            <label>이름:</label>
            {/*
                useEffect()훅 함수를 테스트하기 위해 아래 사용자 입력값을 state로 관리하자
                즉 사용자 입력값을 state로 해서 value속성에 설정한다
                ※단,폼의 입력 필드에 value속성을 추가하면 그 필드는 무조건 readOnly 필드가 된다
                  이때는 onChange 리스너를 부착하자 그럼 쓰기도 가능해진다
                  즉 value속성을 추가하면 onChange속성을 반드시 넣자
            */}
            <input type="text" className="form-control" value={username} onChange={e=>{setUsername(e.target.value)}}/>
        </div>
    
    </>
}