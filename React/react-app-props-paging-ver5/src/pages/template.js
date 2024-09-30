import { Outlet } from "react-router-dom";
import Header from "./header";

//레이아웃용 컴포넌트
export default function Template({isAuth,processAuth,processLogout,users}){

    return <>
        <Header isAuth={isAuth} processLogout={processLogout}/>
        <div className="container">
            <Outlet context={{isAuth,processAuth,users}}/>
        </div>
    </>
}