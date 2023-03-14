package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import id.polito.tdp.alien.model.ErroreFormato;
import id.polito.tdp.alien.model.Traduzione;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnPulisci;

    @FXML
    private Button btnTraduci;

    @FXML
    private TextField inputText;

    @FXML
    private TextArea txtBox;
    
    Traduzione model = new Traduzione();

    @FXML
    void pulisci(ActionEvent event) {
    	this.txtBox.clear();
    }

    @FXML
    void traduci(ActionEvent event) {
    	try {
    		if (this.model.traduci(inputText.getText()) == 0) {
    			this.txtBox.appendText(this.model.getDizionario().get(inputText.getText()));
    		}
    		else {
    			txtBox.appendText("La parola e la relativa traduzione sono state aggiunte al dizionario");
    		}
    		} catch (ErroreFormato ef) {
    		txtBox.appendText("Errore. Verificare il formato di inserimento");
    		return;
    	}
    }
    
    public void setModel(Traduzione model) {
    	this.model = model;
    }

    @FXML
    void initialize() {
        assert btnPulisci != null : "fx:id=\"btnPulisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTraduci != null : "fx:id=\"btnTraduci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert inputText != null : "fx:id=\"inputText\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtBox != null : "fx:id=\"txtBox\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    

}


