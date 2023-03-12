import React from 'react'
import Backdrop from '../Backdrop';
import Sidebar from '../Sidebar';
import Footer from '../Footer';
import { ToastContainer } from 'react-toastify';
import Toolbar from '../Toolbar';
import MainPage from './mainpage';


const LogIn = () => {

  return (
    <div > 
        <ToastContainer autoClose={2000}  />
      <MainPage/>
 </div>
  );
}
export default LogIn;
