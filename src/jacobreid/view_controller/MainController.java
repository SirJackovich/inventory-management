package jacobreid.view_controller;

import jacobreid.model.Part;
import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private BorderPane Main;

    @FXML
    private Button exitButton;

    @FXML
    private TextField partsTextField;

    @FXML
    private Button searchPartsButton;

    @FXML
    private TableView<Part> partsTableView;

    @FXML
    private TableColumn<?, ?> partIDColumn;

    @FXML
    private TableColumn<?, ?> partNameColumn;

    @FXML
    private TableColumn<?, ?> partInventoryColumn;

    @FXML
    private TableColumn<?, ?> partPriceColumn;

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
    
    @FXML
    public ObservableList<Part> getParts() {
        return partsTableView.getItems();
    }
    
    @FXML
    public void setParts(ObservableList<Part> parts) {
        partsTableView.setItems(parts);
    }

    @FXML
    void handleAddPart(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Part.fxml"));
        Parent root = loader.load();
        PartController partController = loader.getController();
        partController.setPartLabel("Add Part");
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(addPartButton.getScene().getWindow());
        stage.showAndWait();
    }

    @FXML
    void handleDeletePart(ActionEvent event) {

    }

    @FXML
    void handleExit(ActionEvent event) {

    }

    @FXML
    void handleModifyPart(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Part.fxml"));
        Parent root = loader.load();
        PartController partController = loader.getController();
        partController.setPartLabel("Modify Part");
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(addPartButton.getScene().getWindow());
        stage.showAndWait();
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
