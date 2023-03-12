import httpClient from "../http-common";



const addStation = (station)=>{
    return httpClient.post("/station", station);
}


// const addStation = (station, file) => {
//   const formData = new FormData();
//   formData.append('img', file);
//   formData.append('station', JSON.stringify(station));
  
//   return httpClient.post('/station/req', formData, {
//     headers: {
//       'Content-Type': 'multipart/form-data'
//     }
//   });
// };

  
const logInStation = (logIn) =>{
    return httpClient.post("/station/login", logIn);
 }

 const addSlotsDb = (slotinfo, numberOfSlots,stationId) => {
    slotinfo = {...slotinfo,chargingSlotId : 0}
    console.log(slotinfo);
 
    return httpClient.post(`/slot/addSlot/${numberOfSlots}/${stationId}`, slotinfo);
 }

const Getall = ()=> {
    return httpClient.get("/station");
}


const getAllSlots = (stationId)=> {
    return httpClient.get("slot/getslots",stationId).data;
}


const uploadFile = (file, chargingStationId) => {
    const formData = new FormData();
    formData.append('image', file);
    console.log(chargingStationId);
    return httpClient.post(`/station/upload/${chargingStationId}`, formData, {
      headers: {
        'Content-Type': 'multipart/form-data'
      }
    });
  };


  const getImage = (imageName) => {
    return httpClient.get(`station/image/${imageName}`, { responseType: 'arraybuffer' })
      .then(response => {
      const imageBytes = response.arrayBuffer();
        var blob = new Blob([imageBytes], { type: "image/jpeg" });
          var imageUrl = URL.createObjectURL(blob);
           return imageUrl;
      })
      .catch(error => console.log(error));
  };


//  const  downloadRandomImage = (imageName) => {
//     fetch(`http://localhost:8070/station/image/${imageName}`)
//       .then(response => {
//         const filename =  response.headers.get('Content-Disposition').split('filename=')[1];
//         response.blob().then(blob => {
//           let url = window.URL.createObjectURL(blob);
//           let a = document.createElement('a');
//           a.href = url;
//           a.download = filename;
//          return a;
//       });
//    });
//   }

const downloadRandomImage = (imageName) => {
  return fetch(`http://localhost:8070/station/image/${imageName}`)
    .then(response => {
      console.log(response);
      const filename = 'image1.jpg'
      return response.blob().then(blob => {
        let url = window.URL.createObjectURL(blob);
        let img = document.createElement('img');
        img.src = url;
        // img.download = filename;
        img.style.width = '30%';
        img.style.margin = '10px'
        img.className = 'fluid'
        img.style.border = '2px solid green'
        img.style.borderRadius = '10px' // Set width to 30%
        return img;
      });
    })
    .catch(error => console.log(error));
};


export default {addStation, Getall, logInStation,addSlotsDb,getAllSlots, uploadFile, getImage, downloadRandomImage}