package servlets;
import Modelo.Asignatura;
import Modelo.AsignaturaProvider;
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
public class ServletCrearClase extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        String semestre = request.getParameter("semestre");
        String grupo = request.getParameter("grupo");
        int sem = Integer.parseInt(semestre);
        
        Asignatura as = new Asignatura();
        AsignaturaProvider ap = new AsignaturaProvider();
        
        ArrayList<Asignatura> arrayAsignatura = ap.ObtenerAsignaturaSemestre(sem);
        int id;String nombre;
        String cadena;String cadena1="";
        for(int x=0;x<arrayAsignatura.size();x++) {
            id = arrayAsignatura.get(x).getIdAsignatura();
            nombre= arrayAsignatura.get(x).getAsignatura();
            cadena = "<option value="+id+">"+nombre+"</option>";
            cadena1=cadena1+cadena;
        }
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"shortcut icon\" href=\"./estilos/imagenes/favicon.png\">\n" +"<meta charset=\"utf-8\">\n" +"<link href=\"./estilos/estiloAdmin.css\" rel=\"stylesheet\" type=\"text/css\"/>  \n" +"	<title>Clase</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<header>\n" +"<br><br><div align=\"center\"><img src=\"./estilos/imagenes/crearClase.png\" alt=\"logo\"></div><br> \n" +"</header>");
            
            out.println("<form action= \"registrarClase\" method=\"post\">");
            out.println("<br><br><label>Seleccionar asignatura</label><br><br>");
            out.println("<select name=\"asignatura\" class=\"ini\">");
            out.println(cadena1);
            out.println("</select>");
            out.println("<br><br><label>Semestre</label><br><br>");
            out.println("<input type=\"text\" id=\"semestre\" name =\"semestre\" value=\""+semestre+"\"readonly class=\"ini\">");
            out.println("<br><br><label>grupo</label><br><br>");
            out.println("<input type=\"text\" id=\"grupo\" name =\"grupo\" value=\""+grupo+" \"readonly class=\"ini\">");
            out.println("\n" + "<br><br>\n" +
                "<input type=\"submit\" id=\"registar1\" value=\"Registrar\" name=\"registrar1\" class=\"boton1\">\n" +
                "<a href=\"crearClase.jsp\" class=\"boton2\">Volver</a>");
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
            Logger.getLogger(ServletCrearClase.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletCrearClase.class.getName()).log(Level.SEVERE, null, ex);
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
