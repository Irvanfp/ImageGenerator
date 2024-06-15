import logo from './logo.svg';
import react, { useState } from 'react';
import axios from 'axios';
import './App.css';

function App() {
  const [prompt, setPrompt] = useState('');
  const [image, setImage] = useState('');
  const getImage = async (e) => {
    const response = await axios.post(
      'http://localhost:8080/generator',
      {
        prompt,
      }
    );
    setImage(response.data.image);
  }
  return (
    <div className="App">
      <header className="Image Generator">
        <h1>Image Generator</h1>
      </header>
      <form onSubmit={getImage}>
        <input 
        type='text'
        value={prompt}
        onChange={(e) => setPrompt(e.target.value)}
        />
        <button type="submit">Generate Image</button>
      </form>
      {image && <img src={image} alt="image" />}
    </div>
  );
}

export default App;
