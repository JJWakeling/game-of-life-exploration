package pattern_tests;

import org.junit.Test;
import java.io.*;
import org.junit.Assert;
import edu.macalester.comp124.life.*;

public class LabelTest {

	//TODO: fix early tests to call testUnsafePattern
	@Test
	public void test0() {
		test(
			new UnsafePattern(new boolean[0][0]),
			"0"
		);
	}
	
	@Test
	public void testa1() {
		test(
			new UnsafePattern(new boolean[][] { { true } }),
			"a1"
		);
	}
	
	@Test
	public void testb1_1() {
		test(
			new UnsafePattern(
				new boolean[][] {
					{ true, true },
					{ false, false}
				}
			),
			"b1,1"
		);
	}
	
	@Test
	public void testb1_0_1() {
		test(
			new UnsafePattern(
				new boolean[][] {
					{true, false},
					{false, true}
				}
			),
			"b1,0,1"
		);
	}
	
	@Test
	public void testb1_1_1() {
		testUnsafePattern(
			new boolean[][] {
				{true, true},
				{false, true}
			},
			"b1,1,1"
		);
	}
	
	@Test
	public void testb1_1_1_1() {
		testUnsafePattern(
			new boolean[][] {
				{true, true},
				{true, true}
			},
			"b1,1,1,1"
		);
	}
	
	private void testUnsafePattern(boolean[][] cells, String expected) {
		test(new UnsafePattern(cells), expected);
	}
	
	private void test(Pattern pattern, String expected) {
		try {
			Assert.assertEquals(expected, pattern.label());
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			Assert.fail(e.getMessage() + ":\n" + sw.toString());
		}
	}
}
