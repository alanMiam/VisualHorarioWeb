package servlets;
import Modelo.Usuario;
import Modelo.UsuarioProvider;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ServletActUs extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        UsuarioProvider up = new UsuarioProvider();
        ArrayList<Usuario> arrayUsuario = up.ObtenerUsuario();
        int id;int y=1;
        String cadena;String cadena1="";
        for(int x=0;x<arrayUsuario.size();x++) {
            id = arrayUsuario.get(x).getIdUsuario();
            y++;
            cadena = "<option value="+id+">"+id+"</option>";
            cadena1=cadena1+cadena;
        }
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +"        <meta charset=\"utf-8\">\n" +"        <link href=\"./estilos/estiloAdmin.css\" rel=\"stylesheet\" type=\"text/css\"/>");
            out.println("<link rel=\"shortcut icon\" href=\"./estilos/imagenes/favicon.png\">");
            out.println("</head>");
            out.println("<body>");
            out.println(" <header>\n" +"<div align=\"center\"><img src=\"./estilos/imagenes/admin.png\" alt=\"logo\"></div>    \n" +"<br> \n" +"</header>\n" +"<br>\n" +"<h1>Bienvenido </h1> \n" +"<HR>\n" +"<br>");
            out.println("<form action= \"actualizacionUsuario\" method=\"post\">");
            out.println("<br><label for=\"nombre\">Seleccione un id de usuario</label>");
            out.println("<select name=\"select\" class=\"ini\">");
            out.println(cadena1);
            out.println("</select>");
            out.println("<br><label for=\"nombre\">Nombre de usuario</label>\n" +"<br><br>\n" +
                "<input type=\"text\" id=\"nombre\" name=\"nombre\" class=\"in\" pattern=\"^(?=.{4,30}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$\" required>\n" +"<br><br>\n" +
                "<label for=\"correo\">Contraseña</label>\n" +"<br><br>\n" +
                "<input type=\"password\" id=\"contra\"  name =\"contra\" size=\"30\" required class=\"in\">\n" + "<br><br>\n" +
                "<label for=\"correo\">Rol de usuario</label>\n" +"<br><br>\n" +
                "<select name=\"rol\" required class=\"ini\">>\n" +
                "<option value=\"0\">Usuario</option>\n" +
                "<option value=\"1\">Administrador</option>\n" +
                "</select>\n" + "<br><br>\n" +
                "<input type=\"submit\" id=\"registar1\" value=\"Enviar\" name=\"registrar1\" class=\"boton1\">\n" +
                "<a href=\"admin.jsp\" class=\"boton2\">Volver</a>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
/*
<br><label for="nombre">Nombre de usuario</label>
<br><br>
<input type="text" id="nombre" name="nombre" class="in" pattern="^(?=.{4,30}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$" required>
<br><br>
<label for="correo">Correo electrónico</label>
<br><br>
<input type="email" id="correo"  name ="correo" size="30" pattern="^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$" required class="in">
<br><br>
<label for="correo">Contraseña</label>
<br><br>
<input type="password" id="contra"  name ="contra" size="30" required class="in">
<br><br>
<label for="correo">Rol de usuario</label>
<br><br>
<select name="rol" required class="in1">>
<option value="0">Usuario</option>
<option value="1">Administrador</option>
</select>
<br><br>
<input type="submit" id="registar1" value="Enviar" name="registrar1" class="boton1">
<a href="actualizarUsuario" class="boton2">Volver</a>
*/