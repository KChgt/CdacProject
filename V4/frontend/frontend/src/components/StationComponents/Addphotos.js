import React, { useState } from 'react';
import { toast } from 'react-toastify';
import { getStationEmail } from '../../authontication';
import StationServices from '../../services/StationServices';

const FileUploader = () => {
  const [selectedFile, setSelectedFile] = useState(null);

  const handleFileInputChange = (event) => {
    setSelectedFile(event.target.files[0]);
  };

  const handleFormSubmit = (event) => {
    event.preventDefault();
    if (selectedFile) {
        StationServices.uploadFile(selectedFile, getStationEmail().chargingStationId)
        .then((response) => {
          console.log('File uploaded successfully:', response.data);
          toast.success("file sucessfully upload");
          setSelectedFile(null);
        })
        .catch((error) => {
          console.error('Error uploading file:', error);
        });
    }
  };

  return (
    <div style={{width : '40%' , backgroundColor : 'grey', color : 'blue', marginLeft : '40%', marginTop: '10%', border:'2px solid green', borderRadius : '5px', padding: '10px', color : 'white'}}>
    <form onSubmit={handleFormSubmit}>
        <h3 style={{color : 'green'}}> Upload Station Images</h3>
      <input type="file"  onChange={handleFileInputChange} style={{margin : '10px', padding : '5px', borderRadius : '5px' }} />
      <button type="submit" style={{margin : '10px', padding : '5px', border:'2px solid green', color : 'green', borderRadius : '5px'}}>Upload</button>
    </form>
    </div>
  );
};

export default FileUploader;