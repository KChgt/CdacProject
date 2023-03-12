import React from 'react';

export default function StationBackdrop({sidebar, closeSidebar}) {
  return (
    <div className={sidebar?"backdrop backdrop--open": "backdrop"} onClick={closeSidebar}></div>
  )
}
