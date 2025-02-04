public class DLLTest {
	public static void main(String[] args) throws Exception {
		DLL<String> test = new DLL<String>();
		for(int i = 0; i < 5; i++)
			test.addToTail("a" + i);
		System.out.print("original: " );
		test.printAll();
		System.out.print("reversed: " );
		test.printReverse();

		DLL<Integer> mydll = new DLL<>();
		for(int i = 0; i<10; i++)
			mydll.addToTail((int)(10*Math.random()));

		System.out.print("\n\nInitial list: ");
		mydll.printAll();

		mydll.delete7();
		System.out.print("\nThe list after deleting 7th element: ");
		mydll.printAll();

		while(!mydll.isEmpty()) {
			mydll.delete7();
			System.out.print("\nThe list after deleting 7th element again: ");
			mydll.printAll();
		}

		for(int i = 0; i < 10; i++)
			mydll.addToTail((int) (10* Math.random() + 1));

		DLL<Integer> alterTest = new DLL<>();
		for(int i = 0; i < 10; i++)
			alterTest.addToTail(0);

		mydll.insertAlternate(alterTest);
		System.out.println("\n\nAlternative list test (random with a list of zeros): ");
		mydll.printAll();
	}
}