public class Parent {
	public static void main(String args[]) {
		char[] arr = {'H', 'e', 'l', 'l', 'o'};

		SimpleString sStrArr = new SimpleString(arr);
		SimpleString sStrStr = new SimpleString(" World");

		System.out.println(sStrArr);
		System.out.println(sStrStr);

		sStrArr.concatenate(sStrStr);

		System.out.println(sStrArr);
		System.out.println(sStrArr.subString(0, 11));
	}
}