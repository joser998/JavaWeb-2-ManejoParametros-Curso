package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

//Le indicamos que esta clase sera de tipo Servlet
//Nuestra clase hereda de la clase HttpServlet
@WebServlet("/Servlet")
public class Servlet extends HttpServlet{
    
    //Sobre escribimos el metodo doPost que se procesara la respuesta
    //Recibimos dos argumentos 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        /*Procesamos los valores que nos esta mandando el formulario, es decir los parametros
        Y retornamos una respuesta hacia el navegador */
        
        //Leemos los parametros del formulario HTML:
            //Usamos nuestro objeto Request de la siguiente manera para recibir valores:
            //Guardamos los valores provenientes del formulario HTML en estas variables String
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");
            
            //Las presentamos por consola
            System.out.println("Usuario: "+usuario);
            System.out.println("Password: "+password);
            
            //Presentamos los valores en un doc HTML aqui dentro del Servlet
            PrintWriter escribirSalida = response.getWriter();
            escribirSalida.print("<html>");
            escribirSalida.print("<head>");
            escribirSalida.print("<title>Respuesta desde el Servlet</title>");
            escribirSalida.print("</head>");
            escribirSalida.print("<body>");
            escribirSalida.print("<h1>Respuesta desde mi Servlet</h1>");
            escribirSalida.print("El parametro del usuario es: "+usuario);
            escribirSalida.print("<br>");
            escribirSalida.print("El parametro del password es: "+password);
            escribirSalida.print("</body>");
            escribirSalida.print("</html>");
            escribirSalida.close();
    }
}