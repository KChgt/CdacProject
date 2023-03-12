import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';
import { doLogoutStation, getStation, getStationEmail } from '../../authontication';
import CarauselComp from '../logincomponent/homeComponent/CarauselComp';

export default function StationToolbar({openSidebar}) {
  let [stationName, setStationaName] = useState(getStationEmail);

  const navigate = useNavigate();
  const doLogout = () => {
    doLogoutStation(() => {
      toast.success('logout sucessfully' + stationName.email);
      navigate('/');
    });
  };

  const handleMouseEnter = (event) => {
    event.preventDefault();
    event.target.style.color = 'black';
  };

  const handleMouseLeave = (event) => {
    event.preventDefault();
    event.target.style.color = 'white';
  };

  return (
    <div>
      <div className='tool-bar navbar navbar-expand-lg'>
        <div className='burger' onClick={openSidebar}>
          <i className='ri-menu-line'></i>
        </div>
        <div className='title navbar-brand' style={{ color: 'green' }}>
          Charge EV
        </div>
        <ul className='navbar-nav'>
          <li className='nav-item'>
            <a className='nav-link' href='bookSlot' style={{ color: 'white' }} onMouseEnter={handleMouseEnter} onMouseLeave={handleMouseLeave}>
              Book Slot
            </a>
          </li>
          <li className='nav-item'>
            <a className='nav-link' href='addSlot' style={{ color: 'white' }} onMouseEnter={handleMouseEnter} onMouseLeave={handleMouseLeave}>
              Add slots
            </a>
          </li>
          <li className='nav-item'>
            <a className='nav-link' href='addphotos' style={{ color: 'white' }} onMouseEnter={handleMouseEnter} onMouseLeave={handleMouseLeave}>
              Add Shop photos
            </a>
          </li>
        </ul>

        <ul className='navbar-nav ms-auto'>
          <li className='nav-item'>{stationName.email} </li>
          &nbsp; &nbsp; &nbsp; &nbsp;
          <li className='nav-item' onClick={doLogout} onMouseEnter={handleMouseEnter} onMouseLeave={handleMouseLeave}>
            LogOut
          </li>
        </ul>
      </div>
    </div>
  );
}
