import MyComponent from "./components/MyComponent";

import React from 'react';

const App = () => {
  return (
    <div>
      <MyComponent name="ReactJS"/>
      <MyComponent age={100}/>
    </div>
  );
};

export default App;