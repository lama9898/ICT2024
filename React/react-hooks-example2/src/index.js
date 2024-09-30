import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import { BrowserRouter } from 'react-router-dom';


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <BrowserRouter> 
  {/* 라우팅 하기위해서는 최상위 컴포넌트를 BrowserRouter로 감싸주기 */}
    <App />
  </BrowserRouter>
);
