//무한 스크롤 구현
//https://github.com/thebuilder/react-intersection-observer

import { useEffect, useState } from "react";
import { URL } from "../config/constants";
import Loading from "../components/loading";
import axios from "axios";
import { InView, useInView } from "react-intersection-observer";

export default function Photos(){

    //패치한 사진 정보들 저장
    const [photos,setPhotos] = useState([]);
    //패칭(모든 데이터를 가져왔는지) 여부 판단용
    //패치중일때 로딩화면 보여주기위한 용도(선택사항)
    const [loading,setLoading] = useState(true);

    /*
    // 1. 무한 스크롤링 미 구현시
    useEffect(()=>{
        const photosFetch = async ()=>{
            try{
                const res = await axios.get(`${URL.PHOTO}`);
                console.log('5000개 사진목록',res.data);
                //사진 데이터(State) 변경
                setPhotos(previousState=>[...previousState,...res.data]);
                //로딩 화면 여부 판단용 state 변경: 모두 패치시(false)
                setLoading(false);  // 데이터 패치 종료(로딩 화면 숨기기)       
            }
            catch(e){
                console.log(e);
                //로딩화면 여부 판단용 State변경 : 실패시(false)
                setLoading(false);  //데이터 패치 실패(로딩 화면 숨기기)
            }
        };

        photosFetch();
    },[]);
    if(loading) return <Loading />
    */

    // 2.무한 스크롤링 구현
    //앨범 아이디 저장 - 무한 스크롤링 구현시 추가 코드(1)
    const [albumId, setAlbumId] = useState(1);
    //무한 스크롤링 구현시 추가 코드(2)
    // ref: 모니터링 하고자 하는 DOM 요소에 할당할 ref 객체
    //      패치한 아이템의 마지막 요소에 할당
    // inView : ref를 할당한 요소가 보이면 true, 안보이면 false 값을 갖는 변수로 자동으로
    const [ref,inView] = useInView();//50:마지막 요소에 바인딩
    console.log('ref:%s, inView:%s, albumId:%s',ref,inView,albumId);

    //무한 스크롤링 구현시 추가 코드(3)
    // albumId가 변할때마다 다시 패치한다. 즉 앨범 아이디가 변경될때마다 콜백함수를 호출
    useEffect(()=>{
        //setLoading(true);
        axios
        .get(`${URL.PHOTO}?albumId=${albumId}`)
        .then(res=>{
            setPhotos(prevState=>[...prevState,...res.data]);
            setLoading(false);
        })
        .catch(e=>setLoading(false));

    },[albumId]);

    // 위 useEffect()의 인자인 콜백함수에서 albumId를 변경하면 무한반복
    useEffect(()=>{
        //여기서 albumId를 변경 -> 위의 콜백함수가 다시 호출됨 -> 다시 패치 (다음 스크롤링)
        // 마지막 요소의 inView state가 true가 되면 다음 앨범 아이디에 해당하는 데이터를 패치
        //단, 패치중이 아닐때 (패치할때마다 로딩호면을 보여주자)
        if(InView && !loading) setAlbumId(prevState=>prevState+1);
    },[inView,loading]);

    return <>
    <div>
        <h1 className="mt-4 p-5 rounded" id="lime">
            사진목록
        </h1>
    </div>
    {/* 무한 스크롤링 미 구현시 
    {photos.map((photo,index)=>
        (<div className="card" key={index}>
            <div className="card-header">{photo.title} <span className="badge bg-dark">{photo.id}</span></div>
            <div className="card-body">
                <img className="img-thumbnail" src={photo.thumbnailUrl} alt={photo.thumbnailUrl}></img>
            </div>
            <div className="card-footer" onClick={()=>window.open(`${photo.url}`,'_blank')} style={{cursor:"pointer"}}>{photo.url}</div>
        </div>)
    )}
    */}

    {/* 무한 스크롤링 구현시 */}
    {/*  */}
    
    {/* 패치한 사진 중 마지막 사진의 ref객체를 할당해야한다. */}
    {/* 즉 마지막 요소인 경우, 마지막 DOM요소에 ref 할당(모니터링 하기 위해서) */}
    {/* if(loading) return <Loading />;는 사진목록 컴포넌트가 언마운트 되므로 스크롤이 최상단에 항상 위치하게 된다. */}

    {photos.map((photo,index)=>photos.length-1==index?(
        // 마지막 요소
        <div className="card" key={index} ref={ref}>
            <div className="card-header">{photo.title} <span className="badge bg-dark">{photo.id}</span></div>
            <div className="card-body">
                <img className="img-thumbnail" src={photo.thumbnailUrl} alt={photo.thumbnailUrl}></img>
            </div>
            <div className="card-footer" onClick={()=>window.open(`${photo.url}`,'_blank')} style={{cursor:"pointer"}}>{photo.url}</div>
        </div>
    ):(
        <div className="card" key={index}>
            <div className="card-header">{photo.title} <span className="badge bg-dark">{photo.id}</span></div>
            <div className="card-body">
                <img className="img-thumbnail" src={photo.thumbnailUrl} alt={photo.thumbnailUrl}></img>
            </div>
            <div className="card-footer" onClick={()=>window.open(`${photo.url}`,'_blank')} style={{cursor:"pointer"}}>{photo.url}</div>
        </div>
    ))}
    {loading && <Loading />}
    </>    
}