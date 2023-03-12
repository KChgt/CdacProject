import {

    MDBBtn,
    MDBInput,
    MDBCheckbox,
    MDBRadio
  }
  from 'mdb-react-ui-kit';
import { useEffect, useState } from 'react';
import AdminServices from '../../services/AdminServices';
import { doLoginStation,doLogoutStation,getStation,isLoginStation } from '../../authontication';
import StationServices from '../../services/StationServices';
import { ToastContainer, toast } from 'react-toastify';
import CustomerServices from '../../services/CustomerServices';
import { Navigate, useNavigate } from 'react-router-dom';
import { Form } from 'react-bootstrap';
import { doLoginAdmin } from '../../authontication/AdminnAuthontication';
import { doLoginCustomer } from '../../authontication/CustomerAuthontication';


const LoginComp = ()=> {

let [loginJson, setLoginJSon] = useState({email : '', password : ''});
let  [role, setRole] = useState('');
const navigate = useNavigate();

const addele = (event)=>{
  event.preventDefault(); 
  const {name,value}=event.target
  setLoginJSon({...loginJson,[name]:value});
}

const addRole = (event) => {
  event.preventDefault(); 
  setRole(event.target.value);
}
const Submit = (event)=> {
  event.preventDefault();

    if(loginJson.email !== '' && loginJson.password !== ''  && role !== '') {
      console.log(loginJson)
    if(role === 'Admin') {
      AdminServices.logInAdmin(loginJson).then((responce)=> {
        doLoginAdmin(responce, ()=>{
          toast.success("log in sucessfull " + responce.data.email,{
            position: toast.POSITION.BOTTOM_CENTER
        });
          navigate("/admin/home");
        
         })
      }).catch((err)=>{
        toast.error("inv alid credinals " + err,{
          position: toast.POSITION.BOTTOM_CENTER
      });
      });
     
    }
    else if(role === 'Customer') {
      CustomerServices.logInCustomer(loginJson).then((responce)=> {
        console.log(responce.data);
        doLoginCustomer(responce.data,()=> {
          toast.success("log in sucessfull " + responce.data.email,{
            position: toast.POSITION.BOTTOM_CENTER
        })
        navigate("/customer/home");
        })
       
      }).catch((err)=>{
        toast.error("invalid credinals " + err,{
          position: toast.POSITION.BOTTOM_CENTER
      });
      });
    }
    else{
      StationServices.logInStation(loginJson).then((responce)=> {
      
        doLoginStation(responce, ()=>{
         toast.success("log in sucessfull " + responce.data.email);
         navigate("/station/home");
       
        })}).catch((err)=>{
        toast.error("invalid credinals " + err);
        console.log(err);
      });
    }
   
    }
    else{
      toast.error("all fields are compulsory");
    }

}



    return(
        <div >
        <Form onSubmit={Submit}>
              <MDBInput wrapperClass='mb-4' label='Email address' id='form1' type='email' value={loginJson.email} name='email' style={{ border:'2px solid green', borderRadius : '10px'}} required onChange={addele}/>
          <MDBInput wrapperClass='mb-4' label='Password' id='form2' type='password' value={loginJson.password} name='password' style={{ border:'2px solid green', borderRadius : '10px'}} required onChange={addele}/>
          i am &nbsp;&nbsp;&nbsp;
          <MDBRadio name='inlineRadio' id='inlineRadio1'  value='Admin' label='Admin'  onChange={addRole} required inline  style={{backgroundColor : 'grey', border:'2px solid green', borderRadius : '10px'}} />
      <MDBRadio name='inlineRadio' id='inlineRadio2' value='Customer' label='Customer' onChange={addRole} required inline  style={{backgroundColor : 'grey', border:'2px solid green', borderRadius : '10px'}}/>
      <MDBRadio name='inlineRadio' id='inlineRadio3' value='ChargingStation' label='Charging Station' required onChange={addRole} style={{backgroundColor : 'grey', border:'2px solid green', borderRadius : '10px'}} inline />

            <br></br><br></br>
          <div className="d-flex justify-content-between mx-4 mb-4">
        
            <a href="!#">Forgot password?</a>
          </div>
          
          <MDBBtn className="mb-4 w-100" style={{ border:'2px solid green', borderRadius : '10px'}} >Sign in</MDBBtn>
          </Form>
        </div>
    );
}

export default LoginComp;