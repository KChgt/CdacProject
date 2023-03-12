import React, { useState } from 'react';
import { CountryDropdown } from 'react-country-region-selector';
import {

    MDBBtn,
    MDBInput,
    MDBCheckbox,
    MDBRadio
  }
  from 'mdb-react-ui-kit';
import CustomerService from '../../services/CustomerServices';
import { Form } from 'react-bootstrap';
import { toast } from 'react-toastify';
import { useNavigate } from 'react-router-dom';


const RegisterUser = ()=> {

  let [customerRegister,setCoustomerRegister] =  useState({firstName : '', lastName : '', email : '',gender : '', 
   password : '',contactNumber : 0, dataOfBirth : new Date(), dateOfRegistration : new Date() })
   let [address,setAddress] = useState({houseName : '',lane1 : '', lane2 : '',
   lane3 : '', landmark : '', city : '',district : '' , country : '', pincode : '',gpsLnogitude : 0.0, gpsLatitude : 0.0}); 
    let [confPas,setConfPas] = useState('');
    const [showText, setShowText] = useState(false);
    let [confPassword, setconfPass] = useState('');
    const navigate = useNavigate();
  
  const componentDidMount = (event)=> {
    event.preventDefault();
      navigator.geolocation.getCurrentPosition(function(position) {
        setAddress({...address, gpsLnogitude : position.coords.latitude, gpsLatitude : position.coords.longitude});
        console.log("Latitude is :", position.coords.latitude);
        console.log("Longitude is :", position.coords.longitude);
      });}

      const addele = (event)=>{
        event.preventDefault(); 
        const {name,value}=event.target
        setCoustomerRegister({...customerRegister,[name]:value});
    } 

    const mddele = (event)=>{
      event.preventDefault(); 
      const {name,value}=event.target
      setAddress({...address,[name]:value});
  } 

  const dateOfRegi = ()=> {
    const date = new Date();
  const year = date.getFullYear();
const month = String(date.getMonth() + 1).padStart(2, '0');
const day = String(date.getDate()).padStart(2, '0');
const dateString = `${year}-${month}-${day}`;
      console.log(dateString);
      setCoustomerRegister({...customerRegister, dateOfRegistration : dateString})

  }

    const submitData = (event)=> {
      event.preventDefault(); 
      if(customerRegister.password !== confPassword) {
        alert('passsword and confirm password not matched');
        setShowText(true);
        return;
      }
      const newjson =  {...customerRegister, address}
      console.log(JSON.stringify(customerRegister));
      console.log(JSON.stringify(newjson));
      CustomerService.addCustomer(newjson).then((responce)=> {
        toast.success("registration sucessfull " + responce.data.email);
        console.log(responce.data);
        setCoustomerRegister({firstName : '', lastName : '', email : '',gender : '', 
   password : '',contactNumber : 0, dataOfBirth : new Date(), dateOfRegistration : new Date() })

   setAddress({houseName : '',lane1 : '', lane2 : '',
   lane3 : '', landmark : '', city : '',district : '' , country : '', pincode : '',gpsLnogitude : 0.0, gpsLatitude : 0.0});
   setconfPass('');  
   setShowText(false);  
   navigate('/login');
  }).catch((err)=>{
        toast.error("something went wrong");
        console.log("something wents wrong", err);
      });
      };
    


    const checkPass =  (event)=> {
      event.preventDefault(); 
      setconfPass(event.target.value);
  
      
    }

    return (
        <div>
          <Form onSubmit={submitData}>
<MDBInput wrapperClass='mb-4'  style={{  border:'2px solid green', borderRadius : '10px'}}label='Name' value={customerRegister.firstName} id='form3' required name= 'firstName' type='text' onChange={addele}/>
<MDBInput wrapperClass='mb-4' style={{  border:'2px solid green', borderRadius : '10px'}} label='last name' id='form4' name= 'lastName' value={customerRegister.lastName} required  type='text' onChange={addele}/>
<MDBInput wrapperClass='mb-4' style={{  border:'2px solid green', borderRadius : '10px'}}label='Email' id='form5' name= 'email' value={customerRegister.email}  type='email' required onChange={addele}/>
Gender : &nbsp;
<MDBRadio name='gender' style={{  border:'2px solid green', borderRadius : '10px'}} id='inlineRadio4' required value='MALE' label='Male' inline onChange={addele} />
<MDBRadio name='gender' style={{  border:'2px solid green', borderRadius : '10px'}} id='inlineRadio5' required value='FEMALE'  label='Female' inline onChange={addele} />
<MDBRadio name='gender' style={{  border:'2px solid green', borderRadius : '10px'}} id='inlineRadio6' required value='OTHERS'  label='Others' inline onChange={addele} />
<br></br><br></br>
<MDBInput wrapperClass='mb-4' style={{  border:'2px solid green', borderRadius : '10px'}} name='password' required value={customerRegister.password}  label='Password' id='form6' type='password' onChange={addele}/>
<MDBInput wrapperClass='mb-4' style={{  border:'2px solid green', borderRadius : '10px'}} name='password2' required label='Confirm Password' value={confPassword} id='form7' type='password' onChange={checkPass}/> {showText &&<p style={{color: 'red'}}> password does not matched</p>}
<MDBInput wrapperClass='mb-4' style={{  border:'2px solid green', borderRadius : '10px'}}  name='contactNumber' minLength={10} required value={customerRegister.contactNumber} label='Contact' id='form28' type='number' onChange={addele}/>
<MDBInput wrapperClass='mb-4' style={{  border:'2px solid green', borderRadius : '10px'}} name='dataOfBirth' required value={customerRegister.dataOfBirth}  label='Date Of Birth' id='form8' type='date' onChange={addele}/>

<MDBInput wrapperClass='mb-4' style={{  border:'2px solid green', borderRadius : '10px'}}  name='houseName' required value={address.houseName}  label='House Name' id='form9' type='text' onChange={mddele}/>
<MDBInput wrapperClass='mb-4' style={{  border:'2px solid green', borderRadius : '10px'}} name='lane1' required value={address.lane1}  label='Line Number 1' id='form10' type='text' onChange={mddele}/>
<MDBInput wrapperClass='mb-4' style={{  border:'2px solid green', borderRadius : '10px'}} name='lane2' required value={address.lane2}  label='Line Number 2' id='form11' type='text' onChange={mddele}/>
<MDBInput wrapperClass='mb-4' style={{  border:'2px solid green', borderRadius : '10px'}} name='lane3' required value={address.lane3}  label='Line Number 3' id='form12' type='text' onChange={mddele}/>
<MDBInput wrapperClass='mb-4' style={{  border:'2px solid green', borderRadius : '10px'}} name='landmark' required value={address.landmark}  label='landmark' id='form13' type='text' onChange={mddele}/>
<MDBInput wrapperClass='mb-4' style={{  border:'2px solid green', borderRadius : '10px'}} name='city' required value={address.city}  label='City' id='form14' type='text' onChange={mddele}/>
<MDBInput wrapperClass='mb-4' style={{  border:'2px solid green', borderRadius : '10px'}} name='district' required value={address.district}  label='District' id='form15' type='text' onChange={mddele}/>
<MDBInput wrapperClass='mb-4' style={{  border:'2px solid green', borderRadius : '10px'}} name='pincode' required value={address.pincode}  label='Pincode' id='form16' type='text' onChange={mddele}/>

 <CountryDropdown
 value={address.country} required
 onChange={(value) => setAddress({...address,country:value})}
 style={{  border:'2px solid green', borderRadius : '10px'}}
/>
<br></br><br></br>

<br></br><br></br> 
<MDBBtn label='use current location' style={{  border:'2px solid green', borderRadius : '10px'}} required onClick={componentDidMount}>Use Current Location</MDBBtn>
<br></br>
<br></br>
<div className='d-flex justify-content-center mb-4'>
  <MDBCheckbox name='flexCheck' style={{  border:'2px solid green', borderRadius : '10px'}} required id='flexCheckDefault' label='I have read and agree to the terms' onClick={dateOfRegi}/>
</div>

<MDBBtn className="mb-4 w-100" type='submit' style={{  border:'2px solid green', borderRadius : '10px'}} >Sign up</MDBBtn>
</Form>
 </div>  );

}

export default RegisterUser;