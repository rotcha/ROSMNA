
public class Node {
	
	Node next_;
	int data_;
	
	public Node(int value) {
		data_ = value;
		next_ = null;
	}
	
	public Node(int value, Node next) {
		data_ = value;
		next_ = next;
	}
	
	public Node getNext() {
		return next_;
	}
	
	public void setNext(Node next) {
		next_ = next;
	}
	
	public int getData() {
        return data_;
    }

    public void setData(int value) {
        data_ = value;
    }
	
}
