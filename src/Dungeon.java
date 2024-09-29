import java.util.Hashtable;

public class Dungeon {

	private String title;
	private Room entry; //1
	Hashtable<String, Room> roomNames = new Hashtable<String, Room>();
	
	public Dungeon(Room entry, String title){
		this.entry = entry;
		this.title = title;	
		roomNames.put(entry.getName(), entry);//returns the name of the room the the room itself
	}
	
	public Room getEntry(){      
		return this.entry; //1
	}
	
	public String getTitle() { //title of the world your room is in 
		return this.title;
	}
	
	public void add(Room room) { // allows 
	   roomNames.put(room.getName(), room);
	}
	
	public Room getRoom(String roomName) {
		return roomNames.get(roomName);
		
	}

}

