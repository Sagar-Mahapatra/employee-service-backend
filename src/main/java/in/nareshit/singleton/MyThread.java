package in.nareshit.singleton;

public class MyThread implements Runnable {

	@Override
	public void run() {
		MySingleton s = MySingleton.getInstance();
		System.out.println(s.hashCode());
	}

}
