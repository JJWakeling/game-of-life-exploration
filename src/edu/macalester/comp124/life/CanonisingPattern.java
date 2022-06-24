package edu.macalester.comp124.life;

import elegant_java.*;

public class CanonisingPattern implements Pattern {
	
	private final Latch<CanonicalPattern> pattern;

	public CanonisingPattern(boolean[][] cells) {
		this.pattern = new ListLatch<CanonicalPattern>();
	}

	@Override
	public String label() throws Exception {
		if (!pattern.isSet()) {
			canonise();
		}
		
		return pattern.value().label();
	}
	
	private void canonise() {
		if (pattern.isSet()) {
			return;
		}
		
		//TODO: canonise pattern
	}
}
