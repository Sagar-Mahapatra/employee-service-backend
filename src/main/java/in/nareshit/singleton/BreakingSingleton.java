package in.nareshit.singleton;

@FunctionalInterface
public interface BreakingSingleton {
	void doBreak(MySingleton ms) throws Exception;
}
