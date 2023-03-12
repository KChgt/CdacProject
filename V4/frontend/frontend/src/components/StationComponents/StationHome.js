import React from 'react'
import { getStationEmail } from '../../authontication';
import CarauselComp from '../logincomponent/homeComponent/CarauselComp';
import ChargingStationInfo from './StationInfo';


const StationHome =()=>{



  return (
    <div>
   <ChargingStationInfo station={getStationEmail()}/>
      
    </div>
  )
}
export default StationHome;
