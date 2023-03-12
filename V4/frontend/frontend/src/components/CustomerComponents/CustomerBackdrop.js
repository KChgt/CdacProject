import React from 'react'

export default function CustomerBackdrop({sidebar,closeSidebar}) {
    return (
        <div className={sidebar?"backdrop backdrop--open": "backdrop"} onClick={closeSidebar}></div>
      )
}
