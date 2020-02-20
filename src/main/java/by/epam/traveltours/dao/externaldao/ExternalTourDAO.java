package by.epam.traveltours.dao.externaldao;

import by.epam.traveltours.bean.Tour;
import by.epam.traveltours.dao.daotype.DAOEnum;
import by.epam.traveltours.exception.DaoNotFoundException;

import java.util.List;

public abstract class ExternalTourDAO {

    public static ExternalTourDAO getDAO(String daoType) {
        if (DAOEnum.MYSQL_DAO.getIndexType().equals(daoType)) {
            return MySqlDAO.getInstance();
        }
        if (DAOEnum.JSON_DAO.getIndexType().equals(daoType)) {
            return JsonDAO.getInstance();
        }
        if (DAOEnum.FILE_DAO.getIndexType().equals(daoType)) {
            return FileDAO.getInstance();
        }
        throw new DaoNotFoundException("Data Access Object with type -> \""+ daoType +"\" not found!" + "\nPlease review application.properties file to find correct DAO types!");
    }

    public abstract void readTours();

    public abstract void saveTours(List<Tour> tours);
}
