// App 컴포넌트(App.js)에서 라우팅시 현재 컴포넌트를 부모로 하자 (루트)
// 즉 현재 컴포넌트는 자식 컴포넌트의 배치를 위한 컴포넌트다

import { Outlet } from "react-router-dom";
import Header from "./header";

export default function Template({users,likes}){

    return <>
    {/* 아래 배치가 앱의 레이아웃이다. */}
        <Header />
        <div className="container">
            {/* 
                Outlet 컴포넌트 위치에 URL 패턴에 따른 라우팅된 컴포넌트가 그려진다
                == Outlet 컴포넌트 위치에 Home, About, Users 등의 자식 컴포넌트로 대체된다.
            */}
            <Outlet context={{users,likes}}  />
                        {/* 데이터 지정해야함 */}
        </div>
    </>
}