import React from 'react'
import { Button, Card, CardBody, CardHeader, Col, Container, Form, FormGroup, Input, Label, Row } from 'reactstrap'


const CustomerInfo =({customer}) => {
  return (
    <div>
      <Container className='mt-5'>
        <Row className ='justify-content-center'>
          <Col sm={{size:6, offset:3}}>
            <Card color='dark' outline>

              <CardHeader className='text-center'>
                <h3>Customer Details</h3>

              </CardHeader>

              <CardBody>

                <p><strong>CustomerId:</strong>{customer.customerId}</p>
                <p><strong>CustomerFirstName:</strong>{customer.firstName}</p>
                <p><strong>CustomerLastName:</strong>{customer.lastName}</p>
                <p><strong>Date of Birth:</strong>{customer.dataOfBirth}</p>
                <p><strong>Gender:</strong>{customer.gender}</p>
                <p><strong>CustomerEmail:</strong>{customer.email}</p>
               
                <p><strong>ContactNo:</strong>{customer.contactNumber}</p>
                <p><strong>Date of Registration:</strong>{customer.dateOfRegistration}</p>
              </CardBody>
            </Card>
          
          
          </Col>
        </Row>
      </Container>

    </div>
  )
}

export default CustomerInfo