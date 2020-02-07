import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class AlertBox{

    public static void display(String title, String msg){
        Stage window = new Stage();
        window.setTitle(title);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(200);

        Label message = new Label();
        message.setText(msg);
        Button closeButton = new Button("OK");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(message, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene alertScene = new Scene(layout);
        window.setScene(alertScene);
        window.showAndWait();
    }    
}