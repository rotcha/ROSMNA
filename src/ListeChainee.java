
public class ListeChainee implements ListeChaineeInterface {
	
	Node head;
	int size_;
	int sizeMax_;
	String op_;
	
	public ListeChainee(String path, String op, int val1, int val2, int size, boolean empty) {
		
		if (size == 1)
		{
			sizeMax_ = size;
			op_ = op;
			head = new Node(val1, null);
			size_ = 1;
		}		
		if (size > 1 || size <= 10)
		{
			sizeMax_ = size;
			op_ = op;
			Node temp = new Node(val2);
			head = new Node(val1, temp);
			size_ = 2;
		}
	}

	@Override
	public void ajouter(int element) throws Exception {
		// TODO Auto-generated method stub
		
		if (size_++ > sizeMax_)
			throw new Exception("Out of range...");
		
		Node temp = new Node (element);
		Node current = head;
		
		while (current.getNext() != null)
			current = current.getNext();
		
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
		int res = a;
		
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
			while (reste > b)
			{
				reste = substract(a,b);
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
	
}