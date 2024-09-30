import { Navigate, Route, Routes, useNavigate } from "react-router-dom";
import List from "./list";
import Form from "./form";
import View from "./view";
import useFetch from "../../hooks/useFetch";
import {AUTH_KEY, URL} from "../../config/constants";
import axios from "axios";
import EditForm from "./editform";

const BoardRoute=()=>{

    //0. Navigate는 항상 최 상단에
    //   게시글 등록/수정/삭제 처리 후 이동을 위한 useNavigate() 훅 함수 객체 생성
    const navigate = useNavigate();

    //1. 모든 글 가져오기 : 반환값은 [상태값(글목록), 세터] 형태(커스텀훅)
    // 글 목록을 전역 스테이트 관리할 필요 없다
    const [boardAll,setBoardAll] = useFetch(`${URL.BOARD}?_sort=-id`);
    console.log('(boardRoutes.js)모든 글 목록:',boardAll);
    //JSON-SERVER는 id를 if missing, 자동으로 랜덤하게 생성해 준다.
    // 단, 문자열이라 정렬시 문제가 된다(문자열을 순차적으로 비교)

    //2. 게시글 등록 함수(Form 컴포넌트로 props로 내린다)
    const createBoard=(title,content)=>{
        //★ 다음 글 번호 얻기
        // 최선 버전의 JSON-SERVER의 id는 문자열, 반드시 문자열로 변환해줘야 GET 요청시 404에러가 안난다.
        const id = (boardAll.length!==0 ? Math.max(...boardAll.map(post=>post.id))+1 :1).toString();
        console.log('게시글의 다음 글 번호:',id);
        const username = sessionStorage.getItem(AUTH_KEY.USERNAME);
        
        //등록
        const date = new Date();
        const postDate = `${date.getFullYear()}-${date.getMonth()+1}-${date.getDate()}`;

        // 글 등록
        axios
            .post(URL.BOARD, {id,title,content,username,postDate,views:0})
            .then(response=>{
                //게시글 목록 state변경
                setBoardAll(prevState=>[response.data,...prevState]);
                //등록 후 목록으로 이동
                navigate('/board');
            })
            .catch(e=>console.log(e));
    };

    // 3.게시글 수정 함수 editForm 컴포넌트로 내린다
    const updateBoard =(board)=>{
        //반드시 id로 전달해야 JSON-SERVER가 요청을 받아 수정한다
        // https://www.npmjs.
        // PUT /posts/:id
        axios
        .put(`${URL.BOARD}/${board.id}`)
        .then(response=>{
            setBoardAll(prevState=>prevState.map(
                prevBoard=>prevBoard.id===board.id?{...prevBoard,title:board.title,content:board.content}:prevBoard));
                //prevState: 전체글 목록
                //인자로 받은 게시글의 아이디가 같은 게시글의 제목과 내용 수정
            //수정후 상세보기로 이동
            navigate(`/board/${board.id}`);
        })
        .catch(error=>console.log(error));
        
    };

    //4. 게시글 삭제 함수 : view컴포넌트로 내린다 : filter true인것으로만 배열 만들기
    const deleteBoard =(id)=>{
        axios
        .delete(`${URL.BOARD}/${id}`)
        .then(response=>{
            setBoardAll(prevState=>prevState.filter(prevBoard=>prevBoard.id!==id));
            //삭제후 목록으로 이동
            navigate('/board');
        })
        .catch(error=>console.log(error));
    }

    
    
    return <>
    {/* 게시글과 관련된 컴포넌트로 라우팅 */}
    <Routes>
        <Route path="" element={<List boardAll={boardAll}/>} />
        {/* path="" 와 /board는 같은 것. */}

        {/* 입력폼으로 */}
        <Route path="/form" element={<Form createBoard={createBoard} />} />

        {/* 수정폼으로 */}
        <Route path="/form/:id" element={<EditForm updateBoard={updateBoard}/>} />
        
        {/* 상세보기 */}
        <Route path="/:id" element={<View deleteBoard={deleteBoard} />}/>
        {/* 위 url 패턴에 해당하지 않은 경우 List 컴포넌트로 리다이렉션 */}
        <Route path="*" element={<Navigate to="" replace={true} />}/>
    </Routes>
    </>
};
export default BoardRoute;