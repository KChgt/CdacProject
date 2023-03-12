import React from 'react'
import Backdrop from '../Backdrop'
import Footer from '../Footer'
import Sidebar from '../Sidebar'
import Toolbar from '../Toolbar'
import { useState } from 'react'
import CarauselComp from './homeComponent/CarauselComp'

export default function AboutPage() {
  const [sidebar, setSidebar] = useState(false);
  const toggleSidebar = ()=> {
  setSidebar((prevState)=>!prevState);
  }
  return (
    <div style={{  color : 'white'}}>
      <Toolbar openSidebar={toggleSidebar}/>
      <Backdrop sidebar={sidebar} closeSidebar={toggleSidebar}/>
      <Sidebar sidebar={sidebar}></Sidebar>
      <CarauselComp/>
      <h1>AboutPage</h1>
    <p>We are leading EV charging station Booking services provider in 50+ countries including India</p>
   <Footer/>
   </div>
  )
}
