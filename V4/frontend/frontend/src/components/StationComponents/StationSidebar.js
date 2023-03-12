import React, { useState } from 'react';

export default function StationSidebar({ sidebar }) {
  const [hoveredItem, setHoveredItem] = useState(null);

  const handleMouseEnter = (event, item) => {
    event.preventDefault();
    setHoveredItem(item);
  };

  const handleMouseLeave = (event) => {
    event.preventDefault();
    setHoveredItem(null);
  };

  const getTextColor = (item) => {
    if (item === hoveredItem) {
      return 'black';
    } else {
      return 'white';
    }
  };

  return (
    <div className={sidebar ? 'sidebar sidebar--open' : 'sidebar'}>
      <ul>
        <li
          onMouseEnter={(event) => handleMouseEnter(event, 'home')}
          onMouseLeave={handleMouseLeave}
        >
          <a
            href='home'
            style={{
              textDecoration: 'none',
              color: getTextColor('home'),
            }}
          >
            <i
              className='ri-home-line'
              style={{ color: getTextColor('home') }}
            ></i>{' '}
            &nbsp;&nbsp;&nbsp; Home
          </a>
        </li>
        <li
          onMouseEnter={(event) => handleMouseEnter(event, 'contact')}
          onMouseLeave={handleMouseLeave}
        >
          <a
            href='contact'
            style={{
              textDecoration: 'none',
              color: getTextColor('contact'),
            }}
          >
            <i
              className='ri-phone-fill'
              style={{ color: getTextColor('contact') }}
            ></i>
            &nbsp;&nbsp;&nbsp; Contact Us
          </a>
        </li>
        <li
          onMouseEnter={(event) => handleMouseEnter(event, 'about')}
          onMouseLeave={handleMouseLeave}
        >
          <a
            href='about'
            style={{
              textDecoration: 'none',
              color: getTextColor('about'),
            }}
          >
            <i
              className='ri-information-line'
              style={{ color: getTextColor('about') }}
            ></i>
            &nbsp;&nbsp;&nbsp; About Us
          </a>
        </li>
        <li
          onMouseEnter={(event) => handleMouseEnter(event, 'career')}
          onMouseLeave={handleMouseLeave}
        >
          <a
            href='career'
            style={{
              textDecoration: 'none',
              color: getTextColor('career'),
            }}
          >
            <i
              className='ri-newspaper-line'
              style={{ color: getTextColor('career') }}
            ></i>
           &nbsp;&nbsp;&nbsp;  Career
          </a>
        </li>
      </ul>
    </div>
  );
}
