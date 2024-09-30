import { useRef, useState } from "react";

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

function UseState3(){
    console.log('UseState3 (렌더링)');

    const [users,setUsers] = useState(()=>dataFetch());
    let nextid = getNextId(users);

    // DOM요소인 폼 하위요소의 값 제어하기
    // 방법1> 사용자 입력값을 각각의 state로 관리 (유효성 체크시 매우 유용)
    //      사용자 입력값을 state로 관리하기 위해 폼 하위요소에 onChange 이벤트 추가
    //      name 속성이 없어도 무관
    //      username과 age변수는 사용자 입력값을 저장하는 state

/*    
    const [username,setUsername] = useState('');
    const [age,setAge] = useState('');

    const changeUsername=(e)=>{
        console.log('이름 입력창의 입력값:',e.target.value);
        //state인 username과 폼의 하위 요소인 이름 입력창 연결
        setUsername(e.target.value);
    };

    const changeAge=(e)=>{
        console.log('나이 입력창의 입력값:',e.target.value);
        //state인 age와 폼의 하위 요소인 나이 입력창 연결
        setAge(e.target.value);
    };
*/
/*
    // 방법2> 모든 사용자 입력값을 하나의 state로 묶어서 관리
    // 방법1과의 차이는 없지만, 코드를 줄이는 효과만 있음
    // 방법2는 반드시 name 속성 있어야함. name속성의 값을 키로 하는 객체를 값으로 설정
    //      역시 폼 하위요소에 onChange 이벤트 추가
    const [inputs,setInputs] = useState({username:'',age:''});
    const {username,age} = inputs;

    const changeInputs=(e)=>{
        //파라미터명을 state인 객체의 키와 일치 시키기 전
        // console.log(typeof e.target);
        // console.log(e.target.value);
        // let tempname='';
        // let tempage='';
        // if(e.target.type==='text'){
        //     tempname = e.target.value;
        // }
        // else{
        //     tempage = e.target.value;
        // }
        // setInputs({...inputs,username:tempnamge,age:tempage});

        //파라미터명을 state인 객체의 키와 일치 시키자
        console.log(e.target.name);
        console.log(e.target.value);
        //e.target의 name및 value속성(키)으로 구조분해
        const {name,value} = e.target;
        console.log('name:%s, value:%s',name,value);
        setInputs({...inputs,[name]:value})
    };
*/
    // 방법3> useRef() 훅 함수를 사용해서 불필요한 렌더링을 막자
    //      참조하려는 DOM 요소별로 Ref(참조)객체 생성
    const usernameRef = useRef('HELLO');    // usernameRef : {current:'HELLO'}
    const ageRef = useRef('');
    console.log('usernameRef:',usernameRef);
    console.log('ageRef:',ageRef);

    //사용자 등록함수
    const createUser=(e)=>{
        //(방법1>)
        // setUsers(previous=>{
        //     return [{id:nextid, username:username, age},...users];
        // });

        //(방법2>)
        // setUsers(previous=>{
        //     //방법 1하과 방법2일때 
        //     // 방법 1, 2는 폼요소에 타이핑시마다 랜더링이 발생함.
        //     //return [{id:nextid, username, age},...users];

        //     return [{id:nextid, username, age},...previous];
        // });

        //(방법3> : ref객체로 해당 요소를 참조한다.)
        setUsers(previous=>{
            return [{id:nextid,username:usernameRef.current.value, age:ageRef.current.value},...previous];
        });
    };
    // 방법1, 방법2는 state로 관리
    // 방법3 값을 참조 -> 

    return <>
        <div className="form-group">
            <label>이름 : </label>
            {/* (방법1>) */}
            {/* <input  type="text"  name="username" className="form-control" onChange={changeUsername}/> */}
            {/* (방법2> 파라미터명을 state인 객체의 키와 일치 시키자) */}
            {/* <input  type="text"  name="username" className="form-control" onChange={changeInputs}/> */}
            {/* (방법3>) useRef() 훅함수 사용 */}
            <input  type="text"  name="username" className="form-control" ref={usernameRef}/>
        </div>
        <div className="form-group">
            <label>나이 : </label>
            {/* (방법1>) */}
            {/* <input   type="number" name="age" className="form-control" onChange={changeAge}/> */}
            {/* (방법2> 파라미터명을 state인 객체의 키와 일치 시키자) */}
            {/* <input   type="number" name="age" className="form-control" onChange={changeInputs}/> */}
            {/* (방법3>) useRef() 훅함수 사용 */}
            <input   type="number" name="age" className="form-control" ref={ageRef}/>
        </div>
        <button className="btn btn-warning" onClick={createUser}>등록</button>
        <hr></hr>
        <ul className="list-unstyled">
            {
                users.map((user,index)=><li key={index}>NAME: {user.username},AGE: {user.age}</li>)
            }
        </ul>
    
    </>
}

export default UseState3;