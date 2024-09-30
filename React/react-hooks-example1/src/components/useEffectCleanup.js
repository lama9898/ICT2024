import { useEffect } from "react";

const CleanUp=()=>{
    useEffect(()=>{
        console.log('Cleanup 컴포넌트가 화면에 마운트되었느니라');
        const timer = setInterval(()=>console.log('1초마다 뿅'),1000);
        //setInterval의 콜백함수
        
        //클린업 함수는 componentWillUnmout()와 동일
        //클린업 함수(해당 컴포넌트가 unmout될때나 혹은 다음 렌더링 후 useEffect()가 호출되는 경우?)
        
        return ()=>{
            clearInterval(timer);
            console.log('타이머를 해제 했어요')
        };  //클린업 함수 - 타이머 해제 등 해당 컴포넌트가 사라지는 경우 정리해야되는 내용 작성
    });

    return <>
        <h3>Clean Up 함수 사용 예제입니다</h3>
    </>
};

export default CleanUp;