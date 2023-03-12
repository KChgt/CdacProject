import React from 'react';
import './style.css';
import AboutPage from './logincomponent/AboutPage';
export default function Toolbar({openSidebar}) {
  return (
    <div className='tool-bar navbar navbar-expand-lg'>
        <div className='burger' onClick={openSidebar}>
        <i className="ri-menu-line"></i>
        </div>
    <div className='title navbar-brand' style={{color:'green'}}>Charge EV</div>
    <ul className="navbar-nav ms-auto">
        <li className="nav-item">
           <a className='nav-link' href='/' style={{color:'white'}}> Home</a>
        </li>
        <li className="nav-item">
           <a className='nav-link' href='/about' style={{color:'white'}}> About</a>
        </li>
        <li className="nav-item">
           <a className='nav-link' href='' style={{color:'white'}}> Download</a>
        </li>
    </ul>

 
    </div>
  )
}
