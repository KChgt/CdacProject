
import { useState } from "react";
import AdminBackdrop from '../AdminComponent/AdminBackdrop';
import AdminFooter from '../AdminComponent/AdminFooter';
import AdminSidebar from '../AdminComponent/AdminnSidebar';
import AdminToolbar from '../AdminComponent/AdminToolbar';
import { Navigate, Outlet } from 'react-router-dom'
import { isLoginAdmin } from "../../authontication/AdminnAuthontication";

const AdminBase=() =>{
    const [sidebar, setSidebar] = useState(false);
    const toggleSidebar = ()=> {
    setSidebar((prevState)=>!prevState);
    }
    if(isLoginAdmin) {
      return (<div><AdminToolbar openSidebar={toggleSidebar} style={{ position: 'relative' }}/>
     
      <AdminBackdrop sidebar={sidebar} closeSidebar={toggleSidebar} style={{ position: 'relative' }}/>
      <AdminSidebar sidebar={sidebar} style={{ position: 'relative' }}/>  <Outlet/><AdminFooter/></div>);
    }
    else{
      return <Navigate to={'/'}/>
    }
  
  }
  
  export default AdminBase;
  