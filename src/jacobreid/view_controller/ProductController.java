package jacobreid.view_controller;

import jacobreid.JacobReid;
import jacobreid.model.Part;
import jacobreid.model.Product;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ProductController {

  @FXML
  private TextField partsTextField;

  @FXML
  private Button searchButton;

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
  private Button addButton;

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

  @FXML
  private Button deleteButton;

  @FXML
  private Button saveButton;

  @FXML
  private TextField IDTextField;

  @FXML
  private TextField nameTextField;

  @FXML
  private TextField inventoryTextField;

  @FXML
  private TextField priceTextField;

  @FXML
  private TextField minTextField;

  @FXML
  private TextField maxTextField;

  @FXML
  private Button cancelButton;

  @FXML
  private Label productLabel;
    
  private Stage productStage;
  private Product product;

  @FXML
  void handleAdd(ActionEvent event) {
    // data = allPartsTableView.getItems();
  }

  @FXML
  void handleCancel(ActionEvent event) {

  }

  @FXML
  void handleDelete(ActionEvent event) {

  }

  @FXML
  void handleSave(ActionEvent event) {

  }

  @FXML
  void handleSearch(ActionEvent event) {

  }

  public void setProductStage(Stage productStage) {
    this.productStage = productStage;
  }

  public void setProduct(Product product) {
    nameTextField.setText(product.getName());
    inventoryTextField.setText(Integer.toString(product.getInventory()));
    priceTextField.setText(Double.toString(product.getPrice()));
    maxTextField.setText(Integer.toString(product.getMax()));
    minTextField.setText(Integer.toString(product.getMin()));
    IDTextField.setText(Integer.toString(product.getID()));
    this.product = product;
  }

  public Product getProduct() {
    return product;
  }
  
  public static Product showDialog(Stage primaryStage, Product product) throws IOException{
    
      // Load the fxml file and create a new stage for the popup dialog.
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(JacobReid.class.getResource("view_controller/Product.fxml"));
      AnchorPane page = (AnchorPane) loader.load();

      // Create the dialog Stage.
      Stage productStage = new Stage();
      // productStage.setTitle(title);
      productStage.initModality(Modality.APPLICATION_MODAL);
      productStage.initOwner(primaryStage);
      Scene scene = new Scene(page);
      productStage.setScene(scene);

      // set the part in the controller
      ProductController prodcutController = loader.getController();
      // prodcutController.setProductLabel(title);
      
      prodcutController.setProductStage(productStage);
      if(product != null){
        prodcutController.setProduct(product);
      }


      productStage.showAndWait();

      return prodcutController.getProduct();

    
  }

}
