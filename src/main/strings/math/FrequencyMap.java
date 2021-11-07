package strings.math;

import java.util.Map;
import java.util.HashMap;

public class FrequencyMap {

	private String str;

	FrequencyMap (String string) {
		assert string != null : "string can't be null";
		this.str = string;
	}

	public Map<String, Integer> getFrequencyMap() {
		Map<String, Integer> result = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			int cp = str.codePointAt(i);
			String chStr = String.valueOf(Character.toChars(cp));

			/*
			* the charCount value "2" of a single codepoint means
			* an Unicode 32-bits surrogate pair (two 16-bits consecutive values)
			*/
			if (Character.charCount(cp) == 2) {
				i++;
			}

			result.compute(chStr, (k, v) -> (v == null) ? 1 : ++v);
		}

		return result;
	}

}
