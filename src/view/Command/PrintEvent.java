package view.Command;

import view.ConsoleUI;

public class PrintEvent extends Command {
    public PrintEvent(ConsoleUI consoleUI) {
        super(consoleUI);
        this.description = "Вывести событие";
    }

    @Override
    public void execute() {
        consoleUI.PrintCurrentEvent();
    }
}
