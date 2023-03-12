import React from 'react'
import './AdminSidebar.css' // Import CSS file with custom styles

export default function AdminSidebar({sidebar}) {

  return (
    <div className={sidebar ? "sidebar sidebar--open" : "sidebar"}>

      <ul>
        <li>
          <a href='home'>
            <i className="ri-home-line"></i>
            <span>Home</span>
          </a>
        </li>
        <li>
          <a href='contact'>
            <i className="ri-phone-fill"></i>
            <span>Contact Us</span>
          </a>
        </li>
        <li>
          <a href='about'>
            <i className="ri-information-line"></i>
            <span>About Us</span>
          </a>
        </li>
        <li>
          <a href='career'>
            <i className="ri-newspaper-line"></i>
            <span>Career</span>
          </a>
        </li>
      </ul>
      
    </div>
  )
}
