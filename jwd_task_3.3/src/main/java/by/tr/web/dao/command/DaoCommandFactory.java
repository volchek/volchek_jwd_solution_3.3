package by.tr.web.dao.command;

import java.util.Map;
import java.util.HashMap;

import by.tr.web.dao.command.impl.util.Parsers;
import by.tr.web.dao.command.impl.ParseWithSAX;
import by.tr.web.dao.command.impl.ParseWithSTAX;
import by.tr.web.dao.command.impl.ParseWithDOM;


public class DaoCommandFactory {

    private static final DaoCommandFactory instance = new DaoCommandFactory();
    
    private final Map<String, DaoCommand> commands = new HashMap<>();
    {
        commands.put(Parsers.SAX.name(), new ParseWithSAX());
        commands.put(Parsers.STAX.name(), new ParseWithSTAX());
        commands.put(Parsers.DOM.name(), new ParseWithDOM());
    }


    public Map<String, DaoCommand> getCommands() {
        return commands;
    }

    public DaoCommand getCommand(String commandName) {
        return commands.get(commandName);
    }	

    public static DaoCommandFactory getInstance() {
        return instance;
    }

    private DaoCommandFactory() { }

}
