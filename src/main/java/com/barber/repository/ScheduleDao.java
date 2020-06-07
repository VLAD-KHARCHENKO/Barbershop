package com.barber.repository;

import com.barber.config.ConnectionFactory;
import com.barber.model.Sсhedules;
import com.barber.model.enums.BookingStatus;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class ScheduleDao extends AbstractDao<Sсhedules> {
    private static final Logger LOG = Logger.getLogger(ScheduleDao.class);
    private Sсhedules entity;

    public ScheduleDao(ConnectionFactory connectionFactory) {
        super(connectionFactory);
    }

    private static final String COLUMN_USER_ID = "userId";
    private static final String COLUMN_DATETIME = "datetime";
    private static final String COLUMN_STATUS = "status";
    private static final String COLUMN_MASTER_ID = "masterId";
    ;


    private static final String SELECT_ALL_SCHEDULE = "SELECT * FROM `schedule`";
    private static final String SELECT_ALL_SCHEDULE_PAGINATED = "SELECT * FROM `schedule` LIMIT ?,?";

    private static final String INSERT_INTO_SCHEDULE = "INSERT INTO `schedule` ("
            + COLUMN_USER_ID + ", "
            + COLUMN_DATETIME + ", "
            + COLUMN_STATUS + ", "
            + COLUMN_MASTER_ID + ") VALUE (?, ?, ?, ?)";


    private static final String UPDATE_SCHEDULE = "UPDATE `schedule` SET "
            + COLUMN_USER_ID + "= ?, "
            + COLUMN_DATETIME + "= ?, "
            + COLUMN_STATUS + "= ?, "
            + COLUMN_MASTER_ID + "= ? WHERE "
            + COLUMN_ID + " = ?";


    private static final String DELETE_SCHEDULE = "DELETE FROM `schedule` "
            + "WHERE " + COLUMN_ID + " = ?";


    public Sсhedules getById(int id, boolean full) {
        return getById("SELECT * FROM `schedule` WHERE id = ?",
                ps -> ps.setInt(1, id),
                getMapper());
    }

    public Sсhedules getByDate(String datetime, boolean full) {
        return getByDate("SELECT * FROM `schedule` WHERE   datetime = ?",
                ps -> ps.setString(1, datetime),
                getMapper());
    }

    @Override
    public Sсhedules getByDate(LocalDateTime date, boolean full) {
        return null;
    }

    @Override
    public List<Sсhedules> getAll() {
        return getAll(SELECT_ALL_SCHEDULE, getMapper());
    }

    @Override
    public List<Sсhedules> getAllPaginated(int page, int size) {
        int limit = (page - 1) * size;
        return getAll(SELECT_ALL_SCHEDULE_PAGINATED,
                ps -> {
                    ps.setInt(1, limit);
                    ps.setInt(2, size);
                },
                getMapper());
    }


    private EntityMapper<Sсhedules> getMapper() {
        return resultSet -> new Sсhedules(resultSet.getInt(COLUMN_ID),
                resultSet.getInt(COLUMN_USER_ID),
                resultSet.getTimestamp(COLUMN_DATETIME).toLocalDateTime(),
                BookingStatus.valueOf(resultSet.getString(COLUMN_STATUS)),
                 resultSet.getInt(COLUMN_MASTER_ID));


    }



    @Override
    public boolean create(Sсhedules entity) {
        LOG.debug("Create user: + " + entity);
        return createUpdate(INSERT_INTO_SCHEDULE, ps -> {
            ps.setInt(1, entity.getUserId());
            ps.setTimestamp(2, Timestamp.valueOf(entity.getStartAt()));
            ps.setString(3,BookingStatus.BOOKED.toString());
            ps.setInt(4, entity.getMasterId());

                   });
    }

    @Override
    public boolean update(Sсhedules entity) {
        LOG.debug("Update user: " + entity);
        return createUpdate(UPDATE_SCHEDULE, ps -> {
            ps.setInt(1, entity.getUserId());
            ps.setTimestamp(2, Timestamp.valueOf(entity.getStartAt()));
            ps.setString(3,BookingStatus.BOOKED.toString());
            ps.setInt(4, entity.getMasterId());
            ps.setInt(5, entity.getId());
        });
    }

    @Override
    public boolean remove(Sсhedules entity) {
              LOG.debug("Delete user: " + entity);
        return createUpdate(DELETE_SCHEDULE, ps -> ps.setInt(1, entity.getId()));
    }

    @Override
    public List<Sсhedules> getAllById(int id, boolean full) {
        return null;
    }

}
