package com.readtime;

public class WordCounter implements Tokenizer {

	@Override
	public int countWords(String data) {
		int count = 0;
		try {
			if (data.length() == 0 || data == null) {
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
