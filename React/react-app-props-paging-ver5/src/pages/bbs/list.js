import Pagination from "rc-pagination/lib/Pagination";
import { Link, useNavigate } from "react-router-dom"

export default function List({bbsPaging,pagingData}){
    console.log('(list.js)List()함수 호출');
    //글 등록 및 제목 클릭시 페이지 이동을 위한 useNavigate()훅 함수
    const navigate=useNavigate();
    return <>
            <div className="p-5 bg-warning text-white rounded">
                <h1>
                    게시판 목록
                </h1>
            </div>
            <div className="text-end my-2">
                <button className="btn btn-danger" onClick={()=>navigate('/bbs/form')}>글 등록</button>
            </div>
            <table className="table table-hover text-center">
                <thead className="table-dark">
                    <tr>
                        <th className="col-1">번호</th>
                        <th>제목</th>
                        <th className="col-2">글쓴이</th>
                        <th className="col-2">작성일</th>
                        <th className="col-1">조회수</th>
                    </tr>
                </thead>
                <tbody>
                {/* 게시글이 있는 경우:{}형태의 객체를 JSX로 변형해서 반환*/}
                {
                    bbsPaging.length===0 ?
                    (<tr>
                        <td colSpan="5">등록된 글이 없습니다</td>
                    </tr>)
                    :                    
                    bbsPaging.map(bbs=>
                    (<tr key={bbs.id}>
                        <td>{bbs.id}</td>
                        <td className="text-start"><Link to={`/bbs/${bbs.id}`} >{bbs.title}</Link></td>
                        <td>{bbs.username}</td>
                        <td>{bbs.postDate}</td>
                        <td>{bbs.views}</td>
                    </tr>))   
                }           
            </tbody>
        </table>   

        {/* 페이징 표시:<Pagination total={totalSize} current={nowPage} pageSize={pageSize}/>
		    페이징 표시는 되나 페이지 번호 클릭시 이벤트 처리가 안됨
            페이지번호 클릭시 이벤트 처리를 위해서는 onChange={(clickPage)=>setNowPage(clickPage)}
            여기서 clickPage는 클릭한 페이지 번호이다 즉 인자로 전달이 된다
			단,Bbs 컴포넌트에서 글 가져오는 dataFetch를 nowPage state가 변할때마다 커스텀 훅의 콜백함수가 호출되도록
            의존성 배열 [nowPage]에 설정한다 ((페이징 미 구현시)에서 [nowPage]로 변경해야 한다)
		    가운데 정렬:className="d-flex justify-content-center" 추가(디폴트가 왼쪽에 페이징 표시)
			
		*/}
        <Pagination className="d-felx justify-content-center" total={pagingData.totalSize} current={pagingData.nowPage} pageSize={pagingData.pageSize} onChange={clickPage=>{pagingData.setNowPage(clickPage)}}></Pagination>
    </>
}