package Ex16.students;

import Ex16.Saver;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception{
        StudentGenerator generator = new StudentGenerator();
        //Group group = generator.generateGroup(0, 10, 0);
        //System.out.println(group);
        List<Group> groups = new LinkedList<>();
        //groups.add(group);

        DataLayer dataLayer = new DataLayer();
        //*
        //dataLayer.saveAll(groups);
        //*/
        //group = null;
        groups = null;
        groups = dataLayer.loadAll(';');
        System.out.println(groups.get(0));

        ReportsBuilder reportsBuilder = new ReportsBuilder();
        String report = reportsBuilder.getAverageMarks(groups.get(0));
        System.out.println(report);

        Saver resSaver = new Saver();
        resSaver.SaveToFile(dataLayer.getFilesPath() + "report.txt", report);
    }
}
