package jacobreid.view_controller;

import jacobreid.JacobReid;
import jacobreid.model.Part;
import jacobreid.model.Product;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainController {

  @FXML
  private Button exitButton;

  @FXML
  private TextField partsTextField;

  @FXML
  private Button searchPartsButton;

  @FXML
  private TableView<Part> partsTableView;

  @FXML
  private TableColumn<Part, Integer> partIDColumn;

  @FXML
  private TableColumn<Part, String> partNameColumn;

  @FXML
  private TableColumn<Part, Integer> partInventoryColumn;

  @FXML
  private TableColumn<Part, Double> partPriceColumn;

  @FXML
  private Button addPartButton;

  @FXML
  private Button modifyPartButton;

  @FXML
  private Button deletePartButton;

  @FXML
  private TextField productsTextField;

  @FXML
  private Button searchProductsButton;

  @FXML
  private TableView<Product> productsTableView;

  @FXML
  private TableColumn<Product, Integer> productIDColumn;

  @FXML
  private TableColumn<Product, String> productNameColumn;

  @FXML
  private TableColumn<Product, Integer> productInventoryColumn;

  @FXML
  private TableColumn<Product, Double> productPriceColumn;

  @FXML
  private Button addProductButton;

  @FXML
  private Button modifyProductButton;

  @FXML
  private Button deleteProductButton;

  // Reference to the main application.
  private JacobReid app;
  
  private Stage primaryStage;
    
  @FXML
  private void initialize() {
    // Initialize the part table
    partIDColumn.setCellValueFactory(cellData -> cellData.getValue().IDProperty().asObject());
    partNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
    partInventoryColumn.setCellValueFactory(cellData -> cellData.getValue().inventoryProperty().asObject());
    partPriceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
    
    // Initialize the product table
    productIDColumn.setCellValueFactory(cellData -> cellData.getValue().IDProperty().asObject());
    productNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
    productInventoryColumn.setCellValueFactory(cellData -> cellData.getValue().inventoryProperty().asObject());
    productPriceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
  }

  public void setApp(JacobReid app) {
    this.app = app;

    // Add data to tables
    partsTableView.setItems(app.getInventory().getParts());
    productsTableView.setItems(app.getInventory().getProducts());
  }
  
  public void setPrimaryStage(Stage primaryStage){
    this.primaryStage = primaryStage;
  }

  @FXML
  void handleAddPart(ActionEvent event) throws IOException {
    Part part = PartController.showDialog(primaryStage, null, "Add Part", false);;
    if(part != null){
      app.getInventory().getParts().add(part);
    }
  }

  @FXML
  void handleDeletePart(ActionEvent event) {
    int index = partsTableView.getSelectionModel().getSelectedIndex();
    if (index >= 0) {
      // TODO see if it removes it from the inventory
      partsTableView.getItems().remove(index);
    } else {
      noSelectionAlert();
    }
  }

  @FXML
  void handleExit(ActionEvent event) {
    app.close();
  }

  @FXML
  void handleModifyPart(ActionEvent event) throws IOException {
    Part part = partsTableView.getSelectionModel().getSelectedItem(); 
    if (part != null) {
      PartController.showDialog(primaryStage, part, "Modify part", true);
    } else {
      noSelectionAlert();
    }
  }
  
  @FXML
  void handleSearchParts(ActionEvent event) {
    String search = partsTextField.getText();
    if("".equals(search)){
      partsTableView.setItems(app.getInventory().getParts());
    }else{
      partsTableView.setItems(app.getInventory().searchParts(search));
    }
  }

  @FXML
  void handleModifyProduct(ActionEvent event) throws IOException {
    Product product = productsTableView.getSelectionModel().getSelectedItem(); 
    if (product != null) {
      ProductController.showDialog(app, primaryStage, product);
    } else {
      noSelectionAlert();
    }
  }

  @FXML
  void handleAddProduct(ActionEvent event) throws IOException {
    Product product = ProductController.showDialog(app, primaryStage, null);
    if(product != null){
      app.getInventory().getProducts().add(product);
    }
  }
  
  @FXML
  void handleDeleteProduct(ActionEvent event) {
    int index = productsTableView.getSelectionModel().getSelectedIndex();
    if (index >= 0) {
      // TODO see if it removes it from the inventory
      productsTableView.getItems().remove(index);
    } else {
      noSelectionAlert();
    }
  }

  @FXML
  void handleSearchProducts(ActionEvent event) {
    String search = productsTextField.getText();
    if("".equals(search)){
      productsTableView.setItems(app.getInventory().getProducts());
    }else{
      productsTableView.setItems(app.getInventory().searchProducts(search));
    }
  }
  
  private void noSelectionAlert(){
    Alert alert = new Alert(AlertType.WARNING);
    alert.initOwner(app.getPrimaryStage());
    alert.setTitle("No Selection");
    alert.setHeaderText("No Person Selected");
    alert.setContentText("Please select a person in the table.");
    alert.showAndWait();
  }

}
