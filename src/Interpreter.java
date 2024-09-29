import java.util.Scanner;

class Interpreter {

	public static Scanner scan = new Scanner(System.in);

	static private Dungeon buildSampleDungeon() {

		//Room creations
		Room entrance = new Room("\nThe Gates of Erebor"); //creates a new room object (entry) with the room name "The Great Hall"
		entrance.setDesc("\nGuarded by two stone mountainous dwarves. The entry north lays ahaed."); // sets description to (entry) room using the setDecs() method in the room class 
		Room GHall = new Room("Great Halls of Erebor"); //creates a second room object (entryHall) 
		GHall.setDesc("\nCeilings that reach hundreds of feet. Doorways lead in each direction north, east, and west."); // sets description of second room (entryHall)
		Room armory = new Room("Dwarven Armory"); 
		armory.setDesc("\nA room full of dust, armour, and arms. The only way out is east where you came from.");
		Room deadend = new Room("caved in rooom");
		deadend.setDesc("\nbodies fill this room, those who couldnt escape. The only way out is south, back where you came from.");
		Room theForge = new Room("The Forge");
		theForge.setDesc("\nAbandonded they all sit, great baths of stone frozen like ice. The only accesable way out is south where you came from. ");

		//Exits
		Exit northHall = new Exit("n", entrance, GHall); // creates an exit object going north from (entry) to (entryHall)
		entrance.addExit(northHall); // adds exit from room addExit() method 
		Exit southHall = new Exit("s", GHall, entrance); // return user back to the room they where in by calling opposite direction 
		GHall.addExit(southHall); 
		Exit westHallToArmory = new Exit("w", GHall, armory);
		GHall.addExit(westHallToArmory);
		Exit eastArmoryToHall = new Exit("e", armory, GHall);
		armory.addExit(eastArmoryToHall);
		Exit eastGhToCavedR = new Exit("e", GHall, deadend);
		GHall.addExit(eastGhToCavedR);
		Exit westCavedRToGh = new Exit("w", deadend, GHall);
		deadend.addExit(westCavedRToGh);
		Exit northGhToForge = new Exit("n", GHall, theForge);
		GHall.addExit(northGhToForge);
		Exit southForgeToGh = new Exit("s", theForge, GHall);
		theForge.addExit(southForgeToGh);


		Dungeon Mountain = new Dungeon(entrance,"                                                                        ***GAMERULES***\n"
				+"                                                             Use n,e,s,w,d,u as a means to explore\n"
				+ "       Adventure through the crypts of the lonely mountain and find what remains under the dust and ashes. However do be quiet as more than rats dwell in this mountain."+
				" \n                                                                    A journey through Erebor\n");
		Mountain.add(entrance);
		return Mountain;

	}


	public static void main(String[] args) {

		Dungeon myDungeon = buildSampleDungeon();
		System.out.println(myDungeon.getTitle());
		GameState gs = GameState.instance();
		gs.initialize(myDungeon);
		CommandFactory CF = CommandFactory.instance();
		System.out.println(gs.instance().getAdventurersCurrentRoom().describe());
		do {

			String user = scan.nextLine();
			user.toLowerCase();
			if(user.toLowerCase().equals("n") || user.toLowerCase().equals("e") || user.toLowerCase().equals("s") || user.toLowerCase().equals("w") || user.toLowerCase().equals("d") || user.toLowerCase().equals("u")){
				System.out.println(CF.parse(user).execute());
			}else if(user.toLowerCase().equals("q")) {
				System.out.println("you have quit the game");
				break;
			}else {
				System.out.println("Hmmm you need to be more spacific");
			}

		}while(true);

	}
}

