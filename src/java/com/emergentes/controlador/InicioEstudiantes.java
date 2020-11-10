package com.emergentes.controlador;

import com.emergentes.dao.EstudiantesDAOimpl;
import com.emergentes.modelo.Estudiantes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.emergentes.dao.EstudiantesDAO;

@WebServlet(name = "InicioEstudiantes", urlPatterns = {"/InicioEstudiantes"})
public class InicioEstudiantes extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
           EstudiantesDAO dao = new EstudiantesDAOimpl();
           int id;
           Estudiantes estu = new Estudiantes();
           String action = (request.getParameter("action") != null) ? request.getParameter("action"): "view";
           
            switch (action) {
                case "add":
                    request.setAttribute("estudiantes", estu);
                    request.getRequestDispatcher("frmestudiantes.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    estu = dao.getById(id);
                    System.out.println(estu);
                    request.setAttribute("estudiantes", estu);
                    request.getRequestDispatcher("frmestudiantes.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect(request.getContextPath()+"/InicioEstudiantes");
                    break;
                case "view":
                    List<Estudiantes> lista = dao.getAll();
                    request.setAttribute("estudiantes", lista);
                    request.getRequestDispatcher("listadoestudiantes.jsp").forward(request, response);
                default:
                    break;
            }
            
        }catch(Exception ex){
            System.out.println("Error"+ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String correo = request.getParameter("correo");
        
        Estudiantes estu = new Estudiantes();
        estu.setId(id);
        estu.setNombre(nombre);
        estu.setApellidos(apellidos);
        estu.setCorreo(correo);
        
        if(id==0){
            try{
                EstudiantesDAO dao = new EstudiantesDAOimpl();
                dao.insert(estu);
                response.sendRedirect(request.getContextPath()+"/InicioEstudiantes");
                
            }catch(Exception ex){
                System.out.println("Error "+ex.getMessage());
            }
        }else{
            try{
                EstudiantesDAO dao = new EstudiantesDAOimpl();
                dao.update(estu);
                response.sendRedirect(request.getContextPath()+"/InicioEstudiantes");
            }catch(Exception ex){
                System.out.println("Error "+ex.getMessage());
            }
        }
    
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
