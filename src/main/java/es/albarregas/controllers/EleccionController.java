/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package es.albarregas.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.albarregas.beans.EleccionBean;

/**
 *
 * @author Pedro Lazaro
 */
@WebServlet(name = "EleccionController", urlPatterns = {"/EleccionController"})
public class EleccionController extends HttpServlet {

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
        String[] seguro = request.getParameterValues("seguro");
        EleccionBean eleccion = new EleccionBean();

        if(seguro == null){
            request.getRequestDispatcher("JSP/inicio.jsp").forward(request, response);
        }else if(seguro.length == 1 && seguro[0].equals("continente")){
            eleccion.setContinente(true);
            request.getSession().setAttribute("eleccion", eleccion);
            request.getRequestDispatcher("JSP/continente.jsp").forward(request, response);
        }else if(seguro.length == 1 && seguro[0].equals("contenido")){
            eleccion.setContenido(true);
            request.getSession().setAttribute("eleccion", eleccion);  
            request.getRequestDispatcher("JSP/contenido.jsp").forward(request, response);
        }else{
            eleccion.setContinente(true);
            eleccion.setContenido(true);
            request.getSession().setAttribute("eleccion", eleccion);  
            request.getRequestDispatcher("JSP/continente.jsp").forward(request, response);
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
