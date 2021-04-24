package help;

public class ArrayToString {
	public static String arrayToString(String[] stringArray) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < stringArray.length; i++) {
			sb.append(stringArray[i] + "\t");
		}
		String str = sb.toString();
//    System.out.println(str);
		return str;
	}
}
