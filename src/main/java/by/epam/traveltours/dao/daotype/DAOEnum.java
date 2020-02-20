package by.epam.traveltours.dao.daotype;

public enum DAOEnum {

    MYSQL_DAO("1"),
    JSON_DAO("2"),
    FILE_DAO("3");

    private String indexType;

    DAOEnum(String indexType) {
        this.indexType = indexType;
    }

    public String getIndexType() {
        return indexType;
    }
}
