import { useState } from "react"
import CleanUp from "./components/useEffectCleanup";

export default function UseEffect2(){
    
    const [isShow,setIsShow]=useState(false);

    return <>
    {/* isShow state에 따라 Cleanup 컴포넌트를 보였다(마운트) 안보였다가(언마운트)  */}

    {/* Cleanup 컴포넌트를 unmount해도 타이머는 계속 작동한다.
    이를 위해 useEffect()의 인자인 콜백함수에서 함수(클린업 함수)를 리턴하여 타이머를 해제해야한다. */}
        {isShow && <CleanUp/>}
        <button className="btn btn-info" onClick={()=>{setIsShow(!isShow)}}>Cleanup 컴포넌트 토글링</button>
    
    
    </>
}