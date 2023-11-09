import {Button, TextField, Box} from "@mui/material";
import { useState } from "react";
import axios from "axios";

function Formulario() {
    const [cargando, setCargando] = useState(false); // !hook que hace que el boton se bloque
    const [datosFormulario, setDatosFormulario]= useState( //!hook que guarda los datos del formulario
        {  //! DATOSFORMULARIO ESTA DECLARADO COMO UN OBJETO
            nombre:'',
            password:''
        }
    );
    const hacerPeticion= async ()=>{
        try{
            const respuesta=await axios.get('http://localhost:4567/ruta3');
            console.log(respuesta.data);
            return respuesta.data; //! DATA ES UN OBJETO 
        }catch(error){
            throw error;
        }
    }
    
    const procesarFormulario= async (evento)=>{
        evento.preventDefault();
        console.log("Datos recuperados del formulario: ", datosFormulario);
        setCargando(true);// se bloquea el boton de envio despues de enviarlo
        try{
            const respuesta= await hacerPeticion() ;//el resultado de la respuesta de la función que
            // manda los datos del formulario se guarda en la variable respuesta
            // console.log(respuesta);
            setCargando(false);
            //! SE VALIDAN LOS DATOS DEL FORMULARIO 
            // console.log("Repuesta del servidor",respuesta.alumno);
            // console.log("Input del formulario", datosFormulario.nombre);
            if(datosFormulario.nombre == respuesta.alumno){
                console.log("El usuario es correcto");
            }else{
                console.log("El usuario no es correcto");
            }
        }catch(error){
            // console.log("Error: ", error)
            setCargando(false)
        }
    }
    //?ESTA ES UNA FUNCIÓN ANÓNIMA
    const cambiosFormulario=(evento)=>{
        // console.log(evento.target);
        const {name,value} =evento.target  //!SE DESESTRUCTURA LO QUE TENGA EL VALOR DEL TARGET
        //! SE GUARDA EL VALOR DEL LOS ELEMENTO QUE TENGAN LA FUNCIÓN DE CAMIOSFORMULARIO Y 
        //! Y LO DESESTRUCTURA EN  NAME Y VALUE
        setDatosFormulario({
            ...datosFormulario, //! SE GUARDA LA COPIA DEL VALOR DE LA VARIABLE 
            [name]: value //! Y SE HACE LA ACTUALIZACIÓN DE LOS DATOS
            //? name y value son propiedades de los textfields abajoa
        
        })
    }
    //! EN LO TEXTFIELDS SE TIENE LA FUNCION DE CAMBIOS POR LO TANTO GUARDA EL VALOR DEL INPUT
    return  (

    <>
    <h1>Inicio de sesión</h1>
    <form onSubmit={procesarFormulario}>
        <Box m={5}>
            <TextField label="Nombre: " variant="outlined" fullWidth onChange={cambiosFormulario} name="nombre" value={datosFormulario.nombre}></TextField>

        </Box>

        <Box m={5}>
            <TextField label="Contraseña: " variant="outlined" type="password" fullWidth onChange={cambiosFormulario} name="password" value={datosFormulario.password}></TextField>
        </Box>

        <Box m={5}>
           <Button variant="contained" type="submit" color="primary" fullWidth disabled={cargando}>Iniciar Sesion</Button>
        </Box>
    </form>
    </>
);
}
export default Formulario;