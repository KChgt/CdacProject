import React ,{useState}from 'react'
import { Navigate,Outlet } from 'react-router-dom';
import { isLoginCustomer } from '../../authontication/CustomerAuthontication';
import CustomerBackdrop from './CustomerBackdrop';
import CustomerSidebar from './CustomerSidebar';
import CustomerToolbar from './CustomerToolbar';
import CustomerFooter from './CustomerFooter';
const CustomerBase =() => {
    const [sidebar, setSidebar] = useState(false);
    const toggleSidebar = ()=> {
    setSidebar((prevState)=>!prevState);
    }

    if(isLoginCustomer()){
  return (
    <div>
        <CustomerToolbar openSidebar={toggleSidebar} style={{ position: 'relative' }}/>
        <CustomerBackdrop sidebar={sidebar} closeSidebar={toggleSidebar} style={{ position: 'relative' }}/>
    <CustomerSidebar sidebar={sidebar} style={{ position: 'relative' }}/>  <Outlet/><CustomerFooter/>
    </div>
    
  )
    }
    else{
        return <Navigate to={'/'}/>
      }
}

export default CustomerBase