import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Divisa {

	String nombre;
	double valor;
	static List listaDivisas = new ArrayList();
	static Map<String, Double> dictDivisas = new HashMap<String, Double>();
	
	public Divisa(String nombre, double valor) {
		
		this.nombre = nombre;
		this.valor = valor;
		this.listaDivisas.add(nombre);
		dictDivisas.put(nombre, (double) valor);
		
	}
	
	public String getNombre() {
		
		return this.nombre;
		
	}
	
	public static List getListaDivisas() {
		
		return listaDivisas;
		
	}
	
	public static double calcular(double valorDivisaUna, String divisaUna, String divisaDos) {
		
		double valorPrim = dictDivisas.get(divisaUna);
		double valor = dictDivisas.get(divisaDos);
		
		return ((valorDivisaUna/valorPrim)*valor);
		
	}

}
