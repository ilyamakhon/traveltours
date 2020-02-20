package by.epam.traveltours.dao.externaldao;

import by.epam.traveltours.bean.Tour;
import by.epam.traveltours.propertyloader.PropertyLoader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class FileDAO extends ExternalTourDAO {

    private static final String FILE_PATH = PropertyLoader.loadProperty("file.tours.path");
    private static final FileDAO INSTANCE = new FileDAO();

    public static FileDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public void readTours() {
        try (FileReader reader = new FileReader(FILE_PATH);
             Scanner scan = new Scanner(reader)) {
            while (scan.hasNext()) {
                System.out.println(scan.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveTours(List<Tour> tours) {
        try  {
            File file = new File(FILE_PATH);
            createFolder(file);
            FileWriter writer = new FileWriter(file);
            for (Tour tour : tours) {
                writer.write(tour.toString() + "\n");
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createFolder(File file) {
        if (file.getParentFile().mkdirs()) {
            System.out.println("Folder " + file.getParentFile() + " created");
        } else {
            System.out.println("Folder " + file.getParentFile() + " already exists");
        }
    }
}

