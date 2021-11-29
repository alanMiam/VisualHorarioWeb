package servlets;
import Modelo.Usuario;
import Modelo.UsuarioProvider;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Seguridad.Encriptacion;
public class ServletEnviarReg extends HttpServlet {
    Encriptacion enc = new Encriptacion();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String correo = request.getParameter("correo1");
        String nombre = request.getParameter("nombre1");
        String contra = request.getParameter("contra");
        String contraCode = enc.code(contra);
        
        Usuario us = new Usuario();
        UsuarioProvider up = new UsuarioProvider();
        us.setCorreoUsuario(correo);
        us.setNombreUsuario(nombre);
        us.setPassUsuario(contraCode);
        us.setRolUsuario(0);
        up.Insertar(us);
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"shortcut icon\" href=\"./estilos/imagenes/favicon.png\">");
            out.println("<meta charset=\"utf-8\">\n" +"  <link href=\"./estilos/estiloLogin2.css\" rel=\"stylesheet\" type=\"text/css\"/>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<br><br><br><br><br>\n" +
            "<h1>Registrado corectamente</h1>\n" +"<br><br><br>\n" +
            "<a href=\"index.html\" class=\"boton1\">Inicio</a>");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletEnviarReg.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletEnviarReg.class.getName()).log(Level.SEVERE, null, ex);
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
