package in.nareshit.singleton;

import org.springframework.stereotype.Component;

@Component("clon")
public class BreakByCloning implements BreakingSingleton {

	@Override
	public void doBreak(MySingleton ms) {
		MySingleton clone = null;
		try {
			clone = (MySingleton) ms.clone();
			if (ms.equals(clone)) {
				System.out.println("SINGLETON NOT BROKE BY CLONING");
			} else {
				System.out.println("SINGLETON BROKED BY CLONING");
			}
		} catch (CloneNotSupportedException e) {
			System.out.println(e.getMessage());
		}

	}

}
