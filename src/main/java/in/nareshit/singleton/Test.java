package in.nareshit.singleton;

import org.springframework.stereotype.Component;

@Component
public class Test {

	public void singletonExperiment(BreakingSingleton bs) {

		// 1. checking by multiple threads
		/*
		 * CheckingSingleton c = (b) -> { ExecutorService pool =
		 * Executors.newFixedThreadPool(5); MyThread mt = new MyThread();
		 * pool.execute(mt); pool.execute(mt); pool.execute(mt); }; c.check(null);
		 */

		// 2. checking by serialization
		/*
		 * CheckingSingleton c1 = (b) -> b.doBreak(MySingleton.getInstance());
		 * c1.check(bs);
		 */

		// 3. checking by cloning
		/*
		 * CheckingSingleton c2 = (b) -> b.doBreak(MySingleton.getInstance());
		 * c2.check(bs);
		 */

		// 3. checking by reflection
		CheckingSingleton c2 = (b) -> {
			try {
				b.doBreak(MySingleton.getInstance());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		};
		c2.check(bs);
	}
}
