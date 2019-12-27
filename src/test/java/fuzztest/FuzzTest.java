package fuzztest;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.NoSuchAlgorithmException;

import org.junit.Ignore;
import org.junit.Test;

import dev.fuzzit.javafuzz.core.AbstractFuzzTarget;
import dev.fuzzit.javafuzz.core.Fuzzer;

public class FuzzTest {

	private void writeToFile(String s, String filename) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(filename)) {
		   fos.write(s.getBytes());
		}		
	}
	
	@Test
	@Ignore
	public void generateValidTestCases() throws IOException {
		writeToFile("12.5.2019", "src/main/resources/corpus/12-5-2019.txt");
		writeToFile("1.1.1976", "src/main/resources/corpus/1-1-1976.txt");
		writeToFile("24.12.1999", "src/main/resources/corpus/24-12-1999.txt");
	}
	
	@Test
	public void runFuzzer() {
		try {
			final AbstractFuzzTarget fuzzTarget=new MyFuzzTarget();
			final String dirs="build/corpus,src/main/resources/corpus";
			final Fuzzer fuzzer = new Fuzzer(fuzzTarget, dirs);
	        fuzzer.start();
		} catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException
				| IllegalAccessException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
}
