import React from 'react'

const CustomerSidebar =({sidebar}) => {
  return (
    <div className={sidebar?"sidebar sidebar--open": "sidebar"}>
        
        <li> <a href='home'><i class="ri-home-line" ></i>Home</a></li>
        <li><i class="ri-phone-fill"></i>Contact Us</li>
        <li ><i class="ri-information-line"></i>About Us </li>
        <li><i class="ri-newspaper-line"></i>Carrer</li>

    </div>
  )
}

export default CustomerSidebar