/*
    어떤 거를 컴포넌트로 만들것인가?
        1. 반복되는 UI      ex) 버튼
        2. 데이터가 변경되는 UI     ex)뉴스
*/

// Hello컴포넌트용 스타일 import
import './Hello.css'    // 모든 컴포넌트에 다 적용됨

//
import style from './Hello.module.css';


function Hello(){
    console.log("hello from the other side (hello 컴포넌트 랜더링)");
    // '변경된 가상돔이 만들어진다.'

    const number =10;
    const string = '문자욜';
    const bool = true;
    const null_ = null;
    const undefined_ = undefined;

    const object1 ={username:'ict',password:'ict1234'};
    const array = [2024,'청룡의해','취업 가보자고'];
    const day = new Date();

    //이벤트 처리
    // 방법1
    function handleClick1(e){
        //hook 함수 호출 불가(함수안의 함수이기 때문에)
        //                  hello     handleCilck
        console.log('첫번째 버튼 클릭 이벤트 발생:',e.target);
    }
    function handleClick2(e){
        console.log('두번째 버튼 클릭 이벤트 발생:',e.target);
    }

    // <>는 반드시 return 옆에!
    return <>
        <h2 className="box" style={{color:'gainsboro', background:'grey', opacity:0.2}}>[inline style css 적용]</h2>
        <h2 className="box" >[import style css 적용]</h2>
        <h2 className={style.box}>컴포넌트명.module.css적용</h2>
        <h2>JSX안에서 변수 사용</h2>
        <ul>
            <li>number Type : {number}</li>
            <li>string Type : {string}</li>
            {/* JSX에서는 boolean, null, undefined 는 아무것도 출력되지 않는다 */}
            <li>boolean Type : {bool}</li>
            <li>object Type(null) : {null_}</li>
            <li>undefined Type : {undefined_}</li>

            {/* 
            Objects are not valid as a React child (found: object with keys {username, password}).
            If you meant to render a collection of children, use an array instead.
            <li>object Type(리터럴 객체) : {object1}</li>
            */}
            <li>object Type(array 리터럴-map함수 미적용) : {array}</li>
            <li>object Type(array 리터럴-map함수 적용) : 
                {/* map(콜백함수)의 인자인 콜백함수는 화면을 표시하기 위해서는 JSX를 리턴해야 한다 */}
                {/* Warning: Each child in a list should have a unique "key" prop 
                    - 자식 컴포넌트(<p>)를 반복하려면 반드시 자식 컴포넌트에 key속성으로 unique한 값을 지정해줘야 함
                    - 그렇지 않으면 경고가 콘솔창에 출력된다.
                */}
                {/* {array.map((element,index)=><p>{element}</p>)} */}
                {array.map((element,index)=><p key={index}>{element}</p>)}
            </li>
            {/* 리터럴 객체와 동일
                <li>object 타입(생성자 함수):{day}</li>
             */}
             <li>오늘 날짜 : {`${day.getFullYear()}-${day.getMonth()+1}-${day.getDate()}`}</li>
        </ul>
        <h2>JSX의 이벤트 처리</h2>
        <h4>방법 1) 함수 정의 및 컴포넌트의 onClick={/*함수명만*/}</h4>
        <button className='btn btn-danger' onClick={handleClick1}>클릭 이벤트 첫번째</button>
        <h4>방법 2) 함수 정의 및 컴포넌트의 onClick={/*(e)=>정의한 함수 호출*/}</h4>
        <button className='btn btn-warning' onClick={(e)=>handleClick2(e)}>클릭 이벤트 두번째</button>
        <h4>방법 2) 함수 미 정의 및 컴포넌트의 onClick={/*(e)=>함수 구현부 정의*/}</h4>
        <button className='btn btn-success' onClick={(e)=>{
            console.log('두번째 버튼 클릭 이벤트 발생:',e.target);
        }}>클릭 이벤트 세번째</button>

    </>
}

export default Hello;