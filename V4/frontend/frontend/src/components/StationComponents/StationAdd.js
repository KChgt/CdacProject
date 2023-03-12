import { useState } from "react";
import { getStationEmail } from "../../authontication";
import StationServices from '../../services/StationServices';
import { toast } from "react-toastify";
import { CardHeader } from "reactstrap";

const AddSlots = () => {
    
  let [slotJson, setSlotJson] = useState({vehical : '', port : '' });
  let [numberOfSlot, setNumberOfSlots] = useState(0);

  const saveToDb = (event) => {
    event.preventDefault();
    const stationId = getStationEmail();
    console.log(stationId.chargingStationId);
    StationServices.addSlotsDb(slotJson, numberOfSlot, stationId.chargingStationId).then((responce) => {
      toast.success("data added successfully");
      setSlotJson({vehical : '', port : '' });
      setNumberOfSlots(0);
    }).catch((err) => {
      toast.error("something went wrong");
    });
  }

  return (
    
    <>
    <div style={{textAlign : 'center' , marginTop : '15%'}}>
      <h4  style={{color : 'green'}}>Add slots</h4>
    </div>
    <div style={{display: 'flex', justifyContent: 'center', marginTop : '-4px', color : 'white'}}>
      <form onSubmit={saveToDb} style={{border: '2px solid black', padding: '2%', backgroundColor: 'grey', display: 'flex', flexDirection: 'column', alignItems: 'center', height: '30vh', border : '2px solid green', borderRadius : '10px'}}>
        <label style={{marginBottom: '10px'}}>
          Select Vehicle Type:
          <select
            required
            value={slotJson.vehical}
            onChange={(event) => setSlotJson({...slotJson, vehical : event.target.value})}
            style={{marginLeft: '10px',border : '2px solid green', borderRadius : '5px' }}
          >
            <option value="">-- Select Vehicle Type --</option>
            <option value="TWOWHEELER">Two Wheeler</option>
            <option value="THREEWHEELER">Three Wheeler</option>
            <option value="FOURWHEELER">Four Wheeler</option>
          </select>
        </label>
        <label style={{marginBottom: '10px'}}>
          Select Port Type:
          <select
            required
            value={slotJson.port}
            onChange={(event) => setSlotJson({...slotJson, port : event.target.value})}
            style={{marginLeft: '10px',border : '2px solid green', borderRadius : '5px'}}
          >
            <option value="">-- Select Port Type --</option>
            <option value="ACTYPE1">AC TYPE 1</option>
            <option value="ACTYPE2">AC TYPE 2</option>
            <option value="DCCHADEMO">DC CHAdeMO</option>
            <option value="DCCSS">DC CCS</option>
            <option value="DCTYPE2">DC TYPE 2</option>
          </select>
        </label>
        <label style={{marginBottom: '10px'}}>
          Number of Slots:
          <input
            type="number"
            value={numberOfSlot}
            onChange={(event) => setNumberOfSlots(event.target.value)}
            min={1}
            style={{marginLeft: '10px',border : '2px solid green', borderRadius : '5px'}}
          />
        </label>
        <button type="submit" style={{marginTop: '10px', border : '2px solid #0842FD', backgroundColor : 'green', borderRadius : '5px'}}>Add Data</button>
      </form>
    </div>
    </>
  )
}

export default AddSlots;
