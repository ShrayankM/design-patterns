package org.example.decoratorPattern.inputStream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamDemo {
	public static void main(String [] args) throws IOException {

		int c;
		InputStream in = new LowercaseInputStream(
				new BufferedInputStream(new FileInputStream(
						"/Users/shrayankmistry/design-patterns/low-level/src/main/java/org/example/decoratorPattern/inputStream/text.txt")
				)
		);

		while ((c = in.read()) >= 0) {
			System.out.print((char) c);
		}
	}
}
