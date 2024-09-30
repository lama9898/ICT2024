const Header=(props)=>{//{totalUsers:2}
    //props는 {키:값,...} 형태의 객체다. 이때 키는 컴포넌트(JSX태그)의 속성명
    console.log('props:',props)

    return <>
        <kbd>총 회원수 : {props.totalUsers}명</kbd>
    
    </>
};

export default Header;