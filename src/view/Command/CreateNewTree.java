package view.Command;

import view.ConsoleUI;

public class CreateNewTree extends Command {

    public CreateNewTree(ConsoleUI consoleUI) {
        super(consoleUI);
        this.description = "Создать новое дерево";
    }
    @Override
    public void execute() {
        consoleUI.CreateNewTree();
    }
}
