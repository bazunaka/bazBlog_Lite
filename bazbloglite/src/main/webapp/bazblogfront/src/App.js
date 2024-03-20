import {Route, Routes} from 'react-router-dom';
import './App.css';
import HomePage from './Components/HomePage/HomePage';
import Auth from './Components/Auth/Auth';

function App() {
    return (
        <div className="">
            <Routes>
                <Route path="/*" element={true ? <HomePage/> : <Auth/>}>

                </Route>
            </Routes>
        </div>
    );
}

export default App;
