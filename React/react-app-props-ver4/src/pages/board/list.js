import { Link, useNavigate } from "react-router-dom"

export default function List({boardAll}){

    //글 등록 및 제목 클릭 시 링크 이동을 위해 useNavigate
    const navigate = useNavigate();

    return <>
        <div>
            <h1 className="mt-4 p-5 rounded" id="lime">
                게시판
            </h1>
        </div>
        <div className=" text-end my-2">
            <button className="btn text-white" id="teal" onClick={()=>{navigate('/board/form')}}>글 등록</button>
        </div>
        <table className="table table-hover text-center">
            <thead className="table-dark">
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>글쓴이</th>
                <th>작성일</th>
                <th>조회수</th>
            </tr>
            </thead>
            <tbody>
                {
                    boardAll.length===0? 
                        <tr>
                            <td colSpan="5">등록된 글이 없습니다.</td>
                        </tr>
                     : boardAll.map(board=>
                        (<tr key={board.id}>
                            <td>{board.id}</td>
                            <td className="text-start"><Link to={`/board/${board.id}`}> {board.title}</Link></td>
                            <td>{board.username}</td>
                            <td>{board.postDate}</td>
                            <td>{board.views}</td>
                        </tr>)
                     )

                }
            </tbody>
        </table>
    
    </>
}