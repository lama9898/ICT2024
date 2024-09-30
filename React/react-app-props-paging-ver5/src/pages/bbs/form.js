import { useRef, useState } from "react";

const Form=({createBbs})=>{
    
    //폼 요소 제어용 Ref객체 생성
    const titleRef = useRef();
    const contentRef = useRef();  
    
    //유효성 체크 메시지 출력을 위한 State
    const [titleValid,setTitleValid] = useState(null);
    const [contentValid,setContentValid] = useState(null);

    //등록 버튼 이벤트
    const handleCreateBbs=e=>{
        e.preventDefault();//submit 기능 막기
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
        //모두 입력한 경우 부모에서 내린 게시글 등록 함수 호출
        createBbs(titleRef.current.value,contentRef.current.value);
    };

    return <>
        <div className="p-5 bg-warning text-white rounded">
            <h1>
                게시판 등록
            </h1>
        </div>
        <form>
        <div className="mb-3 mt-3">
            <label htmlFor="title" className="form-label">제목</label>
            <input ref={titleRef} type="text" className="form-control" id="title" placeholder="제목을 입력하세요" name="title" 
            onChange={(e)=>{
                e.target.value.length===0?setTitleValid('제목을 입력하세요'):setTitleValid(null);

            }}/>
            {/* 유효성 체크 메시지 표시용 SPAN컴포넌트*/}
            <span style={{color:'#FF0000'}}>{titleValid}</span>
        </div>
        <div className="mb-3">
            <label htmlFor="content">내용</label>
            {/* JSX에서는 textarea의 컨텐츠를 value속성으로 설정 */}
            <textarea  ref={contentRef} className="form-control" rows="5" id="content" name="content" placeholder="내용을 입력하세요" 
            onChange={(e)=>{
                e.target.value.length===0?setContentValid('내용을 입력하세요'):setContentValid(null);

            }}></textarea>
             {/* 유효성 체크 메시지 표시용 SPAN컴포넌트*/}
             <span style={{color:'#FF0000'}}>{contentValid}</span>
        </div>
        
        <button type="submit" className="btn btn-primary" onClick={handleCreateBbs}>등록</button>
        </form>
    </>
};
export default Form;