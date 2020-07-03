class StringBufferExample {
	public static void main(String[] args) {
		/**
		* String object is immutable and StringBuffer/StringBuilder objects are mutable.
		*/

		StringBuffer sb = new StringBuffer();
		System.out.println(sb.capacity());	// 16; updated by (c+1)*2 where c = 16 initially
		sb.append("abcdefghijklmnopqrstuvxyz");
		System.out.println(sb.capacity()); // 34 => (16+1) * 2 = 34
		sb.append("abcdefghijklmnopqrstuvxyz");
		System.out.println(sb.capacity()); // 70 => (34+1) * 2 = 70
		
		StringBuffer sb1 = new StringBuffer(100);
		System.out.println(sb1.capacity());	// 100

		StringBuffer sb2 = new StringBuffer("Java");
		System.out.println("The length of \"" + sb2 + "\" is " + sb2.length()); // 4
		System.out.println("The character at index 2 is '" + sb2.charAt(2) + "'");	// 'v'
		sb2.append(" tech");
		System.out.println(sb2);	// Java tech

		StringBuffer sb3 = new StringBuffer("java");
		sb3.append(" tech");
		sb3.append(100);	// valid
		sb3.append(true);	// valid
		sb3.append(500.00);	// valid
		sb3.insert(0, "HIBERNATE");	// insert "HIBERNATE" in sb3 from index 2 onwards
		sb3.insert(2, "JDBC");		// insert "JDBC" in sb3 from index 0 onwards
		System.out.println(sb3);	// HIJDBCBERNATEjava tech100true500.0

		sb3.delete(0, 12);	// delete characters from index 0 to index 11.
		System.out.println(sb3); // Ejava tech100true500.0

		// we have a reverse() method in case of the StringBuffer object, not there for String object.
		sb3.reverse();
		System.out.println(sb3); // 0.005eurt001hcet avajE

		// We can convert a StringBuffer object to a String object using toString() method.
		String str = sb3.toString();
		System.out.println(str); // 0.005eurt001hcet avajE

		StringBuffer sb4 = new StringBuffer();

		// we can chain methods like this:
		sb4.append("java").append(" tech").append(100).append(true).deleteCharAt(5).insert(12, "JDBC");
		System.out.println(sb4); // java ech100tJDBCrue

		// Both StringBuilder and StringBuffer classes are used interchangeably because both use the same methods
		// both of the class' objects are mutable. The only difference between StringBuffer and StringBuilder classes
		// is that, StringBuffer is Thread Safe and StringBuilder is Thread Unsafe, meaning, we can use StringBuffer
		// class for multithreading purposes which decreases the performance of StringBuffer object, whereas StringBuilder
		// class' objects cannot be used for multithreading purposes.

		StringBuilder s1 = new StringBuilder();
		s1.append("java").append(" tech").append(100).append(true).deleteCharAt(5).insert(12, "JDBC");
		System.out.println(s1); // java ech100tJDBCrue
	}
}