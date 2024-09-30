import User from "./user";

export default function Users({users,dispatch}){ //{users:[{},{},...]}
    //props는 항상 객체다
    return <>
        <ul className="list-group list-group-flush">
            {/* ui 확인을 위한 테스트용 */}
            {/*  <User/> */}
            {/* map의 인자인 콜백함수는 JSX를 리턴해야한다. */}
            {users.map(user=> <User key={user.id} dispatch={dispatch} user={user}/>)}
           

        </ul>
    </>
}