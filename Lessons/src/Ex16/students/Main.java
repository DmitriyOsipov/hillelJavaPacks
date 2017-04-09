package Ex16.students;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        StudentGenerator generator = new StudentGenerator();
        Group group = generator.generateGroup(0, 10, 0);
        //System.out.println(group);
        List<Group> groups = new LinkedList<>();
        //groups.add(group);

        DataLayer dataLayer = new DataLayer();
        //*
        //dataLayer.saveAll(groups);
        //*/
        group = null;
        groups = null;
        groups = dataLayer.loadAll(';');
        System.out.println(groups.get(0));
    }
}
