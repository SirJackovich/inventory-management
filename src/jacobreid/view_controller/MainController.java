package jacobreid.view_controller;

import jacobreid.JacobReid;
import jacobreid.model.Inhouse;
import jacobreid.model.Outsourced;
import jacobreid.model.Part;
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
    private TableView<?> productsTableView;

    @FXML
    private TableColumn<?, ?> productIDColumn;

    @FXML
    private TableColumn<?, ?> productNameColumn;

    @FXML
    private TableColumn<?, ?> productInventoryColumn;

    @FXML
    private TableColumn<?, ?> productPriceColumn;

    @FXML
    private Button addProductButton;

    @FXML
    private Button modifyProductButton;

    @FXML
    private Button deleteProductButton;
    
    // Reference to the main application.
    private JacobReid main;
    
//    @FXML
//    public ObservableList<Part> getParts() {
//        return partsTableView.getItems();
//    }
//    
//    @FXML
//    public void setParts(ObservableList<Part> parts) {
//        partsTableView.setItems(parts);
//    }
    
    @FXML
    private void initialize() {
        // Initialize the tables
        partIDColumn.setCellValueFactory(cellData -> cellData.getValue().IDProperty().asObject());
        partNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        partInventoryColumn.setCellValueFactory(cellData -> cellData.getValue().inventoryProperty().asObject());
        partPriceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
    }

    public void setMain(JacobReid main) {
        this.main = main;

        // Add observable list data to the table
        partsTableView.setItems(main.getParts());
    }

    @FXML
    void handleAddPart(ActionEvent event) {
        Part part = main.showAddPartDialog();
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

    }

    @FXML
    void handleModifyPart(ActionEvent event) {
        Part part = partsTableView.getSelectionModel().getSelectedItem();        
        if (part != null) {
            boolean updated;
            if("Outsourced".equals(part.getPartType())){
                Outsourced outsourcedPart = (Outsourced) partsTableView.getSelectionModel().getSelectedItem();
                updated = main.showModifyOutsourcedPartDialog(outsourcedPart);
            }else{
                Inhouse inhousePart = (Inhouse) partsTableView.getSelectionModel().getSelectedItem();
                updated = main.showModifyInhousePartDialog(inhousePart);
            }
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
    void handleModifyProduct(ActionEvent event) {

    }

    @FXML
    void handleProductAdd(ActionEvent event) {

    }

    @FXML
    void handleProductsSearch(ActionEvent event) {

    }

    @FXML
    void handleSearchParts(ActionEvent event) {

    }

}
