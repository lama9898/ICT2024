import { useState } from "react";
import CreateUser from "./components/hooks/createUsers";

function CustomHookUI(){
    //React.memo()함수 테스트용 코드
    console.log('부모 컴포넌트인 CustomHookUI 랜더링');
    const [state,setState]= useState(0);

    return <>
        <CreateUser/>
        <hr>
        </hr>
        <button className="btn btn-danger" onClick={()=>setState(prev=>prev+1)}>React.memo() 테스트용</button>
    </>
}

export default CustomHookUI;