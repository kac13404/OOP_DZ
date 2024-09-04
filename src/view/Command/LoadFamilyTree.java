package view.Command;

import view.ConsoleUI;

public class LoadFamilyTree extends Command {
    public LoadFamilyTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Загрузить семейное древо";
    }

    @Override
    public void execute() {
        consoleUI.LoadFamilyTree();
    }
}
