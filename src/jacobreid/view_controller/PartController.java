package jacobreid.view_controller;

import jacobreid.model.Inhouse;
import jacobreid.model.Outsourced;
import jacobreid.model.Part;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class PartController {
    
    private ObservableList<Part> parts = FXCollections.observableArrayList();

    @FXML
    private Label partLabel;
    
    @FXML
    private Label partTextLabel;
    
    @FXML
    private ToggleGroup group;

    @FXML
    private RadioButton inHouseRadioButton;

    @FXML
    private RadioButton OutsourcedRadioButton;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField inventoryTextField;

    @FXML
    private TextField priceTextField;

    @FXML
    private TextField partTextField;

    @FXML
    private TextField maxTextField;

    @FXML
    private TextField minTextField;

    @FXML
    private TextField IDTextField;

    @FXML
    private Button saveButton;

    @FXML
    private Button cancelButton;
    
    @FXML
    public void initialize() {
        inHouseRadioButton.setSelected(true);
        inHouseRadioButton.setToggleGroup(group);
        OutsourcedRadioButton.setToggleGroup(group);
        partTextLabel.setText("Company Name");
        IDTextField.setDisable(true);
    }
    
    @FXML
    void setPartLabel(String str){
        partLabel.setText(str);
    }

    @FXML
    void handleCancel(ActionEvent event) {
        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void handleInHouse(ActionEvent event) {
        partTextLabel.setText("Company Name");
    }

    @FXML
    void handleOutsourced(ActionEvent event) {
        partTextLabel.setText("Machine ID");
    }

    @FXML
    void handleSave(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
        MainController mainController = loader.getController();
        parts = mainController.getParts();
        RadioButton selected = (RadioButton)group.getSelectedToggle();
        String partType = selected.getText();
        String name = nameTextField.getText();
        String inventory = inventoryTextField.getText();
        String price = priceTextField.getText();
        String max = maxTextField.getText();
        String min = minTextField.getText();
        String partText = partTextField.getText();
        if("Outsourced".equals(partType)){
            parts.add(new Outsourced(name, Double.parseDouble(price), Integer.parseInt(inventory), Integer.parseInt(min), Integer.parseInt(max), partText));
        }else{
           parts.add(new Inhouse(name, Double.parseDouble(price), Integer.parseInt(inventory), Integer.parseInt(min), Integer.parseInt(max), Integer.parseInt(partText)));
        }
        // TODO: need to bind the part to the table cells??
        mainController.setParts(parts);
        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.close();
    }

}
