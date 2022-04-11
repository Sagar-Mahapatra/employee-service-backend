package in.nareshit.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.springframework.stereotype.Component;

@Component("refl")
public class BreakByReflection implements BreakingSingleton {

	@Override
	public void doBreak(MySingleton ms)
			throws InstantiationException, IllegalAccessException, InvocationTargetException {
		Constructor<?>[] declaredConstructors = ms.getClass().getDeclaredConstructors();
		for (Constructor<?> cons : declaredConstructors) {
			cons.setAccessible(true);
			MySingleton reflectionInstance = (MySingleton) cons.newInstance();
			if (ms.equals(reflectionInstance)) {
				System.out.println("SINGLETON NOT BROKE BY REFLECTION");
			} else {
				System.out.println("SINGLETON BROKED BY REFLECTION");
			}
		}
	}
}
