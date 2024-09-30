import { useContext } from "react";
import { UsersContext } from "./usersContext";

const Header=()=>{

    //const contextValue = useContext(UsersContext);
    //console.log('contextValue:',contextValue);

    const {usersInfo} = useContext(UsersContext);
    
    return <>
        <kbd>총 회원수 : {usersInfo.count} 명</kbd>
    
    </>
};

export default Header;