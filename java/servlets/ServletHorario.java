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
public class ServletHorario extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
                out.println("<head>");
                    out.println("<title>visualHorario</title>    \n" +"    <meta charset=\"UTF-8\">\n" +"    <meta name=\"title\" content=\"VisualHorario\">\n" +"    <link rel=\"shortcut icon\" href=\"./estilos/imagenes/favicon.png\">\n" +"    <meta name=\"description\" content=\"Descripción de la WEB\">    \n" +"    <link href=\"./estilos/estilo.css\" rel=\"stylesheet\" type=\"text/css\"/>");            
                out.println("</head>");
                out.println("<body>");
                    out.println("<header>");
                        out.println("<br><div align=\"center\"><img src=\"./estilos/imagenes/logoTexto.png\" alt=\"logo\"></div><br>");
                    out.println("</header>");
        //--------------------------------------------------------------------------------------------        
                    out.println("<article>");
                    out.println("<div align=\"left\" id=\"centro\">");
                        
                        out.println("<br><br>\n"+"<label for=\"correo\">Semestre: </label>\n");
                        out.println("<select name=\"semestre\" class=\"ini\">\n" +"<option value=1>1</option>\n"+"<option value=3>3</option>\n" +"<option value=5>5</option>\n"+"<option value=7>7</option>\n"+"</select>");
                        out.println("<br><br><br>");
                    out.println("<br><br>\n"+"<label for=\"correo\">Asignatura: </label>\n");
                    out.println("<select name=\"asignatura\" class=\"ini\">");
                    out.println("<option value=as>Asignatura</option>");
                    out.println("</select>");
                out.println("</div>");
                out.println("<div align=\"right\" id=\"centro\">");
                out.println("<br>");
                out.println("</div>");
                
                out.println("</article> ");
        //---------------------------------------------------------------------------------------------            
                out.println("<aside>");
                    out.println("<div>");
                       
                    out.println("</div>");
                    //----------------------------------------------------------
                    out.println("<div>");
                    out.println("<div align=\"right\" id=\"centro\">");
                        out.println("<p id=\"Lema\">CREACIÓN DE HORARIO</p><div></div>");
                         out.println("<a href=\"enviarHorario\"><input type=\"button\" value=\"Enviar\" class=\"boton1\"></a>");
                        out.println("<a href=\"index.html\"><input type=\"button\" value=\"Cerrar sesión\" class=\"boton2\"></a>");
                        out.println("<br><br>");
                out.println("</div>");
                    out.println("</div>");
                out.println("</aside>");
        //---------------------------------------------------------------------------------------------        
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
            Logger.getLogger(ServletHorario.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletHorario.class.getName()).log(Level.SEVERE, null, ex);
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
