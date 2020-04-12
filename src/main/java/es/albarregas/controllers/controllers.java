/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.albarregas.controllers;

import es.albarregas.beans.Calculator;
import es.albarregas.controllers.controllers;
import es.albarregas.exceptions.ExcepcionDividirPorCero;
import es.albarregas.models.Division;
import es.albarregas.models.Multiplicacion;
import es.albarregas.models.Resta;
import es.albarregas.models.Suma;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author franciscoantonio
 */
public class controllers extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.setAttribute("error", "Estás intentando acceder mal a la calculadora, por favor vuelve al menú principal");
        request.getRequestDispatcher("/JSP/error.jsp").forward(request, response);
    } 

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
        
        Calculator cal = new Calculator();//instanciada la clase CalculadoraDatos

        String url;

        //instanciadas las clases correspondientes a los métodos de las operaciones
        Multiplicacion mul = new Multiplicacion();
        Division div = new Division();
        Suma sum = new Suma();
        Resta res = new Resta();

        //obtener valores de los operandos, vienen como String y hay que pasarlos a integer o double si así estubieran definidos
        int ope1 = Integer.parseInt(request.getParameter("operando1"));
        int ope2 = Integer.parseInt(request.getParameter("operando2"));
        cal.setOperando1(ope1);
        cal.setOperando2(ope2);

        try {
            if (request.getParameter("operacion") != null) {
                if (request.getParameter("operacion").equals("Sumar")) {
                    cal.setResultado(sum.Sumar(ope1, ope2));
                    cal.setSignoOperacion("+");
                } else if (request.getParameter("operacion").equals("Restar")) {
                    cal.setResultado(res.Restar(ope1, ope2));
                    cal.setSignoOperacion("-");
                } else if (request.getParameter("operacion").equals("Multiplicar")) {
                    cal.setResultado(mul.Multiplicar(ope1, ope2));
                    cal.setSignoOperacion("*");
                } else if (request.getParameter("operacion").equals("Dividir")) {
                    cal.setResultado(div.Dividir(ope1, ope2));
                    cal.setSignoOperacion("/");

                }
            }

            request.setAttribute("resultado", cal);
            url = "JSP/resultado.jsp";

        /*} catch (NumberFormatException ex) {
            url = "JSP/error.jsp";
            request.setAttribute("error", "Debes introducir valores numéricos");*/
        } catch (ExcepcionDividirPorCero ex) {
            url = "JSP/error.jsp";
            request.setAttribute("error", ex.toString());
        } catch (ArithmeticException ex){
            url = "JSP/error.jsp";
            request.setAttribute("error", "No se puede dividir entre 0");
        }
        
        request.getRequestDispatcher(url).forward(request,response);
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
