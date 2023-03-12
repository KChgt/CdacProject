import React from 'react'
import { Navigate, Outlet } from 'react-router-dom'
import { isLoginStation } from '../../authontication'
import StationSidebar from './StationSidebar'
import StationToolbar from './StationToolbar'
import StationBackdrop from './StationBackdrop'
import StationFooter from './StationFooter'
import { useState } from 'react'
import CarauselComp from '../logincomponent/homeComponent/CarauselComp'

const Base=() =>{
  const [sidebar, setSidebar] = useState(false);
  const toggleSidebar = ()=> {
  setSidebar((prevState)=>!prevState);
  }
  if(isLoginStation()) {
    return (<div><StationToolbar openSidebar={toggleSidebar} style={{ position: 'relative' }}/>
   
    <StationBackdrop sidebar={sidebar} closeSidebar={toggleSidebar} style={{ position: 'relative' }}/>
    <StationSidebar sidebar={sidebar} style={{ position: 'relative' }}/>  <Outlet/><StationFooter/></div>);
  }
  else{
    return <Navigate to={'/'}/>
  }

}

export default Base;
