<%-- 
    Document   : index
    Created on : 14 oct. 2019, 19:39:38
    Author     : franciscoantonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/calculatorStyle.css">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ include file = "/INC/imagenLateral.jsp" %>

        <form action="Controlador" method="post" class="right">
            <h1>CALCULATOR</h1>
            
            <fieldset>
                <div id="introDatos">
                <label>Primer operando:</label><input id="entrada" type="number" name="operando1"/><br/>
                <label>Segundo operando:</label><input id="entrada" type="number" name="operando2"/>
                </div>
                
                Sumar<input id="operandos" name="operacion" value="Sumar" type="radio" checked="checked">  
                Restar<input id="operandos" name="operacion" value="Restar" type="radio">  
                Multiplicar<input id="operandos" name="operacion" value="Multiplicar" type="radio">    
                Dividir<input id="operandos" name="operacion" value="Dividir" type="radio">
                <br/>
                <br/>
                <button type="submit" name="calcular" value="calcular"><span>Calcular</span></button>
                <button type="reset" name="Limpiar" value="Limpiar"><span>Limpiar</span></button>
                
                
            </fieldset>
            
        </form>
    </body>
</html>
