import { useRef, useState } from "react";

const Form=({createBoard})=>{

    //폼 요소 제어용 ref 객체 생성
    const titleRef = useRef();
    const contentRef = useRef();

    //유효성 체크 코드 시작 : span요소에 메시지 표시
    // 선행작업 : span요소 추가 및 각 입력 요소(제목 및 내용)에 onChange 이벤트 추가
    // 유효성 체크시 메시지 출력을 위해 span요소의 컨텐츠를 state로 관리
    const [titleValid,setTitleValid] = useState(null);
    const [contentValid,setContentValid] = useState(null);

    //등록버튼
    const handleCreateBoard=(e)=>{
        e.preventDefault(); //submit 기능 막기
        if(titleRef.current.value.trim().length===0){
            window.alert('제목을 입력해주세요');
            console.log()
            setTitleValid('제목을 입력해주세요');
            titleRef.current.focus();
            //return; //내용을 입력안한 경우 메세지가 표시 안된다.
        }
        if(contentRef.current.value.trim().length===0){
            window.alert('내용을 입력해주세요');
            console.log()
            setContentValid('내용을 입력해주세요');
            contentRef.current.focus();
            return;
        }

        if(titleRef.current.value.trim().length===0 || contentRef.current.value.trim()==='')
            return;
        else    //모두 입력후
            createBoard(titleRef.current.value,contentRef.current.value);
    };


    return <>
        <h1 className="mt-4 p-5 rounded" id="lime">
            게시판 등록
        </h1>
        <form>
        <div className="mb-3 mt-3">
            <label htmlFor="title" className="form-label">제목:</label>
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
        <button type="submit" className="btn text-white my-2" id="teal" onClick={handleCreateBoard}>등록</button>
        </div>
        </form>
    </>
};

export default Form;