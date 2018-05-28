package example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import scala.collection.immutable.List;

public class Main extends Application
  {
      private static wordList words;
      private static TextField enterWord;
      private static Button addButton;
      private static Button reverseButton;
      private static Button stringButton;
      private static Button dublicateButton;
      private static ListView<String> list;
      private static Scene scene;
      private static GridPane gridNumbers;
      private static ObservableList<String> items;
      @Override
      public void start(Stage primaryStage) throws Exception {
          scene = new Scene(new Group());
          words = new wordList();
        //  primaryStage.setTitle("Numbers");
          primaryStage.setWidth(175);
          primaryStage.setHeight(265);
          primaryStage.setFullScreen(false);
          primaryStage.setResizable(false);

          gridNumbers = new GridPane();
          gridNumbers.setPadding(new Insets(10, 10, 10, 10));
          gridNumbers.setVgap(5);
          gridNumbers.setHgap(5);

          enterWord = new TextField();
          enterWord.setPromptText("Число");
          GridPane.setConstraints(enterWord, 0, 0);
          gridNumbers.getChildren().add(enterWord);


          addButton = new Button("Добавить число");
          GridPane.setConstraints(addButton, 0, 2);
          gridNumbers.getChildren().add(addButton);

          dublicateButton = new Button("Изменить");
          GridPane.setConstraints(dublicateButton, 0, 3);
          gridNumbers.getChildren().add(dublicateButton);

          stringButton = new Button("Получить строку");
          GridPane.setConstraints(stringButton, 0, 4);
          gridNumbers.getChildren().add(stringButton);

          list = new ListView();
          items = FXCollections.observableArrayList();
          list.setItems(items);
          list.setPrefWidth(100);
          list.setPrefHeight(100);
          GridPane.setConstraints(list, 0, 1);
          gridNumbers.getChildren().add(list);

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

                          if(enterWord.getText().matches("-?\\d+(\\.\\d+)?"))
                          {
                                  items.clear();
                                  words.addWord(Integer.parseInt(enterWord.getText()));
                                  List<Integer> temp = words.getWord();
                                  temp.foreach(x -> items.add(x.toString()));
                                  list.setItems(items);
                           }
                      }
                      });
          dublicateButton.addEventHandler(MouseEvent.MOUSE_PRESSED,
                  new EventHandler<MouseEvent>() {
                      @Override
                      public void handle(MouseEvent e)
                      {
                          items.clear();
                          words.oddEven();
                          List<Integer> temp = words.getWord();
                          temp.foreach(x -> items.add(x.toString()));
                          list.setItems(items);
                      }
                      });

          stringButton.addEventHandler(MouseEvent.MOUSE_PRESSED,
                  new EventHandler<MouseEvent>() {
                      @Override
                      public void handle(MouseEvent e)
                      {
                          String res = words.getString(words);
                          if(!res.isEmpty())
                          {
                              System.out.println(res);
                             /* Alert alert = new Alert(Alert.AlertType.INFORMATION);
                              alert.setTitle("Result:");
                              alert.setHeaderText("Only words with upper case:");
                              alert.setContentText(res);
                              alert.showAndWait();*/
                          }
                      }
                  });

      }
  }

