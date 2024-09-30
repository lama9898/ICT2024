import { useContext } from "react";
import User from "./user";
import { UsersContext } from "./usersContext";

export default function Users(){

    const {usersInfo} = useContext(UsersContext);

    return <>
        <ul className="list-group list-group-flush">
            {usersInfo.users.map(user=><User key={user.id} user={user}/>)}
        </ul>
    </>
}