const formularioJS=document.getElementById("formularioJS");
const parametros=["Nombre","Correo Electrónico"];
const parametros2=["Direccion","Ciudad"];
const boton=()=>{
    return ` <input type="submit" name="btnEnvia" id="btnEnvia" value="Enviar">`
}
const informacion=(legend,parametros)=>{
    for(let i=0;i<parametros.length;i++){        
        return`
        <fieldset>
        <legend>${legend}</legend>
        <label for="">${parametros[i]}</label>
        <input type="text" name="nombre" class="input">
        <label for="">${parametros[i+1]}</label>
        <input type="text" name="correo" class="input">
        </fieldset>` 
    }

}

   formularioJS.innerHTML+=informacion('Información Personal2',parametros);
   formularioJS.innerHTML+=informacion('Información de Dirección2',parametros2);
   formularioJS.innerHTML+=boton();
   