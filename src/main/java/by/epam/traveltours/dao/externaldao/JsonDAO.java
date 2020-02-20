package by.epam.traveltours.dao.externaldao;

import by.epam.traveltours.bean.Tour;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class JsonDAO extends ExternalTourDAO {

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
        File file = new File(FILE_PATH);
        file.getParentFile().mkdirs();
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(file, tours);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
