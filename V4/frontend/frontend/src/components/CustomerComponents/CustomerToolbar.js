import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';

import { doLogoutCustomer, getCustomerEmail } from '../../authontication/CustomerAuthontication'

const CustomerToolbar=({openSidebar})=> {
   const [customerData, SetCustomerData] = useState(getCustomerEmail);
   const navigate = useNavigate();

   const doLogout =()=>{
      doLogoutCustomer (()=>{
         navigate('/')
      })
   }
   const findStation =()=>{
      navigate('/customer/stationSearch')
   }
  return (
    <div>
    <div className='tool-bar navbar navbar-expand-lg'>
        <div className='burger' onClick={openSidebar}>
        <i className="ri-menu-line"></i>
        </div>
    <div className='title navbar-brand' style={{color : 'green'}}>Charge EV</div>
    <ul className="navbar-nav ">
       
    
        <li className="nav-item">
           <a className='nav-link' href='' style={{color : 'white'}}  onClick={findStation}> Find Station</a>
        </li>
    </ul>

    <ul className="navbar-nav ms-auto">
    <li className="nav-item">{customerData.email} </li>
    &nbsp;   &nbsp;   &nbsp;   &nbsp;
    <li className="nav-item" onClick={doLogout}> LogOut </li>
    </ul>

    
   
    </div>
   
   </div>
  )
}

export default CustomerToolbar