package edu.macalester.comp124.life;

/**
 * Pattern implementation with no validation or canonisation mechanisms
 */
public class UnsafePattern implements Pattern {
	
	private final boolean[][] cells;

	public UnsafePattern(boolean[][] cells) {
		this.cells = cells;
	}

	//TODO: consider caching result in a Latch
	public String label() throws Exception {
		if (cells.length == 0) {
			return "0";
		}
		
		boolean[][] sides = new PatternSides(cells).sides();
		String[] sideLabels = new String[] {"", "", "", ""};
		
		for (int i = 0; i < 4; i++) {
			
			int j = 0;
			while (j < sides[i].length) {
				boolean liveChain = sides[i][j];
				
				int k = 1;
				while (j + k < sides[i].length && sides[i][j] == liveChain) {
					k++;
				}
				
				if (liveChain) {
					sideLabels[i] += Integer.toString(k);
				} else if (j + k < sides[i].length) { //exclude trailing zeroes
					sideLabels[i] += "0".repeat(k);
				}
				
				j += k;
			}
		}
		
		String squareLabel = "";
		
		boolean trailing = true;
		for (int i = 1; i <= sideLabels.length; i++) {
			if (!trailing) {
				squareLabel = ',' + squareLabel;
			}
			
			String label = sideLabels[sideLabels.length - i];
			if (label == "") {
				if (!trailing) {
					squareLabel = '0' + squareLabel;
				}
			} else {
				squareLabel = label + squareLabel;
				trailing = false;
			}
		}
		
		if (squareLabel != "") {
			squareLabel = new OrdinalLetters().text(cells.length) + squareLabel;
		}
		
		if (cells.length <= 2) {
			return squareLabel;
		}
		
		boolean[][] innerCells = new boolean[cells.length - 2][cells.length - 2];
		for (int i = 0; i < innerCells.length; i++) {
			for (int j = 0; j < innerCells.length; i++) {
				innerCells[i][j] = cells[i + 1][j + 1];
			}
		}
		return squareLabel + new UnsafePattern(innerCells).label();
	}
}
