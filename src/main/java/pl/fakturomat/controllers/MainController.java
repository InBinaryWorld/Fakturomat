package pl.fakturomat.controllers;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pl.fakturomat.tools.DialogTools;
import pl.fakturomat.tools.FxmlTools;

import java.util.Optional;

public class MainController {

  private static final String NEW_INVOICE_FXML = "/fxml/NewInvoice.fxml";
  @FXML
  public CheckMenuItem alwaysOnTopBtn;
  @FXML
  public ToggleGroup styleGroup;

  @FXML
  private TopMenuController topMenuController;

  @FXML
  private BorderPane mainBorderPane;

  @FXML
  private void alwaysOnTopAction() {
    final Stage stage = (Stage) mainBorderPane.getScene().getWindow();
    stage.setAlwaysOnTop(alwaysOnTopBtn.isSelected());
  }

  @FXML
  private void aboutAction() {
    DialogTools.dialogAboutApplication();
  }

  @FXML
  private void exitAction() {
    final Optional<ButtonType> result = DialogTools.confirmationDialog();
    if (result.isPresent() && result.get().getButtonData().equals(ButtonBar.ButtonData.YES)) {
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
  private void initialize() {
    topMenuController.setMainController(this);
    setCenter(NEW_INVOICE_FXML);
  }

  void setCenter(final String patch) {
    mainBorderPane.setCenter(FxmlTools.fxmlLoader(patch));
  }
}


