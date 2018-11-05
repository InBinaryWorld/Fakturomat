package pl.fakturomat.tools;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class FxmlTools {
  /**
   * FXMLLoader.
   * @param patch Path.
   * @return Pane.
   */
  public static Pane fxmlLoader(String patch) {
    FXMLLoader loader = new FXMLLoader(FxmlTools.class.getResource(patch));
    try {
      return loader.load();
    } catch (Exception ee1) {
      DialogTools.errorDialog(ee1.getMessage());
    }
    return null;

  }

}