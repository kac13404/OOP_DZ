package Model.Service.Comparator;

import java.util.Comparator;

import Model.Models.Human.Human;

public class ComparatorHumanByName implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
