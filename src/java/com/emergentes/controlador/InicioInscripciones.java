package com.emergentes.controlador;

import com.emergentes.dao.InscripcionesDAOimpl;
import com.emergentes.modelo.Inscripciones;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.emergentes.dao.InscripcionesDAO;

@WebServlet(name = "InicioInscripciones", urlPatterns = {"/InicioInscripciones"})
public class InicioInscripciones extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
           InscripcionesDAO dao = new InscripcionesDAOimpl();
           int id;
           Inscripciones ins = new Inscripciones();
           String action = (request.getParameter("action") != null) ? request.getParameter("action"): "view";
           
            switch (action) {
                case "add":
                    request.setAttribute("inscripcion", ins);
                    request.getRequestDispatcher("frminscripciones.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    ins = dao.getById(id);
                    System.out.println(ins);
                    request.setAttribute("inscripcion", ins);
                    request.getRequestDispatcher("frminscripciones.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect(request.getContextPath()+"/InicioInscripciones");
                    break;
                case "view":
                    List<Inscripciones> lista = dao.getAll();
                    request.setAttribute("inscripcion", lista);
                    request.getRequestDispatcher("listadoinscripciones.jsp").forward(request, response);
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
        int id_curso = Integer.parseInt(request.getParameter("id_curso"));
        int id_estudiante = Integer.parseInt(request.getParameter("id_estudiante"));
        int nota_final = Integer.parseInt(request.getParameter("nota_final"));
       //String curso = request.getParameter("curso");
        //String nombre = request.getParameter("nombre");
        
        Inscripciones ins = new Inscripciones();
        ins.setId(id);
        ins.setId_curso(id_curso);
        ins.setId_estudiante(id_estudiante);
        ins.setNota_final(nota_final);
        //ins.setCurso(curso);
        //ins.setNombre(nombre);
        
        if(id==0){
            try{
                InscripcionesDAO dao = new InscripcionesDAOimpl();
                dao.insert(ins);
                response.sendRedirect(request.getContextPath()+"/InicioInscripciones");
                
            }catch(Exception ex){
                System.out.println("Error "+ex.getMessage());
            }
        }else{
            try{
                InscripcionesDAO dao = new InscripcionesDAOimpl();
                dao.update(ins);
                response.sendRedirect(request.getContextPath()+"/InicioInscripciones");
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
