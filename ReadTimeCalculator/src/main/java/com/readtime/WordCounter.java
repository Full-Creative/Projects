package com.readtime;

public class WordCounter implements Tokenizer {

	@Override
	public int countWords(String data) {
		int count = 0;
		try {
			if ( data == null || data.length() == 0) {
				throw new IllegalArgumentException("Text not entered");
			} else {
				count = data.split("\\W+").length;
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		return count;
	}
}
