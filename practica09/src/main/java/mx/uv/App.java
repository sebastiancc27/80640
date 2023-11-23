package mx.uv;
import static spark.Spark.*;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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
        get("/index.html",(request,response)->"<h1>Hola CR7</h1>");
        /*Se le pasan dos parámetros 1.-UNA RUTA, 2.-FUNCIÓN LAMBDA*/
        /*REQUEST MANIPULA LAS PETICIONES DEL CLIENTE */
        /*RESPONSE NOS PERMITE DEVOLVER LAS RESPUTAS AL CLIENTE */
        post("/", (request,response)->"Soy el post");
        // delete("/index.html", (request,response)->"Hola");
        get("/ruta1",(request,response)->{
            String parametro=request.queryParams("password");
            System.out.println("Tipo de contenido: "+request.contentType());
            System.out.println(request.queryParams("password"));
            //! EN QUERY PARAMS  se pasa como parametro el name del input que queremos obtener
            //?     ESTE SE MOSTRARÁ EN LA CONSOLA
            return "<h1>Adios mundo "+parametro+" </h1>";
        });//CADA RUTA ES UN RECURSO

        post("/ruta1",(request,response)->{
            String parametro=request.queryParams("password");
            System.out.println("Tipo de contenido: "+request.contentType());
            // System.out.println(request.params(null));
        System.out.println(request.queryParams("password"));
            //! EN QUERY PARAMS  se pasa como parametro el name del input que queremos obtener
            //?     ESTE SE MOSTRARÁ EN LA CONSOLA
            return "<h1>Adios mundo "+parametro+" </h1>";
        });
        //EL NOMBRE SE CAPTURA DEL FORMULARIO
         get("/ruta2",(request,response)->{
            //! cuando es get se recupeta como query params
            String parametro=request.queryParams("nombre");
            System.out.println("Tipo de contenido: "+request.contentType());
            JsonObject respuesta= new JsonObject();
            
            respuesta.addProperty("msj", "hola");
            respuesta.addProperty("apellido", parametro);

            response.type("application/json");
            return respuesta;
         });

            post("/ruta2",(request,response)->{
            // String parametro=request.queryParams("nombre");
            //!CUANDO ES POR EL METODO POST, SE RECUPERA POR EL METODO request.body
            String parametro =request.body();
            System.out.println("Tipo de contenido: "+request.contentType());
            System.out.println("EL BODY TIENE: "+parametro);
            //!SE HACE UN OBJETO PARA LA CONVERSION
            JsonParser parser=new JsonParser();
            //ESTE OBJETO SIRVE PARA ACCEDER A LOS ELEMENETOS DE LA PETICIÓN EN JSON
            //! SE GUARDA EN ARBOL EL PARAMETRO DEL BODY
            JsonElement arbol=parser.parse(parametro);


            //ESTE OBJETO SIRVE PARA CONSTRUIR LA RESPUESTA EN JSON
            JsonObject respuesta= new JsonObject();            
            respuesta.addProperty("msj", "hola");
            respuesta.addProperty("apellido", arbol.getAsJsonObject().get("nombre").toString());
            
            response.type("application/json");
            return respuesta;
         });


         get("/ruta3",(request,response)->{
            System.out.println("Esto es el request "+request.contentType());
            response.type("application/json");
            return "{\"alumno\":\"Jhon\",\"matricula\":\"zS21016334\",\"carrera\":\"TC\"}";
         });
    }
}
