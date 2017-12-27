package jacobreid.view_controller;

import jacobreid.JacobReid;
import jacobreid.model.Part;
import jacobreid.model.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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
  private JacobReid main;
    
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

  public void setMain(JacobReid main) {
    this.main = main;

    // Add data to tables
    partsTableView.setItems(main.getParts());
    productsTableView.setItems(main.getProducts());
  }

  @FXML
  void handleAddPart(ActionEvent event) {
    Part part = main.showAddPartDialog(null);
    if(part != null){
      main.getParts().add(part);
    }
  }

  @FXML
  void handleDeletePart(ActionEvent event) {
    int index = partsTableView.getSelectionModel().getSelectedIndex();
    if (index >= 0) {
      partsTableView.getItems().remove(index);
    } else {
      Alert alert = new Alert(AlertType.WARNING);
      alert.initOwner(main.getPrimaryStage());
      alert.setTitle("No Selection");
      alert.setHeaderText("No Person Selected");
      alert.setContentText("Please select a person in the table.");
      alert.showAndWait();
    }
  }

  @FXML
  void handleExit(ActionEvent event) {
    main.close();
  }

  @FXML
  void handleModifyPart(ActionEvent event) {
    Part part = partsTableView.getSelectionModel().getSelectedItem(); 
    if (part != null) {
      main.showModifyPartDialog(part);
    } else {
      Alert alert = new Alert(AlertType.WARNING);
      alert.initOwner(main.getPrimaryStage());
      alert.setTitle("No Selection");
      alert.setHeaderText("No Person Selected");
      alert.setContentText("Please select a person in the table.");
      alert.showAndWait();
    }
  }
  
  @FXML
  void handleSearchParts(ActionEvent event) {
    String search = partsTextField.getText();
    if("".equals(search)){
      partsTableView.setItems(main.getParts());
    }else{
      partsTableView.setItems(main.searchParts(search));
    }
  }

  @FXML
  void handleModifyProduct(ActionEvent event) {

  }

  @FXML
  void handleAddProduct(ActionEvent event) {
    Product product = main.productDialog(null);
    if(product != null){
      main.getProducts().add(product);
    }
  }

  @FXML
  void handleSearchProducts(ActionEvent event) {

  }

}
