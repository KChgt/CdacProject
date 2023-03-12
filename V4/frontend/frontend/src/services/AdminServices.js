import httpClient from "../http-common";

const logInAdmin = (logIn) =>{
    return httpClient.post("/admin/login", logIn);
 }

 


  export default {logInAdmin}