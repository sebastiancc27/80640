import MiFieldSet from "./MiFieldSet";/* SE IMPORTA MI FIELDSET O EL COMPONENTE DENTRO DE ESTE COMPONENTE */
import DatosPersonales from "./DatosPersonales";
import DatosEscolares from "./datosEscolares";
function Formulario() {/*! EL COMPONENTE ES FORMULARIO */
return (
<>
<form action="">
     <DatosPersonales></DatosPersonales>
    <DatosEscolares></DatosEscolares>
    <input type="submit" value="Enviar Datos" />
    </form>
</>
)
}

export default Formulario;