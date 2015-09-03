
public class ListeChainee implements ListeChaineeInterface {
	
	Node head;
	int size_;
	int sizeMax_;
	String op_;
	
	public ListeChainee(String path, String op, int val1, int val2, int size, boolean empty) throws Exception {
		
		if (size == 1)
		{
			sizeMax_ = size;
			op_ = op;
			head = new Node(val1, null);
			size_ = 1;
		}		
		else if (size > 1 || size <= 10)
		{
			sizeMax_ = size;
			op_ = op;
			Node temp = new Node(val2);
			head = new Node(val1, temp);
			size_ = 2;
			
			/* REMPLISSAGE AUTOMATIQUE DE LA LISTE */
			while (size_ < sizeMax_)
			{
				Node last = head;
				Node penultimate = head;
		
				//On parcourt  les nodes jusqu'a la derniere
				while (last.getNext() != null) 
				{
					last = last.getNext();
				} // last contient la derniere Node
				
				// On parcourt les nodes jusqu'a l'avant-derniere
				while (penultimate.getNext() != last) 
				{
					penultimate = penultimate.getNext();
				} // penultimate contient l'avant-derniere node
				
				// Choix du bon operateur
				switch (op) {
				
				case "add":
					ajouter(add(penultimate.getData(),last.getData()));
					break;
				case "substract":
					ajouter(substract(penultimate.getData(),last.getData()));
					break;
				case "multiply":
					ajouter(multiply(penultimate.getData(),last.getData()));
					break;
				case "divide":
					ajouter(divide(penultimate.getData(),last.getData()));
					break;
				default:
					throw new IllegalArgumentException("Operateur invalide!");
				
				}			

			}
			
			/* TEST DES OPERATEURS. TOUT FONCTIONNE APRES UN PEU DE DEBUGAGE.
			ajouter(add(-56,-6));
			ajouter(substract(-8,-10));
			ajouter(multiply(-15, -3));
			ajouter(divide(-15,-5));
			*/
			
			/* POUR LES BESOINS DE TEST */
			printAll();
		}
		else
		{
			System.out.print("Taille invalide");
		}
	}

	@Override
	public void ajouter(int element) throws Exception {
		
		// On verifie que la taille est valide
		if (size_ + 1 > sizeMax_)
			throw new Exception("Attention, la taille maximale a ete depassee!");
		
		// Element a ajouter
		Node temp = new Node (element);
		
		// On se place au debut
		Node current = head;
		
		// On parcourt la liste jusqu'a la fin
		while (current.getNext() != null)
			current = current.getNext();
		
		// On ajoute le nouvel element
		current.setNext(temp);
		size_++;
	}

	@Override
	public int removeAt(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean removeItem(int element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setAt(int element, int position) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getAt(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private int add(int a, int b) {
		int res = a;
		
		if (b > 0)
		{
			while (b-- != 0)
				res++;
		}
		else if (b < 0)
		{
			while (b++ != 0)
				res--;
		}
		return res;
	}
	
	private int substract(int a, int b) {
		
		int res = a;
		
		if (b > 0)
		{
			while (b-- != 0)
				res--;
		}
		else if (b < 0)
		{
			while (b++ != 0)
				res++;
		}
		return res;
	}
	
	private int multiply(int a, int b) {
		
		int res = 0;
		
		if (a > 0 && b > 0)
		{
			while (b-- != 0)
				res = add(a,res);
		}
		else if (a < 0 && b < 0)
		{
			res = multiply(-a, -b);
		}
		else if (a > 0 && b < 0)
		{
			res = -multiply(a, -b);
		}
		else if (a < 0 && b > 0)
		{
			res = -multiply(-a, b);
		}
		else
		{
			res = 0;
		}
		
		return res;
	}
	
	private int divide(int a, int b) throws Exception {
		
		if (b == 0)
			throw new Exception("Division par 0!");

		int res = a;

		if (Math.abs(a) < Math.abs(b) || a == 0)
			res = 0;	
		else if (a > 0 && b > 0)
		{
			int reste = substract(a,b);
			int compteur = 1;
			while (reste >= b)
			{
				reste = substract(reste,b);
				compteur++;
			}
			res = compteur;
		}
		else if (a < 0 && b < 0)
			res = divide(Math.abs(a),Math.abs(b));
		else if ((a < 0 && b > 0) || (a > 0 && b < 0) )
			res = -divide(Math.abs(a),Math.abs(b));
		
		return res;
	}

	@Override
	public void printAll() {
		
		Node current = head;
		
		//On parcourt et imprime les nodes a partir de la tete.
		while (current.getNext() != null) 
		{
			System.out.println(current.getData());
			current = current.getNext();
		}
		// On imprime la derniere node
		System.out.println(current.getData());
			
	}
	
}