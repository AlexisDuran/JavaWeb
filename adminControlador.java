/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Alumno;
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
public class adminControlador extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code.  */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>adminControlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet adminControlador </h1>");
            out.println("</body>");
            out.println("</html>");
           
            String accion = request.getParameter("accion");
            String por = request.getParameter("por");
            
            if(accion.equals("insertarMaestro") ){
                String nombre = request.getParameter("nombre");
                String usuario = request.getParameter("usuario");
                String contraseña = request.getParameter("contraseña");
                int no_empleado = Integer.parseInt(request.getParameter("no_empleado"));
                int tipoEmpleadoId = Integer.parseInt(request.getParameter("tipoEmpleadoId"));
                int estatus = Integer.parseInt(request.getParameter("estatus"));
            
                Maestro maestro = new Maestro(nombre,usuario,contraseña,no_empleado,tipoEmpleadoId,estatus);
                maestro.insertarMaestro(maestro);
                response.sendRedirect("Vista/admin.jsp");
            }
            if(accion.equals("insertarAlumno") ){
                String nombre = request.getParameter("nombre");
                String usuario = request.getParameter("usuario");
                String contraseña = request.getParameter("contraseña");
                int matricula = Integer.parseInt(request.getParameter("matricula"));
                int estatus = Integer.parseInt(request.getParameter("estatus"));
                Alumno alumno = new Alumno(nombre,usuario,contraseña,matricula,estatus);
                alumno.insertarAlumno(alumno);
                
                response.sendRedirect("Vista/admin.jsp");
            }
            if(accion.equals("obtenerMaestro") ){
                Maestro maestro = new Maestro();
                List lista = maestro.obtenerMaestro();
                
                HttpSession session = request.getSession();
                session.setAttribute("maestro",lista);
                response.sendRedirect("Vista/admin.jsp");
            }
            if(accion.equals("obtenerAlumno") ){
                Alumno alumno = new Alumno();
                List lista = alumno.obtenerAlumno();
                
                HttpSession session = request.getSession();
                session.setAttribute("alumno",lista);
                response.sendRedirect("Vista/admin.jsp");
            }
            if(accion.equals("editarAlumno") ){
                int id = Integer.parseInt(request.getParameter("id"));
                String nombre = request.getParameter("nombre");
                String usuario = request.getParameter("usuario");
                String contraseña = request.getParameter("contraseña");
                int matricula = Integer.parseInt(request.getParameter("matricula"));
                int estatus = Integer.parseInt(request.getParameter("estatus"));
                Alumno alumno = new Alumno(id,nombre,usuario,contraseña,matricula,estatus);
                alumno.editarAlumno(alumno);
                response.sendRedirect("Vista/buscaAlumno.jsp");
            }
            if(accion.equals("eliminarAlumno") ){
                int id = Integer.parseInt(request.getParameter("id"));
                Alumno alumno = new Alumno();
                alumno.setId(id);
                alumno.eliminarAlumno(alumno);
                response.sendRedirect("Vista/buscaAlumno.jsp");
            }
            if(accion.equals("buscaAlumno")){
                if(por.equals("nombre")){
                    String txt = request.getParameter("txt");
                    Alumno alumno = new Alumno();
                    alumno.setNombre(txt);
                    List lista = alumno.buscarAlumnoNombre(alumno);
                    HttpSession session = request.getSession();
                    session.setAttribute("alumno",lista);
                    response.sendRedirect("Vista/buscaAlumno.jsp");
                }
                if(por.equals("usuario")){
                    String txt = request.getParameter("txt");
                    Alumno alumno = new Alumno();
                    alumno.setUsuario(txt);
                    List lista = alumno.buscarAlumnoUsuario(alumno);
                    HttpSession session = request.getSession();
                    session.setAttribute("alumno",lista);
                    response.sendRedirect("Vista/buscaAlumno.jsp");
                }
                if(por.equals("matricula")){
                    int txt = Integer.parseInt(request.getParameter("txt"));
                    Alumno alumno = new Alumno();
                    alumno.setMatricula(txt);
                    List lista = alumno.buscarAlumnoMatricula(alumno);
                    HttpSession session = request.getSession();
                    session.setAttribute("alumno",lista);
                    response.sendRedirect("Vista/buscaAlumno.jsp");
                }
                if(por.equals("estatus")){
                    int txt = Integer.parseInt(request.getParameter("txt"));
                    Alumno alumno = new Alumno();
                    alumno.setEstatus(txt);
                    List lista = alumno.buscarAlumnoEstatus(alumno);
                    HttpSession session = request.getSession();
                    session.setAttribute("alumno",lista);
                    response.sendRedirect("Vista/buscaAlumno.jsp");
                }
            }
            if(accion.equals("buscaMaestro")){
                if(por.equals("nombre")){
                    String txt = request.getParameter("txt");
                    Maestro maestro = new Maestro();
                    maestro.setNombre(txt);
                    List lista = maestro.buscarMaestroNombre(maestro);
                    HttpSession session = request.getSession();
                    session.setAttribute("maestro",lista);
                    response.sendRedirect("Vista/buscaMaestro.jsp");
                }
                if(por.equals("usuario")){
                    String txt = request.getParameter("txt");
                    Maestro maestro = new Maestro();
                    maestro.setUsuario(txt);
                    List lista = maestro.buscarMaestroUsuario(maestro);
                    HttpSession session = request.getSession();
                    session.setAttribute("maestro",lista);
                    response.sendRedirect("Vista/buscaMaestro.jsp");
                }
                if(por.equals("tipoEmpleadoId")){
                    int txt = Integer.parseInt(request.getParameter("txt"));
                    Maestro maestro = new Maestro();
                    maestro.setTipoEmpleadoId(txt);
                    List lista = maestro.buscarMaestroTipoEmpleadoId(maestro);
                    HttpSession session = request.getSession();
                    session.setAttribute("maestro",lista);
                    response.sendRedirect("Vista/buscaMaestro.jsp");
                }
                if(por.equals("no_empleadoId")){
                    int txt = Integer.parseInt(request.getParameter("txt"));
                    Maestro maestro = new Maestro();
                    maestro.setNo_empleado(txt);
                    List lista = maestro.buscarMaestroNo_empleado(maestro);
                    HttpSession session = request.getSession();
                    session.setAttribute("maestro",lista);
                    response.sendRedirect("Vista/buscaMaestro.jsp");
                }
                if(por.equals("estatus")){
                    int txt = Integer.parseInt(request.getParameter("txt"));
                    Maestro maestro = new Maestro();
                    maestro.setEstatus(txt);
                    List lista = maestro.buscarMaestroEstatus(maestro);
                    HttpSession session = request.getSession();
                    session.setAttribute("maestro",lista);
                    response.sendRedirect("Vista/buscaMaestro.jsp");
                }
            }
            //test
            if(accion.equals("editarMaestro") ){
                int id = Integer.parseInt(request.getParameter("id"));
                String nombre = request.getParameter("nombre");
                String usuario = request.getParameter("usuario");
                String contraseña = request.getParameter("contraseña");
                int no_empleado = Integer.parseInt(request.getParameter("no_empleado"));
                int tipoEmpleadoId = Integer.parseInt(request.getParameter("tipoEmpleadoId"));
                int estatus = Integer.parseInt(request.getParameter("estatus"));
                Maestro maestro = new Maestro(id,nombre,usuario,contraseña,no_empleado,tipoEmpleadoId,estatus);
                maestro.editarMaestro(maestro);
                response.sendRedirect("Vista/buscaMaestro.jsp");
            }
            if(accion.equals("eliminarMaestro") ){
                int id = Integer.parseInt(request.getParameter("id"));
                Maestro maestro = new Maestro();
                maestro.setId(id);
                maestro.eliminarMaestro(maestro);
                response.sendRedirect("Vista/buscaMaestro.jsp");
            }
            
            
            
            
        }//AQUI TERMINA DIOS...
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
            Logger.getLogger(adminControlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(adminControlador.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(adminControlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(adminControlador.class.getName()).log(Level.SEVERE, null, ex);
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
