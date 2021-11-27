package servlets;
import Modelo.Clase;
import Modelo.ClaseProvider;
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
public class ServletElimClase extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        ClaseProvider clp = new ClaseProvider();
        ArrayList<Clase> arrayClase = clp.ObtenerClase();
        int id;
        String cadena;String cadena1="";
        for(int x=0;x<arrayClase.size();x++) {
            id = arrayClase.get(x).getID();
            cadena = "<option value="+id+">"+id+"</option>";
            cadena1=cadena1+cadena;
        }
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"shortcut icon\" href=\"./estilos/imagenes/favicon.png\">");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +"        <meta charset=\"utf-8\">\n" +"        <link href=\"./estilos/estiloAdmin.css\" rel=\"stylesheet\" type=\"text/css\"/>");            
            out.println("</head>");
            out.println("<body>");
            out.println(" <header>\n" +"<div align=\"center\"><img src=\"./estilos/imagenes/admin.png\" alt=\"logo\"></div>    \n" +"<br> \n" +"</header>\n" +"<br>\n" +"<h1>Bienvenido </h1> \n" +"<HR>\n" +"<br>");
            out.println("<form action= \"eliminacionClase\" method=\"post\">");
            out.println("<br><label for=\"nombre\">Seleccione un id de Clase</label>");
            out.println("<select name=\"select\" class=\"ini\">");
            out.println(cadena1);
            out.println("</select>");
            out.println("\n" +"<br><br>\n" +
                "<input type=\"submit\" id=\"registar1\" value=\"Eliminar\" name=\"registrar1\" class=\"boton1\">\n" +
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletElimClase.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletElimClase.class.getName()).log(Level.SEVERE, null, ex);
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
