import React, { useState } from 'react';

import {
  MDBContainer,
  MDBTabs,
  MDBTabsItem,
  MDBTabsLink,
  MDBTabsContent,
  MDBTabsPane,
}
from 'mdb-react-ui-kit';
import LoginComp from './LogInComp';
import RegisterUser from './RegestierUser';
import StoreRegistration from './StoreRegistration';
import Backdrop from '../Backdrop';
import Footer from '../Footer';
import Sidebar from '../Sidebar';
import Toolbar from '../Toolbar'



function MainPage() {
    

  const [justifyActive, setJustifyActive] = useState('tab1');;

  const handleJustifyClick = (value) => {
    if (value === justifyActive) {
      return;
    }

    setJustifyActive(value);
  };

  const [sidebar, setSidebar] = useState(false);
  const toggleSidebar = ()=> {
  setSidebar((prevState)=>!prevState);
  }
  

  return (
<div >
    <Toolbar openSidebar={toggleSidebar}/>
    <Backdrop sidebar={sidebar} closeSidebar={toggleSidebar}/>
    <Sidebar sidebar={sidebar}/> 


    <MDBContainer className="p-3 my-5 d-flex flex-column w-50" style={{backgroundColor : 'grey', border:'2px solid green', borderRadius : '10px'}}>
      <MDBTabs sucess pills justify className='mb-3 d-flex flex-row justify-content-between custom-tabs' style={{backgroundColor : 'grey', border:'2px solid green', borderRadius : '10px'}} >
        <MDBTabsItem>
          <MDBTabsLink onClick={() => handleJustifyClick('tab1')} active={justifyActive === 'tab1'}>
            Login
          </MDBTabsLink>
        </MDBTabsItem>
        <MDBTabsItem>
          <MDBTabsLink onClick={() => handleJustifyClick('tab2')} active={justifyActive === 'tab2'}>
            Register
          </MDBTabsLink>
        </MDBTabsItem>
      </MDBTabs>

      <MDBTabsContent>

        <MDBTabsPane show={justifyActive === 'tab1'}>

           
      <LoginComp/>
        

        </MDBTabsPane>

        <MDBTabsPane show={justifyActive === 'tab2'}>
        <MDBTabs pills justify className='mb-3 d-flex flex-row justify-content-between' style={{backgroundColor : 'grey', border:'2px solid green', borderRadius : '10px'}}>
        <MDBTabsItem>
          <MDBTabsLink onClick={() => handleJustifyClick('tab2')} active={justifyActive === 'tab2'}>
          Customer rigistation
          </MDBTabsLink>
        </MDBTabsItem>
        <MDBTabsItem>
          <MDBTabsLink onClick={() => handleJustifyClick('tab3')} active={justifyActive === 'tab3'}>
            Station registration
          </MDBTabsLink>
        </MDBTabsItem>
      </MDBTabs>

      <RegisterUser/>
         

        </MDBTabsPane>
        
        <MDBTabsPane show={justifyActive === 'tab3'}>
      <StoreRegistration/>
        </MDBTabsPane>

      </MDBTabsContent>

    </MDBContainer>
    <Footer/>
    </div>
  );
}

export default MainPage;