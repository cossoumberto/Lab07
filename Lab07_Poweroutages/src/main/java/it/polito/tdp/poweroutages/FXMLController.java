/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.poweroutages;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.poweroutages.model.Model;
import it.polito.tdp.poweroutages.model.Nerc;
import it.polito.tdp.poweroutages.model.PowerOutage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="boxSelect"
    private ComboBox<Nerc> boxSelect; // Value injected by FXMLLoader

    @FXML // fx:id="txtYears"
    private TextField txtYears; // Value injected by FXMLLoader

    @FXML // fx:id="txtHours"
    private TextField txtHours; // Value injected by FXMLLoader

    @FXML // fx:id="btnAnalysis"
    private Button btnAnalysis; // Value injected by FXMLLoader

    @FXML // fx:id="txtResut"
    private TextArea txtResut; // Value injected by FXMLLoader

    @FXML
    void analysis(ActionEvent event) {
    	Nerc nerc = boxSelect.getValue();
    	int x = -1;
    	int y = -1;
    	if(nerc == null) {
    		txtResut.setText("Devi selezionare un NERC");
    		return;
    	}
    	try {
			x = Integer.parseInt(txtYears.getText());
			y = Integer.parseInt(txtHours.getText());
    	} catch(Exception e) {
    		e.printStackTrace();
    		txtResut.setText("Devi inserire numeri");
    	}
    	if(x!=-1 && y!=-1) {
    		List<PowerOutage> poTrovati = model.trova(nerc, x, y);
    		txtResut.setText("Totale persone colpite: " + model.getColpitiMax() + "\n"
    				+ "Totale ore: " + model.getOreTot() + "\n");
    		for(PowerOutage po : poTrovati)
    			txtResut.appendText(po.toString() + "\n");
    	}
    }

    @FXML
    void select(ActionEvent event) {
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert boxSelect != null : "fx:id=\"boxSelect\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtYears != null : "fx:id=\"txtYears\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtHours != null : "fx:id=\"txtHours\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnAnalysis != null : "fx:id=\"btnAnalysis\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResut != null : "fx:id=\"txtResut\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    	this.boxSelect.getItems().addAll(model.getNercList());
    }
}
