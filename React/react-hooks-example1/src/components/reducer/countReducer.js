
const ACTION ={INCREASE:'INCREASE',DECREASE:'DECREASE'};
export const counterReducer=(currentState,action)=>{
    console.log('dispatch(action) 호출할때마다 리듀서가 호출된다');
    console.log(currentState,action);
    switch(action.type){
        case ACTION.INCREASE:return currentState+1;
        case ACTION.DECREASE:return currentState-1;
        default: return new Error('액션이 없어요');
    }


    //return currentState;
};
