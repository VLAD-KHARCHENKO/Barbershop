package com.barber.repository;

import com.barber.config.ConnectionFactory;
import com.barber.model.Feedback;
import com.barber.model.Master;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class MasterDao extends AbstractDao<Master> {
    private static final Logger LOG = Logger.getLogger(MasterDao.class);

    public MasterDao(ConnectionFactory connectionFactory) {
        super(connectionFactory);
    }



    private static final String COLUMN_USER_ID = "userId";
    private static final String COLUMN_PHOTO = "photo";

    private static final String SELECT_ALL_MASTER = "SELECT * FROM `master`";

    private static final String INSERT_INTO_MASTER = "INSERT INTO `master` ("+
             COLUMN_USER_ID+ ", "+
             COLUMN_PHOTO+") VALUE (?, ?)";


    private static final String UPDATE_MASTER = "UPDATE `master` SET "
            + COLUMN_USER_ID + "= ? WHERE "
            + COLUMN_ID + " = ?";

    private static final String DELETE_MASTER = "DELETE FROM `master` "
            + "WHERE " + COLUMN_ID + " = ?";

    private static final String GET_BY_ID = "SELECT * FROM `master` WHERE id = ?";

    @Override
    public Master getById(int id, boolean full) {
        return getById(GET_BY_ID, ps -> ps.setInt(1, id), getMapper());
    }

    @Override
    public Master getByDate(LocalDateTime date, boolean full) {
        return null;
    }

    @Override
    public List<Master> getAll(boolean full) {
        return getAll(SELECT_ALL_MASTER, getMapper());
    }

    @Override
    public List<Master> getAllById(int id, boolean full) {
        return null;
    }


    @Override
    public List<Master> getAll() {
        return getAll(SELECT_ALL_MASTER, getMapper());
    }

    @Override
    public boolean create(Master entity) {
        LOG.info("Create master: + " + entity);
        return createUpdate(INSERT_INTO_MASTER, ps -> {
            ps.setInt(1, entity.getUserId());
            ps.setString(2, entity.getPhoto());

        });
    }

  @Override
   public boolean update(Master entity) {
      LOG.debug("Update master: " + entity);
      return createUpdate(INSERT_INTO_MASTER, ps -> {
          ps.setInt(1, entity.getUserId());
          ps.setString(2, entity.getPhoto());

      });
  }



   @Override
   public boolean remove(Master entity) {
        LOG.debug("Delete feedback: " + entity);
      return createUpdate(DELETE_MASTER, ps ->
                ps.setInt(1, entity.getId()));
   }

    private EntityMapper<Master> getMapper() {
        return resultSet -> new Master(resultSet.getInt(COLUMN_ID),
                resultSet.getInt(COLUMN_USER_ID),
                resultSet.getString(COLUMN_PHOTO));
                   }

    @Override
    public List<Master> getAllPaginated(int page, int size) {
        return null;
    }





}
