import { Link, useNavigate, useOutletContext, useParams } from "react-router-dom"
import useFetch from "../../hooks/useFetch";
import { URL } from "../../config/constants";
import axios from "axios";
import React, { useEffect, useState } from "react";
import Loading from "../../components/loading";
import Error_ from "../../components/error";

export default function View({deleteBoard}){
    /*
    비동기 데이타 JSX에 뿌려주기
    1. 뿌려줄 데이타를 State로 설정한다
    const [data,setData]=useState(null);
    2.useEffect(()=>{비동기 코드},[]);
    로 마운트시 콜백(()=>{비동기코드})을 한번만 호출
    3.비동기 코드에서 원격(REST API)에서 받은 데이터(data)를 State의 세터로 변경한다
        비동기 코드
        const fetchData=async ()=>{
            const res=await axios.get(URL);
            setData(prevState=>{res.data속성으로 스테이트 변경});
        };
    4.  비동기 함수 호출 즉 마운트 될때 원격(REST API)에서 데이터를 받은 후 state를 변경하면서 리랜더링 발생
        fetchData()
    5.1번에서 설정한 state인 data로 JSX에 뿌려준다
    */

    //수정/삭제/목록 버튼 클릭시 이동을 위한 훅 함수
    const navigate = useNavigate();
    //1. URL 파라미터로 넘어오는 게시글의 키(id)값 받기
    const params = useParams();
    console.log('view.js- params:',params);

    //2. 모든 사용자 목록을 컨텍스트에서 가져오기
    const {users} =useOutletContext();
    //3. id에 해당하는 글 읽어오기
    const [board,setBoard] = useState(null);
    
    //로딩 화면은 데이터가 많거나 비동기 요청이 여러개인 경우 주로 사용
    const [loading,setLoading] = useState(true);
    const [error,setError] = useState(null);

    useEffect(()=>{
        //비동기 코드 넣어주기
        //3번,4번 (비동기를 동기로)
        const fetchBoard = async ()=>{


            try{
                const response = await axios.get(`${URL.BOARD}/${params["id"]}`);
                const boardById = response.data;
                console.log('boardById:',boardById);
                console.log('view.js- 사용자목록:',users[0]);
                //게시글을 작성한 사용자의 정보 가져오기
                const userByUsername = users[0].filter(user=>user.username===boardById.username);
                console.log('글 작성자:', userByUsername);
                //사용자 아이디 대신 사용자 이름을 뿌려주기 위해
                // boardById에 name키로 사용자 이름을 추가해서 변경하자
                setBoard((previousState)=>({...boardById,name:userByUsername[0].name}));
                setLoading(false);
                
            //Error_컴포넌트 테스트를 위한 강제 에러 발생
            //throw new Error('에러가 발생했어요(테스트용)');
            }
            catch(err){
                console.log(err);
                setError(err);
            }
        };
        fetchBoard();
    },[]);

    const handleDelete=(e)=>{
        e.preventDefault();
        if(window.confirm('삭제하시겠습니까?')){
            //확인
            deleteBoard(board.id);
        }
        else    //취소
            return;
    }

    //로딩 화면 보여주기
    if(loading) return <Loading/>;
    //에러발생시 에러내용 보여주기
    if(error) return <Error_ error={error.message}/>

    //const [bbs,setBbs] = useFetch(`${URL.BBS}/${params["id"]}`);

    return <>
    
        <div>
            <h1 className="mt-4 p-5 rounded" id="lime">
                게시판 상세
            </h1>
        </div>
        {/* board는 마운트 시 null
            마운트때 데이터 요청 후 받은 데이터와 name키를 추가해서 state변경
        */}
        {   board && (<>
        <table className="table table-hover text-start table-bordered mt-3">
            <tbody>
                <tr>
                    <th className="w-25 text-center bg-dark text-white">번호</th>
                    <td>{board.id}</td>
                </tr>
                <tr>
                    <th className="w-25 text-center bg-dark text-white">글쓴이</th>
                    <td>{board.name}</td>
                </tr>
                <tr>
                    <th className="w-25 text-center bg-dark text-white">작성일</th>
                    <td>{board.postDate}</td>
                </tr>
                <tr>
                    <th className="w-25 text-center bg-dark text-white">제목</th>
                    <td>{board.title}</td>
                </tr>
                <tr>
                    <th className="w-25 text-center bg-dark text-white">조회수</th>
                    <td>{board.views}</td>
                </tr>
                <tr>
                    <th className="text-center bg-dark text-white" colSpan="2">내용</th>
                </tr>
                <tr>
                    {/* https://legacy.reactjs.org/docs/dom-elements.html */}
                    {/*
                    <td colSpan="2">{board.content.replace('\n','<br/>')}</td>
                        줄바꿈이 일어나지 않고 태그가 브라우저에 그대로 보인다
                        ex) 내용입니다1<br/>내용입니다2
                    */}
                    {/* 
                    <td colSpan="2">내용입니다1<br/> 내용입니다2</td>
                        줄바꿈이 일어남
                        즉 <br/> JSX컴포넌트를 그대로 반환해야함.
                        예 : "내용1\n내용2"
                        step1) "내용1\n내용2"를 \n으로 분리(즉 배열로 만든다)
                        setp2) 배열에 map 적용해서 문자열<br/> 형태로 변형한다
                            => <td colSpan="2">내용입니다1{"<br/>"}내용입니다2</td>
                    */}
                    <td colSpan="2">{board.content && board.content.split("\n").map((line,index)=><React.Fragment key={index}>{line}<br/></React.Fragment>)}</td>
                    {/* 중괄호 쓰면 return 써야함 */}
                </tr>
            </tbody>
        </table>
        
        <div className="text-center">
            {/* 수정폼 컴포넌트에서 url 파라미터로 받은 게시글 아이디로 해당글을 가져와도 된다
                or navigate()함수의 두번째 인자로 
            */}
            <button className="btn text-white tealbtn mx-1" onClick={()=>navigate(`/board/form/${board.id}`,{state:board})}>수정</button>
            <button className="btn text-white tealbtn mx-1" onClick={(handleDelete)}>삭제</button>
            
            {/* <button className="btn text-white" onClick={()=>{navigate('/board')}}>목록</button> */}
            <Link to="/board" className="btn text-white tealbtn mx-1">목록</Link>
            {/* 버튼으로 하면 onclick */}
        </div>
        </>)
        }
    </>
}