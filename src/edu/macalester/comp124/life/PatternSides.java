package edu.macalester.comp124.life;

public class PatternSides {
	
	private final boolean[][] pattern;

	public PatternSides(boolean[][] pattern) {
		this.pattern = pattern;
	}

	//TODO: reverse traversal order
	// so that identifying x with first index and y with second
	// we traverse the square clockwise from top left
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
