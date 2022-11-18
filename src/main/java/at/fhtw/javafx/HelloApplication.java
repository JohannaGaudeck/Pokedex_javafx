package at.fhtw.javafx;

import at.fhtw.javafx.model.Pokemon;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        boolean screenbuilder = true;

        if (screenbuilder) {

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 320, 240);
            stage.setTitle("Pokedex");
            stage.setScene(scene);
            stage.show();

        } else {
            VBox outerVBox = new VBox();
            BorderPane boderPane = new BorderPane();
            VBox innerVBox = new VBox();
            TextArea txtLog = new TextArea();
            ListView<String> lvbag = new ListView<>();
            TextField txtName = new TextField();
            txtName.setPromptText("Name");
            TextField txtLevel = new TextField();
            txtLevel.setPromptText("Level");

            //zwei weitere Eingabefelder (int hp (health points) und int exp (experience points)) für die
            //Klasse Pokemon. Beachten Sie das korrekte Exception Handling beim Parsen der Daten.

            TextField txtEXP = new TextField();
            txtEXP.setPromptText("exp");
            TextField txtHp = new TextField();
            txtHp.setPromptText("hp");

            Button btnAdd = new Button("Add");
            Button btnRemove = new Button("Remove");
            //einem "Clear Pokedex" Button, der die Liste leert.
            Button btnClear = new Button("Clear");

            ObservableList<String> bag = FXCollections.observableArrayList();

            outerVBox.getChildren().addAll(txtLog, boderPane);
            boderPane.setLeft(innerVBox);
            boderPane.setCenter(lvbag);
            innerVBox.getChildren().addAll(txtName, txtLevel, txtHp, txtEXP, btnAdd, btnRemove, btnClear);

            btnAdd.setPrefWidth(200);
            btnRemove.setPrefWidth(200);
            btnClear.setPrefWidth(200);
            outerVBox.setSpacing(10);
            outerVBox.setPadding(new Insets(10));
            innerVBox.setSpacing(10);
            innerVBox.setPadding(new Insets(0, 10, 0, 0));

            lvbag.setItems(bag);

            btnAdd.setOnAction(e -> {
                String name = txtName.getText();
                int level = Integer.parseInt(txtLevel.getText());
                int hp = Integer.parseInt(txtHp.getText());
                int exp = Integer.parseInt(txtEXP.getText());
                Pokemon newPokemon = new Pokemon(name, level, hp, exp);
                bag.add(newPokemon.toString());

            });

            btnRemove.setOnAction(e -> {
                String item = lvbag.getSelectionModel().getSelectedItem();
                bag.remove(item);
                txtLog.appendText(item + "removed \n");


            });

            btnClear.setOnAction(event -> {
                bag.clear();
                txtLog.appendText("The Podex has been cleared \n");

            });

            Scene scene = new Scene(outerVBox, 500, 500);

            stage.setTitle("Game");
            stage.setScene(scene);


            stage.show();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
