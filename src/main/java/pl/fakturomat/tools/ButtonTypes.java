package pl.fakturomat.tools;


import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

abstract class ButtonTypes {
  static final ButtonType YES = new ButtonType("Tak", ButtonBar.ButtonData.YES);
  static final ButtonType NO = new ButtonType("Nie", ButtonBar.ButtonData.NO);
}