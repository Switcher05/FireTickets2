/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tickets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Switcher
 */
public class DatabaseUtility {

    private static PreparedStatement prepStatement = null;
    private static ResultSet resultSet = null;
    private static Connection connection = null;
    private static Statement statement = null;

    public DatabaseUtility() throws SQLException, ClassNotFoundException {
        connect();
    }

    public boolean isConnectionClosed() throws SQLException {
        return null == connection || connection.isClosed();
    }

    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName(Settings.getDRIVER());
        connection = DriverManager.getConnection(Settings.getJDBCURL(), Settings.getUSER(), Settings.getPASS());

    }

    public PreparedStatement getPreparedStatement(String sql) throws SQLException {
        return this.connection.prepareStatement(sql);

    }

    public Map<String, String> executeWithPreparedStatement(String query, String... values) throws SQLException {
        Map<String, String> records = new HashMap<String, String>();
        try {
            prepStatement = getPreparedStatement(query);
            int noOfParameters = values.length;
            for (int i = 0; i < noOfParameters; i++) {
                prepStatement.setString(1, values[i]);
            }
            resultSet = prepStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            while (resultSet.next()) {
                records.put(resultSetMetaData.getColumnName(1), resultSet.getString(resultSetMetaData.getColumnName(1)));
//                for (int i = 1; i < resultSetMetaData.getColumnCount(); i++) {
//                    records.put(resultSetMetaData.getColumnName(i), resultSet.getString(resultSetMetaData.getColumnName(i)));
//                }
            }
        } finally {
            releaseResources();
        }
        return records;
    }

    public void insertWithPreparedStatement(String query, String... values) throws SQLException {
        try {
            prepStatement = getPreparedStatement(query);
            int noOfParameters = values.length;
            for (int i = 0; i < noOfParameters; i++) {
                prepStatement.setString(i + 1, values[i]);
            }
            prepStatement.executeUpdate();
        } finally {
            releaseResources();
        }
    }

    private void releaseResources() throws SQLException {
        if (null != resultSet) {
            resultSet.close();
        }
        if (null != prepStatement) {
            prepStatement.close();
        }
        if (null != statement) {
            statement.close();
        }
    }

    public int executeUpdate(String query) throws SQLException {
        try {
            statement = connection.createStatement();
            return statement.executeUpdate(query);
        } finally {
            releaseResources();
        }
    }

    public boolean executeDDL(String query) throws SQLException {
        try {
            statement = connection.createStatement();
            return statement.execute(query);
        } finally {
            releaseResources();
        }
    }

    public void disconnect() throws SQLException {
        if (!isConnectionClosed()) {
            connection.close();
        }
    }

    public static void main(String args[]) {
        try {
            DatabaseUtility db = new DatabaseUtility();
            /*String query = "insert into users(id, name) values(?, ?)";
             String[] values = {"6", "Bilal Ameer"};
             db.insertIntoDatabase(query, values);
             System.out.println("Success");*/

            String query = "select user_id, name from users where level = ?";
            String[] values = {"0"};
            Map<String, String> records = db.executeWithPreparedStatement(query, values);
            System.out.println("ID\tNAME");
            for (int i = 0; i < records.size(); i++) {
                System.out.println(records.get("user_id") + "\t" + records.get("name"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
