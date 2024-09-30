import { BBS } from "../config/constants";

const bbsReducer=(state,action)=>{

    switch(action.type){
        case BBS.LOADING:
            return {...state,loading:action.loading};
        case BBS.PAGING_ALL:
            return {...state,bbsPaging:action.bbsPaging};
        case BBS.WRITE:
            return {...state,bbsPaging:action.bbsPaging};
        case BBS.DELETE:
            return {...state,bbsPaging:action.bbsPaging};
        case BBS.UPDATE:
            return {...state,bbsPaging:action.bbsPaging};
        case BBS.NOWPAGE:
            return {...state,nowPage:action.nowPage};
        case BBS.TOTAL_SIZE:
            return {...state,totalSize:action.totalSize};
        default:
            throw new Error(`존재하지 않는 액션 타입입니다:${action.type}`);
    }

};
export default bbsReducer;