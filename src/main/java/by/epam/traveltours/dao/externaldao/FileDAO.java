package by.epam.traveltours.dao.externaldao;

import by.epam.traveltours.bean.Tour;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class FileDAO extends TourDAO {

    private static final String FILE_PATH = "src/main/resources/textfiles/tours.txt";
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
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            for (Tour tour : tours) {
                writer.write(tour.toString() + "\n");
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

