package pl.fakturomat.tools;


import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

public abstract class ButtonTypes {
  public static final ButtonType YES = new ButtonType("Tak", ButtonBar.ButtonData.YES);
  public static final ButtonType NO = new ButtonType("Nie", ButtonBar.ButtonData.NO);
  public static final ButtonType CANCEL = new ButtonType("Anuluj", ButtonBar.ButtonData.CANCEL_CLOSE);
  public static final ButtonType OK = ButtonType.OK;

}