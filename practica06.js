const formulario=document.getElementById("formulario1");
let usuario=document.getElementById("usuario");
let contrasena=document.getElementById("password");
formulario.addEventListener("submit",(e)=>{
    e.preventDefault();
    alert(`EL usuario es ${usuario.value} y la contraseña es ${contrasena.value}`);
})
