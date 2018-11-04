package pl.fakturomat;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.fakturomat.dataBase.DbManager;
import pl.fakturomat.tools.FxmlTools;
import java.sql.SQLException;

public class Main extends Application {

  private static final String FXML_MAIN_PATCH = "/fxml/Main.fxml";

  @Override
  public void start(Stage primaryStage) throws SQLException {
    primaryStage.setScene(new Scene(FxmlTools.fxmlLoader(FXML_MAIN_PATCH)));
    primaryStage.setMinWidth(primaryStage.getWidth());
    primaryStage.setMinHeight(180);
    primaryStage.setTitle("Fakturomat");
    primaryStage.show();

    DbManager.initDatabase();
  }
}
