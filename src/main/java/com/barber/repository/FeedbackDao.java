package com.barber.repository;

import com.barber.config.ConnectionFactory;
import com.barber.model.Feedback;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class FeedbackDao extends AbstractDao<Feedback> {
    private static final Logger LOG = Logger.getLogger(FeedbackDao.class);

    public FeedbackDao(ConnectionFactory connectionFactory) {
        super(connectionFactory);
    }

    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_FEEDBACK = "feedback";
    private static final String COLUMN_USER_ID = "userId";


    private static final String SELECT_ALL_FEEDBACK = "SELECT * FROM `feedback`";

    private static final String INSERT_INTO_FEEDBACK = "INSERT INTO `feedback` ("
            + COLUMN_DATE + ", "
            + COLUMN_FEEDBACK + ", "
            + COLUMN_USER_ID + ") VALUE (?, ?, ?)";

    private static final String UPDATE_FEEDBACK = "UPDATE `feedback` SET "
            + COLUMN_DATE + "= ?, "
            + COLUMN_FEEDBACK + "= ?, "
            + COLUMN_USER_ID + "= ? WHERE "
            + COLUMN_ID + " = ?";

    private static final String DELETE_FEEDBACK = "DELETE FROM `feedback` "
            + "WHERE " + COLUMN_ID + " = ?";

    private static final String GET_BY_ID = "SELECT * FROM `feedback` WHERE id = ?";

    @Override
    public Feedback getById(int id, boolean full) {
        return getById(GET_BY_ID, ps -> ps.setInt(1, id), getMapper());
    }

    @Override
    public Feedback getByDate(LocalDateTime date, boolean full) {
        return null;
    }

    @Override
    public List<Feedback> getAll(boolean full) {
        return getAll(SELECT_ALL_FEEDBACK, getMapper());
    }

    @Override
    public List<Feedback> getAllById(int id, boolean full) {
        return null;
    }


    @Override
    public List<Feedback> getAll() {
        return getAll(SELECT_ALL_FEEDBACK, getMapper());
    }

    @Override
    public boolean create(Feedback entity) {
        LOG.info("Create feedback: + " + entity);
        return createUpdate(INSERT_INTO_FEEDBACK, ps -> {
            ps.setTimestamp(1, Timestamp.valueOf(entity.getDate()));
            ps.setString(2, entity.getFeedback());
            ps.setInt(3, entity.getUserId());
        });
    }

    @Override
    public boolean update(Feedback entity) {
        LOG.debug("Update feedback: " + entity);
        return createUpdate(UPDATE_FEEDBACK, ps -> {
            ps.setTimestamp(1, Timestamp.valueOf(entity.getDate()));
            ps.setString(2, entity.getFeedback());
            ps.setInt(3, entity.getUserId());
            ps.setInt(4, entity.getId());
        });
    }

    @Override
    public boolean remove(Feedback entity) {
        LOG.debug("Delete feedback: " + entity);
        return createUpdate(DELETE_FEEDBACK, ps ->
                ps.setInt(1, entity.getId()));
    }

    private EntityMapper<Feedback> getMapper() {
        return resultSet -> new Feedback(resultSet.getInt(COLUMN_ID),
                resultSet.getTimestamp(COLUMN_DATE).toLocalDateTime(),
                resultSet.getString(COLUMN_FEEDBACK),
                resultSet.getInt(COLUMN_USER_ID));
    }

    @Override
    public List<Feedback> getAllPaginated(int page, int size) {
        return null;
    }

}
