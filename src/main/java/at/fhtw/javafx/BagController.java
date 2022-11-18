package at.fhtw.javafx;

import at.fhtw.javafx.model.Pokemon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class BagController {

    private List<Pokemon> bag = new ArrayList<>();
    @FXML
    private Button btn_caught;

    @FXML
    private Label lbl_level;

    @FXML
    private Label lbl_name;

    @FXML
    private Label lbl_bag;

    @FXML
    private TextArea ta_bag;

    @FXML
    private TextField tf_level;

    @FXML
    private TextField tf_name;

    @FXML
    private TextField tf_hp;

    @FXML
    private TextField tf_exp;

    @FXML
    private Button btn_Remove;

    @FXML
    private Button btn_Clear;

    @FXML
    void onCaught(ActionEvent event) {
        int level;
        try {
            level = Integer.parseInt(tf_level.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Level not filled out correctly", ButtonType.OK);
            alert.show();
            return;
        }
        String name = tf_name.getText();

       // zwei weitere Eingabefelder (int hp (health points) und int exp (experience points)) für die
        //Klasse Pokemon. Beachten Sie das korrekte Exception Handling beim Parsen der Daten.

        int hp;
        int exp;

        try {
            hp = Integer.parseInt(tf_hp.getText());
        }catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "hp not filled out correctly", ButtonType.OK);
            alert.show();
            return;
        }

        try {
            exp = Integer.parseInt(tf_exp.getText());
        }catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "exp not filled out correctly", ButtonType.OK);
            alert.show();
            return;
        }

        Pokemon pokemon = new Pokemon(name, level,hp, exp);
        bag.add(pokemon);

        ta_bag.clear();
        bag.forEach(p -> ta_bag.appendText(p.toString() + "\n"));
    }

        @FXML
        void onRemove(ActionEvent event) {
            bag.removeIf(i -> i.getName().equals(tf_name.getText()));

            /*das selbe wie das
            *  for(Pokemon i : bag){
                if(i.getName().equals( tf_name.getText())){
                    bag.remove(i);
                }
            }*/
            ta_bag.clear();
            bag.forEach(p -> ta_bag.appendText(p.toString() + "\n"));
        }

        @FXML
        void onClear(ActionEvent event) {
            bag.clear();
            ta_bag.clear();
            bag.forEach(p -> ta_bag.appendText(p.toString() + "\n"));

        }







        // other options to iterate
        /*String bagContent = bag.stream()
                .map(Pokemon::toString)
                .collect(Collectors.joining("\n"));
        ta_bag.setText(bagContent);*/


        /*ta_bag.clear();
        for(Pokemon p : bag){
            ta_bag.appendText(p.toString() + "\n");
        }*/

}
