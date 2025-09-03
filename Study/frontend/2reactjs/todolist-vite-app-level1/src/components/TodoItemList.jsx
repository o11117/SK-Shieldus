import { Component } from 'react';
import PropTypes from 'prop-types';
import { connect } from 'react-redux'

import { fetchAllTodos } from '@/actions'
import TodoItem from '@Components/TodoItem';

class TodoItemList extends Component {
    componentDidMount() {
        this.props.getTodos();
    }
    //true 리턴 (myTodos 변수에 변경이 있는 경우)면 render() 호출
    //false 리턴 (myTodos 변수에 변경이 없는 경우)면 render() 호출 안함
    shouldComponentUpdate(nextProps, nextState) {
        return this.props.myTodos !== nextProps.myTodos;
    }

    render() {
        const { myTodos, myToggle, myRemove } = this.props;
        const todoList = myTodos.map(({id, text, checked}) => (
            <TodoItem
                key={id}
                id={id}
                text={text}
                checked={checked}
                onToggle={() => myToggle(id)}
                onRemove={() => myRemove(id)}
            />
        ));
        return (
            <div>
                {todoList}
            </div>
        );
    }
}
TodoItemList.propTypes = {
    myTodos: PropTypes.array,
    myToggle: PropTypes.func,
    myRemove: PropTypes.func,
    getTodos: PropTypes.func
};

export default connect(
    //store에 저장된 todos를 가져와서 myTodos 프로퍼티에 매핑
    (state) => ({ myTodos: state.todos }),
    //action함수를 dispatch 하는 함수를 getTodos 프로퍼티에 매핑
    { getTodos: fetchAllTodos }
)(TodoItemList);