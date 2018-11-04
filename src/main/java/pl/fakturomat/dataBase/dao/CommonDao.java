package pl.fakturomat.dataBase.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import pl.fakturomat.dataBase.DbManager;
import pl.fakturomat.dataBase.models.BaseModel;
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

  public <I> Dao<T, I> getDao() throws ApplicationException {
    try {
      return DaoManager.createDao(connectionSource, cls);
    } catch (SQLException e) {
      LOGGER.warn(e.getCause().getMessage());
      throw new ApplicationException("Błąd tworzenia DAO.");
    }finally {
      closeDbConnectionSource();
    }
  }

  public <I> void create(T baseModel) throws ApplicationException {
    try {
      Dao<T, I> dao = getDao();
      dao.create(baseModel);
    } catch (SQLException e) {
      LOGGER.warn(e.getCause().getMessage());
      throw new ApplicationException("Błąd - Nie powiodła się próba aktualizacji rejestru.");
    }finally {
      closeDbConnectionSource();
    }
  }

  public <I> void delete(T baseModel) throws ApplicationException {
    try {
      Dao<T, I> dao = getDao();
      dao.delete(baseModel);
    } catch (SQLException e) {
      LOGGER.warn(e.getCause().getMessage());
      throw new ApplicationException("Błąd - Nie powiodła sie próba usunięcia rejestru.");
    }finally {
      closeDbConnectionSource();
    }
  }

  public <I> void refresh(T baseModel) throws ApplicationException {
    try {
      Dao<T, I> dao = getDao();
      dao.refresh(baseModel);
    } catch (SQLException e) {
      LOGGER.warn(e.getCause().getMessage());
      throw new ApplicationException("Błąd - Nie powiodła sie próba odświerzania.");
    }finally {
      closeDbConnectionSource();
    }
  }

  public <I> List<T> queryForAll() throws ApplicationException {
    try {
      Dao<T, I> dao = getDao();
      return dao.queryForAll();
    } catch (SQLException e) {
      LOGGER.warn(e.getCause().getMessage());
      throw new ApplicationException("Błąd zczytywania wszystkichg danych z tabeli.");
    }finally {
      closeDbConnectionSource();
    }
  }

  public <I> void deleteById(I id) throws ApplicationException {
    try {
      Dao<T, I> dao = getDao();
      dao.deleteById(id);
    } catch (SQLException e) {
      LOGGER.warn(e.getCause().getMessage());
      throw new ApplicationException("Błąd - Nie powiodło sie usuwnanie po ID.");
    }finally {
      closeDbConnectionSource();
    }
  }

  public <I> T findById(I id) throws ApplicationException {
    try {
      Dao<T, I> dao = getDao();
      return dao.queryForId(id);
    } catch (SQLException e) {
      LOGGER.warn(e.getCause().getMessage());
      throw new ApplicationException("Błąd - szukanie rekordu.");
    }finally {
      closeDbConnectionSource();
    }
  }

  public void closeDbConnectionSource() throws ApplicationException {
    try {
      connectionSource.close();
    } catch (IOException e) {
      LOGGER.warn(e.getCause().getMessage());
      throw new ApplicationException("Błąd - Nie można zamknąć DAO");
    }
  }
}
