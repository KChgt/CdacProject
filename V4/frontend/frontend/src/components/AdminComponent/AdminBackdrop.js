import React from 'react';

export default function AdminBackdrop({sidebar, closeSidebar}) {
  return (
    <div className={sidebar?"backdrop backdrop--open": "backdrop"} onClick={closeSidebar}></div>
  )
}
