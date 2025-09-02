/*
action 객체를 만드는 액션 생성 함수들을 선언합니다
(action creators).
여기서 () => ({})은 function() { return { } }와
동일한 의미입니다.
*/
import * as types from './ActionTypes';

//증가
export const increment = () => ({
    type: types.INCREMENT
});
//감소
export const decrement = () => ({
    type: types.DECREMENT
});
//색 변경
export const setColor = (color) => ({
    type: types.SET_COLOR,
    color
});
