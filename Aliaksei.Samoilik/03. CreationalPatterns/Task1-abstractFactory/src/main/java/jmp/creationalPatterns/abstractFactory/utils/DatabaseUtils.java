package jmp.creationalpatterns.abstractfactory.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DatabaseUtils {
    private static final Log LOG = LogFactory.getLog(DatabaseUtils.class);

    private DatabaseUtils() {

    }

    public static void close(Statement s) {
        try {
            if (s != null) {
                s.close();
            }
        } catch (SQLException e) {
            LOG.error("Sql error", e);
        }
    }

    public static void close(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            LOG.error("Sql error", e);
        }
    }

    public static void close(PreparedStatement s) {
        try {
            if (s != null) {
                s.close();
            }
        } catch (SQLException e) {
            LOG.error("Sql error", e);
        }
    }

    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            LOG.error("Sql error", e);
        }
    }
}
