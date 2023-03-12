import React, { useState, useEffect, useRef } from 'react';
import { Container, Row, Col, Card, Badge } from 'react-bootstrap';
import { Border } from 'react-bootstrap-icons';
import StationServices from '../../services/StationServices'

const ChargingStationInfo = ({ station }) => {
  const [imageLink, setImageLink] = useState('');
  const imageLinkRef = useRef(null);
  const [imgarr, setimgArr] = useState([]);

  useEffect(() => {
    const arr = station.image_names;
    const imgNames = arr.map(imgObj => imgObj.imageName);
    setimgArr(imgNames);
  }, [station]);
  
  useEffect(() => {
    imgarr.forEach((imgName) => {
      func(imgName);
    });
  }, [imgarr]);


  const func =  (image)=>{ StationServices.downloadRandomImage(image).then(a => {
    if (imageLinkRef.current) {
      // imageLinkRef.current.innerHTML = '';
      imageLinkRef.current.appendChild(a);
      console.log(imgarr)
    }
  })};



  return (
    <div>
      <Container className="mt-5">
      <div style={{ Border : '2px solid green', }} ref={imageLinkRef}>
          {imageLink}
        </div>
        <Row className="justify-content-center" style={{marginTop : '10%'}}>
          <Col md={6}>
            <Card style={{backgroundColor : 'grey', color : 'white', border : '2px solid green', borderRadius : '10px'}}>
              <Card.Body>
                <Card.Title className="text-center mb-4 custom-title">{station.stationName}</Card.Title>
                <Card.Subtitle className="mb-2 text-muted text-center" style={{color : 'white'}}>{`Station ID: ${station.chargingStationId}`}</Card.Subtitle>
                <Card.Text>
                  <p><strong>Email:</strong> {station.email}</p>
                  <p><strong>GST Number:</strong> {station.gstNumber}</p>
                  <p><strong>Date of Registration:</strong> {station.dateOfRegistration}</p>
                  <p><strong>Shop Ratings:</strong> <Badge variant="primary">{station.shopRatings}</Badge></p>
                  <hr />
                  <p><strong>Address:</strong></p>
                  <p>{station.address.houseName}, {station.address.lane1}, {station.address.lane2}, {station.address.lane3}, {station.address.landmark}</p>
                  <p>{station.address.city}, {station.address.district} - {station.address.pincode}, {station.address.country}</p>
                </Card.Text>
       
              </Card.Body>
            </Card>
          </Col>
        </Row>
        
      </Container>
     
    </div>
  );
}; export default ChargingStationInfo;