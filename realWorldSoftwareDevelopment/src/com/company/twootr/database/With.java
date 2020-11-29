package com.company.twootr.database;

import java.sql.SQLException;

interface With<P> {
    void run(P stmt) throws SQLException;
}
