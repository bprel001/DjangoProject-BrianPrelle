import java.util.Hashtable;

public class Exit {
	
	private String dir;
	private Room src;
	private Room dest;
	
 	Exit(String dir, Room src, Room dest){
		this.dir = dir;
		this.src = src;
		this.dest = dest;
		
		}
	String discribe() { // tells where exits lead to (direction)
		return "Exit is " + this.dir + "" + this.dest.getName();
	}
	public String getDir() {
		return this.dir;
	}
	
	public Room getSrc() {
		return this.src;
	}
	public Room getDest() {
		return this.dest;
	}
	
}

