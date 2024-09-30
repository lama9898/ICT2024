import { Link } from "react-router-dom";

export default function User({user}){

    return <>
        <div className="card">
        <img className="card-img-top" src="/images/img_avatar1.png" alt="Card image" />
        <div className="card-body">
            <h4 className="card-title">{user.name}</h4>
            <p className="card-text">{user.profile}</p>

            {/* 절대경로 /로 시작 */}
            <Link to={user.id} className="btn btn-primary my-1" >프로필</Link>
        </div>
        </div>
    </>
}