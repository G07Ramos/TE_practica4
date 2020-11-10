package com.emergentes.controlador;

import com.emergentes.dao.CursoDAOimpl;
import com.emergentes.modelo.Curso;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.emergentes.dao.CursoDAO;

@WebServlet(name = "InicioCurso", urlPatterns = {"/InicioCurso"})
public class InicioCurso extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
           CursoDAO dao = new CursoDAOimpl();
           int id;
           Curso curs = new Curso();
           String action = (request.getParameter("action") != null) ? request.getParameter("action"): "view";
           
            switch (action) {
                case "add":
                    request.setAttribute("cursos", curs);
                    request.getRequestDispatcher("frmcurso.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    curs = dao.getById(id);
                    System.out.println(curs);
                    request.setAttribute("cursos", curs);
                    request.getRequestDispatcher("frmcurso.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect(request.getContextPath()+"/InicioCurso");
                    break;
                case "view":
                    List<Curso> lista = dao.getAll();
                    request.setAttribute("cursos", lista);
                    request.getRequestDispatcher("listadocurso.jsp").forward(request, response);
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
        String descripcion = request.getParameter("descripcion");
        
        Curso curs = new Curso();
        curs.setId(id);
        curs.setDescripcion(descripcion);
        
        if(id==0){
            try{
                CursoDAO dao = new CursoDAOimpl();
                dao.insert(curs);
                response.sendRedirect(request.getContextPath()+"/InicioCurso");
                
            }catch(Exception ex){
                System.out.println("Error "+ex.getMessage());
            }
        }else{
            try{
                CursoDAO dao = new CursoDAOimpl();
                dao.update(curs);
                response.sendRedirect(request.getContextPath()+"/InicioCurso");
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
