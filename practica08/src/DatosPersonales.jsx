function DatosPersonales() {
    
    return (
<>
<fieldset>
        <legend>Datos Personales</legend>
        <label htmlFor="nombre">Nombre:</label>
        <input type="text" id="nombre"/>
        <label htmlFor="nombre">Apellido paterno:</label>
        <input type="text" id="apelidoPaterno"/>
        <label htmlFor="nombre">Apellido Materno:</label>
        <input type="text" id="apellidoMaterno"/>
        <label htmlFor="nombre">Contraseña:</label>
        <input type="password" id="password"/>
    </fieldset>
</>

    );
}
export default DatosPersonales;