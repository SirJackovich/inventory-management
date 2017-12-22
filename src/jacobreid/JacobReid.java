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
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author sirjackovich
 */
public class JacobReid extends Application {
    
    private ObservableList<Part> parts = FXCollections.observableArrayList();

    /**
     * Constructor
     */
    public JacobReid() {
        parts.add(new Outsourced("name", 10, 2, 1, 5, "companyName"));
        parts.add(new Inhouse("name", 10, 2, 1, 5, 7));
    }

    public ObservableList<Part> getParts() {
        return parts;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("here");
        FXMLLoader loader = new FXMLLoader();
        System.out.println("here1");
        loader.setLocation(JacobReid.class.getResource("view_controller/Main.fxml"));
        System.out.println("here2");
        Parent root = loader.load();
        System.out.println("here3");
        // Give the controller access to the main app.
        MainController mainController = loader.getController();
        System.out.println("here4");
        mainController.setMain(this);
        System.out.println("here5");
        
        
        
        
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
