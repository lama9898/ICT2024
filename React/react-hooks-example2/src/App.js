import { Route, Routes } from "react-router-dom";
import Header from "./pages/header";
import Home from "./pages/home";
import About from "./pages/about";
import NotFound from "./pages/notfound";
import Users from "./pages/users";
import { useState } from "react";
import UserProfileNoNested from "./pages/userprofile_nonested";
import UserProfileNested from "./pages/userprofile_nested";
import Search from "./pages/search";
import Navigate from "./pages/navigate";

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

// Outlet 컴포넌트 미사용

// Outlet 컴포넌트 미 사용
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
    {/* 1. <Routes>밖에 배치(Header가 Routes의 영향을 받지 않아 url에 따라 라우팅을 적용받지 않아 항상 보인다) */}
      <Header/>
      <div className="container">
        {/* 화면용 뷰인 각 컴포넌트로 라우팅 */}
      <Routes>
        {/* <Home/> */}
        {/* [Home] is not a <Route> component, Route의 자식은 반드시 route여야 함 */}
        <Route path="/" element={<Home/>} />  {/* / : 루트 */}
        {/* 특정 url로 라우팅하기
            <Route path="url 패턴" element={<화면용 컴포넌트/>} />
            Url 패턴은 /로 시작
            단 서브 라우트 구현시에는 /를 생략하여 부모 url을 기준으로 함
        */}
        <Route path="/" element={<Home/>}/>
        <Route path="/about" element={<About/>}/>
        <Route path="/users" element={<Users users={allUsers} likes={updateLikes}/>}>
          {/* 
            B. 서브 라우터(라우터 안의 라우터,중첩라우팅)로 url 파라미터 구성
              - "/users/파라미터변수(아이디)" URL요청을 해도 URL은 여전히 /users다 즉 뷰는 Users컴포넌트다
              - URL파라미터는 부모(Users)와 자식(UserProfile) 둘다에서 받을 수 있다
                즉 프로필 버튼 클릭시 브라우저의 URL 창에 /users/kim으로 바뀔때
                부모인 Users에서도 useParams()으로 받을 수 있다
              - ※중첩 라우팅은 부모 컴포넌트(뷰)에서 자식 컴포넌트(뷰)를
                보여주고자 할때 사용한다
              - ※모든 사용자 데이타를 자식인 UserProfile에 속성으로 내릴 필요 없다
              - ★ Users 컴포넌트에 UserProfileNested 컴포넌트를 마운트하는 코드 추가
          */}
          <Route path=":id" element={<UserProfileNested/>} />
        </Route>
        {/* A. 중첩라우팅이 아닌 별도의 라우터
          - "/users/:파라미터변수(아이디)" url요청시 뷰는 userProfile 컴포넌트
          - URL 파라미터는 UserProfile컴포넌트에서 받아야 함.
          - 별도의 화면으로 자식 컴포넌트(뷰)를 보여주고자 할때 사용
            즉 userProfile뷰를 독립된 화면으로 보여줄때
          - 모든 사용자 데이터를 속성으로 내려야 함
        <Route path="/users/:id" element={<UserProfileNoNested users={allUsers} />}/>
         */}
        <Route path="/search" element={<Search/>}/>
        <Route path="/navigate" element={<Navigate/>}/>
        <Route path="/*" element={<NotFound/>}/>
      </Routes>
      </div>
    </>
  );
}

export default App;
