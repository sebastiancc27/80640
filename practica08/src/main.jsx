import React from 'react'
import ReactDOM from 'react-dom/client'
// import App from './App.jsx'
import './index.css'
// import MiFieldSet from './MiFieldSet'
import Formulario from './formulario'

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    {/* <App /> */}
    {/* <form action="">
    <MiFieldSet titulo="Datos Personales" txt1="Nombre" txt2="Password"/>
      <input type="submit" value="Enviar Datos" />
    </form> */}
    <Formulario></Formulario>
  </React.StrictMode>,
)
