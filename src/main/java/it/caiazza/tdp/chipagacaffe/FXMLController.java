package it.caiazza.tdp.chipagacaffe;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class FXMLController implements Initializable{
	private int nmax = 100;
	private int nmin = 1;
	private int segreto;
	private int tentativiFatti;
	private boolean inGioco = false;

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtStanza;

    @FXML
    private Button btnCrea;

    @FXML
    private Button btnUnisciti;

    @FXML
    private Label lblIntervallo;

    @FXML
    private HBox layoutTentativo;

    @FXML
    private TextField txtRisposta;

    @FXML
    private Button btnProva;

    @FXML
    void doCreaStanza(ActionEvent event) {
    	// provvisoriamente crea una nuova partita
    	// Logica del gioco
    	this.segreto = (int)(Math.random() * nmax) + 1;
    	this.tentativiFatti = 0;
    	this.inGioco = true;
    	
    	// Gestione dell'interfaccia
    	layoutTentativo.setDisable(false);
    	txtRisposta.clear();
    	lblIntervallo.setText("Il numero fortunato e' compreso tra "+ Integer.toString(nmin) + " e " + Integer.toString(nmax) + ".");
    	
    }

    @FXML
    void doProva(ActionEvent event) {
    	// leggere l'input
    	int risposta;
    	try{
    		risposta = Integer.parseInt(txtRisposta.getText());
    	}catch(NumberFormatException e){
    		lblIntervallo.setText("!! DEVI INSERIRE UN NUMERO !!");
    		return;
    	}
    	tentativiFatti ++;
    	
    	if(risposta == this.segreto) {
    		lblIntervallo.setText("Che culo... oggi paghi il caffe' !!!");
    		layoutTentativo.setDisable(true);
    		this.inGioco = false; 
    		return;
    	}
    	// il numero è troppo alto / basso
    	if(risposta < this.segreto) {
    		lblIntervallo.setText("Il numero selezionato è BASSO!!");
    		this.nmin = risposta;
    	}
    	else {
    		lblIntervallo.setText("Il numero selezionato è ALTO!!");
    		this.nmax = risposta;
    	}
    }

    @FXML
    void doUniscitiStanza(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert txtStanza != null : "fx:id=\"txtStanza\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCrea != null : "fx:id=\"btnCrea\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnUnisciti != null : "fx:id=\"btnUnisciti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblIntervallo != null : "fx:id=\"lblIntervallo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert layoutTentativo != null : "fx:id=\"layoutTentativo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisposta != null : "fx:id=\"txtRisposta\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnProva != null : "fx:id=\"btnProva\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
