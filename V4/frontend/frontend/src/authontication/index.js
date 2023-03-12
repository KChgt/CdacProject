


export const doLoginStation = (data, next)=> {
  

   localStorage.setItem("stationCred",JSON.stringify(data));
    next();

}

export const isLoginStation= ()=> {
   let data = JSON.parse(localStorage.getItem("stationCred"));
   
   if(data == null)
   return false;
   else
   return true;
}

export const doLogoutStation = ((next)=> {
    localStorage.removeItem("stationCred");
next();
});

export const getStation = ()=> {
    if(isLoginStation){
        return JSON.parse(localStorage.getItem("stationCred"));
    }
    else{
        return false;
    }
}

export const getStationEmail = ()=> {
    if(isLoginStation){
        console.log(getStation())
        return JSON.parse(localStorage.getItem("stationCred"))?.data;
    }
    else{
        return false;
    }
}

