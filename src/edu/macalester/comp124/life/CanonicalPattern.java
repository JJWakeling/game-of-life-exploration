package edu.macalester.comp124.life;

import elegant_java.*;

/**
 * Pattern of live cells in its canonical form
 * 
 * In the set of all translations, rotations and reflections of a pattern,
 * exactly one is the canonical form
 */
public class CanonicalPattern implements ValidPattern {
	
	private final Pattern pattern;
	private final Latch<Boolean> valid;

	public CanonicalPattern(Pattern pattern) {
		this.pattern = pattern;
		valid = new ListLatch<Boolean>();
	}

	@Override
	public String label() throws Exception {
		if (!valid()) {
			throw new Exception("Pattern not canonical");
		}
		
		return pattern.label();
	}

	@Override
	public boolean valid() throws Exception {
		if (valid.isSet()) {
			return valid.value().booleanValue();
		}
		
		// TODO write validation logic
	}

}
