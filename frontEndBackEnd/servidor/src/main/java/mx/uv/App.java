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
        String[] datos=new String[2];
        get("/", (request,response)->"Hola");
        get("/ruta2",(request,response)->{
            
            // String parametro=request.queryParams("nombre");
            //!CUANDO ES POR EL METODO POST, SE RECUPERA POR EL METODO request.body
             String nombre=request.queryParams("nombre");
             String apellido=request.queryParams("apellido");
            
             datos[0]=nombre;
             datos[1]=apellido;


            //ESTE OBJETO SIRVE PARA CONSTRUIR LA RESPUESTA EN JSON
            JsonObject respuesta= new JsonObject();            
            respuesta.addProperty("nombre",nombre);
            respuesta.addProperty("apellido", apellido);
            
            response.type("application/json");
            return respuesta;
         });
         
            get("/ruta3",(request,response)->{
            
            // String parametro=request.queryParams("nombre");
            //!CUANDO ES POR EL METODO POST, SE RECUPERA POR EL METODO request.body
             String nombre= datos[0];
             String apellido=datos[1];
            

            //ESTE OBJETO SIRVE PARA CONSTRUIR LA RESPUESTA EN JSON
            JsonObject respuesta= new JsonObject();            
            respuesta.addProperty("nombre",nombre);
            respuesta.addProperty("apellido", apellido);
            
            response.type("application/json");
            return respuesta;
         });

         get("/ruta4",(request,response)->{
            
            // String parametro=request.queryParams("nombre");
            //!CUANDO ES POR EL METODO POST, SE RECUPERA POR EL METODO request.body
             String nombre= datos[0]=" ";
             String apellido=datos[1]=" ";
            

            //ESTE OBJETO SIRVE PARA CONSTRUIR LA RESPUESTA EN JSON
            JsonObject respuesta= new JsonObject();            
            respuesta.addProperty("nombre",nombre);
            respuesta.addProperty("apellido", apellido);
            
            response.type("application/json");
            return respuesta;
         });

        get("/ruta5",(request,response)->{
            
            // String parametro=request.queryParams("nombre");
            //!CUANDO ES POR EL METODO POST, SE RECUPERA POR EL METODO request.body
            String nombre=request.queryParams("nombre");
             String apellido=request.queryParams("apellido");
              nombre= datos[0]=nombre;
              apellido=datos[1]=apellido;
            

            //ESTE OBJETO SIRVE PARA CONSTRUIR LA RESPUESTA EN JSON
            JsonObject respuesta= new JsonObject();            
            respuesta.addProperty("nombre",nombre);
            respuesta.addProperty("apellido", apellido);
            
            response.type("application/json");
            return respuesta;
         });
    }
}
