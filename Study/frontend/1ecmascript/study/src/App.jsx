//App.js
import Hello from './Hello';
import './App.css';

function App() {

  const post = '강남 돈까스 맛집';

  return (
    <div className='App'>
      <div className='black-nav'>
        <h4 style={{color:'red', fontSize: '20px'}}>아기사자 블로그</h4>
      </div>
      <Hello />
      <h4>{post}</h4>
    </div>
    
  );
}

export default App;
