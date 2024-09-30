//에러 내용 보여주는 컴포넌트
//에러 내용은 Props로 받는다
export default function Error_({error}){
    return <>
       
        <div className="alert alert-warning">
                <h1 className="display-4 text-danger" >에러! <small className="text-dark">{error}</small></h1>
        </div>
       
    
    </>
}