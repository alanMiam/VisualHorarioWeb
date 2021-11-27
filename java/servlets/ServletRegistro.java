package servlets;
import Modelo.Usuario;
import Modelo.UsuarioProvider;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ServletRegistro extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        boolean coincide=true;
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        UsuarioProvider up = new UsuarioProvider();
        
        ArrayList<Usuario> arrayUsuario = up.ObtenerUsuario();
        
        for(int x=0;x<arrayUsuario.size();x++) {
            System.out.println(arrayUsuario.get(x));
            if (correo.equals(arrayUsuario.get(x).getCorreoUsuario())) {
                coincide=false;
                System.out.println("correo: "+arrayUsuario.get(x).getCorreoUsuario());
            }
        }
        if (coincide==true) {
//-------------------------------------------------------------------------------------------        
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<link rel=\"shortcut icon\" href=\"./estilos/imagenes/favicon.png\">");
                out.println("<meta charset=\"utf-8\">\n" +"  <link href=\"./estilos/estiloLogin.css\" rel=\"stylesheet\" type=\"text/css\"/>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<header>\n"+"<br><br>\n" +"<div align=\"center\"><img src=\"./estilos/imagenes/registroLogo.png\" alt=\"logo\"></div>    \n" +"<br> \n" +"</header>");
                out.println("<br>\n" +
                "<form action= \"enviar\" method=\"post\">\n" +
                    "<label for=\"nombre\">Nombre de usuario</label>\n" +"<br><br><br>\n" +
                    "<input type=\"text\" id=\"nombre1\" name=\"nombre1\" value=\""+nombre+"\" readonly class=\"in\">\n" +"<br><br><br>\n" +
                    "<label for=\"numero\">Correo electrónico</label>\n" +"<br><br><br>\n" +
                    "<input type=\"email\" id=\"correo1\" name =\"correo1\" value=\""+correo+"\" readonly class=\"in\">\n" +"<br><br><br>\n" +
                    "<label>Ingrese una contraseña</label>\n" +"<br><br><br>\n" +
                    "<input type=\"password\" name=\"contra\" id=\"contra\" required=\"\" class=\"in\">\n" +"<br><br><br>\n" +
                    "<input type=\"submit\" id=\"registar2\" value=\"Registrar\" name=\"registrar2\" class=\"boton1\">\n" +"<label>          </label>\n" +
                    "<a href=\"index.html\" class=\"boton2\">Cancelar</a>\n" +
                "</form>");
                out.println("</body>");
                out.println("</html>");
            }
        }else if(coincide==false){
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<link rel=\"shortcut icon\" href=\"./estilos/imagenes/favicon.png\">");
                out.println("<meta charset=\"utf-8\">\n" +"  <link href=\"./estilos/estiloLogin2.css\" rel=\"stylesheet\" type=\"text/css\"/>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<br><br><br><br><br>\n" +
                "<h1>Registro erroneo</h1>\n" +
                "<h1>El correo ya se encuentra registrado</h1>"+        
                "<br><br><br>\n" +
                "<a href=\"registro.jsp\" class=\"boton1\">Registrarse</a>");
                out.println("</body>");
                out.println("</html>");
            }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
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
