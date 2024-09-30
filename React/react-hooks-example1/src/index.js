import React from 'react'; //★
import ReactDOM from 'react-dom/client';  //★
import './index.css';
import App from './App';

const root = ReactDOM.createRoot(document.getElementById('root'));
/*
  https://ko.reactjs.org/docs/strict-mode.html#gatsby-focus-wrapper

  StrictMode는 애플리케이션 내의 잠재적인 문제를 알아내기 위한 도구 ~= user Strict
  useEffect 등의 훅 함수 사용시 즉 useEffect(콜백함수,[])의 인자인 콜백함수가 두 번 호출된다.
  (개발 모드에서만 발생하는 현상)
  => <React.StrictMode>를 <React.Fragment>나 <>로 변경한다.
*/
root.render(
  /*
  <React.StrictMode>
    <App />
  </React.StrictMode>
  */
 <React.Fragment>
    <App />

 </React.Fragment>
);

