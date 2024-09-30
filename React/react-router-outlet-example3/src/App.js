import { Route, Routes } from "react-router-dom";
import Home from "./pages/home";
import About from "./pages/about";
import NotFound from "./pages/notfound";
import Users from "./pages/users";
import { useState } from "react";
import UserProfileNested from "./pages/userprofile_nested";
import Search from "./pages/search";
import Navigate from "./pages/navigate";
import Template from "./pages/template";

const users = [
  {
    id:"tom",
    name: '토마토',
    profile: '토마토입니다',
    likes:0,
  },
 {  id:"lee",
    name: '이수경',
    profile: '이수경입니다',
    likes:0,
  },
  {
    id:"mee",
    name: '미알감',
    profile: '미쳐버린알감자입니다',
    likes:0,
  },
  {
    id:"duck",
    name: '덕복희',
    profile: '덕복희입니다',
    likes:0,
  },
  {
    id:"bam",
    name: '밤순',
    profile: '밤순입니다',
    likes:0,
  },
  {
    id:"yam",
    name: '덕얌희',
    profile: '덕얌희입니다',
    likes:0,
  },
  {
    id:"kosmo3",
    name: '한소인3',
    profile: '한소인3입니다',
    likes:0,
  },
];

{/*
  ※ Outlet 컴포넌트 사용 (단, 중첩 라우팅을 해야한다)
    모든 자식 컴포넌트가 Outlet 컴포넌트의context 속성에 지정한 데이터를
    Props로 받지않고 사용할 수 있다
  ※ 자식 컴포넌트에서 데이터 사용시는 useOutletContext()훅 함수를 호출해서 사용할 수 있다
*/}

function App() {

  //users 1. 사용자데이터(users) state로 설정
  const [allUsers,setAllUsers] = useState(users);

  console.log('App.js의 렌더링 함수 호출');
  //2. 좋아요(likes) 수정 함수 정의
  // user 컴포넌트로 내린다. user컴포넌트에서는 사용자의 id를 인자로 전달해서 호출한다.
  const updateLikes=(id)=>{
    //map()함수로 순회하면서 키로 찾아 수정
    const newAllUsers=allUsers.map(user=>user.id===id?{...user,likes:user.likes+1}:user);
    setAllUsers(newAllUsers);
};


  return (
    <>
    {/* 데이터를 Props로 내리는 컴포넌트에만(Users) Outlet을 적용해도 된다.
        이때는 Header컴포넌트를 Routes 컴포넌트 밖에 위치 시켜야 한다.(react-router-components)

        하지만 확장성을 위해서 모든 데이터를 가지고 있는 App컴포넌트의 자식 컴포넌트들에 Outlet을 적용하자
        (예를 들면 회사소개 컴포넌트인 About에 총 사용자 수를 출력하는 경우가 생길 수 있기 때문에)
    */}
      <Routes>
        <Route element={<Template users={allUsers} likes={updateLikes} />}>
          {/* 레이아웃 컴포넌트(템플릿)를 부모로 => 부모인 context에 있는 내용을 바로 쓸 수 있음
              Template은 레이아웃용 컴포넌트일 뿐, 라우팅을 위한 컴포넌트는 아님. => path속성은 지정하지 않는다.
          */}
          <Route path="/" element={<Home/>}/>
          <Route path="/about" element={<About/>}/>
          {/* 데이터를 Props로 내리는 컴포넌트에 Outlet사용 -> 앱전체에서는 사용하지 못함
              -> 앱전체를 outlet으로 구성하면 확장성이 좋다.
          */}
          <Route path="/users" element={<Users/>}>
            <Route path=":id" element={<UserProfileNested/>} />
          </Route>
          
          <Route path="/search" element={<Search/>}/>
          <Route path="/navigate" element={<Navigate/>}/>
          <Route path="/*" element={<NotFound/>}/>
        </Route>
      </Routes>
      
    </>
  );
}

export default App;
