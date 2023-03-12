import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';
import { doLogouAdmin, getAdminEmail } from '../../authontication/AdminnAuthontication';
import './AdminSidebar.css' // Import CSS file with custom styles
import CarauselComp from '../logincomponent/homeComponent/CarauselComp';


export default function AdminToolbar({openSidebar}) {
 let [adminName,setAdminaName] = useState(getAdminEmail);
const navigate = useNavigate();
 const doLogout = ()=> {
   doLogouAdmin(()=> {
      toast.success('logout sucessfully' + adminName.email);
      navigate('/')
   
   })
 }
  return (
   <div>
    <div className='tool-bar navbar navbar-expand-lg'>
        <div className='burger' onClick={openSidebar}>
        <i className="ri-menu-line"></i>
        </div>
    <div className='title navbar-brand' style={{color : 'green'}}>Charge EV</div>
    <ul className="navbar-nav ">
        
        <li className="nav-item" >
           <a className='nav-link' href='complaint' style={{color : 'white'}}> view complaint</a>
        </li>
        
    </ul>

    <ul className="navbar-nav ms-auto">
    <li className="nav-item">{adminName.email} </li>
    &nbsp;   &nbsp;   &nbsp;   &nbsp;
    <li className="nav-item" onClick={doLogout}> LogOut </li>
    </ul>


    </div>
   
   </div>
  )
}
