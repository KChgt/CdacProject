
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';

import { detectOverflow } from '@popperjs/core';
import AddSlots from '../src/components/StationComponents/StationAdd'
import 'react-toastify/dist/ReactToastify.css';





import Base from './components/StationComponents/Base';
import StationHome from './components/StationComponents/StationHome';
import LogIn from './components/logincomponent/logIn';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import BookSlot from './components/StationComponents/BookSlot';
import MainPage from './components/logincomponent/mainpage';
import AdminBase from './components/AdminComponent/AdminBase';
import AdminHome from './components/AdminComponent/AdminHome';
import { ToastContainer } from 'react-toastify';
import AboutPage from './components/logincomponent/AboutPage';
import Addphotos from './components/StationComponents/Addphotos';
import CustomerBase from './components/CustomerComponents/CustomerBase';
import CustomerHome from './components/CustomerComponents/CustomerHome';
import CustomerSearch from './components/CustomerComponents/CustomerSearch';
import CustomerBookSlot from './components/CustomerComponents/CutomerBookSlots';



function App() {

 
  return (
    <div style={{backgroundColor : 'black'}}>
   
   <ToastContainer position='BOTTOM_CENTER' autoClose={2000} />
<BrowserRouter>
<Routes>
  <Route exact path='/' element={<LogIn/>}/>
  <Route exact path='/about' element={<AboutPage/>}/>
  <Route exact path='/login' element={<MainPage/>}/>
  <Route path='/station' element={<Base/>}>
    <Route path='home' element={<StationHome/>}/>
    <Route path='addSlot' element={<AddSlots/>}/>
    <Route path='bookSlot' element={<BookSlot/>}/>
    <Route path='addphotos' element={<Addphotos/>}/>
  </Route>
  <Route path='/admin' element={<AdminBase/>}>
    <Route path='home' element={<AdminHome/>}/>
  </Route>
  
  
  <Route path='/customer' element={<CustomerBase/>}>
    <Route path='home' element={<CustomerHome/>}/>
    <Route path='stationSearch' element={<CustomerBookSlot/>}/>
    </Route>
</Routes>
</BrowserRouter>
    
 
      


    </div>
  );
}

export default App;
