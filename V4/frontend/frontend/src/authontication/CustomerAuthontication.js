export const doLoginCustomer = (data, next)=> {
  

    localStorage.setItem("customerDetails",JSON.stringify(data));
     next();
 
 }


 export const isLoginCustomer= ()=> {
    let data = JSON.parse(localStorage.getItem("customerDetails"));
    console.log(data);
    if(data == null)
    return false;
    else
    return true;
 }

 export const doLogoutCustomer = ((next)=> {
    localStorage.removeItem("customerDetails");
next();
});


export const getCustomer = ()=> {
    if(isLoginCustomer){
        return JSON.parse(localStorage.getItem("customerDetails"));
    }
    else{
        return false;
    }
}

export const getCustomerEmail = ()=> {
    if(isLoginCustomer){
        console.log(getCustomer())
        return JSON.parse(localStorage.getItem("customerDetails"));
    }
    else{
        return false;
    }
}

