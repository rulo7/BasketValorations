package com.dani.raul.basketvalorations_app.reloj;

import com.dani.raul.basketvalorations_app.reloj.Contador;

/**
 * Clase encargada de simular la abstraccion de un reloj Utiliza el patr�n
 * singleton con el fin de permitir una unica instancia de esta clase
 * 
 * @author Raul Cobos y Sergio Rodriguez
 * 
 */
public class Reloj {

	// ________Atributos_____________ //

	private Contador horas;
	private Contador minutos;
	private Contador segundos;
	private Contador decimasDeSegundo;

	/**
	 * Constructor de tipo privado que solo permite instanciar esta clase en
	 * ella misma Instancia cada uno de sus atributos como contadores con
	 * dependencias entre si
	 * 
	 */
	public Reloj() {
		horas = new Contador(23, null);
		minutos = new Contador(59, horas);
		segundos = new Contador(59, minutos);
		decimasDeSegundo = new Contador(9, segundos);
	}

	// ____________________ Gets & Sets ____________________ //

	public int getHoras() {
		return horas.getCuenta();
	}

	public int getMinutos() {
		return minutos.getCuenta();
	}

	public int getSegundos() {
		return segundos.getCuenta();
	}

	public int getDecimasDeSegundo() {
		return decimasDeSegundo.getCuenta();
	}

	public void setHoras(int _horas) {
		horas.setValor(_horas);
	}

	public void setMinutos(int _minutos) {
		minutos.setValor(_minutos);
	}

	public void setSegundos(int _segundos) {
		segundos.setValor(_segundos);
	}

	public void setDecimas(int _decimasDeSegundo) {
		decimasDeSegundo.setValor(_decimasDeSegundo);
	}

	// ____________________ Sobreescritura de los metodos de las interfaces que
	// implementan ____________________ //

	public void ejecutar() {
		decimasDeSegundo.incrementar();
	}

	public void decrementar() {
		if (decimasDeSegundo.getCuenta() == 0 && segundos.getCuenta() == 0
				&& minutos.getCuenta() == 0 && horas.getCuenta() == 0) {
			//no hacer nada
		}else{
			decimasDeSegundo.decrementar();
		}
	}

	public String getTiempoAplicacion() {

		String str = "";
		if (horas.getCuenta() < 10)
			str += "0";
		str += horas.getCuenta() + ":";
		if (minutos.getCuenta() < 10)
			str += "0";
		str += minutos.getCuenta() + ":";
		if (segundos.getCuenta() < 10)
			str += "0";
		str += segundos.getCuenta() + ":";
		if (decimasDeSegundo.getCuenta() < 10)
			str += "0";
		str += decimasDeSegundo.getCuenta();
		return str;

	}
}
