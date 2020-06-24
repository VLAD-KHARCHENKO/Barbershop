package com.barber.repository;

import com.barber.config.ConnectionFactory;
import com.barber.config.DataSourceConnectionPool;
import com.barber.model.enums.DaoType;

import java.util.HashMap;
import java.util.Map;

public class DaoFactory {

    private static Map<DaoType, EntityDao> daoMap = new HashMap<>();
    private static final ConnectionFactory CONNECTION_FACTORY = DataSourceConnectionPool.getInstance();

    static {
        daoMap.put(DaoType.USER, new UserDao(CONNECTION_FACTORY));
        daoMap.put(DaoType.FEEDBACK, new FeedbackDao(CONNECTION_FACTORY));
        daoMap.put(DaoType.SKILLS, new SkillsDao(CONNECTION_FACTORY));
        daoMap.put(DaoType.MASTER, new MasterDao(CONNECTION_FACTORY));
        daoMap.put(DaoType.MASTERSCHEDULES, new ScheduleDao(CONNECTION_FACTORY));
        daoMap.put(DaoType.SERVICE, new ServiceDao(CONNECTION_FACTORY));

    }

    private DaoFactory() {
    }

    public static EntityDao getEntityDao(DaoType daoType) {
        EntityDao entityDao = daoMap.get(daoType);
        if (entityDao != null) {
            return entityDao;
        }
        throw new RuntimeException("Dao with current dao type do not exist: " + daoType.name());
    }

}
