import React, { Component } from 'react';
import PropTypes from 'prop-types';

class MyComponent extends Component {
    //컴포넌트 내부에 상태변수를 포함하는 state객체 선언
    state = {
        value : 0,
    }

    render() {
        //destructuring assignment
        const {name, age} = this.props;
        const {value} = this.state;

        return (
            <div>
                <h2>클래스 타입 컴포넌트</h2>
                <h3>Hello!{name} - {age}</h3>
                <p>상태변수 value = {value}</p>
            </div>
        );
    }
}
MyComponent.defaultProps = {
    name: '리액트JS'
};
MyComponent.propTypes = {
    name: PropTypes.string,
    age: PropTypes.number.isRequired
};

export default MyComponent;