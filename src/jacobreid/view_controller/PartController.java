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
    
    private Stage partStage;
    private Inhouse inhousePart;
    private Outsourced outsourcedPart;
    private boolean saveClicked;
    
    @FXML
    public void initialize() {
        inHouseRadioButton.setSelected(true);
        inHouseRadioButton.setToggleGroup(group);
        OutsourcedRadioButton.setToggleGroup(group);
        partTextLabel.setText("Machine ID");
        IDTextField.setDisable(true);
    }
    
    public void setPartStage(Stage partStage) {
        this.partStage = partStage;
    }
    
    public void setInhousePart(Inhouse inhousePart) {
        nameTextField.setText(inhousePart.getName());
        inventoryTextField.setText(Integer.toString(inhousePart.getInventory()));
        priceTextField.setText(Double.toString(inhousePart.getPrice()));
        maxTextField.setText(Integer.toString(inhousePart.getMax()));
        minTextField.setText(Integer.toString(inhousePart.getMin()));
        IDTextField.setText(Integer.toString(inhousePart.getID()));
        partTextField.setText(Integer.toString(inhousePart.getMachineID()));
    }
    
    public void setOutsourcedPart(Outsourced outsourcedPart) {
        nameTextField.setText(outsourcedPart.getName());
        inventoryTextField.setText(Integer.toString(outsourcedPart.getInventory()));
        priceTextField.setText(Double.toString(outsourcedPart.getPrice()));
        maxTextField.setText(Integer.toString(outsourcedPart.getMax()));
        minTextField.setText(Integer.toString(outsourcedPart.getMin()));
        IDTextField.setText(Integer.toString(outsourcedPart.getID()));
        partTextField.setText(outsourcedPart.getCompanyName());
    }
        
    public boolean isSaveClicked() {
        return saveClicked;
    }
    
    public Part getPart(){
        if("Outsourced".equals(getPartType())){
            return getOutsourcedPart();
        }else {
            return getInhousePart();
        }
    }
    
    public Inhouse getInhousePart(){
        return this.inhousePart;
    }
    
    public Outsourced getOutsourcedPart(){
        return this.outsourcedPart;
    }
    
    public String getPartType() {
        RadioButton selected = (RadioButton)group.getSelectedToggle();
        return selected.getText();
    }
    
    @FXML
    public void setPartLabel(String str){
        partLabel.setText(str);
    }

    @FXML
    void handleCancel(ActionEvent event) {
        partStage.close();
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
    void handleSave(ActionEvent event){
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
//        loader.load();
//        MainController mainController = loader.getController();
//        parts = mainController.getParts();
//        RadioButton selected = (RadioButton)group.getSelectedToggle();
//        String partType = selected.getText();
//        String name = nameTextField.getText();
//        int inventory = Integer.parseInt(inventoryTextField.getText());
//        double price = Double.parseDouble(priceTextField.getText());
//        int max = Integer.parseInt(maxTextField.getText());
//        int min = Integer.parseInt(minTextField.getText());
//        String partText = partTextField.getText();
//        Part part;
//        if("Outsourced".equals(partType)){
//            part = new Outsourced(name, price, inventory, min, max, partText);
//        }else{
//            part = new Inhouse(name, price, inventory, min, max, Integer.parseInt(partText));
//        }
//        parts.add(part);
//        // TODO: need to bind the part to the table cells??
//        mainController.setParts(parts);
//        

        if (isInputValid()) {
            
            
                if("Outsourced".equals(getPartType())){
                    this.outsourcedPart = new Outsourced(nameTextField.getText(), Double.parseDouble(priceTextField.getText()), Integer.parseInt(inventoryTextField.getText()), Integer.parseInt(minTextField.getText()), Integer.parseInt(maxTextField.getText()), partTextField.getText());
                }else {
                    this.inhousePart = new Inhouse(nameTextField.getText(), Double.parseDouble(priceTextField.getText()), Integer.parseInt(inventoryTextField.getText()), Integer.parseInt(minTextField.getText()), Integer.parseInt(maxTextField.getText()), Integer.parseInt(partTextField.getText()));
                }
            
//                part.setName(nameTextField.getText());
//                part.setInventory(Integer.parseInt(inventoryTextField.getText()));
//                part.setPrice(Double.parseDouble(priceTextField.getText()));
//                // part.setCompanyName(partTextField.getText())
//                part.setMax(Integer.parseInt(maxTextField.getText()));
//                part.setMin(Integer.parseInt(minTextField.getText()));            
           saveClicked = true;
            partStage.close();
        }
    }
    
    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */
    private boolean isInputValid() {
//        String errorMessage = "";
//
//        if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
//            errorMessage += "No valid first name!\n"; 
//        }
//        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
//            errorMessage += "No valid last name!\n"; 
//        }
//        if (streetField.getText() == null || streetField.getText().length() == 0) {
//            errorMessage += "No valid street!\n"; 
//        }
//
//        if (postalCodeField.getText() == null || postalCodeField.getText().length() == 0) {
//            errorMessage += "No valid postal code!\n"; 
//        } else {
//            // try to parse the postal code into an int.
//            try {
//                Integer.parseInt(postalCodeField.getText());
//            } catch (NumberFormatException e) {
//                errorMessage += "No valid postal code (must be an integer)!\n"; 
//            }
//        }
//
//        if (cityField.getText() == null || cityField.getText().length() == 0) {
//            errorMessage += "No valid city!\n"; 
//        }
//
//        if (birthdayField.getText() == null || birthdayField.getText().length() == 0) {
//            errorMessage += "No valid birthday!\n";
//        } else {
//            if (!DateUtil.validDate(birthdayField.getText())) {
//                errorMessage += "No valid birthday. Use the format dd.mm.yyyy!\n";
//            }
//        }
//
//        if (errorMessage.length() == 0) {
//            return true;
//        } else {
//            // Show the error message.
//            Alert alert = new Alert(AlertType.ERROR);
//            alert.initOwner(dialogStage);
//            alert.setTitle("Invalid Fields");
//            alert.setHeaderText("Please correct invalid fields");
//            alert.setContentText(errorMessage);
//
//            alert.showAndWait();
//
//            return false;
//        }
    return true;
    }

}
