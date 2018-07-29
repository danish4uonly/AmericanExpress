
public class PhoneParser {

	private static final String SEPARATOR = "-";

	//	00-44  48 5555 8361 -> 004-448-555-583-61 (14 sign)
	//	0 - 22 1985--324    -> 022-198-53-24      (10 sign)
	//	555372654           -> 555-372-654        (9 sign)

	public static void main(String[] args) {
		String case1 = "00-44  48 5555 8361";
		String case2 = "0 - 22 1985--324";
		String case3 = "555372654";
		System.out.println("case1: " + parse(case1)); //case1: 004-448-555-583-61
		System.out.println("case2: " + parse(case2)); //case2: 022-198-53-24
		System.out.println("case3: " + parse(case3)); //case3: 555-372-654
	}

	public static String parse(String input) {
		input = input.replaceAll(" ", "").replaceAll("-", "");
		int inputLength = input.length();
		if (inputLength <= 3) {
			return input;
		} else {
			int mod = inputLength % 3;
			if (mod == 0) {
				return split3(input);
			} else if (mod == 1) {
				int baseEnd = inputLength - 4;
				String base = split3(input.substring(0, baseEnd));
				String suffix = split2(input.substring(baseEnd, inputLength));
				return base + "-" + suffix;
			} else {
				int baseEnd = inputLength - 2;
				String base = split3(input.substring(0, baseEnd));
				String suffix = input.substring(baseEnd, inputLength);
				return base + "-" + suffix;
			}
		}
	}

	private static String split2(String input) {
		return splitTemplate(input, 2);
	}

	private static String split3(String input) {
		return splitTemplate(input, 3);
	}

	private static String splitTemplate(String input, int splitSize) {
		String result = "";
		int length = input.length();
		for (int i = 0; i < length; i += splitSize) {
			String sub = input.substring(i, i + splitSize);
			result = result.concat(sub);
			if (i != length - splitSize) {
				result = result.concat(SEPARATOR);
			}
		}
		return result;
	}

}
