package by.epam.traveltours.dao.externaldao;

import by.epam.traveltours.bean.Tour;
import by.epam.traveltours.dao.daotype.DAOEnum;
import by.epam.traveltours.exception.DaoNotFoundException;

import java.util.List;

public abstract class ExternalTourDAO {

    public static ExternalTourDAO getDAO(String daoType) {
        if (DAOEnum.MYSQL_DAO.getType().equals(daoType)) {
            return MySqlDAOExternal.getInstance();
        }
        if (DAOEnum.JSON_DAO.getType().equals(daoType)) {
            return JsonDAOExternal.getInstance();
        }
        if (DAOEnum.FILE_DAO.getType().equals(daoType)) {
            return FileDAOExternal.getInstance();
        }
        throw new DaoNotFoundException("Data Access Object with type -> \""+ daoType +"\" not found!");
    }

    public abstract void readTours();

    public abstract void saveTours(List<Tour> tours);
}
