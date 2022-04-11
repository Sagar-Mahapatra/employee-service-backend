package in.nareshit.singleton;

import java.io.Serializable;

public class MySingleton implements Serializable, Cloneable {

	private static final long serialVersionUID = 4528179168050017972L;

	private static MySingleton INSTANCE;

	private MySingleton() {
		if (INSTANCE != null) {
			throw new RuntimeException("INSTANCE ALREADY INTIALIZED");
		}
	}

	public static MySingleton getInstance() {
		if (INSTANCE == null) {
			synchronized (MySingleton.class) {
				if (INSTANCE == null) {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					INSTANCE = new MySingleton();
				}
			}
		}
		return INSTANCE;
	}

	public static MySingleton getInstanceWithoutDoubleCheckingLock() {
		if (INSTANCE == null) {

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			INSTANCE = new MySingleton();
		}

		return INSTANCE;
	}

	private Object readResolve() {
		return getInstance();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("CLONE NOT SUPPORTED");
	}

}
