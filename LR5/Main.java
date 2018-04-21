package example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import scala.Tuple2;

import java.util.StringJoiner;

public class Main extends Application
  {
      private static numberList numbers;
      private static TextField numberField;
      private static TextField maximaField;
      private static TextField minimaField;
      private static String minimum = "Минимальное число в списке:";
      private static String local_max = "Локальный максимум:";
      private static String local_min = "Локальный минимум:";
      private static String bounds = "[-100;100]";
      private static Integer maxima = 100;
      private static Integer minima = -100;
      private static Label boundsLabel;
      private static Label minimumLabel;
      private static Label local_maxLabel;
      private static Label local_minLabel;
      private static Label minimumResult;
      private static Label local_maxResult;
      private static Label local_minResult;
      private static Button addButton;
      private static Button addBounds;
      private static ListView<Integer> list;
      private static Scene scene;
      private static GridPane gridNumbers;
      private static ObservableList<Integer> items;

      @Override
      public void start(Stage primaryStage) throws Exception {
          scene = new Scene(new Group());
          numbers = new numberList();
          primaryStage.setTitle("Numbers");
          primaryStage.setWidth(300);
          primaryStage.setHeight(300);
          primaryStage.setFullScreen(false);
          primaryStage.setResizable(false);

          gridNumbers = new GridPane();
          gridNumbers.setPadding(new Insets(10, 10, 10, 10));
          gridNumbers.setVgap(5);
          gridNumbers.setHgap(5);

          numberField = new TextField();
          numberField.setPromptText("Число");
          GridPane.setConstraints(numberField, 0, 0);
          gridNumbers.getChildren().add(numberField);

          maximaField = new TextField();
          maximaField.setPromptText("Верхняя граница");
          GridPane.setConstraints(maximaField, 0, 1);
          gridNumbers.getChildren().add(maximaField);

          minimaField = new TextField();
          minimaField.setPromptText("Нижняя граница");
          GridPane.setConstraints(minimaField, 0, 2);
          gridNumbers.getChildren().add(minimaField);

          addButton = new Button("Добавить число");
          GridPane.setConstraints(addButton, 1, 0);
          gridNumbers.getChildren().add(addButton);

          boundsLabel = new Label(bounds);
          GridPane.setConstraints(boundsLabel, 1, 1);
          gridNumbers.getChildren().add(boundsLabel);


          addBounds = new Button("Изменить");
          GridPane.setConstraints(addBounds, 1, 2);
          gridNumbers.getChildren().add(addBounds);

          list = new ListView();
          items = FXCollections.observableArrayList();
          list.setItems(items);
          list.setPrefWidth(100);
          list.setPrefHeight(100);
          GridPane.setConstraints(list, 0, 3);
          gridNumbers.getChildren().add(list);

          minimumLabel = new Label(minimum);
          GridPane.setConstraints(minimumLabel, 0,4);
          gridNumbers.getChildren().add(minimumLabel);

          local_maxLabel = new Label(local_max);
          GridPane.setConstraints(local_maxLabel, 0,5);
          gridNumbers.getChildren().add(local_maxLabel);

          local_minLabel = new Label(local_min);
          GridPane.setConstraints(local_minLabel, 0,6);
          gridNumbers.getChildren().add(local_minLabel);


          minimumResult = new Label("...");
          GridPane.setConstraints(minimumResult, 1,4);
          gridNumbers.getChildren().add(minimumResult);

          local_maxResult = new Label("...");
          GridPane.setConstraints(local_maxResult, 1,5);
          gridNumbers.getChildren().add(local_maxResult);

          local_minResult = new Label("...");
          GridPane.setConstraints(local_minResult, 1,6);
          gridNumbers.getChildren().add(local_minResult);
          minimumResult.setTextFill(Color.DARKBLUE);
          local_maxResult.setTextFill(Color.DARKBLUE);
          local_minResult.setTextFill(Color.DARKBLUE);
          ((Group) scene.getRoot()).getChildren().add(gridNumbers);
          primaryStage.setScene(scene);
          primaryStage.show();
          setEvent();


      }
      public static void main(String[] args)
      {
          launch(args);

      }
      public static void setEvent() {
          addButton.addEventHandler(MouseEvent.MOUSE_PRESSED,
                  new EventHandler<MouseEvent>() {
                      @Override
                      public void handle(MouseEvent e) {
                          try {
                              Integer num = Integer.parseInt(numberField.getText());
                              items.add(num);
                              numbers.addNumber(num);
                              minimumResult.setTextFill(Color.DARKBLUE);
                              local_maxResult.setTextFill(Color.DARKBLUE);
                              local_minResult.setTextFill(Color.DARKBLUE);

                              Integer result = numbers.minTail();
                              minimumResult.setText(result.toString());
                              Tuple2<Integer, Integer> pair = numbers.extremumTail(minima,maxima);

                              if(pair._2 == java.lang.Integer.MIN_VALUE)
                              {
                                  local_maxResult.setTextFill(Color.FIREBRICK);
                                  local_maxResult.setText("Error");

                              }
                              else local_maxResult.setText(pair._2.toString());

                              if(pair._1 == java.lang.Integer.MAX_VALUE)
                              {
                                  local_minResult.setTextFill(Color.FIREBRICK);
                                  local_minResult.setText("Error");

                              }
                              else local_minResult.setText(pair._1.toString());
                          } catch (Exception exp) {
                              minimumResult.setText("Error");
                              minimumResult.setTextFill(Color.FIREBRICK);
                              local_maxResult.setTextFill(Color.FIREBRICK);
                              local_maxResult.setText("Error");
                              local_minResult.setTextFill(Color.FIREBRICK);
                              local_minResult.setText("Error");
                              minimumResult.setTextFill(Color.FIREBRICK);
                              local_maxResult.setTextFill(Color.FIREBRICK);
                              local_minResult.setTextFill(Color.FIREBRICK);
                          }
                      }
                  });
          addBounds.addEventHandler(MouseEvent.MOUSE_PRESSED,
                  new EventHandler<MouseEvent>() {
                      @Override
                      public void handle(MouseEvent e)
                      {
                          try
                          {
                           Integer maxima_temp = Integer.parseInt(maximaField.getText());
                           Integer minima_temp = Integer.parseInt(minimaField.getText());
                            if(maxima_temp < minima_temp)
                                throw  new Exception() ;
                            maxima = Integer.parseInt(maximaField.getText());
                            minima = Integer.parseInt(minimaField.getText());
                            Integer result = numbers.minNotTail();
                            minimumResult.setText(result.toString());
                            Tuple2<Integer, Integer> pair = numbers.extremumNotTail(minima_temp,maxima_temp);

                            if(pair._2 == java.lang.Integer.MIN_VALUE)
                            {
                                local_maxResult.setTextFill(Color.FIREBRICK);
                                local_maxResult.setText("Error");

                            }
                            else local_maxResult.setText(pair._2.toString());

                              if(pair._1 == java.lang.Integer.MAX_VALUE)
                              {
                                  local_minResult.setTextFill(Color.FIREBRICK);
                                  local_minResult.setText("Error");

                              }
                              else local_minResult.setText(pair._1.toString());
                            StringJoiner sj1 = new StringJoiner("");
                            String joined = sj1.add("[").add(minimaField.getText()).add(";").add(maximaField.getText()).add("]").toString();

                            boundsLabel.setText(joined);

                              minimumResult.setTextFill(Color.DARKBLUE);
                              local_maxResult.setTextFill(Color.DARKBLUE);
                              local_minResult.setTextFill(Color.DARKBLUE);

                          }
                          catch (Exception exp)
                          {

                              local_maxResult.setTextFill(Color.FIREBRICK);
                              local_maxResult.setText("Error");
                              local_minResult.setTextFill(Color.FIREBRICK);
                              local_minResult.setText("Error");
                          }
                      }
                  });
      }
  }

