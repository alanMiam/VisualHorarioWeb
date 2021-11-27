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
public class ServletActualizacionUsuario extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        String id = request.getParameter("select");
        int ID = Integer.parseInt(id);
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String contra = request.getParameter("contra");
        String rol = request.getParameter("rol");
        int ROL = Integer.parseInt(rol);
        Usuario us = new Usuario();
        
        
        us.setNombreUsuario(nombre);
        //us.setCorreoUsuario(correo);
        us.setPassUsuario(contra);
        us.setRolUsuario(ROL);
        
        UsuarioProvider up = new UsuarioProvider();
        
        
        up.Modificar(ID, us);
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"shortcut icon\" href=\"./estilos/imagenes/favicon.png\">");
            out.println("<meta charset=\"utf-8\">\n" +"  <link href=\"./estilos/estiloLogin2.css\" rel=\"stylesheet\" type=\"text/css\"/>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<br><br><br><br><br>\n" +
            "<h1>Se actializó el usuario: "+ID+"</h1>\n"+        
            "<br><br><br>\n" +
            "<a href=\"admin.jsp\" class=\"boton1\">Volver</a>");
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
            Logger.getLogger(ServletActualizacionUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletActualizacionUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
