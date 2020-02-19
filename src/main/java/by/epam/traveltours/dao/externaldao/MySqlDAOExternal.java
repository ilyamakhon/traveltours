package by.epam.traveltours.dao.externaldao;

import by.epam.traveltours.bean.Tour;
import by.epam.traveltours.propertyloader.PropertyLoader;

import java.sql.*;
import java.util.List;

public class MySqlDAOExternal extends ExternalTourDAO {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = PropertyLoader.loadProperty("db.url");
    private static final String DB_USERNAME = PropertyLoader.loadProperty("db.username");
    private static final String DB_PASSWORD = PropertyLoader.loadProperty("db.password");

    private static final MySqlDAOExternal INSTANCE = new MySqlDAOExternal();

    public static MySqlDAOExternal getInstance() {
        return INSTANCE;
    }

    @Override
    public void readTours() {

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM tours")) {

            while (rs.next()) {
                System.out.print("Tour id: " + rs.getLong("tour_id") + "|");
                System.out.print("Tour Type: " + rs.getString("tour_type") + "|");
                System.out.print("Tour Price: " + rs.getFloat("price") + "|");
                System.out.print("Transport Type: " + rs.getString("transport_type") + "|");
                System.out.print("Type Of Food: " + rs.getString("type_of_food") + "|");
                System.out.println("Amount Of Days: " + rs.getInt("amount_of_days") + "|");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveTours(List<Tour> tours) {

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             Statement st = conn.createStatement()) {

            st.executeUpdate("TRUNCATE TABLE tours");
            String insertSqlQuery = "INSERT INTO tours (tour_id, tour_type, price, transport_type, type_of_food, amount_of_days) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = conn.prepareStatement(insertSqlQuery);

            for (Tour tour : tours) {
                preparedStmt.setLong(1, tour.getTourId());
                preparedStmt.setString(2, tour.getTourType().toString());
                preparedStmt.setFloat(3, tour.getPrice());
                preparedStmt.setString(4, tour.getTransportType().toString());
                preparedStmt.setString(5, tour.getTypeOfFood().toString());
                preparedStmt.setInt(6, tour.getAmountOfDays());

                preparedStmt.execute();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
