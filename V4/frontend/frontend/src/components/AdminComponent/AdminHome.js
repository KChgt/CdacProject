import { useState } from "react";
import StationServices from '../../services/StationServices'
import { useEffect } from "react";
import StationInfo from "./StationList";


const  AdminHome = ()=> {
    let [allStation, setAllStation] = useState([]);
 
    useEffect(() => {
        // Your code here
        console.log('Component loaded');
        StationServices.Getall().then((responce)=> {
            setAllStation(responce.data);
        }).catch((err)=> {
            console.log("error" + err);
        })
      }, []); 

    return(
        <div>
        <h1 style={{textAlign : 'center', margin : '10px', color : 'green'}}> Station List </h1>
            {allStation.map((x,index)=> {
                return <StationInfo  station={x}/>
            })}
            
        </div>
    )
}
export default AdminHome;