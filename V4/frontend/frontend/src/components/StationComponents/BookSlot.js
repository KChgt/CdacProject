import { useState } from "react";
import { Button, Card, Form, Nav } from "react-bootstrap";
import { TextCenter } from "react-bootstrap-icons";


const BookSlot = ()=> {
 
    const [toggleValue, setToggleValue] = useState("");
    const handleToggleChange = (event) => {
      setToggleValue(event.target.value);
    };

    let[vehicle1,setVehicle ] = useState('');
    let [port1,setPort] = useState('');



    const bookByCity = ()=> {
      

    }
    const bookByPort = ()=> {

    }

    const bookByLoc = ()=> {
      
    }

   
      
  
      
      
    return(<div >

        <Form>
        <div style={{ color : 'green', width: '65%', backgroundColor : 'grey',position: 'fixed', padding : '30PX', border : '3px solid green',  position : 'relativen', borderRadius : '10px',margin : '100px'}}>
      <h2 style={{color : 'green'}}>BOOK SLOT</h2>
     
            
            <label>Select type:</label>
            <select style={{margin : '5px', padding : '5px', borderRadius : '5px', border : '1px solid green', color : 'green'}}>
              <option value="TWOWHEELER">TWOWHEELER</option>
              <option value="THREEEWHEELER">THREEEWHEELER</option>
              <option value="FOURWHEELER">FOURWHEELER</option>
            
            </select>

            <label>Select port:</label>
            <select style={{margin : '16px', padding : '5px', borderRadius : '5px', border : '1px solid green', color : 'green'}}>
              <option value="ACTYPE1" >ACTYPE1</option>
              <option value="ACTYPE2">ACTYPE2</option>
              <option value="DCCHADEMO">DCCHADEMO</option>
              <option value="DCCSS">DCCSS</option>
              <option value="DCTYPE2">DCTYPE2</option>
            </select>
     
            <Button style={{borderRadius : '5px', backgroundColor : 'green'}} onClick={bookByPort}>Submit</Button>
    

      </div>
        </Form>
    </div>
   
    )
  

}
export default BookSlot;