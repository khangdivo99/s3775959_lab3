import java.util.ArrayList;

public class SuperVIPCustomer {
	private String name;
	private String address;
	private String ID;
	private String phone;
	private ArrayList<Video> rentals;
	private int reward_points;
	static SuperVIPCustomer obj = new SuperVIPCustomer();
	
	private SuperVIPCustomer() {
		
	}
	
	public static SuperVIPCustomer getInstance() {
		return obj;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPhone() {
		return phone;
	}
	public int getNumRentals() {
		return this.rentals.size();
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public int getReward_points() {
		return reward_points;
	}
	public void setReward_points(int reward_points) {
		this.reward_points = reward_points;
	}
	
	public boolean checkBorrow(Video rental) {
		for (int i = 0; i < this.rentals.size(); i++) {
			Video temp = this.rentals.get(i);
			if (temp.getID().equals(rental.getID())) {
				System.out.println("Customer " + this.getName() + " has already borrowed video item "+rental.getTitle());
				return false;
			}
		}
		this.rentals.add(rental);
		rental.setRental_status(true);
		System.out.println("Customer " + this.getName() + " now borrowed video item "+rental.getTitle());
		return true;
	}
	public boolean returnVid(Video rental) {
		for (int i = 0; i < this.rentals.size(); i++) {
			Video temp = this.rentals.get(i);
			if (temp.getID().equals(rental.getID())) {
				this.rentals.remove(i);
				rental.setRental_status(false);
				System.out.println("Customer " + this.getName() + " returned the video item " + rental.getTitle());
				return true;
			}
		}
		System.out.println("Customer " + this.getName() + " did not borrow the video item " + rental.getTitle());
		return false;
	}
	
	public boolean borrowVid(Video rental) {
		if (checkBorrow(rental)) {
			if (reward_points>=100)
				reward_points = 0;
			else
				reward_points += 10;
			System.out.println("Customer "+this.getName()+" now has "+this.getReward_points()+" reward points");
			return true;
		}
		return false;
	}
}
