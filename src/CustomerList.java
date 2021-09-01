import java.util.ArrayList;
import java.util.Iterator;

public class CustomerList {
	private ArrayList<Customer> theList;
	
	public CustomerList() {
		this.theList = new ArrayList<Customer>();
	}
	
	public Iterator getIterator() {
		return new CustomerIterator();
	}
	
	private class CustomerIterator implements Iterator {
		Iterator<Customer> iter = theList.iterator();
		
		@Override
		public boolean hasNext() {
			return iter.hasNext();
		}
		
		@Override
		public Object next() {
			return iter.next();
		}
	}
	
	public ArrayList<Customer> getList() {
		return this.theList;
	}
	
	public Customer getCustomer(String id) {
		for (int i = 0; i < this.theList.size(); i++) {
			Customer temp = this.theList.get(i);
			if (temp.getID().equals(id))
				return temp;
		}
		System.out.println("Customer " + id + " not found");
		return null;
	}
	
	public boolean addCustomer(Customer cust) {
		for (int i = 0; i < this.theList.size(); i++) {
			Customer temp = this.theList.get(i);
			if (temp.getID().equals(cust.getID()))
				return false;
		}
		this.theList.add(cust);
		return true;
	}
}
