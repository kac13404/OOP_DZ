package view;

import view.Command.Command;

import java.util.ArrayList;
import java.util.List;

public class OriginalMenu {

    protected List<Command> commandList;

    public OriginalMenu(ConsoleUI consoleUI){
        commandList = new ArrayList<>();
    }
    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice){
        Command command = commandList.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return commandList.size();
    }



}


