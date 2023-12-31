/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package es.albarregas.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import es.albarregas.beans.ContenidoBean;
import es.albarregas.models.CalcularCuota;

/**
 *
 * @author Pedro Lazaro
 */
@WebServlet(name = "ContenidoController", urlPatterns = { "/ContenidoController" })
public class ContenidoController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        CalcularCuota calcular = new CalcularCuota();
        ContenidoBean contenido = new ContenidoBean();

        try {
            BeanUtils.populate(contenido, request.getParameterMap());
        } catch (Exception e) {
            // Manejar excepciones si ocurren
            e.printStackTrace();
        }


        contenido.setCuota(calcular.cuotaContenido(contenido));

        request.setAttribute("contenido", contenido);
        request.getRequestDispatcher("JSP/vistaFinal.jsp").forward(request, response);

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
