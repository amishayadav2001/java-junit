package com.aurionpro.model;

public class StringUtil {
	public String truncateInFirst2Positions(String str) {
		if (str == null || str.length() < 2) {
			return str;
		} else {
			return str.substring(0, 2);
		}

	}

	public boolean areFirstAndLastTwoCharactersTheSame(String str) {
		if (str == null || str.length() < 2) {
			return false;
		}

		String firstTwo = str.substring(0, 2);
		String lastTwo = str.substring(str.length() - 2);

		firstTwo.equals(lastTwo);
		return true;
	}

}
