package com.barber.config;

import java.sql.Connection;

public interface ConnectionFactory {

    Connection getConnection();
}
