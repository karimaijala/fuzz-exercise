package fuzztest;

import java.lang.reflect.InvocationTargetException;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

import dev.fuzzit.javafuzz.core.AbstractFuzzTarget;
import dev.fuzzit.javafuzz.core.Fuzzer;

public class FuzzTest {

	@Test
	public void runFuzzer() {
		try {
			final AbstractFuzzTarget fuzzTarget=new MyFuzzTarget();
			final String dirs="corpus";
			final Fuzzer fuzzer = new Fuzzer(fuzzTarget, dirs);
	        fuzzer.start();
		} catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException
				| IllegalAccessException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
}
