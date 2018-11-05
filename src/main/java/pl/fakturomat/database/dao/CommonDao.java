package pl.fakturomat.database.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import pl.fakturomat.database.DbManager;
import pl.fakturomat.database.models.BaseModel;
import pl.fakturomat.tools.ApplicationException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public abstract class CommonDao<T extends BaseModel> {
  private static final Logger LOGGER = LoggerFactory.getLogger(CommonDao.class);
  private final ConnectionSource connectionSource;
  private final Class<T> cls;

  CommonDao(Class<T> cls) {
    this.connectionSource = DbManager.getConnectionSource();
    this.cls = cls;
  }

  /**
   * Get dao.
   * @param <I> Class extends base model.
   * @return Dao object.
   * @throws ApplicationException Error creating Dao.
   */
  public <I> Dao<T, I> getDao() throws ApplicationException {
    try {
      return DaoManager.createDao(connectionSource, cls);
    } catch (SQLException ee1) {
      LOGGER.warn(ee1.getCause().getMessage());
      throw new ApplicationException("Błąd tworzenia DAO.");
    } finally {
      closeDbConnectionSource();
    }
  }

  /**
   *
   * @param baseModel Create.
   * @param <I> Extends base model
   * @throws ApplicationException Error create.
   */
  public <I> void create(T baseModel) throws ApplicationException {
    try {
      Dao<T, I> dao = getDao();
      dao.create(baseModel);
    } catch (SQLException ee1) {
      LOGGER.warn(ee1.getCause().getMessage());
      throw new ApplicationException("Błąd - Nie powiodła się próba aktualizacji rejestru.");
    } finally {
      closeDbConnectionSource();
    }
  }

  /**
   * Query for all.
   * @param <I> Extends base model.
   * @return Queried objects.
   * @throws ApplicationException Query error.
   */
  public <I> List<T> queryForAll() throws ApplicationException {
    try {
      Dao<T, I> dao = getDao();
      return dao.queryForAll();
    } catch (SQLException ee1) {
      LOGGER.warn(ee1.getCause().getMessage());
      throw new ApplicationException("Błąd zczytywania wszystkichg danych z tabeli.");
    } finally {
      closeDbConnectionSource();
    }
  }

  /**
   * Find by id.
   * @param id object id.
   * @param <I> Extends base model.
   * @throws ApplicationException Delete error.
   */
  public <I> void deleteById(I id) throws ApplicationException {
    try {
      Dao<T, I> dao = getDao();
      dao.deleteById(id);
    } catch (SQLException ee1) {
      LOGGER.warn(ee1.getCause().getMessage());
      throw new ApplicationException("Błąd - Nie powiodło sie usuwnanie po ID.");
    } finally {
      closeDbConnectionSource();
    }
  }


  private void closeDbConnectionSource() throws ApplicationException {
    try {
      connectionSource.close();
    } catch (IOException ee1) {
      LOGGER.warn(ee1.getCause().getMessage());
      throw new ApplicationException("Błąd - Nie można zamknąć DAO");
    }
  }
}
