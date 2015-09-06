
public interface ListeChaineeInterface {
	
	public void ajouter(int element) throws Exception;
	public int removeAt(int position) throws Exception;
	public boolean removeItem(int element);
	public void setAt(int element, int position);
	public int getAt (int position);
	public void reset();
	public boolean isValid();
	public void printAll();
}
