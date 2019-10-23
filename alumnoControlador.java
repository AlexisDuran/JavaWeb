/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Alumno;
import Modelo.Alumno_materia;
import Modelo.Maestro;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Equipo16
 */
public class alumnoControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String accion = request.getParameter("accion");
            
            if(accion.equals("insertarMateria") ){
                int materiaId = Integer.parseInt(request.getParameter("materiaId"));
                int alumnoId = Integer.parseInt(request.getParameter("alumnoId"));
                Alumno_materia alumno_materia = new Alumno_materia(materiaId,alumnoId);
                alumno_materia.insertarMateria(alumno_materia);
                
                response.sendRedirect("Vista/alumno.jsp");
            }
            if(accion.equals("buscaMateria") ){
                int id = Integer.parseInt(request.getParameter("id"));
                Alumno_materia alumno_materia = new Alumno_materia();
                alumno_materia.setId(id);
                List lista = alumno_materia.buscarRegistro(alumno_materia);
                HttpSession session = request.getSession();
                session.setAttribute("alumno_materia",lista);
                response.sendRedirect("Vista/buscaAlumnoMateria.jsp");
            }
            if(accion.equals("editar")){
                int id = Integer.parseInt(request.getParameter("id"));
                int materiaId = Integer.parseInt(request.getParameter("materiaId"));
                int alumnoId = Integer.parseInt(request.getParameter("alumnoId"));
                
                Alumno_materia alumno_materia = new Alumno_materia(id,materiaId,alumnoId);
                alumno_materia.editarMateria(alumno_materia);
                response.sendRedirect("Vista/buscaAlumnoMateria.jsp");
            }
            if(accion.equals("eliminar")){
                int id = Integer.parseInt(request.getParameter("id"));
                Alumno_materia alumno_materia = new Alumno_materia();
                alumno_materia.setId(id);
                alumno_materia.eliminarMateria(alumno_materia);
                response.sendRedirect("Vista/buscaAlumnoMateria.jsp");
            }
            if(accion.equals("bajaMateria")){
                int id = Integer.parseInt(request.getParameter("id"));
                Alumno_materia alumno_materia = new Alumno_materia();
                alumno_materia.setId(id);
                alumno_materia.eliminarMateria(alumno_materia);
                response.sendRedirect("Vista/alumno.jsp");
            }
            
            
            
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet alumnoControlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet alumnoControlador at " + request.getContextPath() + "</h1>");
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(alumnoControlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(alumnoControlador.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(alumnoControlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(alumnoControlador.class.getName()).log(Level.SEVERE, null, ex);
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
