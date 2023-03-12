import React from 'react'
import { getCustomer, getCustomerEmail } from '../../authontication/CustomerAuthontication'
import CustomerInfo from './CustomerInfo'

const CustomerHome=() => {
  return (
    <div>
        <CustomerInfo customer={getCustomer()}/>
    </div>
  )
}

export default CustomerHome