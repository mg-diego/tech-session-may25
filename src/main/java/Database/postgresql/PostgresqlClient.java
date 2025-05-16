package Database.postgresql;

import utils.ConfigurationReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PostgresqlClient {
    private static Connection postgresqlConnection;

    public static void openConnection() {
        openPostgresqlConnection();
    }

    public static void closeConnection() {
        closePostgresqlConnection();
    }

    private static void openPostgresqlConnection() {
        try {
            postgresqlConnection = DriverManager.getConnection(
                    ConfigurationReader.getPostgresqlConnectionString() + ConfigurationReader.getPostgresqlDatabaseName(),
                    ConfigurationReader.getPostgresqlUser(),
                    ConfigurationReader.getPostgresqlPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void closePostgresqlConnection() {
        try {
            postgresqlConnection.close();
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    protected static void executeQuery(String query) {
        try {
            Statement stmt = postgresqlConnection.createStatement();
            stmt.execute(query);
        } catch (Exception e) {
            openPostgresqlConnection();
            throw new Error(e.getMessage());
        }
    }

    protected static int executeUpdate(String query) {
        final int[] modifiedRows = {-1};
        try {
            Statement stmt = postgresqlConnection.createStatement();
            modifiedRows[0] = stmt.executeUpdate(query);
        } catch (Exception e) {
            openPostgresqlConnection();
            throw new Error(e.getMessage());
        }

        return modifiedRows[0];
    }

    protected static ResultSet executeQueryAndReturnResults(String query) {
        final ResultSet[] rs = { null };
        try {
            PreparedStatement preparedStatement = postgresqlConnection.prepareStatement(query);
            rs[0] = preparedStatement.executeQuery();
            rs[0].next();

        } catch (Exception e) {
            openPostgresqlConnection();
            throw new Error(e.getMessage());
        }
        return rs[0];
    }

    protected static ArrayList<String> getAllResultsFromResultSet(ResultSet rs, String columnName) throws SQLException {
        var resultList = new ArrayList<String>();

        if (rs.getRow() > 0) {
            resultList.add(rs.getObject(columnName).toString());
            while (rs.next()) {
                resultList.add(rs.getObject(columnName).toString());
                rs.next();
            }
        }
        return resultList;
    }
}