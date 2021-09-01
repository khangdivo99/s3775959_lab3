import java.util.ArrayList;
import java.util.Iterator;

public class VideoList {
private ArrayList<Video> theList;
	
	public VideoList() {
		this.theList = new ArrayList<Video>();
	}
	
	public ArrayList<Video> getList() {
		return this.theList;
	}
	
	public Iterator getIterator() {
		return new VideoIterator();
	}
	
	private class VideoIterator implements Iterator {
		Iterator<Video> iter = theList.iterator();
		
		@Override
		public boolean hasNext() {
			return iter.hasNext();
		}
		
		@Override
		public Object next() {
			return iter.next();
		}
	}
	
	public Video getVideo(String id) {
		for (int i = 0; i < this.theList.size(); i++) {
			Video temp = this.theList.get(i);
			if (temp.getID().equals(id))
				return temp;
		}
		System.out.println("Video " + id + " not found");
		return null;
	}
	
	public boolean addVideo(Video vid) {
		for (int i = 0; i < this.theList.size(); i++) {
			Video temp = this.theList.get(i);
			if (temp.getID().equals(vid.getID()))
				return false;
		}
		theList.add(vid);
		return true;
	}
}
