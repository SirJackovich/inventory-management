/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jacobreid;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import jacobreid.model.Inhouse;
import jacobreid.model.Inventory;
import jacobreid.model.Outsourced;
import jacobreid.model.Part;
import jacobreid.model.Product;
import jacobreid.view_controller.MainController;
import jacobreid.view_controller.PartController;
import jacobreid.view_controller.ProductController;

/**
 *
 * @author sirjackovich
 */
public class JacobReid extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view_controller/Main.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
