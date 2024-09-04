package Model.Service.HumanDatabase;

import Model.Models.Human.Human;
import Model.Service.Comparator.ComparatorHumanByAge;
import Model.Service.Comparator.ComparatorHumanById;
import Model.Service.Comparator.ComparatorHumanByName;
import Model.Service.OriginalDatabase;


public class HumanDatabase extends OriginalDatabase<Human>{


    public HumanDatabase() {
        super();
    }

    @Override
    public String getDatabaseName() {
        return "База данных";
    }
    
    public void removeByName(String name) {
        objectList.removeIf(obj-> obj.getFirstName().equals(name));
    }

    public void sortHumanByName(){
        this.objectList.sort(new ComparatorHumanByName());
    }

    public void sortHumanByAge(){
        this.objectList.sort(new ComparatorHumanByAge());
    }

    public void sortHumanById(){
        this.objectList.sort(new ComparatorHumanById() );
    }

    public int getLastHuman() {
        return this.objectList.get(this.objectList.size() - 1).getId();
    }
}

