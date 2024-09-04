package Model.Service.FamilyTreeNameDatabase;

import Model.Models.FamilyTreeName.FamilyTree;
import java.util.ArrayList;
import java.util.List;;


public class FamilyTreeNameDatabase {

    private List<FamilyTree> familyTreeNameDatabase;

    public FamilyTreeNameDatabase() {
        this.familyTreeNameDatabase = new ArrayList<>();
    }

    public void addFamilyTree(int familyTreeId, String familyTreeName){
        FamilyTree familyTree = new FamilyTree(familyTreeId, familyTreeName);
        this.familyTreeNameDatabase.add(familyTree);
    }

    public String getFamilyTreeNameById(int familyTreeId){
        for (FamilyTree familyTree : familyTreeNameDatabase) {
            if (familyTree.getFamilyTreeId() == familyTreeId) {
                return familyTree.getName();
            }
        }
        System.out.println("Семейное древо не найдено");
        return null;
    }
}
