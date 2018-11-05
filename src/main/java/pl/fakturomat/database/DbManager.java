package pl.fakturomat.database;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import pl.fakturomat.database.models.Client;
import pl.fakturomat.database.models.Invoice;
import pl.fakturomat.database.models.Order;
import pl.fakturomat.database.models.Product;
import pl.fakturomat.database.models.Seller;
import pl.fakturomat.tools.DialogTools;
import pl.fakturomat.tools.FillDatabase;

import java.io.IOException;
import java.sql.SQLException;

public class DbManager {
  private static final String URL = "jdbc:h2:./dbLibrary";
  private static final String USER = "admin";
  private static final String PASSWORD = "admin";
  private static ConnectionSource connectionSource;

  /**
   * Init.
   */
  public static void initDatabase() {
    createConnectionSource();
    dropTables();
    createIfNotExistTables();
    closeConnectionSource();
    FillDatabase.fillDatabase();
  }

  /**
   * Connect.
   * @return Connection source.
   */
  public static ConnectionSource getConnectionSource() {
    if (connectionSource == null) {
      createConnectionSource();
    }
    return connectionSource;
  }

  /**
   * Close connection.
   */
  public static void closeConnectionSource() {
    if (connectionSource != null) {
      try {
        connectionSource.close();
      } catch (IOException ee1) {
        DialogTools.errorDialog(ee1.getMessage());
      }
    }
  }

  private static void createIfNotExistTables() {
    try {
      TableUtils.createTableIfNotExists(connectionSource, Client.class);
      TableUtils.createTableIfNotExists(connectionSource, Invoice.class);
      TableUtils.createTableIfNotExists(connectionSource, Order.class);
      TableUtils.createTableIfNotExists(connectionSource, Product.class);
      TableUtils.createTableIfNotExists(connectionSource, Seller.class);
    } catch (SQLException ee1) {
      DialogTools.errorDialog(ee1.getMessage());
    }
  }

  private static void dropTables() {
    try {
      TableUtils.dropTable(connectionSource, Client.class, true);
      TableUtils.dropTable(connectionSource, Invoice.class, true);
      TableUtils.dropTable(connectionSource, Order.class, true);
      TableUtils.dropTable(connectionSource, Product.class, true);
      TableUtils.dropTable(connectionSource, Seller.class, true);
    } catch (SQLException ee1) {
      DialogTools.errorDialog(ee1.getMessage());
    }

  }

  private static void createConnectionSource() {
    try {
      connectionSource = new JdbcConnectionSource(URL, USER, PASSWORD);
    } catch (SQLException ee1) {
      DialogTools.errorDialog(ee1.getMessage());
    }
  }

}
