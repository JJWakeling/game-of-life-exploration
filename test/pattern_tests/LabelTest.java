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
	
	@Test
	public void testc1_1() {
		testUnsafePattern(
			new boolean[][] {
				{true, false, true},
				{false, false, false},
				{false, false, false}
			},
			"c1,1"
		);
	}
	
	@Test
	public void testc1_01() {
		testUnsafePattern(
			new boolean[][] {
				{true, false, false},
				{false, false, true},
				{false, false, false}
			},
			"c1,01"
		);
	}
	
	@Test
	public void testc1_0_1() {
		testUnsafePattern(
			new boolean[][] {
				{true, false, false},
				{false, false, false},
				{false, false, true}
			},
			"c1,0,1"
		);
	}
	
	@Test
	public void testc2_1() {
		testUnsafePattern(
			new boolean[][] {
				{true, true, true},
				{false, false, false},
				{false, false, false}
			},
			"c2,1"
		);
	}
	
	@Test
	public void c01_01_01() {
		testUnsafePattern(
			new boolean[][] {
				{false, true, false},
				{false, false, true},
				{false, true, false}
			},
			"c01,01,01"
		);
	}
	
	@Test
	public void testc2_01_0_1() {
		testUnsafePattern(
			new boolean[][] {
				{true, true, false},
				{false, false, true},
				{true, false, false}
			},
			"c2,01,0,1"
		);
	}
	
	@Test
	public void testc2_0_1_1a1() {
		testUnsafePattern(
			new boolean[][] {
				{true, true, false},
				{false, true, false},
				{true, false, true}
			},
			"c2,0,1,1a1"
		);
	}
	
	@Test
	public void testc2_2_2_2a1() {
		testUnsafePattern(
			new boolean[][] {
				{true, true, true},
				{true, true, true},
				{true, true, true}
			},
			"c2,2,2,2a1"
		);
	}
	
	@Test
	public void testd02_02_01_001b0_0_0_1() {
		testUnsafePattern(
			new boolean[][] {
				{false, true, true, false},
				{true, false, false, true},
				{false, true, false, true},
				{false, false, true, false}
			},
			"d02,02,01,001b0,0,0,1"
		);
	}
	
	@Test
	public void teste0101_01_0_0001c1_2_0_01() {
		testUnsafePattern(
			new boolean[][] {
				{false, true, false, true, false},
				{true, true, false, true, true},
				{false, true, false, true, false},
				{false, false, false, false, false},
				{false, false, false, false, false}
			},
			"e0101,01,0,0001c1,2,0,01"
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
