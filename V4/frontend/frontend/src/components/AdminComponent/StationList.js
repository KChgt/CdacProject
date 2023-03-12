
const StationInfo = (props)=> {
 
  

    return(
        <div   style={{ border: '1px solid #c71818',
        padding: '10px',marginBottom : '10px' ,marginTop : ' 10px', width : '45%', marginLeft : '30%', backgroundColor : 'ghostwhite' }} >
            <h4  style={{textAlignLast : 'end'}}>{props.station.stationName}</h4>
            <hr></hr>
            <h6>Email : & {props.station.email}</h6>
            <h6>Shop Ratings :  {props.station.shopRatings} </h6>
            <h6>Address :  {props.station.address.lane1}, {props.station.address.lane2},{props.station.address.lane3}, 
            {props.station.address.city}, {props.station.address.district}, {props.station.address.country} : {props.station.address.pincode}</h6>
        </div>

    );

}
export default StationInfo;