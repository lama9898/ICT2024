/*
    context 객체 생성 :React.createContext(컨텍스트의 기본값)
    - context 객체는 여러 컴포넌트를 하나의 문맥으로 묶는 객체다
    - 최상위 컴포넌트에 <Context 객체.Provider value={데이터}>로 하위 컴포넌트들을 같은 영역으로 묶는다.
        그러면 하위 컴포넌트들에서는 value속성에 지정한 데이타를 속성 드릴링(props drilling)을 하지 않고 가져다 쓸 수 있다
    -하위 컴포넌트에서 가져다 쓸때는 useContext(Context객체) 호출   // 인자로 컨텍스트 객체를 넘겨줘야함.
        컨텍스트의 기본값은 <Context객체.Provider value={설정값}>로 감싸지 않을때
  
        하위 컴포넌트에서 const 값=usecontext(Context객체)로 사용시
    useContext가 반환한 값은 컨텍스트의 기본값이 된다. 보통은 null을 설정한다 

*/

import React from "react";

export const UsersContext = React.createContext('컨텍스트의 기본값');
