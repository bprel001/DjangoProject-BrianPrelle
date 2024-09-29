
class CommandFactory {
	
	private static CommandFactory theInstance = null;
	
	public static CommandFactory instance() {
		if (CommandFactory.theInstance ==  null) {
			CommandFactory.theInstance = new CommandFactory();
		}
		return CommandFactory.theInstance;
	}
	private CommandFactory(){
		
	}
	
	Command parse(String commandString) {
		return new Command(commandString);    //???
	}
	//A factory class whose purpose is to parse text strings and produce the appropriate Command objects
	
}
