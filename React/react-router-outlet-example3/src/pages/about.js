import { useOutletContext } from "react-router-dom"

export default function About(){

    const {users} = useOutletContext();

    return <>
        <div className="mt-5 p-5 bg-info text-white">
            <h1>About us</h1> <small>회사 소개 <kbd>총 회원수 : {users.length}</kbd></small>
        </div>
    </>
}