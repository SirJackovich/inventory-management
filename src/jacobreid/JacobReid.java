/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jacobreid;

import jacobreid.model.Inhouse;
import jacobreid.model.Outsourced;
import jacobreid.model.Part;
import jacobreid.view_controller.MainController;
import jacobreid.view_controller.PartController;
import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author sirjackovich
 */
public class JacobReid extends Application {
    private Stage primaryStage;
    private BorderPane mainLayout;
    private final ObservableList<Part> parts = FXCollections.observableArrayList();

    /**
     * Constructor
     */
    public JacobReid() {
        parts.add(new Outsourced("outsourced part", 15, 3, 1, 5, "companyName"));
        parts.add(new Inhouse("inhouse part", 10, 2, 1, 5, 7));
    }

    public ObservableList<Part> getParts() {
        return parts;
    }
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Inventory Management System");
        showMain();
    }
    
    public void showMain() {
        try {
            // Load main layout from fxml file
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(JacobReid.class.getResource("view_controller/Main.fxml"));
            mainLayout = (BorderPane) loader.load();
            
            // Give the controller access to the main app.
            MainController mainController = loader.getController();
            mainController.setMain(this);

            // Show the scene containing the main layout
            Scene scene = new Scene(mainLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (IOException e) {
        }
    }
    
   public Part showAddPartDialog() {
       try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(JacobReid.class.getResource("view_controller/Part.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            
            // Create the dialog Stage.
            Stage partStage = new Stage();
            partStage.setTitle("Add Part");
            partStage.initModality(Modality.APPLICATION_MODAL);
            partStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            partStage.setScene(scene);

            // set the part in the controller
            PartController partController = loader.getController();
            partController.setPartLabel("Add Part");
            partController.setPartStage(partStage);
            // partController.setInhousePart(inhousePart);

            partStage.showAndWait();
            
            
            return partController.getPart();
            
        } catch (IOException e) {
           return null;
       }
   }
   
//   public boolean showModifyPartDialog(Part part) {
//       try {
//            // Load the fxml file and create a new stage for the popup dialog.
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(JacobReid.class.getResource("view_controller/Part.fxml"));
//            AnchorPane page = (AnchorPane) loader.load();
//            
//            // Create the dialog Stage.
//            Stage partStage = new Stage();
//            partStage.setTitle("Modify Part");
//            partStage.initModality(Modality.APPLICATION_MODAL);
//            partStage.initOwner(primaryStage);
//            Scene scene = new Scene(page);
//            partStage.setScene(scene);
//
//            // set the part in the controller
//            PartController partController = loader.getController();
//            partController.setPartLabel("Modify Part");
//            partController.setPartStage(partStage);
//            if("Outsourced".equals(partController.getPartType())){
//                // partController.setInhousePart(inhousePart);
//            }else{
//                Inhouse inhousePart = new Inhouse(part.getName(), part.getPrice(), part.getInventory(), part.getMin(), part.getMax());
//                partController.setInhousePart(part);
//            }
//            
//                
//            
//
//            partStage.showAndWait();
//            
//            
//            return partController.getPart();
//            
//        } catch (IOException e) {
//           e.printStackTrace();
//           return null;
//       }
//   }
   
   public boolean showModifyInhousePartDialog(Inhouse inhousePart) {
       try {
           
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(JacobReid.class.getResource("view_controller/Part.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            
            // Create the dialog Stage.
            Stage partStage = new Stage();
            partStage.setTitle("Modify Part");
            partStage.initModality(Modality.APPLICATION_MODAL);
            partStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            partStage.setScene(scene);

            // set the part in the controller
            PartController partController = loader.getController();
            partController.setPartLabel("Modify Part");
            partController.setPartStage(partStage);
            partController.setInhousePart(inhousePart);
            
            partStage.showAndWait();
            
            
            return partController.isSaveClicked();
            
        } catch (IOException e) {
           return false;
       }
   }
   
   public boolean showModifyOutsourcedPartDialog(Outsourced outsourcedPart) {
       try {
           
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(JacobReid.class.getResource("view_controller/Part.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            
            // Create the dialog Stage.
            Stage partStage = new Stage();
            partStage.setTitle("Modify Part");
            partStage.initModality(Modality.APPLICATION_MODAL);
            partStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            partStage.setScene(scene);

            // set the part in the controller
            PartController partController = loader.getController();
            partController.setPartLabel("Modify Part");
            partController.setPartStage(partStage);
            partController.setOutsourcedPart(outsourcedPart);
            
            partStage.showAndWait();
            
            
            return partController.isSaveClicked();
            
        } catch (IOException e) {
           return false;
       }
   }
    
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
