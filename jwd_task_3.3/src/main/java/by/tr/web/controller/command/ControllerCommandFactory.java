package by.tr.web.controller.command;

import java.util.Map;
import java.util.HashMap;

import by.tr.web.controller.command.impl.Parse;
import by.tr.web.controller.command.impl.Show;
import by.tr.web.controller.command.util.CommandType;


public class ControllerCommandFactory {

	
    private static final ControllerCommandFactory instance = new ControllerCommandFactory();

    
    private final Map<String, ControllerCommand> commands = new HashMap<>();
    {
        commands.put(CommandType.PARSE.name(), new Parse());
        commands.put(CommandType.SHOW.name(), new Show());
    }
    
    
    public static ControllerCommandFactory getInstance() {
        return instance;
    }

    
    public Map<String, ControllerCommand> getCommands() {
        return commands;
    }

    
    public ControllerCommand getCommand(String commandName) {
        return commands.get(commandName);
    }	

    
    private ControllerCommandFactory() { }

}
