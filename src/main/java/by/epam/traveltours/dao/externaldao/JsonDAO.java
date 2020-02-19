package by.epam.traveltours.dao.externaldao;

import by.epam.traveltours.bean.Tour;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class JsonDAO extends TourDAO {

    private static final String FILE_PATH = "src/main/resources/textfiles/tours.json";
    private static final JsonDAO INSTANCE = new JsonDAO();

    public static JsonDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public void readTours() {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream fileStream = new FileInputStream(FILE_PATH)) {
            Arrays.asList(mapper.readValue(fileStream, Tour[].class)).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveTours(List<Tour> tours) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(FILE_PATH), tours);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
