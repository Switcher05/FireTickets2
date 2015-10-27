/*
 * The MIT License
 *
 * Copyright 2015 Ryan.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package main.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ryan
 */
public class DBUtil {
    private PreparedStatement prepStatement = null;
    private ResultSet resultSet = null;
    private Connection connection = null;
    private Statement statement=null;
public DBUtil() throws SQLException, ClassNotFoundException {
        connect();
    }

    public boolean isConnectionClosed() throws SQLException {
        return null==connection || connection.isClosed();
    }

    public void connect() throws ClassNotFoundException, SQLException {
            Class.forName(Settings.getDbdriver());
            connection = DriverManager.getConnection(Settings.getUrl(), Settings.getUser(), Settings.getPass());
    }


    public Map<String,String> executeWithPreparedStatement(String query, String ...values) throws SQLException {
        Map<String,String> records = new HashMap<String,String>();
        boolean flag = false;
        try {
            prepStatement = connection.prepareStatement(query);
            int noOfParameters = values.length;
            for(int i=0;i<noOfParameters;i++) {
                prepStatement.setString(1, values[i]);
            }
            resultSet = prepStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            while(resultSet.next()){
                    for(int i=1;i<=resultSetMetaData.getColumnCount();i++){
                        records.put(resultSetMetaData.getColumnName(i),resultSet.getString(resultSetMetaData.getColumnName(i)));
                    }
            }

        }  finally {
            releaseResources();
        }
        return records;
    }

    private void releaseResources() throws SQLException {
        if(null!=resultSet){
            resultSet.close();
        }
        if(null!=prepStatement){
            prepStatement.close();
        }
        if(null!=statement){
            statement.close();
        }
    }

    public int executeUpdate(String query) throws SQLException {
            try {
                statement = connection.createStatement();
                return statement.executeUpdate(query);
            }finally {
                releaseResources();
            }
    }

    public boolean executeDDL(String query) throws SQLException {
        try {
             statement = connection.createStatement();
            return statement.execute(query);
        }finally {
            releaseResources();
        }
    }

    public void disconnect() throws SQLException {
            if (connection != null && !connection.isClosed() ) {
                connection.close();
            }
    }

}
