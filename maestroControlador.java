/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Grupo;
import Modelo.Maestro;
import Modelo.Materia;
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
public class maestroControlador extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>maestroControlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet maestroControlador </h1>");
            out.println("</body>");
            out.println("</html>");
            
            String accion = request.getParameter("accion");
            String por = request.getParameter("por");
            if(accion.equals("insertarMateria")){
                String nombre = request.getParameter("nombre");
                int clave = Integer.parseInt(request.getParameter("clave"));
                int estatus = Integer.parseInt(request.getParameter("estatus"));
                Materia materia = new Materia(nombre,clave,estatus);
                materia.insertarMateria(materia);
                response.sendRedirect("Vista/maestro.jsp");
            }
            if(accion.equals("insertarGrupo")){
                int materiaid = Integer.parseInt(request.getParameter("materiaid"));
                int cantidad = Integer.parseInt(request.getParameter("cantidad"));
                int estatus = Integer.parseInt(request.getParameter("estatus"));
                Grupo grupo = new Grupo(materiaid,cantidad,estatus);
                grupo.insertarGrupo(grupo);
                response.sendRedirect("Vista/maestro.jsp");
            }
            if(accion.equals("obtenerMateria") ){
                Materia materia = new Materia();
                List lista = materia.obtenerMateria();
                
                HttpSession session = request.getSession();
                session.setAttribute("materia",lista);
                response.sendRedirect("Vista/maestro.jsp");
            }
            if(accion.equals("obtenerGrupo") ){
                Grupo grupo = new Grupo();
                List lista = grupo.obtenerGrupo();
                
                HttpSession session = request.getSession();
                session.setAttribute("grupo",lista);
                response.sendRedirect("Vista/maestro.jsp");
            }//test
            if(accion.equals("buscaMateria")){
                if(por.equals("nombre")){
                    String txt = request.getParameter("txt");
                    Materia materia= new Materia();
                    materia.setNombre(txt);
                    List lista = materia.buscarMateriaNombre(materia);
                    HttpSession session = request.getSession();
                    session.setAttribute("materia",lista);
                    response.sendRedirect("Vista/buscaMateria.jsp");
                }
                if(por.equals("clave")){
                    int txt = Integer.parseInt(request.getParameter("txt"));
                    Materia materia= new Materia();
                    materia.setClave(txt);
                    List lista = materia.buscarMateriaClave(materia);
                    HttpSession session = request.getSession();
                    session.setAttribute("materia",lista);
                    response.sendRedirect("Vista/buscaMateria.jsp");
                }
                if(por.equals("estatus")){
                    int txt = Integer.parseInt(request.getParameter("txt"));
                    Materia materia= new Materia();
                    materia.setEstatus(txt);
                    List lista = materia.buscarMateriaEstatus(materia);
                    HttpSession session = request.getSession();
                    session.setAttribute("materia",lista);
                    response.sendRedirect("Vista/buscaMateria.jsp");
                }
            }
            if(accion.equals("editarMateria")){
                int id = Integer.parseInt(request.getParameter("id"));
                String nombre = request.getParameter("nombre");
                int clave = Integer.parseInt(request.getParameter("clave"));
                int estatus = Integer.parseInt(request.getParameter("estatus"));
                Materia materia = new Materia(id,nombre,clave,estatus);
                materia.editarMateria(materia);
                response.sendRedirect("Vista/buscaMateria.jsp");
            }
            if(accion.equals("eliminarMateria")){
                int id = Integer.parseInt(request.getParameter("id"));
                Maestro maestro = new Maestro();
                maestro.setId(id);
                maestro.eliminarMaestro(maestro);
                response.sendRedirect("Vista/buscaMateria.jsp");
            }
            
            if(accion.equals("buscaGrupo")){
                if(por.equals("materiaid")){
                    int txt = Integer.parseInt(request.getParameter("txt"));
                    Grupo grupo = new Grupo();
                    grupo.setMateriaid(txt);
                    List lista = grupo.buscarGrupoMateriaid(grupo);
                    HttpSession session = request.getSession();
                    session.setAttribute("grupo",lista);
                    response.sendRedirect("Vista/buscaGrupo.jsp");
                }
                if(por.equals("estatus")){
                    int txt = Integer.parseInt(request.getParameter("txt"));
                    Grupo grupo = new Grupo();
                    grupo.setEstatus(txt);
                    List lista = grupo.buscarGrupoEstatus(grupo);
                    HttpSession session = request.getSession();
                    session.setAttribute("grupo",lista);
                    response.sendRedirect("Vista/buscaGrupo.jsp");
                }
            }
            
            if(accion.equals("editarGrupo")){
                int id = Integer.parseInt(request.getParameter("id"));
                int materiaid = Integer.parseInt(request.getParameter("materiaid"));
                int cantidad = Integer.parseInt(request.getParameter("cantidad"));
                int estatus = Integer.parseInt(request.getParameter("estatus"));
                Grupo grupo = new Grupo(id,materiaid,cantidad,estatus);
                grupo.editarGrupo(grupo);
                response.sendRedirect("Vista/buscaGrupo.jsp");
            }
            if(accion.equals("eliminarGrupo")){
                int id = Integer.parseInt(request.getParameter("id"));
                Grupo grupo = new Grupo();
                grupo.setId(id);
                grupo.eliminarGrupo(grupo);
                response.sendRedirect("Vista/buscaGrupo.jsp");
            }
            
            
        }//fin
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
            Logger.getLogger(maestroControlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(maestroControlador.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(maestroControlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(maestroControlador.class.getName()).log(Level.SEVERE, null, ex);
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
