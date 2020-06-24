package com.barber.repository;

import com.barber.config.ConnectionFactory;
import com.barber.model.Skills;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class SkillsDao extends AbstractDao<Skills> {
    private static final Logger LOG = Logger.getLogger(SkillsDao.class);

    public SkillsDao(ConnectionFactory connectionFactory) {
        super(connectionFactory);
    }

    private static final String COLUMN_MASTER_ID = "masterId";
    private static final String COLUMN_SERVICE_ID = "serviceId";


    private static final String SELECT_ALL_SKILLS = "SELECT * FROM `skills`";

    private static final String INSERT_INTO_SKILLS = "INSERT INTO `skills` ("
            + COLUMN_MASTER_ID + ", "
            + COLUMN_SERVICE_ID + ") VALUE (?, ?)";


    private static final String UPDATE_SKILLS = "UPDATE `skills` SET "
            + COLUMN_MASTER_ID + "= ?, "
            + COLUMN_SERVICE_ID + "= ? WHERE "
            + COLUMN_ID + " = ?";

    private static final String DELETE_SKILLS = "DELETE FROM `skills` "
            + "WHERE " + COLUMN_ID + " = ?";

    private static final String GET_BY_ID = "SELECT * FROM `skills` WHERE id = ?";
    private static final String GET_BY_MASTER_ID = "SELECT * FROM `skills` WHERE masterId = ?";

    @Override
    public Skills getById(int id, boolean full) {
        return getById(GET_BY_ID, ps -> ps.setInt(1, id), getMapper());
    }

    @Override
    public Skills getByDate(LocalDateTime date, boolean full) {
        return null;
    }

    @Override
    public List<Skills> getAll(boolean full) {
        return getAll(SELECT_ALL_SKILLS, getMapper());
    }

    @Override
    public List<Skills> getAllById(int id, boolean full) {

        return getAll(GET_BY_MASTER_ID, ps -> ps.setInt(1, id), getMapper());
    }


    @Override
    public List<Skills> getAll() {
        return getAll(SELECT_ALL_SKILLS, getMapper());
    }

    @Override
    public boolean create(Skills entity) {
        LOG.info("Create feedback: + " + entity);
        return createUpdate(INSERT_INTO_SKILLS, ps -> {
            ps.setInt(2, entity.getMasterId());
            ps.setInt(3, entity.getServiceId());
        });
    }

    @Override
    public boolean update(Skills entity) {
        LOG.debug("Update feedback: " + entity);
        return createUpdate(UPDATE_SKILLS, ps -> {
            ps.setInt(2, entity.getMasterId());
            ps.setInt(3, entity.getServiceId());
            ps.setInt(4, entity.getId());
        });
    }

    @Override
    public boolean remove(Skills entity) {
        LOG.debug("Delete feedback: " + entity);
        return createUpdate(DELETE_SKILLS, ps ->
                ps.setInt(1, entity.getId()));
    }

    private EntityMapper<Skills> getMapper() {
        return resultSet -> new Skills(resultSet.getInt(COLUMN_ID),
                resultSet.getInt(COLUMN_MASTER_ID),
                resultSet.getInt(COLUMN_SERVICE_ID));
    }

    @Override
    public List<Skills> getAllPaginated(int page, int size) {
        return null;
    }


}
