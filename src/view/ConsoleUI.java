package view;

import Model.Models.Gender;
import java.time.LocalDate;
import java.util.Scanner;
import presenter.Presenter;
import view.Menu.MainMenu;
import view.Menu.MenuFamilytree;
import view.Menu.MenuHuman;

public class ConsoleUI implements View{

    private static final String INPUT_ERROR = "Вы ввели неверное значение";

    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private OriginalMenu mainMenu;
    private OriginalMenu humanMenu;
    private OriginalMenu familyTreeMenu;


    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
        this.presenter = new Presenter(this);
        this.work = true;
        this.mainMenu = new MainMenu(this);
        this.familyTreeMenu = new MenuFamilytree(this);
        this.humanMenu = new MenuHuman(this);
    }

    public void CreateNewTree(){
        System.out.println("Введите имя");
        String nameFamilyTree = scanner.nextLine();
        presenter.CreateNewTree(nameFamilyTree);
        printMenu(familyTreeMenu);
        execute(familyTreeMenu);
    }

    public void SetCurrentFamilyTree(){
        System.out.println("Введите идентификатор");
        String familyTreeIdString = scanner.nextLine();
        int familyTreeId = Integer.parseInt(familyTreeIdString);
        presenter.SetCurrentFamilyTree(familyTreeId);

    }

    private LocalDate inputDate(){
        System.out.println("Введите год рождения");
        String yearString = scanner.nextLine();
        int year = Integer.parseInt(yearString);
        System.out.println("Введите месяц рождения");
        String mounthString = scanner.nextLine();
        int mounth = Integer.parseInt(mounthString);
        System.out.println("Введите день рождения");
        String dayString = scanner.nextLine();
        int day = Integer.parseInt(dayString);
        return LocalDate.of(year, mounth, day);
    }

    public void BornHuman(){
        System.out.println("Введите имя");
        String firstName = scanner.nextLine();
        System.out.println("Введите отчество");
        String lastName = scanner.nextLine();
        System.out.println("Введите фамилия");
        String familyName = scanner.nextLine();
        LocalDate birthday = inputDate();
        System.out.println("Введите место рождения");
        String placename = scanner.nextLine();
        System.out.println("Введите пол");
        Gender gender = Gender.male;
        presenter.BornHuman(firstName, lastName, familyName, birthday, placename, gender);
        presenter.PrintCurrentHuman(presenter.getLastHumanId());
        printMenu(humanMenu);
        execute(humanMenu);
    }

    public void SetParent(){
        System.out.println("Введите идентификатор человека");
        String humanIdString = scanner.nextLine();
        int humanId = Integer.parseInt(humanIdString);
        System.out.println("Введите идентификатор отца");
        String fatherIdString = scanner.nextLine();
        int fatherId = Integer.parseInt(fatherIdString);
        System.out.println("Введите идентификатор матери");
        String motherIdString = scanner.nextLine();
        int motherId = Integer.parseInt(motherIdString);
        presenter.SetParent(humanId, fatherId, motherId);
    }

    public void WendingHuman(){
        System.out.println("Введите идентификатор");
        String wideIdString = scanner.nextLine();
        int wideId = Integer.parseInt(wideIdString);
        System.out.println("Введите идентификатор мужа");
        String husbandIdString = scanner.nextLine();
        int husband = Integer.parseInt(husbandIdString);
        LocalDate wendingDate = inputDate();
        System.out.println("Введите дату свадьбы");
        String placeName = scanner.nextLine();
        presenter.WendingHuman(wideId, husband, wendingDate, placeName);
    }

    public void DiedHuman(){
        System.out.println("Введите идентификатор человека");
        String humanIdStr = scanner.nextLine();
        int humanId = Integer.parseInt(humanIdStr);
        System.out.println("Введите дату мерти человека");
        LocalDate diedDate = inputDate();
        System.out.println("Введите место смерти человека");
        String placeName = scanner.nextLine();
        presenter.DiedHuman(humanId, diedDate, placeName);
    }

    public void PrintFamilyTreeHuman(){
        presenter.PrintFamilyTreeHuman();
    }

    public void PrintFamilyTreeEvent(){
        presenter.PrintEventInFamilyTree();
    }

    public void PrintCurrentHuman(){
        System.out.println("Введите идентификатор человека");
        String humanIdStr = scanner.nextLine();
        int humanId = Integer.parseInt(humanIdStr);
        presenter.PrintCurrentHuman(humanId);
    }

    public void PrintCurrentEvent(){
        System.out.println("Введите идентификатор события");
        String eventIdStr = scanner.nextLine();
        int eventId = Integer.parseInt(eventIdStr);
        presenter.PrintCurrentEvent(eventId);
    }

    public void SortHumanByName(){
        presenter.sortHumanByName();
    }

    public void SortHumanByAge(){
        presenter.SortHumanByAge();
    }

    public void SortHumanById(){
        presenter.SortHumanById();
    }

    public void SaveFamilyTree(){
        System.out.println("Введите путь к файлу человека");
        String filepathHumanDb = scanner.nextLine();
        System.out.println("Введите путь к файлу события");
        String filepathEventDb = scanner.nextLine();
        presenter.SaveFamilyTree(filepathHumanDb, filepathEventDb);
    }

    public void LoadFamilyTree(){
        System.out.println("Введите путь к файлу человека");
        String filepathHumanDb = scanner.nextLine();
        System.out.println("Введите путь к файлу события");
        String filepathEventDb = scanner.nextLine();
        presenter.LoadFamilyTree(filepathHumanDb);
        presenter.LoadFamilyTree(filepathEventDb);
    }

    @Override
    public void PrintAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        while (work) {
            printMenu(mainMenu);
            execute(mainMenu);
        }
    }

    public void execute(OriginalMenu originalMenu){
        String line = scanner.nextLine();
        if (
                checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand, originalMenu)) {
                System.out.println("\033[2J\033[H");
                originalMenu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand, OriginalMenu originalMenu){
        if (numCommand <= originalMenu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void printMenu(OriginalMenu originalMenu){
        System.out.println(originalMenu.menu());
    }

    private void printFamilyTreeMenu(){
        System.out.println(familyTreeMenu.menu());
    }

    private void printHumanMenu(){
        System.out.println(humanMenu.menu());
    }


    private void inputError(){
        System.out.println(INPUT_ERROR);
    }


    public void Exit() {
        work = false;
    }

    public void BackToMainMenu() {
        printMenu(mainMenu);
        execute(mainMenu);
    }

    public void backTreeMenu() {
        printMenu(familyTreeMenu);
        execute(familyTreeMenu);
    }

}
