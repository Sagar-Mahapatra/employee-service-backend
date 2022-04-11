package in.nareshit.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.springframework.stereotype.Component;

@Component("ser")
public class BreakBySerialization implements BreakingSingleton {

	@Override
	public void doBreak(MySingleton obj) {

		MySingleton serObj = null;

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("breakBySerialization.ser"))) {

			oos.writeObject(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("breakBySerialization.ser"))) {
			serObj = (MySingleton) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (obj.equals(serObj)) {
			System.out.println("SINGLETON NOT BROKE BY SERIALIZATION");
		} else {
			System.out.println("SINGLETON BROKED BY SERIALIZATION");
		}
	}

}
