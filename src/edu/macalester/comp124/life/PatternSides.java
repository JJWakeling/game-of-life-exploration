package edu.macalester.comp124.life;

public class PatternSides {
	
	private final boolean[][] pattern;

	public PatternSides(boolean[][] pattern) {
		this.pattern = pattern;
	}

	//N.b. This traverses the square anticlockwise
	// as given in graphical display,
	// but clockwise when given as array literals
	public boolean[][] sides() {
		boolean[][] sides = new boolean[4][pattern.length-1];
		
		for (int i = 0; i < pattern.length - 1; i++) {
			sides[0][i] = pattern[0][i];
		}
		for (int i = 0; i < pattern.length - 1; i++) {
			sides[1][i] = pattern[i][pattern.length - 1];
		}
		for (int i = 0; i < pattern.length - 1; i++) {
			sides[2][i] = pattern[pattern.length - 1][pattern.length - 1 - i];
		}
		for (int i = 0; i < pattern.length - 1; i++) {
			sides[3][i] = pattern[pattern.length - 1 - i][0];
		}
		
		return sides;
	}
}
