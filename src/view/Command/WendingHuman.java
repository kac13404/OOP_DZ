package view.Command;

import view.ConsoleUI;

public class WendingHuman extends Command {

    public WendingHuman(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Свадьба";
    }

    @Override
    public void execute() {
        consoleUI.WendingHuman();
    }
}
