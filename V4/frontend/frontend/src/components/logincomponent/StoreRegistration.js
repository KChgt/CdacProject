
import React, {useState} from 'react';


import {
    MDBBtn,
    MDBInput,
    MDBCheckbox,
  }
  from 'mdb-react-ui-kit';

import { CountryDropdown} from 'react-country-region-selector';
import StationServices from '../../services/StationServices';
import { Form } from 'react-bootstrap';
import { toast } from 'react-toastify';
import { useNavigate } from 'react-router-dom';

const StoreRegistration = ()=> {
   
    const [showText, setShowText] = useState(false);
    let [confPassword, setconfPass] = useState('');

  

    let [stationRegister,setstationRegister] =  useState({stationName : '', email : '', 
    password : '', shopRatings : 0.0 , contactNumber : 0,gstNumber : '',dateOfRegistration : new Date() });
    let [shopPhotos,setShopPhotos] = useState([]);
    let [address, setAddress] = useState({houseName : 'station',lane1 : '', lane2 : '',
    lane3 : '', landmark : '', city : '',district : '' , country : '',  pincode : '',gpsLnogitude : 0.0, gpsLatitude : 0.0,});
    const navigate = useNavigate();


        const componentDidMount = (event)=> {
          event.preventDefault();
            navigator.geolocation.getCurrentPosition(function(position) {
              setAddress({...address, gpsLnogitude : position.coords.latitude, gpsLatitude : position.coords.longitude});
              console.log("Latitude is :", position.coords.latitude);
              console.log("Longitude is :", position.coords.longitude);
            });}

            const dateOfRegi = ()=> {
              const date = new Date();
            const year = date.getFullYear();
          const month = String(date.getMonth() + 1).padStart(2, '0');
          const day = String(date.getDate()).padStart(2, '0');
          const dateString = `${year}-${month}-${day}`;
                console.log(dateString);
          setstationRegister({...stationRegister, dateOfRegistration : dateString})
         
            }

            const checkPass =  (event)=> {
              event.preventDefault(); 
           
              setconfPass(event.target.value);
            }
    
            const addPhotos = (event)=> {
              event.preventDefault();
              setShopPhotos(event.target.value);
            }

  const addele = (event)=>{
    event.preventDefault(); 
    const {name,value}=event.target
    setstationRegister({...stationRegister,[name]:value});
} 

const mddele = (event)=>{
  event.preventDefault(); 
  const {name,value}=event.target
  setAddress({...address,[name]:value});
} 

const submitRegistration = (event)=> {
  event.preventDefault(); 
  if(stationRegister.password !== confPassword) {
    alert('passsword and confirm password not matched');
    setShowText(true);
    return;
  }
 
  const newJson = {...stationRegister,address}
  console.log(newJson);
  StationServices.addStation(newJson).then((result)=>{
    toast.success("registration sucessfull " + result.data.stationName);
    console.log(result);
    setstationRegister({stationName : '', email : '', 
    password : '', shopRatings : 0.0 , contactNumber : 0,dateOfRegistration : new Date() , gstNumber : ''});
    setAddress({houseName : 'station',lane1 : '', lane2 : '',
    lane3 : '', landmark : '', city : '',district : '' , country : '', pincode : '',gpsLnogitude : 0.0, gpsLatitude : 0.0});
    setconfPass('');
    navigate('/login');
}).catch((err)=> {
  toast.error("something went wrong");
  console.log(err);
}); }

  
    return (
        <div>
          <Form onSubmit={submitRegistration}>
<MDBInput wrapperClass='mb-4' style={{  border:'2px solid green', borderRadius : '10px'}} required label='Station Name' name= 'stationName' value={stationRegister.stationName} id='form30' type='text' onChange={addele}/>
<MDBInput wrapperClass='mb-4' style={{  border:'2px solid green', borderRadius : '10px'}} required label='Email' name= 'email' id='form17' value={stationRegister.email} type='email' onChange={addele}/>
<MDBInput wrapperClass='mb-4' style={{  border:'2px solid green', borderRadius : '10px'}} required label='Password' name= 'password' value={stationRegister.password} id='form18' type='password' onChange={addele}/> {showText &&<p style={{color: 'red'}}> password does not matched</p>}
  <MDBInput wrapperClass='mb-4' style={{  border:'2px solid green', borderRadius : '10px'}} required label='Confirm Password' value={confPassword} name= 'pass2' id='form19' type='password'   onChange={checkPass}/>
  <MDBInput wrapperClass='mb-4' style={{  border:'2px solid green', borderRadius : '10px'}} required label='Contact' minLength={10} name= 'contactNumber' value={stationRegister.contactNumber} id='form20' type='text' onChange={addele}/>
  <MDBInput wrapperClass='mb-4' style={{  border:'2px solid green', borderRadius : '10px'}} required label='Line Number 1' name= 'lane1' value={address.lane1} id='form21' type='text' onChange={mddele}/>
  <MDBInput wrapperClass='mb-4' style={{  border:'2px solid green', borderRadius : '10px'}} required label='Line Number 2' name= 'lane2' value={address.lane2} id='form22' type='text' onChange={mddele}/>
  <MDBInput wrapperClass='mb-4' style={{  border:'2px solid green', borderRadius : '10px'}} required label='Line Number 3' name= 'lane3' value={address.lane3} id='form23' type='text' onChange={mddele}/>
  <MDBInput wrapperClass='mb-4' style={{  border:'2px solid green', borderRadius : '10px'}} required label='landmark' name= 'landmark' id='form27' value={address.landmark} type='text' onChange={mddele}/>
  <MDBInput wrapperClass='mb-4' style={{  border:'2px solid green', borderRadius : '10px'}} required label='City' name= 'city' id='form24' value={address.city} type='text' onChange={mddele}/>
  <MDBInput wrapperClass='mb-4' style={{  border:'2px solid green', borderRadius : '10px'}} required label='District' name= 'district' id='form25' value={address.district} type='text' onChange={mddele}/>
  <MDBInput wrapperClass='mb-4' style={{  border:'2px solid green', borderRadius : '10px'}} required label='Gst Number' name= 'gstNumber' id='form26' value={stationRegister.gstNumber} type='text' onChange={addele}/>
  <MDBInput wrapperClass='mb-4' style={{  border:'2px solid green', borderRadius : '10px'}} required name='pincode' value={address.pincode}  label='Pincode' id='form31' type='text' onChange={mddele}/>

 <p>Select Country : </p>
  <CountryDropdown
 value={address.country} required
 onChange={(value) => setAddress({...address,country:value})} style={{  border:'2px solid green', borderRadius : '10px'}} />
 
<br></br><br></br>

{/* <input className="form-control" required type="file" name='shopPhotos' value={shopPhotos} id="formFileMultiple" multiple onChange={addPhotos} /> */}
<br></br><br></br>
<MDBBtn label='use current location' style={{  border:'2px solid green', borderRadius : '10px'}} required onClick={componentDidMount}>Use Current Location</MDBBtn>
<br></br>
<br></br>

  <div className='d-flex justify-content-center mb-4'>
    
    <MDBCheckbox style={{  border:'2px solid green', borderRadius : '10px'}} name='flexCheck' required id='flexCheckDefault' label='I have read and agree to the terms' onClick={dateOfRegi} />
  </div>
  <MDBBtn style={{  border:'2px solid green', borderRadius : '10px'}} className="mb-4 w-100"  type='submit'>Sign up</MDBBtn>
  </Form>
 </div>
    );
}
export default StoreRegistration;