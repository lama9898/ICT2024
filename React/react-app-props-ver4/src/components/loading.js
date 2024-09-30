//로딩중이라는 화면을 보여주는 컴포넌트
import style from "./Loading.module.css"

export default function Loading(){
    return <>
        <div className="p-5 text-white rounded" id="lime">
        <div className="d-flex justify-content-center">
        <div className="d-flex ">
                    <h1 className="display-2">
                        로딩중 
                    </h1>
                </div>
                <div className="d-flex align-items-center">
                {/* <div className={style.Loading}>
                    <div className={style.item}></div>
                    <div className={style.item}></div>
                    <div className={style.item}></div>
                    <div className={style.item}></div>
                    <div className={style.item}></div>
                    <div className={style.item}></div>
                </div> */}
                <div className="spinner-border text-light"></div>
                </div>
           </div>
        </div>
    
    </>
}