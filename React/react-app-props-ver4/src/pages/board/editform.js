import { useEffect, useRef, useState } from "react";
import { useLocation } from "react-router-dom";

const EditForm=({updateBoard})=>{

    //useNavigate()객체로 이동시 state를 받기 위한 훅 함수, 쿼리스트링 받을 때도 사용한다.
    const {state} =useLocation();
    console.log("Editform.js - state:",state);


    //폼 요소 제어용 ref 객체 생성
    const titleRef = useRef();
    const contentRef = useRef();

    // 유효성 체크시 메시지 출력을 위해 span요소의 컨텐츠를 state로 관리
    const [titleValid,setTitleValid] = useState(null);
    const [contentValid,setContentValid] = useState(null);

    //수정버튼
    const handleUpdateBoard =(e)=>{
        e.preventDefault();
        if(titleRef.current.value===''){
            //window.alert('제목을 입력하세요');
            setTitleValid('제목을 입력하세요');
            titleRef.current.focus();
            //return; //내용을 입력 안한 경우 메시지가 표시 안된다 
        }
        if(contentRef.current.value===''){
            //window.alert('내용을 입력하세요');
            setContentValid('내용을 입력하세요');
            contentRef.current.focus();            
        }
        //여기서 값 입력 유무 확인후  return
        if(titleRef.current.value==='' || contentRef.current.value==='') return;
        //모두 입력한 경우 부모에서 내린 게시글 수정 함수 호출
        updateBoard({...state,title:titleRef.current.value.trim(),content:contentRef.current.value.trim()});
    };

    useEffect(()=>{
        titleRef.current.value=state.title;
        contentRef.current.value=state.content;
    },[]);    //리랜더링, 마운트 될때 호출 => 마운트 될때만 기존 입력 내용으로 제목, 내용 설정해주기
  


    return <>
        <h1 className="mt-4 p-5 rounded" id="lime">
            게시판 수정
        </h1>
        <form>
        <div className="mb-3 mt-3">
            <label htmlFor="title" className="form-label">제목:</label>
            {/* ★ value={state.title} 코드로 입력 내용을 뿌려주게 되면 읽기전용이 된다.
                즉 쓰기가 가능하기 위해 입력값을 state로 관리해야함. */}
            <input ref={titleRef} type="text" className="form-control" id="title" name="title"
             onChange={(e)=>{
                e.target.value.length===0?setTitleValid('제목을 입력하세요'):setTitleValid(null)
             }} />
            {/* 유효성 체크 메시지 표시용 span컴포넌트 */}
            <span className="text-danger">{titleValid}</span>
        </div>
        <label htmlFor="content">내용:</label>
        {/* JSX에서는 textarea의 컨텐츠를 value속성으로 설정 */}
        <textarea ref={contentRef} className="form-control" rows="5" id="content" name="content" 
        onChange={(e)=>{
            e.target.value.length===0?setContentValid('내용을 입력하세요'):setContentValid(null)
         }}></textarea>
        {/* 유효성 체크 메시지 표시용 span컴포넌트 */}
        <span className="text-danger">{contentValid}</span>
        <div>
        <button type="submit" className="btn text-white my-2" id="teal" onClick={handleUpdateBoard}>수정</button>
        </div>
        </form>
    </>
};

export default EditForm;