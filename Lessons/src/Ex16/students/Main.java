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
        //groups.add(generator.generateGroup(0, 10, 0));
        //groups.add(generator.generateGroup(1, 10, 10));

        /*
        DataLayer dataLayer = new DataLayer();
        dataLayer.setFileTransformImpl(new CsvFileTransformImpl(';', dataLayer.getFilesPath()));

        groups = dataLayer.loadAll();//*/

        DataLayer dataLayerSerialize =createDataLayer();
        //dataLayerSerialize.saveAll(groups);
        groups = dataLayerSerialize.loadAll();

        //*
        for (Group group : groups) {
            System.out.println(group);
            System.out.println("\n==============================");
        }

        ReportsBuilder reportsBuilder = new ReportsBuilder();
        String report = reportsBuilder.getAverageMarks(groups.get(0));
        System.out.println(report);//*/

    }

    private static DataLayer createDataLayer(){
        DataLayer dataLayer = new DataLayer();
        dataLayer.setFileTransformImpl(new SerializationFileTransformImpl(dataLayer.getFilesPath()));
        return dataLayer;
    }
}
