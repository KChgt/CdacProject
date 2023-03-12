import React from 'react'
import './style.css';
import AboutPage from './logincomponent/AboutPage';
import { useHistory } from 'react-router-dom';
export default function Sidebar({sidebar}) {

  return (
    <div className={sidebar?"sidebar sidebar--open": "sidebar"}>

        <li><i class="ri-home-line"></i>Home</li>
        <li><i class="ri-phone-fill"></i>Contact Us</li>
        <li ><i class="ri-information-line"></i>About Us </li>
        <li><i class="ri-newspaper-line"></i>Carrer</li>
       
    </div>
  )
}
