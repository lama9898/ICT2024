import { useState } from "react";

// id 만들기 함수
function getNextId(users){
    //배열의 모든 id값 추출
    // id 값만으로 새로운 배열 생성
    const ids = users.map(user=>user.id);    //아이디로 이루어진 새로운 배열
    console.log('ids: ',ids);
    return Math.max(...ids)+1;
}

//■■■
// 네트워크에서 데이터를 받는 함수(가정)
const dataFetch=()=>{
    console.log('네트워크를 통해 데이터를 패치합니다');
    return [{id:1,username:'가동동',age:20},{id:2,username:'나봉봉',age:35}];
}

function UseState2(){
    //useState(초기값/콜백함수) 훅 함수는 state(users, name, age)가 변경될 때마다 호출된다

    // 방법1> useState() 함수의 인자를 값(배열 객체)으로 설정
    // 초기값을 [{},{}] 배열 값으로 설정
    //const[users,setUsers]=useState([{id:1,username:'가동동',age:20},{id:2,username:'나봉봉',age:35}]);
    
    // 방법2> useState()함수의 인자를 콜백함수로 설정(컴포넌트 성능 최적화를 위해)
    //      초기값을 네트워크를 통해서 fetch해 온다고 가정 ■■■
    // 2_1콜백함수 미적용 
    //const [users,setUsers] = useState(dataFetch());
    // 콜백함수로 안하면 계속 랜더링(dataFetch()함수가 계속 호출), mount 될때 초기화 된 후 그 이후로는 초기화 안됨

    // mount 될때만 호출되고 리랜더링에는 호출 안하게 바꾸고 싶음
    // => 콜백함수 사용
    // 2_2 콜백함수 적용:dataFetch()함수는 마운트(화면에 그려질때) 될때만 호출되고, 리랜더링이 일어날때마다 dataFetch()함수가 계속 호출됨
    const [users,setUsers] = useState(()=>dataFetch()); //컴포넌트 성능 최적화에 해당


    console.log('users:',users);
    console.log('SetUsers:',setUsers);
    console.log('next id:', getNextId(users));
    let nextid = getNextId(users);
    const createUser=(e)=>{
        const username = document.querySelector('input[name=username]').value;
        const age = document.querySelector('input[name=age]').value;
        
        
        //state 직접 수정(비추천)

        //users.push({id:nextid, username:username, age});
        //console.log('사용자 추가:',users);
        // console에는 찍히지만 화면에는 안보임
        // 컴포넌트인 함수가 호출되지 않는다(JSX가 리턴X), 즉 리랜더링이 일어나지 않는다.
        // 이유는 State인 users(객체는 주소비교)의 주소가 바뀌지 않아서.

        // 해결책1> 새로운 배열을 생성해서 세터에 설정 : setUsers(새로운 배열)
        setUsers([...users,{id:nextid, username:username, age}]);

        // 해결책2> 새로운 배열을 생성해서 세터에 설정: setUsers(콜백함수)
        setUsers(previousState=>{
           console.log('이전 state:',previousState);
           //return  [...users,{id:nextid, username:username, age}];
           return  [{id:nextid, username:username, age},...users];
        });
    };

    console.log('등록버튼 클릭 후 세터로 state 변경(JSX 리턴전):',users);

    return <>
         <div className="form-group">
            <label>이름 : </label>
            <input  type="text"  name="username" className="form-control"/>
        </div>
        <div className="form-group">
            <label>나이 : </label>
            <input   type="number" name="age" className="form-control"/>
        </div>
        <button className="btn btn-danger" onClick={createUser}>등록</button>
        <hr/>
        <ul className="list-unstyled">
            {/* 사용자 목록 출력 */}
            {/*JSX안에서 순회하면서 요소를 출력시에는 그 요소의 속성으로 key가 있어야한다
                key속성의 값은 유니크해야한다(없으면 경고)
                https://ko.reactjs.org/docs/lists-and-keys.html
            */}
            {users.map((user,index)=><li key={user.id}>이름:{user.username},나이:{user.age}</li>)}
        </ul>
    </>
}

export default UseState2;