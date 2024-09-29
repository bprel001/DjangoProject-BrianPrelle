import java.util.ArrayList;
import java.util.Hashtable;

public class Room {

	private String name;
	private String desc;
	private Exit room = null;
	//private static GameState gameS;
	
	Hashtable<String, Exit> roomRoutes = new Hashtable<>();
	
	public Room(String name){
		this.name = name;
		this.desc = null;
	}

	public String getName(){
		return this.name;
	}

	void setDesc(String desc){
		this.desc = desc; 

	}
	String describe(){
		if(GameState.instance().hasBeenVisited(this) == true) {
			return this.name ;

		}else {
			GameState.instance().visit(this);
			return this.name + " \n " +this.desc;
		}
	}
    Room leaveBy(String dir) {
		Exit exit = roomRoutes.get(dir);
		if(exit == null) {
			return null;
		}
		return exit.getDest();		
	}
    public void addExit(Exit exit) {
    	roomRoutes.put(exit.getDir(), exit);
    }
	public String toString(){
		return this.name + this.desc;
	}

}
