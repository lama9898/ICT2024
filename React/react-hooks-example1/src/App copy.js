import './App.css';

function returnJSX(jsx){
  return jsx;
}

function App() {
  //console.log("hello");
  //const bye="React Hello";
  const title = "풍선 도움말";
  const h = returnJSX(<h1>함수의 인자로 전달</h1>);

  //5.props
  const user = {username:'kim'};

  return (
    <div className="App" title={title} style={{backgroundColor:'lavender'}}>
      {/*jsx 를 사용하니까 {} 1개 , 객체로 넘길거니까 {}하나 더, 문자열이니까 '' */}
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
          {/*자바스크립트 사용 표현식: {bye}*/}
          {h}
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
      {/*<My props={user}/>*/}
    </div>
  );
}

export default App;
