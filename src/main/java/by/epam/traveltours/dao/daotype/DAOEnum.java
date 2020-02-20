package by.epam.traveltours.dao.daotype;

public enum DAOEnum {

    MYSQL_DAO("mysqlDAO", "1"),
    JSON_DAO("jsonDAO", "2"),
    FILE_DAO("fileDAO", "3");

    private String type;
    private String indexType;

    DAOEnum(String type, String indexType) {
        this.type = type;
        this.indexType = indexType;
    }

    public String getType() {
        return type;
    }

    public String getIndexType() {
        return indexType;
    }
}
