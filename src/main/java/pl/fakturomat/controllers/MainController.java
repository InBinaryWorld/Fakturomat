package pl.fakturomat.controllers;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pl.fakturomat.tools.DialogTools;
import pl.fakturomat.tools.FxmlTools;
import java.util.Optional;

public class MainController {

  private static final String NEW_INVOICE_FXML = "/fxml/NewInvoice.fxml";

  @FXML
  private TopMenuController topMenuController;

  @FXML
  private BorderPane mainBorderPane;

  @FXML
  private void AlwaysOnTopAction(ActionEvent event) {
    Stage stage =(Stage) mainBorderPane.getScene().getWindow();
    stage.setAlwaysOnTop(((CheckMenuItem)event.getSource()).isSelected());
  }

  @FXML
  private void aboutAction() {
    DialogTools.dialogAboutApplication();
  }

  @FXML
  private void exitAction() {
    Optional<ButtonType> result = DialogTools.confirmationDialog();
    if(result.get().getButtonData().equals(ButtonBar.ButtonData.YES)){
      System.exit(0);
    }
  }

  @FXML
  private void setCaspian() {
    Application.setUserAgentStylesheet(Application.STYLESHEET_CASPIAN);
  }

  @FXML
  private void setModena() {
    Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
  }

  @FXML
  private void initialize(){
    topMenuController.setMainController(this);
    setCenter(NEW_INVOICE_FXML);
  }

  public void setCenter(String patch){
    mainBorderPane.setCenter(FxmlTools.fxmlLoader(patch));
  }
}


