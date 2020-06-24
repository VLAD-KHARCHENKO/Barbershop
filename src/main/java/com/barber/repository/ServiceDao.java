package com.barber.repository;

import com.barber.config.ConnectionFactory;
import com.barber.model.Feedback;
import com.barber.model.Service;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class ServiceDao extends AbstractDao<Service> {
    private static final Logger LOG = Logger.getLogger(ServiceDao.class);

    public ServiceDao(ConnectionFactory connectionFactory) {
        super(connectionFactory);
    }

    private static final String COLUMN_SERVICE_NAME = "serviceName";
    private static final String COLUMN_PRICE = "price";



    private static final String SELECT_ALL_SERVICE = "SELECT * FROM `service`";

    private static final String INSERT_INTO_SERVICE = "INSERT INTO `service` ("
            + COLUMN_SERVICE_NAME + ", "
            + COLUMN_SERVICE_NAME + ") VALUE (?, ?)";

    private static final String UPDATE_SERVICE = "UPDATE `service` SET "
            + COLUMN_SERVICE_NAME + "= ?, "
            + COLUMN_PRICE + "= ? WHERE "
            + COLUMN_ID + " = ?";

    private static final String DELETE_SERVICE = "DELETE FROM `service` "
            + "WHERE " + COLUMN_ID + " = ?";

    private static final String GET_BY_ID = "SELECT * FROM `service` WHERE id = ?";

    @Override
    public Service getById(int id, boolean full) {
        return getById(GET_BY_ID, ps -> ps.setInt(1, id), getMapper());
    }

    @Override
    public Service getByDate(LocalDateTime date, boolean full) {
        return null;
    }

    @Override
    public List<Service> getAll(boolean full) {
        return getAll(SELECT_ALL_SERVICE, getMapper());
    }

    @Override
    public List<Service> getAllById(int id, boolean full) {
        return null;
    }


    @Override
    public List<Service> getAll() {
        return getAll(SELECT_ALL_SERVICE, getMapper());
    }

    @Override
    public boolean create(Service entity) {
        LOG.info("Create service: + " + entity);
        return createUpdate(INSERT_INTO_SERVICE, ps -> {
            ps.setString(2, entity.getServiceName());
            ps.setDouble(2, entity.getPrice());
                 });
    }



    @Override
    public boolean update(Service entity) {
        LOG.debug("Update service: " + entity);
        return createUpdate(UPDATE_SERVICE, ps -> {
            ps.setString(2, entity.getServiceName());
            ps.setDouble(2, entity.getPrice());
            ps.setInt(4, entity.getId());
        });
    }

    @Override
    public boolean remove(Service entity) {
        LOG.debug("Delete service: " + entity);
        return createUpdate(DELETE_SERVICE, ps ->
                ps.setInt(1, entity.getId()));
    }

    private EntityMapper<Service> getMapper() {
        return resultSet -> new Service(resultSet.getInt(COLUMN_ID),
                resultSet.getString(COLUMN_SERVICE_NAME),
                resultSet.getDouble(COLUMN_PRICE));
    }

    @Override
    public List<Service> getAllPaginated(int page, int size) {
        return null;
    }

}
