package inventorymanagement.view_controller;

import inventorymanagement.inventorymanagement;
import inventorymanagement.model.AlertDialog;
import inventorymanagement.model.Part;
import inventorymanagement.model.Product;
import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ProductController {
  
  private inventorymanagement app;
  private Product product;
  private Stage productStage;
  
  @FXML
  private Label productLabel;
  
  @FXML
  private TextField inventoryTextField;
  @FXML
  private TextField IDTextField;
  @FXML
  private TextField maxTextField;
  @FXML
  private TextField minTextField;
  @FXML
  private TextField nameTextField;
  @FXML
  private TextField partsTextField;
  @FXML
  private TextField priceTextField;
  
  @FXML
  private TableView<Part> allPartsTableView;
  @FXML
  private TableColumn<Part, Integer> allPartsIDColumn;
  @FXML
  private TableColumn<Part, String> allPartsNameColumn;
  @FXML
  private TableColumn<Part, Integer> allPartsInventoryColumn;
  @FXML
  private TableColumn<Part, Double> allPartsPriceColumn;
  
  @FXML
  private TableView<Part> productPartsTableView;
  @FXML
  private TableColumn<Part, Integer> productPartsIDColumn;
  @FXML
  private TableColumn<Part, String> productPartsNameColumn;
  @FXML
  private TableColumn<Part, Integer> productPartsInventoryColumn;
  @FXML
  private TableColumn<Part, Double> productPartsPriceColumn;
  
  private String checkNumbers() {
    String errorMessage = "";
    int inventory;
    try {
      inventory = Integer.parseInt(inventoryTextField.getText());
    } catch (NumberFormatException e) {
      inventory = 0; 
    }
    int max = Integer.parseInt(maxTextField.getText());
    int min = Integer.parseInt(minTextField.getText());
    ObservableList<Part> parts = productPartsTableView.getItems();
    double price = Double.parseDouble(priceTextField.getText());
    if(max <= min){
      errorMessage += "No valid max (must be greater than min)!\n"; 
    }
    if(min >= max){
      errorMessage += "No valid min (must be less than max)!\n";
    }
    if(inventory < min || inventory > max){
      errorMessage += "No valid inventory (must be between min and max)!\n"; 
    }
    if(parts.isEmpty()){
      errorMessage += "No valid part (each product must have at least one part)!\n"; 
    }else {
      double partsPrice = 0;
      partsPrice = parts.stream().map((part) -> part.getPrice()).reduce(partsPrice, (accumulator, _item) -> accumulator + _item);
      if(price < partsPrice){
        errorMessage += "No valid price (the price of the product cannot be less then the parts)!\n"; 
      }
    }
    return errorMessage;
  }
  
  @FXML
  private void handleAdd() {
    int index = allPartsTableView.getSelectionModel().getSelectedIndex();
    if (index >= 0) {
      productPartsTableView.getItems().add(allPartsTableView.getSelectionModel().getSelectedItem());  
    } else {
      AlertDialog.noSelectionDialog("part");
    }
  }
  
  @FXML
  private void handleCancel() {
    if(AlertDialog.cancelDialog()){
      productStage.close();
    }
  }

  @FXML
  private void handleDelete() {
    int index = productPartsTableView.getSelectionModel().getSelectedIndex();
    if (index >= 0) {
      if(AlertDialog.deleteDialog()){
        productPartsTableView.getItems().remove(index);
      }
    } else {
      AlertDialog.noSelectionDialog("part");
    }
  }
  
  @FXML
  private void handleSave() {
     if (isInputValid()) {
      int inventory;
      try {
        inventory = Integer.parseInt(inventoryTextField.getText());
      } catch (NumberFormatException e) {
        inventory = 0; 
      }
      if(this.product == null){
        this.product = new Product(
          nameTextField.getText(), 
          Double.parseDouble(priceTextField.getText()), 
          inventory, 
          Integer.parseInt(minTextField.getText()), 
          Integer.parseInt(maxTextField.getText()), 
          productPartsTableView.getItems()
        );
      }else {
        this.product.setName(nameTextField.getText());
        this.product.setPrice(Double.parseDouble(priceTextField.getText()));
        this.product.setInventory(inventory);
        this.product.setMin(Integer.parseInt(minTextField.getText()));
        this.product.setMax(Integer.parseInt(maxTextField.getText()));
      }
      productStage.close();
     }
  }

  @FXML
  private void handleSearch() {
    String search = partsTextField.getText();
    if("".equals(search)){
      allPartsTableView.setItems(app.getInventory().getParts());
    }else{
      allPartsTableView.setItems(app.getInventory().searchParts(search));
    }
  }
  
  @FXML
  private void initialize() {
    IDTextField.setDisable(true);
    
    // Initialize the allParts table
    allPartsIDColumn.setCellValueFactory(cellData -> cellData.getValue().IDProperty().asObject());
    allPartsNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
    allPartsInventoryColumn.setCellValueFactory(cellData -> cellData.getValue().inventoryProperty().asObject());
    allPartsPriceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
    
    // Initialize the productParts table
    productPartsIDColumn.setCellValueFactory(cellData -> cellData.getValue().IDProperty().asObject());
    productPartsNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
    productPartsInventoryColumn.setCellValueFactory(cellData -> cellData.getValue().inventoryProperty().asObject());
    productPartsPriceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
  }

  private boolean isInputValid() {
    String errorMessage = "";

    if (nameTextField.getText() == null || nameTextField.getText().length() == 0) {
      errorMessage += "No valid name!\n"; 
    }
    
    if (priceTextField.getText() == null || priceTextField.getText().length() == 0) {
      errorMessage += "No valid price!\n"; 
    } else {
      try {
        Double.parseDouble(priceTextField.getText());
      } catch (NumberFormatException e) {
        errorMessage += "No valid price (must be an double)!\n"; 
      }
    }
    
    if (minTextField.getText() == null || minTextField.getText().length() == 0) {
      errorMessage += "No valid min!\n"; 
    } else {
      try {
        Integer.parseInt(minTextField.getText());
      } catch (NumberFormatException e) {
        errorMessage += "No valid min (must be an integer)!\n"; 
      }
    }
    
    if (maxTextField.getText() == null || maxTextField.getText().length() == 0) {
      errorMessage += "No valid max!\n"; 
    } else {
      try {
        Integer.parseInt(maxTextField.getText());
      } catch (NumberFormatException e) {
        errorMessage += "No valid max (must be an integer)!\n"; 
      }
    }
    
    if(errorMessage.length() == 0){
      errorMessage += checkNumbers();
    }
    
    if (errorMessage.length() == 0) {
      return true;
    } else {
      AlertDialog.errorDialog(errorMessage);
      return false;
    }
  }
  
  public Product getProduct() {
    return product;
  }
  
  public void setApp(inventorymanagement app) {
    this.app = app;

    // Add data to table
    allPartsTableView.setItems(app.getInventory().getParts());
  }
  
  public void setProduct(Product product) {
    nameTextField.setText(product.getName());
    inventoryTextField.setText(Integer.toString(product.getInventory()));
    priceTextField.setText(Double.toString(product.getPrice()));
    maxTextField.setText(Integer.toString(product.getMax()));
    minTextField.setText(Integer.toString(product.getMin()));
    IDTextField.setText(Integer.toString(product.getID()));
    productPartsTableView.setItems(product.getAssociatedParts());
    this.product = product;
  }
  
  @FXML
  public void setProductLabel(String str){
    productLabel.setText(str);
  }

  public void setProductStage(Stage productStage) {
    this.productStage = productStage;
  }

  public static Product showDialog(inventorymanagement app, Stage primaryStage, String title, Product product) throws IOException{
    
      // Load the fxml file and create a new stage for the popup dialog.
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(inventorymanagement.class.getResource("view_controller/Product.fxml"));
      AnchorPane page = (AnchorPane) loader.load();

      // Create the dialog Stage.
      Stage productStage = new Stage();
      productStage.setTitle(title);
      productStage.initModality(Modality.APPLICATION_MODAL);
      productStage.initOwner(primaryStage);
      Scene scene = new Scene(page);
      productStage.setScene(scene);

      // set the part in the controller
      ProductController prodcutController = loader.getController();
      prodcutController.setApp(app);
      prodcutController.setProductLabel(title);
      
      prodcutController.setProductStage(productStage);
      if(product != null){
        prodcutController.setProduct(product);
      }


      productStage.showAndWait();

      return prodcutController.getProduct();

    
  }

}
