package pl.fakturomat.dataBase;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import pl.fakturomat.dataBase.models.*;
import pl.fakturomat.tools.DialogTools;

import java.io.IOException;
import java.sql.SQLException;

public class DbManager {
  private static final String URL ="jdbc:h2:./dbLibrary";
  private static final String USER = "admin";
  private static final String PASSWORD = "admin";
  public static ConnectionSource connectionSource;

  public static void initDatabase(){
    createConnectionSource();
    dropTables();
    createIfNotExistTables();
    closeConnectionSource();
    //FillDatabase.fillDatabase();
  }

  public static ConnectionSource getConnectionSource(){
    if(connectionSource == null) {
      createConnectionSource();
    }
    return connectionSource;
  }

  public static void closeConnectionSource(){
    if(connectionSource != null) {
      try {
        connectionSource.close();
      } catch (IOException e) {
        DialogTools.errorDialog(e.getMessage());
      }
    }
  }
  private static void createIfNotExistTables(){
    try {
      TableUtils.createTableIfNotExists(connectionSource, Client.class);
      TableUtils.createTableIfNotExists(connectionSource, Invoice.class);
      TableUtils.createTableIfNotExists(connectionSource, Order.class);
      TableUtils.createTableIfNotExists(connectionSource, Product.class);
      TableUtils.createTableIfNotExists(connectionSource, Seller.class);
    } catch (SQLException e) {
      DialogTools.errorDialog(e.getMessage());
    }
  }

  private static void dropTables(){
    try {
      TableUtils.dropTable(connectionSource,Client.class,true);
      TableUtils.dropTable(connectionSource,Invoice.class,true);
      TableUtils.dropTable(connectionSource,Order.class,true);
      TableUtils.dropTable(connectionSource,Product.class,true);
      TableUtils.dropTable(connectionSource,Seller.class,true);
    } catch (SQLException e) {
      DialogTools.errorDialog(e.getMessage());
    }

  }
  private static void createConnectionSource(){
    try {
      connectionSource = new JdbcConnectionSource(URL,USER,PASSWORD);
    } catch (SQLException e) {
      DialogTools.errorDialog(e.getMessage());
    }
  }

}
