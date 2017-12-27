package jacobreid.view_controller;

import jacobreid.JacobReid;
import jacobreid.model.Inhouse;
import jacobreid.model.Outsourced;
import jacobreid.model.Part;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PartController {
    
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
    
  private Stage partStage;
  private Part part;
  
  
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
  
  public Part getPart(){
    return part;
  }
  
  public void setPart(Part part) {
    nameTextField.setText(part.getName());
    inventoryTextField.setText(Integer.toString(part.getInventory()));
    priceTextField.setText(Double.toString(part.getPrice()));
    maxTextField.setText(Integer.toString(part.getMax()));
    minTextField.setText(Integer.toString(part.getMin()));
    IDTextField.setText(Integer.toString(part.getID()));

    if("Outsourced".equals(part.getPartType())){
      partTextField.setText(((Outsourced)part).getCompanyName());
      inHouseRadioButton.setSelected(false);
      OutsourcedRadioButton.setSelected(true);
      partTextLabel.setText("Company Name");
    }else{
      partTextField.setText(Integer.toString(((Inhouse)part).getMachineID()));
      inHouseRadioButton.setSelected(true);
      OutsourcedRadioButton.setSelected(false);
      partTextLabel.setText("Machine ID");
    }
    this.part = part;
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
  public void disableRadio(){
    inHouseRadioButton.setDisable(true);
    OutsourcedRadioButton.setDisable(true);
  }

  @FXML
  void handleCancel(ActionEvent event) {
    partStage.close();
  }

  @FXML
  void handleInHouse(ActionEvent event) {
    partTextLabel.setText("Machine ID");
    if(this.part != null){
      partTextField.setText(Integer.toString(((Inhouse)part).getMachineID()));
    }else{
      partTextField.setText("");
    }
  }

  @FXML
  void handleOutsourced(ActionEvent event) {
    partTextLabel.setText("Company Name");
    if(this.part != null){
      partTextField.setText(((Outsourced)this.part).getCompanyName());
    }else{
      partTextField.setText("");
    }
  }

  @FXML
  void handleSave(ActionEvent event){
    // if (isInputValid()) {
      if(this.part == null){
        if("Outsourced".equals(getPartType())){
          this.part = new Outsourced(nameTextField.getText(), Double.parseDouble(priceTextField.getText()), Integer.parseInt(inventoryTextField.getText()), Integer.parseInt(minTextField.getText()), Integer.parseInt(maxTextField.getText()), partTextField.getText());
        }else {
          this.part = new Inhouse(nameTextField.getText(), Double.parseDouble(priceTextField.getText()), Integer.parseInt(inventoryTextField.getText()), Integer.parseInt(minTextField.getText()), Integer.parseInt(maxTextField.getText()), Integer.parseInt(partTextField.getText()));
        }
      }else {
        this.part.setName(nameTextField.getText());
        this.part.setPrice(Double.parseDouble(priceTextField.getText()));
        this.part.setInventory(Integer.parseInt(inventoryTextField.getText()));
        this.part.setMin(Integer.parseInt(minTextField.getText()));
        this.part.setMax(Integer.parseInt(maxTextField.getText()));
        if("Outsourced".equals(getPartType())){
          ((Outsourced)this.part).setCompanyName(partTextField.getText());
        }else {
          ((Inhouse)this.part).setMachineID(Integer.parseInt(partTextField.getText()));
        }
      }
      partStage.close();
    // }
  }
    
  /**
   * Validates the user input in the text fields.
   * 
   * @return true if the input is valid
   */
//  private boolean isInputValid() {
//    String errorMessage = "";
//
//    if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
//      errorMessage += "No valid first name!\n"; 
//    }
//    if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
//      errorMessage += "No valid last name!\n"; 
//    }
//    if (streetField.getText() == null || streetField.getText().length() == 0) {
//      errorMessage += "No valid street!\n"; 
//    }
//
//    if (postalCodeField.getText() == null || postalCodeField.getText().length() == 0) {
//      errorMessage += "No valid postal code!\n"; 
//    } else {
//      // try to parse the postal code into an int.
//      try {
//        Integer.parseInt(postalCodeField.getText());
//      } catch (NumberFormatException e) {
//        errorMessage += "No valid postal code (must be an integer)!\n"; 
//      }
//    }
//
//    if (cityField.getText() == null || cityField.getText().length() == 0) {
//      errorMessage += "No valid city!\n"; 
//    }
//
//    if (birthdayField.getText() == null || birthdayField.getText().length() == 0) {
//      errorMessage += "No valid birthday!\n";
//    } else {
//      if (!DateUtil.validDate(birthdayField.getText())) {
//        errorMessage += "No valid birthday. Use the format dd.mm.yyyy!\n";
//      }
//    }
//
//    if (errorMessage.length() == 0) {
//      return true;
//    } else {
//      // Show the error message.
//      Alert alert = new Alert(AlertType.ERROR);
//      alert.initOwner(dialogStage);
//      alert.setTitle("Invalid Fields");
//      alert.setHeaderText("Please correct invalid fields");
//      alert.setContentText(errorMessage);
//
//      alert.showAndWait();
//
//      return false;
//    }
//    return true;
//  }
  
  public static Part showDialog(Stage primaryStage, Part part, String title, boolean disableRadio) throws IOException{
    
      // Load the fxml file and create a new stage for the popup dialog.
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(JacobReid.class.getResource("view_controller/Part.fxml"));
      AnchorPane page = (AnchorPane) loader.load();

      // Create the dialog Stage.
      Stage partStage = new Stage();
      partStage.setTitle(title);
      partStage.initModality(Modality.APPLICATION_MODAL);
      partStage.initOwner(primaryStage);
      Scene scene = new Scene(page);
      partStage.setScene(scene);

      // set the part in the controller
      PartController partController = loader.getController();
      partController.setPartLabel(title);
      if(disableRadio){
        partController.disableRadio();
      }
      partController.setPartStage(partStage);
      if(part != null){
        partController.setPart(part);
      }

      partStage.showAndWait();

      return partController.getPart();
  }

}
