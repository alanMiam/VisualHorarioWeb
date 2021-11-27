package servlets;
import Modelo.Clase;
import Modelo.ClaseProvider;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ServletRegistrarClase extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        String idAsignatura = request.getParameter("asignatura");
        int ID = Integer.parseInt(idAsignatura);
        String grupo = request.getParameter("grupo");
        String semestre = request.getParameter("semestre");
        int sem = Integer.parseInt(semestre);
        
        Clase cl = new Clase();
        ClaseProvider clp = new ClaseProvider();
        
        cl.setGrupo(grupo);
        cl.setSemestre(sem);
        cl.setIdAsignatura(ID);
        /*clp.insertar(cl);
        if(clp.insertar(cl)==false){
            System.out.println("NO SE REGISTRÓ LA CLASE");
        }*/
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"shortcut icon\" href=\"./estilos/imagenes/favicon.png\">");
            out.println("<meta charset=\"utf-8\">\n" +"  <link href=\"./estilos/estiloLogin2.css\" rel=\"stylesheet\" type=\"text/css\"/>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<br><br><br><br><br>\n" +
            "<h1>Se registró la clase correctamente</h1>\n"+        
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
            Logger.getLogger(ServletRegistrarClase.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletRegistrarClase.class.getName()).log(Level.SEVERE, null, ex);
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
