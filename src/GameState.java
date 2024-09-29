import java.util.HashSet;

class GameState {
	
	private static GameState theInstance = null;
	private Room currentRoom;
	private Dungeon dungeon;
	
	HashSet<Room> roomVisited = new HashSet<Room>();
	
	public static GameState instance() {// return what you need in each method 
		if(GameState.theInstance == null) {
			GameState.theInstance = new GameState();
		}
		return GameState.theInstance;
	}
	public void initialize(Dungeon dungeon) {
		this.dungeon = dungeon;
		this.currentRoom = dungeon.getEntry();
		}
	
	private GameState() {
		this.currentRoom = null;
		this.dungeon = null;
	}
	
	public Room getAdventurersCurrentRoom(){
		return currentRoom;
		
	}
	
	public void setAdventuresCurrentRoom(Room room) {
		this.currentRoom = room;
	}
	
	public Dungeon getDungeon() {
		return this.dungeon;
	}
	
	void visit(Room room) {
		//this.getAdventurersCurrentRoom().
		 roomVisited.add(room);
	}
	
	Boolean hasBeenVisited(Room room) {
		if (roomVisited.contains(room) == true) {
			return true;
		}else {
			return false;
		}
	}
}
