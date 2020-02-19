package by.epam.traveltours.dao.externaldao;

import by.epam.traveltours.bean.Tour;
import by.epam.traveltours.dao.daotype.DAOEnum;

import java.util.List;

public abstract class TourDAO {

    public static TourDAO getDAO(String daoType) {
        if (DAOEnum.MYSQL_DAO.getType().equals(daoType)) {
            return MySqlDAO.getInstance();
        }
        if (DAOEnum.JSON_DAO.getType().equals(daoType)) {
            return JsonDAO.getInstance();
        }
        if (DAOEnum.FILE_DAO.getType().equals(daoType)) {
            return FileDAO.getInstance();
        }
        return null;
    }

    public abstract void readTours();

    public abstract void saveTours(List<Tour> tours);
}
