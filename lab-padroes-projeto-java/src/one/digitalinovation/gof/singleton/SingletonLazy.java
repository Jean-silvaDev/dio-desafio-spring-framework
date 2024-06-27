package one.digitalinovation.gof.singleton;

/**
 * Singleton "preguiçoso"
 * @author jean212022
 */

public class SingletonLazy {
	private static SingletonLazy instancia;
	
	private SingletonLazy() {
		super();
	}
	
	public static SingletonLazy getInstancia() {
		if(instancia == null)
			instancia = new SingletonLazy();
		return instancia;
	}
}
