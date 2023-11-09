package mx.uv;
import static spark.Spark.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // System.out.println( "Hola Mundo!" );
        //fuente:https://gist.github.com/saeidzebardast/e375b7d17be3e0f4dddf

    options("/*",(request,response)->{

    String accessControlRequestHeaders=request.headers("Access-Control-Request-Headers");
    
    if(accessControlRequestHeaders!=null){
    
    response.header("Access-Control-Allow-Headers",accessControlRequestHeaders);
    
    }
    
    String accessControlRequestMethod=request.headers("Access-Control-Request-Method");
    
    if(accessControlRequestMethod!=null){
    
    response.header("Access-Control-Allow-Methods",accessControlRequestMethod);
    
    }
    
    return "OK";
    
    });
    
    before((request,response)->response.header("Access-Control-Allow-Origin","*"));
        /* EN EL CUERPO DE LA FUNCIÓN SE DEBE DEVOLVER ALGO EN CASO DE TENER MUCHAS COSAS*/
        get("/",(request,response)->"<h1>Hola CR7</h1>");
        /*Se le pasan dos parámetros 1.-UNA RUTA, 2.-FUNCIÓN LAMBDA*/
        /*REQUEST MANIPULA LAS PETICIONES DEL CLIENTE */
        /*RESPONSE NOS PERMITE DEVOLVER LAS RESPUTAS AL CLIENTE */
        get("/ruta1",(request,response)->"<h1>CR7 GOAT</h1>");
         get("/ruta2",(request,response)->"{'alumno':'Jhon','matricula':'zS21016334','apodo':'El GOAT'}");
         get("/ruta3",(request,response)->"{\"alumno\":\"Jhon\",\"matricula\":\"zS21016334\",\"carrera\":\"TC\"}");
    }
}
