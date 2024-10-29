package io.github.themoddedchicken.WebConnect.lib.utilities;

import java.util.Collections;

public class StringUtility {
	public static String repeat(String delimiter, String segment, int amount) {
		return String.join(delimiter, Collections.nCopies(amount, segment));
	}
}
