package by.epam.traveltours.dao.daotype;

public enum DAOEnum {

    MYSQL_DAO("mysqlDAO"),
    JSON_DAO("jsonDAO"),
    FILE_DAO("fileDAO");

    private String type;

    DAOEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
