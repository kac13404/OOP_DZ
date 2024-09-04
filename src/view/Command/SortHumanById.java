package view.Command;

import view.ConsoleUI;

public class SortHumanById extends Command {
    public SortHumanById(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сортировать людей по идентификатору";
    }

    @Override
    public void execute() {
        consoleUI.SortHumanById();
    }
}
