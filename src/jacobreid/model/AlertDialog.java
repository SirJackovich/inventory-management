package jacobreid.model;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class AlertDialog {
  public static void noSelectionDialog(String text){
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("No Selection");
    alert.setHeaderText("No " + text +" selected");
    alert.setContentText("Please select a " + text + " in the table.");
    alert.showAndWait();
  }
  
  public static boolean deleteDialog(){
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirm Delete");
    alert.setHeaderText("Confirm Delete");
    alert.setContentText("You are about to delete something, there is no going back.");
    
    Optional<ButtonType> result = alert.showAndWait();
    return (result.get() == ButtonType.OK);
  }
  
  public static boolean cancelDialog(){
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirm Cancel");
    alert.setHeaderText("Confirm Cancel");
    alert.setContentText("Are you sure you want to cancel? Any changes you have made will be lost.");

    Optional<ButtonType> result = alert.showAndWait();
    return (result.get() == ButtonType.OK);
  }
  
  public static void errorDialog(String errorMessage){
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Invalid Fields");
    alert.setHeaderText("Please correct invalid fields");
    alert.setContentText(errorMessage);
    alert.showAndWait();
  }
}
