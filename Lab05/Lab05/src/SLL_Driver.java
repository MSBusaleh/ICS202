public class SLL_Driver {
	public static void main(String[] args){
		SLL<String> myList = new SLL<String>();
     	String[] cityNames = {"Jubail", "Riyadh", "Abha", "Dammam", "Taif"};
		for(int i = 0; i < cityNames.length; i++)
			myList.addToHead(cityNames[i]);


		System.out.println("The list is: " + myList);
		System.out.println("It is " + myList.contains("Dammam") + " that the list contains Dammam.");
		System.out.println("It is " + myList.contains("Jeddah") + " that the list contains Jeddah.");
	}
}