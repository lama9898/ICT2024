import { useContext, useEffect, useRef, useState } from "react";
import { useLocation } from "react-router-dom";
import BbsContext from "../../context/bbsContext";

const EditForm=()=>{

    const {updateBbs} = useContext(BbsContext);

    //※useNavigate()객체로 이동시 state를 받기 위한 훅 함수
    // 쿼리스트링 받을때도 useNavigate() 훅 함수로 받는다
    const {state} = useLocation();
    console.log("(EditForm.js)state:",state);

    //폼 요소 제어용 Ref객체 생성
    const titleRef = useRef();
    const contentRef = useRef();     
    //유효성 체크 메시지 출력을 위한 State
    const [titleValid,setTitleValid] = useState(null);
    const [contentValid,setContentValid] = useState(null);

    //수정 버튼 이벤트
    const handleUpdateBbs=(e)=>{
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
        updateBbs({...state,title:titleRef.current.value,content:contentRef.current.value});
    };

    //마운트시 기존 입력 내용으로 제목/내용 설정
    useEffect(()=>{
        titleRef.current.value=state.title;
        contentRef.current.value=state.content;
    },[]);

    return <>
        <div className="p-5 bg-warning text-white rounded">
            <h1>
                게시판 수정
            </h1>
        </div>
        <form>
        <div className="mb-3 mt-3">
            <label htmlFor="title" className="form-label">제목</label>
            {/* 
            ※value={state.title} 코드로 입력 내용 뿌려주면
            읽기 전용이 된다 즉 쓰기가 가능하려면 입력값을 State로 관리해야 한다
                       
            */}
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
            <textarea  ref={contentRef}  className="form-control" rows="5" id="content" name="content" placeholder="내용을 입력하세요" 
            onChange={(e)=>{
                e.target.value.length===0?setContentValid('내용을 입력하세요'):setContentValid(null);

            }}></textarea>
             {/* 유효성 체크 메시지 표시용 SPAN컴포넌트*/}
             <span style={{color:'#FF0000'}}>{contentValid}</span>
        </div>
        
        <button type="submit" className="btn btn-primary" onClick={handleUpdateBbs}>수정</button>
        </form>
    </>
};
export default EditForm;