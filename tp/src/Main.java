
public class Main {

	public static void main(String[] args) throws Exception {
		
		ListeChainee liste = new ListeChainee("allo", "add", 1, 2,8, false);
		liste.printAll();
		System.out.println();
		System.out.println(liste.removeAt(4));
		System.out.println();
		liste.printAll();
		System.out.println();
		liste.removeItem(3);
		System.out.println();
		liste.printAll();
		System.out.println();
		liste.setAt(6, 4);
		System.out.println();
		liste.printAll();
		System.out.println();
		System.out.println(liste.getAt(4));
		System.out.println();
		liste.reset();		
		liste.printAll();
		
	}

}
