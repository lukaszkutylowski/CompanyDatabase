package lukaszkutylowski.database;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DbQueryExecutor {

    public static ResultSet executeSelect(String selectQuery) {
        try {
            Connection connection = DbConnector.connect();
            Statement statement = connection.createStatement();
            return statement.executeQuery(selectQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void executeQuery(String query) {
        try {
            Connection connection = DbConnector.connect();
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException((e.getMessage()));
        }
    }

    public static void executeQueryInOneTransaction(List<String> queries) {
        try {
            Connection connection = DbConnector.connect();
            connection.setAutoCommit(false);
            queries.forEach(query -> executeQuery(query));
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
