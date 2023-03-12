import { useState } from "react";
import { Button, Card, Form, Nav } from "react-bootstrap";
import { TextCenter } from "react-bootstrap-icons";
import CustomerServices from "../../services/CustomerServices";
import StationServices from "../../services/StationServices";


const CustomerBookSlot = ()=> {
 
    const [toggleValue, setToggleValue] = useState("");
    const handleToggleChange = (event) => {
      setToggleValue(event.target.value);
    };
    
    let [bookingDate, setBookingDate] = useState('');
    let [time, settime] = useState();
    let today = new Date().toISOString().split('T')[0];
    let maxDate = new Date(new Date().setDate(new Date().getDate() + 2)).toISOString().split('T')[0];
    let [searchStation,setSearchStation] = useState({location : '', date : '', vehicle : '', port : ''});
    let [location1,setlocation] = useState('');

      const intialiseJson = (event)=> {
        event.preventDefault(); 
        console.log('a');
        const {name,value}=event.target;
        setSearchStation({...searchStation,[name]:value});
      }




    const bookByPort = (event) => {
      event.preventDefault(); 
      console.log(bookingDate);
      setSearchStation({
        ...searchStation,
        date: bookingDate
      });
      console.log(searchStation);
      console.log(time);
      CustomerServices.GetStationBook(searchStation,time).then((result)=> {
        console.log("success");
        console.log(result);
      }).catch((err)=> {
        console.log(err);
      })
    }

    const setCity = (event)=> {
      event.preventDefault();
      setlocation(event.target.value)
    }

  
  
      return (
        <div style={{margin : '15%', padding : '20px', backgroundColor : 'grey', border : ' 3px solid green', borderRadius : '10px', color : 'white'}}>
          <label>Enter city name:</label>
          <input type="text" style={{margin : '5px', padding : '5px', borderRadius : '5px', border : '2px solid green'}} name='location' value={searchStation.location} onChange={intialiseJson}/>
          <label>Select type:</label>
          <select style={{margin : '5px', padding : '5px', borderRadius : '5px',border : '2px solid green'}} name='vehicle' value={searchStation.vehicle} onChange={intialiseJson}>
          <option value="" >select type</option>
            <option value="TWOWHEELER">TWOWHEELER</option>
            <option value="THREEEWHEELER">THREEEWHEELER</option>
            <option value="FOURWHEELER">FOURWHEELER</option>
          
          </select>

          <label>Select port:</label>
          <select style={{margin : '16px', padding : '5px', borderRadius : '5px',border : '2px solid green'}} name='port' value={searchStation.port} onChange={intialiseJson}>
          <option value="" >select port</option>
            <option value="ACTYPE1" >ACTYPE1</option>
            <option value="ACTYPE2">ACTYPE2</option>
            <option value="DCCHADEMO">DCCHADEMO</option>
            <option value="DCCSS">DCCSS</option>
            <option value="DCTYPE2">DCTYPE2</option>
          </select>
        <br></br>
          <label htmlFor="bookingDate">Booking Date:</label>
    <input 
      type="date" 
      id="bookingDate" 
      name="bookingDate"
      value={searchStation.date}
      min={today}
      max={maxDate}
      onChange={(event) => setSearchStation({...searchStation,date : event.target.value})}
      style={{margin : '16px', padding : '5px', borderRadius : '5px',border : '2px solid green'}}
    />

    <select      style={{margin : '16px', padding : '5px', borderRadius : '5px',border : '2px solid green'}}  onChange={(event) => settime(event.target.value)} >
      <option value=''>Selact time span</option>
      <option value='zero'> 00:00 to 01:00</option>
      <option value='one'> 01:00 to 02:00</option>
      <option value='two'> 02:00 to 03:00</option>
      <option value='three'> 03:00 to 04:00</option>
      <option value='four'> 04:00 to 05:00</option>
      <option value='five'> 05:00 to 06:00</option>
      <option value='six'> 06:00 to 07:00</option>
      <option value='seven'> 07:00 to 08:00</option>
      <option value='eight'> 08:00 to 09:00</option>
      <option value='nine'> 09:00 to 10:00</option>
      <option value='ten'> 10:00 to 11:00</option>
      <option value='eleven'> 11:00 to 12:00</option>
      <option value='twelve'> 12:00 to 13:00</option>
      <option value='thirteen'> 13:00 to 14:00</option>
      <option value='fourteen'> 14:00 to 15:00</option>
      <option value='fifteen'> 15:00 to 16:00</option>
      <option value='sixteen'> 16:00 to 17:00</option>
      <option value='seventeen'> 17:00 to 18:00</option>
      <option value='eighteen'> 18:00 to 19:00</option>
      <option value='nineteen'> 19:00 to 20:00</option>
      <option value='twenty'> 20:00 to 21:00</option>
      <option value='twenty-one'> 21:00 to 22:00</option>
      <option value='twenty-two'> 22:00 to 23:00</option>
      <option value='twenty-three'> 23:00 to 24:00</option>
    </select>
          <Button style={{borderRadius : '5px', backgroundColor : 'green'}} onClick={bookByPort}>Submit</Button>
        </div>

    );

}
export default CustomerBookSlot;