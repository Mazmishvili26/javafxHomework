import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class View implements Initializable {

    String choseValue;

    public ChoiceBox handleAlphabet;
    public TextArea handleShowResult;
    public TextArea handleStatistic;


    // Spinners

    final int INITIAL_VALUE = 1;

    public Spinner <Integer> handleSentences;
    SpinnerValueFactory<Integer> svfLevel1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100, INITIAL_VALUE);

    public Spinner <Integer> minWords;
    SpinnerValueFactory<Integer> svfLevel2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100, INITIAL_VALUE);

    public Spinner <Integer> maxWords;
    SpinnerValueFactory<Integer> svfLevel3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100, INITIAL_VALUE);

    public Spinner <Integer> minCharacters;
    SpinnerValueFactory<Integer> svfLevel4 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100, INITIAL_VALUE);

    public Spinner <Integer> maxCharacters;
    SpinnerValueFactory<Integer> svfLevel5 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100, INITIAL_VALUE);

    // Spinners

    public void handleGenerateBtn(ActionEvent actionEvent) {

        String alphabet = "";
        char letter = 4304; // ASCII Georgian language 4304 = ა;


        // number of word in each sentences random generator;

        Random rd = new Random();
        int words = rd.nextInt(minCharacters.getValue(), maxCharacters.getValue() + 1);

        // number of word in each sentences random generator;


        //  number of word in each sentences random generator

        Random rd2 = new Random();
        int sentences = rd2.nextInt(minWords.getValue(), maxWords.getValue());


        //  number of word in each sentences random generator


        // Main Action

        for (int i = 0 ; i < words; i++){
            alphabet += letter++;
        }


        for (int c = 0; c < handleSentences.getValue(); c++){
            for (int b = 0 ; b < sentences; b++){
                handleShowResult.appendText(alphabet + " ");
            }
            handleShowResult.appendText("\n");
        }


        System.out.println("xazi" +handleSentences.getValue());
        System.out.println("Sentences" +sentences);
        System.out.println("Words" +words);

        // Main Action



        // Statistic handler

        handleStatistic.clear();
        handleStatistic.appendText(choseValue + ": " + handleSentences.getValue() + "sentences;" + sentences * handleSentences.getValue() + "words;" + sentences * words * handleSentences.getValue() + "characters.");

        // Statistic handler


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Spinners getValue

        handleSentences.setValueFactory(svfLevel1);
        minWords.setValueFactory(svfLevel2);
        maxWords.setValueFactory(svfLevel3);
        minCharacters.setValueFactory(svfLevel4);
        maxCharacters.setValueFactory(svfLevel5);


        // Spinners getValue


        // handleAlphabet

        handleAlphabet.getItems().addAll("Georgian");
        handleAlphabet.setValue("Georgian");
        choseValue = String.valueOf(handleAlphabet.getValue());

    }
}
