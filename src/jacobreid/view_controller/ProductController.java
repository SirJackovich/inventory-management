package jacobreid.view_controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ProductController {

    @FXML
    private TextField partsTextField;

    @FXML
    private Button searchButton;

    @FXML
    private TableView<?> allPartsTableView;

    @FXML
    private TableColumn<?, ?> allPartsIDColumn;

    @FXML
    private TableColumn<?, ?> allPartsNameColumn;

    @FXML
    private TableColumn<?, ?> allPartsInventoryColumn;

    @FXML
    private TableColumn<?, ?> allPartsPriceColumn;

    @FXML
    private Button addButton;

    @FXML
    private TableView<?> productPartsTableView;

    @FXML
    private TableColumn<?, ?> productPartsIDColumn;

    @FXML
    private TableColumn<?, ?> productPartsNameColumn;

    @FXML
    private TableColumn<?, ?> productPartsInventoryColumn;

    @FXML
    private TableColumn<?, ?> productPartsPriceColumn;

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

}
