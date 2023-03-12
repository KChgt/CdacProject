import React, { useState } from 'react'
import { Card,  CardBody, Row, Col, Container, Form, FormGroup, Input,Label,Button, CardHeader} from 'reactstrap'

const CustomerSearch=()=> {

  const [station,SetStation] =useState('');

  const findStation =(event)=>{
    event.preventDefault();
    SetStation(event.target.value)

  }

const handleSubmit =() =>{



}

  return (
    <div>
        <Container className='mt-4'>
          <Row className ='justify-content-center'>
            <Col sm={{size:6, offset:3}}>
    <Card color='dark'  inverse>
    <CardBody >
      <Form onSubmit={handleSubmit}>
        <FormGroup>

          <Label for="StationSearch">Search Station</Label>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          


          <FormGroup check inline>
      <Input
        name="station"
        type="radio"
        onChange={findStation}
        value ="city"
      />
      {' '}
      <Label check>
        By City
      </Label>
    </FormGroup>
    
    <FormGroup check inline>
      <Input
        name="station"
        type="radio"
        value="station"
        onChange={findStation}
      />
      {' '}
      <Label check>
        By Station
      </Label>
    </FormGroup>

    
    <FormGroup check inline>
      <Input
        name="station"
        type="radio"
        value="traiff"
        onChange={findStation}
      />
      {' '}
      <Label check>
        By Traiff
      </Label>
    </FormGroup>
    
    
    
    <Input
       type='text'
        name=''
        id=''   
          />
        </FormGroup>
        <Container className='text-center' id=''>
                         <Button color='primary'>Search</Button>
                         </Container>

      </Form>
    </CardBody>
    </Card>

            </Col >
          </Row>
        </Container>



        <Container className='mt-5'>
          <Row className ='justify-content-center'>
            <Col  sm={{size:6, offset:3}}>
            <Card color='dark' outline>
              
              <CardHeader className='text-center'>
              <h3>  Available Station List </h3>
              </CardHeader>
            </Card>
            </Col>
          </Row>
        </Container>
    </div>
  )
}

export default CustomerSearch;