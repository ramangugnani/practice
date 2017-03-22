package practice.javaprogramming.Serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.imageio.stream.FileImageInputStream;

public class SerializableMain {
	public static void main(String[] args) {

		Coordinate coordinate = new Coordinate(10, 20);
		System.out.println(coordinate);
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream  = null;
		try {
			fileOutputStream = new FileOutputStream("test.txt");
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(coordinate);
			objectOutputStream.close();
			fileInputStream = new  FileInputStream("test.txt");
			objectInputStream = new ObjectInputStream(fileInputStream);
			Object a = objectInputStream.readObject();
			Coordinate coordinate1 = (Coordinate) a;
			System.out.println(coordinate1);
			objectInputStream.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
