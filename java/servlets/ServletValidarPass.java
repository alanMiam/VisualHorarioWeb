package servlets;
import Modelo.UsuarioProvider;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ServletValidarPass extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //-----------------------------------------------------------------------
        String pass = request.getParameter("contra");
        String correo1 = request.getParameter("correo1");
        UsuarioProvider up = new UsuarioProvider();
        //nombre pass correo
        String contra = up.ObtenerUsuario234(correo1, 3);
        String nombre = up.ObtenerUsuario234(correo1, 2);
        System.out.println(pass+" "+contra);
        int rol;  
        
        if (pass.equals(contra)) {
            rol = up.ObtenerUsuario15(correo1, 5);
            if (rol==1) {
                try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<label>");
            out.print("</label>");
            out.println("<script type=\"text/javascript\">window.location=\"admin.jsp\";</script>");
            out.println("</html>");
            }
            }else if(rol==0){
                try (PrintWriter out = response.getWriter()) {
                    /* TODO output your page here. You may use following sample code. */
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<link rel=\"shortcut icon\" href=\"./estilos/imagenes/favicon.png\">");
                    out.println("<meta charset=\"utf-8\">\n" +"  <link href=\"./estilos/estiloLogin.css\" rel=\"stylesheet\" type=\"text/css\"/>  ");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<header>\n" +"        <br><br>\n" +"        <div align=\"center\"><img src=\"./estilos/imagenes/logoTexto.png\" alt=\"logo\"></div>    \n" +"        <br> \n" +"      </header> \n" +"        <br>\n" +"        <form action= \" \" method=\"post\">\n" +"          <br><br>\n" +
                    "<label class=\"bienvenida\">"+"Bienvenido "+nombre+"  </label>\n" +"<hr>\n" +"<br>\n" +"<br>\n" +
                    "<a href=\"horario\" class=\"boton1\">Crear horario</a>\n" +"<br>\n" +"<br>\n" +"<br>\n" +
                    "<a href=\"index.html\" class=\"boton2\">Cerrar sesión</a>\n" +"</form>");
                    out.println("</body>");
                    out.println("</html>");
                }
            }
        }else{
            try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<label>"); 
            out.print("</label>");
            out.println("<script type=\"text/javascript\">window.location=\"login.jsp\";</script>");
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
