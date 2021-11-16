package calculator.parser;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;
import static org.mockito.Mockito.*;

import calculator.Calculator;
import calculator.Calculator.Operation;
import calculator.parser.Parser;

public class ParserTest {

	@Test(expected = IllegalArgumentException.class)
	public void testNullParser() {
		new Parser(null);
	}

	@Test(expected = FileNotFoundException.class)
	public void testParserInvalidFile() throws Exception {

		Calculator cal = mock(Calculator.class);

		Parser parser = new Parser(cal);
		parser.parse(new File("invalid"));
	}

	@Test
	public void testParserTest01Xml() throws Exception {

		Calculator cal = mock(Calculator.class);

		Parser parser = new Parser(cal);
		parser.parse(new File("src/resources/test04.xml"));
		
		verify(cal).push(256);
		verify(cal).push(24);

		verify(cal).perform(Operation.mod);

		verifyNoMoreInteractions(cal);
	}
}
