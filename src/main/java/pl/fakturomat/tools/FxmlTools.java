package pl.fakturomat.tools;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class FxmlTools {
  public static Pane fxmlLoader(String patch){
    FXMLLoader loader = new FXMLLoader(FxmlTools.class.getResource(patch));
    try {
      return loader.load();
    } catch (Exception e) {
      e.printStackTrace();
      DialogTools.errorDialog(e.getMessage());
    }
    return null;

  }

}