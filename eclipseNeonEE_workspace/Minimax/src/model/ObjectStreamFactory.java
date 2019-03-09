package model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamFactory {

	public static ObjectOutputStream getObjectOutputStream(File file) {
		ObjectOutputStream objectOutputStream = null;
		try {
			FileOutputStream fileOutStream = new FileOutputStream(file);
			BufferedOutputStream bufferedOutStream = new BufferedOutputStream(fileOutStream);
			objectOutputStream = new ObjectOutputStream(bufferedOutStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return objectOutputStream;
	}

	public static ObjectInputStream getObjectInputStream(File file) {
		ObjectInputStream objectInputStream = null;
		try {
			objectInputStream = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream(file)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return objectInputStream;
	}

}
