
public interface ListeChaineeInterface {
	
	public void ajouter(int element) throws Exception;
	public int removeAt(int position) throws Exception;
	public void removeItem(int element);
	public void setAt(int element, int position)throws Exception;
	public int getAt (int position);
	public void reset();
	public boolean isValid();
	public void printAll();
}
