package fuzztest;

import java.text.ParseException;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.lang3.time.DateParser;
import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.commons.lang3.time.FastDateParser;

import dev.fuzzit.javafuzz.core.AbstractFuzzTarget;

public class MyFuzzTarget extends AbstractFuzzTarget {

	private static final DateParser DATE_PARSER = FastDateFormat.getInstance("d.m.yyyy"); 

	private static String getDateString(byte[] data) {
		try  {
			return new String(data);			
		} catch(Exception e) {
			return null;
		}
	}
	@Override
	public void fuzz(byte[] data) {
		final String dateString=getDateString(data);
		if(dateString!=null) {
			try {
				DATE_PARSER.parse(dateString);
			} catch (ParseException e) {
			}			
		}
	}

}
