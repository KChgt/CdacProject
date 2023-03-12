import httpClient from "../http-common";




const addCustomer = (customer)=>{
    return httpClient.post("/customer", customer);
}

const logInCustomer = (logIn) =>{
    return httpClient.post("/customer/login", logIn);
 }

const Getall = ()=> {
    return httpClient.get("/customer");
}

const GetStationBook = (obj,time)=> {
    return httpClient.post(`station/time/${time}`,obj);
}
export default {addCustomer, Getall, logInCustomer,GetStationBook}

