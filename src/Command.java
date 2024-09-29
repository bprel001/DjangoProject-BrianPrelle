
class Command {

	private String dir;
	
	Command(String dir){
		this.dir = dir;
	
		}
	String execute() {
		Room insideR = GameState.instance().getAdventurersCurrentRoom();
	    Room enterR = insideR.leaveBy(dir);
        if (enterR == null){
        	return "You just face planted into a wall, are you feeling well?";
        }
        GameState.instance().setAdventuresCurrentRoom(enterR);
        return enterR.describe();
	}
	
}
