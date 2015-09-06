
public class Main {

	public static void main(String[] args) throws Exception {
		
		ListeChainee liste = new ListeChainee("allo", "add", 1, 2,5, false);
		liste.printAll();
		System.out.println();
		System.out.println(liste.removeAt(4));
		System.out.println();
		System.out.println(liste.removeItem(8));
		liste.printAll();
		
	}

}
