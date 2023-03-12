

export const doLoginAdmin = (data, next)=> {
  

    localStorage.setItem("adminCred",JSON.stringify(data));
     next();
 
 }
 
 export const isLoginAdmin= ()=> {
    let data = JSON.parse(localStorage.getItem("adminCred"));
    
    if(data == null)
    return false;
    else
    return true;
 }
 
 export const doLogouAdmin = ((next)=> {
     localStorage.removeItem("adminCred");
 next();
 });
 
 export const getAdmin = ()=> {
     if(isLoginAdmin){
         return JSON.parse(localStorage.getItem("adminCred"));
     }
     else{
         return false;
     }
 }
 
 export const getAdminEmail = ()=> {
     if(isLoginAdmin){
         console.log(getAdmin())
         return JSON.parse(localStorage.getItem("adminCred"))?.data;
     }
     else{
         return false;
     }
 }
 