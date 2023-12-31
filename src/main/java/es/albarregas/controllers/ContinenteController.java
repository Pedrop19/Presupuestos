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

import org.apache.commons.beanutils.BeanUtils;

import es.albarregas.beans.ContinenteBean;
import es.albarregas.beans.EleccionBean;
import es.albarregas.models.CalcularCuota;

/**
 *
 * @author Pedro Lazaro
 */
@WebServlet(name = "ContinenteController", urlPatterns = { "/ContinenteController" })
public class ContinenteController extends HttpServlet {


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
        String valor = request.getParameter("valor_estimado");
        EleccionBean eleccionBean = (EleccionBean) request.getSession().getAttribute("eleccion");
        CalcularCuota calcular = new CalcularCuota();
        ContinenteBean continente = new ContinenteBean();
        String fecha = request.getParameter("fecha");

        try {
            BeanUtils.populate(continente, request.getParameterMap());
            continente.setValor(Integer.parseInt(valor));
            continente.setFecha(fecha);
        } catch (Exception e) {
            // Manejar excepciones si ocurren
            e.printStackTrace();
        }

        continente.setCuota(calcular.getCuotaContinente(continente));
        
        request.getSession().setAttribute("continente", continente);
        
        if (eleccionBean.isContenido()) {
            request.getRequestDispatcher("JSP/contenido.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("JSP/vistaFinal.jsp").forward(request, response);
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
