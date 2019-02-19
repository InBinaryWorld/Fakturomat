package pl.fakturomat;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.fakturomat.database.DbManager;
import pl.fakturomat.tools.FillDatabase;
import pl.fakturomat.tools.FxmlTools;
import java.util.Objects;

public class Main extends Application {

  private static final String FXML_MAIN_PATCH = "/fxml/Main.fxml";

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setScene(new Scene(Objects.requireNonNull(FxmlTools.fxmlLoader(FXML_MAIN_PATCH))));
    primaryStage.setMinWidth(primaryStage.getWidth());
    primaryStage.setMinHeight(180);
    primaryStage.setTitle("Fakturomat");
    primaryStage.setResizable(false);
    primaryStage.show();

    DbManager.initDatabase();
    FillDatabase.fillDatabase();
  }
}
