package Model.Service.EventDatabase;

import Model.Models.Event.Event;
import Model.Models.Human.Human;
import Model.Service.OriginalDatabase;

public class EventDatabase extends OriginalDatabase<Event> {

    public EventDatabase() {
        super();
    }

    @Override
    public String getDatabaseName() {
        return "База данных событий";
    }

    public Event getBornEventByHuman(Human human){
        for (Event event : objectList) {
            if (event.getPersons()==human && event.getEventName()=="Человек родился" ) {
                return event;
            }            
        }
        System.out.println("Событие не найдено");
        return null;
    }

}
