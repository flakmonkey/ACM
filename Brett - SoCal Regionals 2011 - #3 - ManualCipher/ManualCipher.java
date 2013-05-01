package manualcipher;

public class ManualCipher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Cipher code = new Cipher("BLUE", 2314);
        code.print();
        System.out.println(code.decrypt("XBDCZGDEVIAZZEKMLIVI"));
	}

}