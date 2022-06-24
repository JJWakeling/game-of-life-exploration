package edu.macalester.comp124.life;

public class OrdinalLetters implements Code {

	private final String alphabet;
	
	public OrdinalLetters(String alphabet) {
		this.alphabet = alphabet;
	}
	
	public OrdinalLetters() {
		this("abcdefghijklmnopqrstuvwxyz");
	}

	@Override
	public String text(int number) throws Exception {
		//TODO: improve to cope with numbers > length of alphabet
		
		if (number < 1 || number > alphabet.length()) {
			throw new Exception("Out of bounds");
		}
		
		return String.valueOf(alphabet.charAt(number - 1));
	}

}
