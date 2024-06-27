package one.digitalinovation.gof.singleton;

/**
 * Singleton "Lazy holder"
 * @see <a href="https://stackoverflow.com/a/24018148">Referencia</a>
 * @author jean212022
 */

public class SingletonLazyHolder {
	private static class Holder{
		public static SingletonLazyHolder instancia = new SingletonLazyHolder();
	}
	
	private SingletonLazyHolder() {
		super();
	}
	
	public static SingletonLazyHolder getInstancia() {
		return Holder.instancia;
	}
}
