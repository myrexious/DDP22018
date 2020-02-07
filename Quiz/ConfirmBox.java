import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ConfirmBox{

    static boolean answer;

    public static boolean display(String title, String msg){
        Stage window = new Stage();
        window.setTitle(title);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(275);
        
        //Confirmation
        Button yesButton = new Button("Yes");
        yesButton.setOnAction(e -> {
            answer = true;
            window.close();
        });

        Button noButton = new Button("No");
        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });

        //Label
        Label message = new Label();
        message.setText(msg);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(message, yesButton, noButton);
        layout.setAlignment(Pos.CENTER);

        Scene alertScene = new Scene(layout);
        window.setScene(alertScene);
        window.showAndWait();

        return answer;
    }    
}