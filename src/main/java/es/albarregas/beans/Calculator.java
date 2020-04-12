
package es.albarregas.beans;

import es.albarregas.exceptions.ExcepcionDividirPorCero;
import java.io.Serializable;

/**
 *
 * @author Francisco_Antonio
 */
public class Calculator implements Serializable{
    private int operando1;
    private int operando2;
    private int resultado;
    private String signoOperacion;
    
    public int getOperando1() {
        return operando1;
    }


    public void setOperando1(int operando1) {
        this.operando1 = operando1;
    }


    public int getOperando2() {
        return operando2;
    }


    public void setOperando2(int operando2) {
        this.operando2 = operando2;
    }


    public int getResultado() {
        return resultado;
    }


    public void setResultado(int resultado) throws ExcepcionDividirPorCero{
        if(getSignoOperacion() == "/" && getOperando2() == 0){
            throw new ExcepcionDividirPorCero("No puedes dividir entre 0");
        }
        this.resultado = resultado;
    }

    public String getSignoOperacion() {
        return signoOperacion;
    }

    public void setSignoOperacion(String signoOperacion) {
        this.signoOperacion = signoOperacion;
    }
}
