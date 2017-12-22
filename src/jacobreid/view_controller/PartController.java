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
        partTextLabel.setText("Machine ID");
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
        partTextLabel.setText("Machine ID");
    }

    @FXML
    void handleOutsourced(ActionEvent event) {
        partTextLabel.setText("Company Name");
    }

    @FXML
    void handleSave(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
        loader.load();
        MainController mainController = loader.getController();
        parts = mainController.getParts();
        RadioButton selected = (RadioButton)group.getSelectedToggle();
        String partType = selected.getText();
        String name = nameTextField.getText();
        int inventory = Integer.parseInt(inventoryTextField.getText());
        double price = Double.parseDouble(priceTextField.getText());
        int max = Integer.parseInt(maxTextField.getText());
        int min = Integer.parseInt(minTextField.getText());
        String partText = partTextField.getText();
        Part part;
        if("Outsourced".equals(partType)){
            part = new Outsourced(name, price, inventory, min, max, partText);
        }else{
            part = new Inhouse(name, price, inventory, min, max, Integer.parseInt(partText));
        }
        parts.add(part);
        // TODO: need to bind the part to the table cells??
        mainController.setParts(parts);
        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.close();
    }

}
