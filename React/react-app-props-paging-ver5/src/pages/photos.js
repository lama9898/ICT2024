//무한 스크롤 구현
//https://github.com/thebuilder/react-intersection-observer

import { useEffect, useState } from "react"
import { URL } from "../config/constants";
import Loading from "../components/loading";
import axios from "axios";
import { useInView } from "react-intersection-observer";
import Modal from "../components/modal";
import dataFetch from "../utils/dataFetch";

//npm install react-intersection-observer
export default function Photos(){

    //페치한 사진 정보들 저장
    const [photos,setPhotos] = useState([]);
    //페칭(모든 데이타를 가져왔는지) 여부 판단용
    //페치중일때 로딩 화면 보여주기 위한 용도(선택사항)
    const [loading,setLoading] = useState(true);

    //[무한 스크롤링 미 구현시]
    /*
    useEffect(()=>{
        const photosFetch=async ()=>{
            try{

                const res = await dataFetch(`${URL.PHOTO}`);
                console.log('5000개 사진목록:',res.data);
                //사진 데이타(State) 변경
                setPhotos(prevState=>[...prevState,...res]);                
                setLoading(false);//데이타 페치 종료(로딩 화면 숨기기)
                
            }
            catch(e){
                console.log(e);
                //로딩 화면 여부 판단용 State변경:실패시(false)
                setLoading(false);//데이타 페치 실패(로딩 화면 숨기기)
            }
        };
        
        photosFetch();

    },[]);    
    if(loading) return <Loading />;
    */

    //[무한 스크롤링 구현시]
    //로딩화면을 모달로 띄우기
    const [showModal, setShowModal] = useState(false);
   
    //1)코드 추가 첫번째
    const [albumId,setAlbumId]=useState(1);
    //2)코드 추가 두번째
    //useInView훅 함수은 배열을 반환 한다
    //ref : 모니터링 하고자 하는 DOM요소에 할당할 ref객체.
    //      ※페치한 아이템의 마지막 요소에 할당한다
    //inView : ref를 할당한 요소가 보이면 true,안보이면 false값을 갖는 변수로 자동으로 변한다  
    const [ref,inView]= useInView();
    console.log('ref:%s,inView:%s,albumId:%s',ref,inView,albumId);
    //3)코드 추가 세번째
    //albumId가 변할때 다시 페치한다. 즉 albumId가 변경될때마다 콜백함수를 다시 호출해야 한다
    useEffect(()=>{
           
            setShowModal(true);
            dataFetch(`${URL.PHOTO}?albumId=${albumId}`)
            .then(res=>{
                setPhotos(prevState=>[...prevState,...res]);                
                setShowModal(false);
            })
            .catch(e=>setShowModal(false));
       
    },[albumId]);

    //위 useEffect()의 인자인 콜백함수에서 albumId를 변경하면 무한반복
    useEffect(()=>{
        //여기서 albumId를 변경 시킨다 그래야 위의 콜백함수 호출되서 
        //다시 페치한다
        //마지막 요소의 inView 스테이트가 true가되면 다음 앨범 아이디에 해당하는 데이타를 가져오자
        //단,페치중이 아닐때(패치할때 마다 로딩 화면을 보여주자)
        if(inView && !showModal) setAlbumId(prevState=>prevState+1);
    },[inView,showModal]);

    
    return <>
        <div className="p-5 bg-warning text-white rounded mb-2">
            <h1>
                사진 목록
            </h1>
        </div>
        {/* [무한 스크롤링 미 구현]  
            {photos.map((photo,index)=>
                    (<div className="card mt-2" key={index}>
                        <div className="card-header bg-warning">{photo.title} <span className="badge bg-dark">{photo.id}</span></div>
                        <div className="card-body">
                            <img src={photo.thumbnailUrl} className="img-thumbnail" alt={photo.thumbnailUrl}/>    
                        </div> 
                        <div className="card-footer bg-danger" style={{cursor:'pointer'}} onClick={()=>window.open(`${photo.url}`,'_blank')}>{photo.url}</div>
                    </div>)
                )
            }
       */}
         {/*
            if(loading) return <Loading />;
            는 사진목록 컴포넌트가 언 마운트 됨으로 스크롤리 최상단에 항상 위치하게 된다
         */}
         
         {showModal && <Modal/> }
         {/* [무한 스크롤링으로 구현] */}
         {/* 페치한 사진중 마지막 사진에 ref객체를 할당해야 한다*/}
         {/* 즉 마지막 요소인 경우:마지막 DOM요소에 ref 할당(모니터링 하기 위해서)*/}
         
         {photos.map((photo,index)=>photos.length-1===index?(
            <div className="card mt-2" key={index} ref={ref}>
                <div className="card-header bg-warning">{photo.title} <span className="badge bg-dark">{photo.id}</span></div>
                <div className="card-body">
                    <img src={photo.thumbnailUrl} className="img-thumbnail" alt={photo.thumbnailUrl}/>    
                </div> 
                <div className="card-footer bg-danger" style={{cursor:'pointer'}} onClick={()=>window.open(`${photo.url}`,'_blank')}>{photo.url}</div>
            </div>
         ):(
            <div className="card mt-2" key={index}>
                <div className="card-header bg-warning">{photo.title} <span className="badge bg-dark">{photo.id}</span></div>
                <div className="card-body">
                    <img src={photo.thumbnailUrl} className="img-thumbnail" alt={photo.thumbnailUrl}/>    
                </div> 
                <div className="card-footer bg-danger" style={{cursor:'pointer'}} onClick={()=>window.open(`${photo.url}`,'_blank')}>{photo.url}</div>
            </div>
         ))}
    </>
}