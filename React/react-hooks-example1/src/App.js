import './App.css';
import Hello from './components/Hello';
import UseCallback_ from './useCallback';
import UseContext_ from './useContext';
import CustomHookUI from './useCustomHook';
import UseEffect1 from './useEffect1';
import UseEffect2 from './useEffect2';
import UseMemo_ from './useMemo_';
import UseReducer1 from './useReducer1';
import UseReducer2 from './useReducer2';
import UseRef_ from './useRef_';
import UseState1 from './useState1';
import UseState2 from './useState2';
import UseState3 from './useState3';

function App() {

  console.log('App 컴포넌트 랜더링:App()함수 호출');
  return <>
  <div className='container'>
    <h1>Import Style CSS(App.js)</h1>
    {/*<Hello/> */}
    <h1 className='box'>Import Style css(App.js)</h1>
    <Hello />
    <h2>useState 훅함수</h2>
    {/* 동일 컴포넌트도 state는 독립적 */}
    <h4>useState1</h4>
    <UseState1/>
    <UseState1/>
    <hr></hr>
    <h4>useState2</h4>
    <UseState2/>
    <hr></hr>
    <h4>useState3</h4>
    <UseState3/>
    
    <hr></hr>
    <h4>useEffect1</h4>
    <UseEffect1/>
    <hr></hr>
    <h4>useEffect2</h4>
    <UseEffect2/>

    <hr></hr>
    <h4>useRef</h4>
    <UseRef_/>

    <hr></hr>
    <h4>UseReducer1</h4>
    <UseReducer1/>
    <hr></hr>
    <h4>UseReducer2(props로 state 전달 "props driller")</h4>
    <UseReducer2/>

    <hr></hr>
    <h4>UseContext (Context API)</h4>
    <UseContext_/>

    <hr></hr>
    <h4>UseMemo</h4>
    <UseMemo_/>

    <hr></hr>
    <h4>UseCallback</h4>
    <UseCallback_/>

    <hr></hr>
    <h4>커스텀 훅 함수 및 React.memo()함수</h4>
    <CustomHookUI/>

    <br></br><br></br>
  </div>
  </>;
}

export default App;
