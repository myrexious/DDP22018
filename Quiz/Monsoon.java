import java.util.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ChoiceBoxListCell;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.text.*;
import javafx.scene.paint.*;

public class Monsoon extends Application{
    
    Stage window;
    Scene mainScene;
    TextField budgetAmount;
    Label totalBudget;
    BorderPane border;
    //ComboBox<String> combo;
    //int total;
    Button btManualBudget, btLoan, btAutoBudget;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        //adds Window
        window = primaryStage;
        window.setTitle("Monsoon Budgeting Project");
        border = new BorderPane();
        //HBox hbox = addHBox();
        //border.setTop(hbox);
        border.setLeft(sideMenu());
        //addStackPane(hbox);         // Add stack to HBox in top region
        
        border.setCenter(manualBudget());
        //border.setRight(addFlowPane());
        
        mainScene = new Scene(border, 475, 600);

        //Prompt On Exit
        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });
        
        
        //------------------------------------------------
        window.setScene(mainScene);
        window.show();
    }
    
    private GridPane manualBudget(){
        Label loc1, loc2, loc3, warehouse, item1loc1, item2loc1, item3loc1, item1loc2, item2loc2, 
        item3loc2, item1loc3, item2loc3, item3loc3, extraOrDeficit, budgetI, budgetL, extraOrDeficitO;
        TextField location1price, location2price, location3price, warehousePrice, 
        location1size, location2size, location3size,  warehouseSize;
        ChoiceBox<Integer> item1loc1proc, item2loc1proc, item3loc1proc, item1loc2proc, item2loc2proc,
        item3loc2proc, item1loc3proc, item2loc3proc, item3loc3proc;

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setStyle("-fx-background-color:#13242E");
        grid.setGridLinesVisible(false);

        //Budget Scene
        budgetI = new Label("Starting cash");
        budgetI.setTextFill(Color.web("#ffffff"));
        GridPane.setConstraints(budgetI, 1, 0);
        
        budgetAmount = new TextField();
        budgetAmount.setPromptText("Starting cash");
        GridPane.setConstraints(budgetAmount, 2, 0, 2, 1);
        
        //Labels
        item1loc1 = new Label("Item1");
        item2loc1 = new Label("Item2");
        item3loc1 = new Label("Item3");
        item1loc2 = new Label("Item1");
        item2loc2 = new Label("Item2");
        item3loc2 = new Label("Item3");
        item1loc3 = new Label("Item1");
        item2loc3 = new Label("Item2");
        item3loc3 = new Label("Item3");
        
        loc1 = new Label("Location 1");
        loc2 = new Label("Location 2");
        loc3 = new Label("Location 3");
        warehouse = new Label("Warehouse");

        List<Label> lblItLst = new ArrayList<Label>(
        Arrays.asList(item1loc1, item2loc1, item3loc1, item1loc2, item2loc2, item3loc2, item1loc3, item2loc3, item3loc3));

        List<Label> lblLocLst = new ArrayList<Label>(
        Arrays.asList(loc1, loc2, loc3, warehouse));
        
        int counter = 0;
        for(int n = 1 ; n <= (lblLocLst.size()*3)+1 ; n+=4){
            GridPane.setConstraints(lblLocLst.get(counter), 1, n);
            lblLocLst.get(counter).setTextFill(Color.web("#ffffff"));
            counter++;
        }

        budgetL = new Label("Total Budget");
        totalBudget = new Label("0");
        extraOrDeficit = new Label("Surplus or Deficit");
        extraOrDeficitO = new Label("0");

        List<Label> lblBudLst = new ArrayList<Label>(
        Arrays.asList(budgetL, totalBudget, extraOrDeficit, extraOrDeficitO));

        counter = 0;
        for(int n = 14 ; n < lblBudLst.size() + 14; n++){
            lblBudLst.get(counter).setTextFill(Color.web("#ffffff"));
            GridPane.setConstraints(lblBudLst.get(counter), n%2+1, n-(counter%2));
            counter++;
        }

        counter = 0;
        for(int j = 2 ; j <= lblItLst.size()+3 ; j++){
            if(j==5 || j==9){
                continue;
            }
            GridPane.setConstraints(lblItLst.get(counter), 2, j);
            lblItLst.get(counter).setTextFill(Color.web("#ffffff"));
            counter++;
        }

        //TextFields
        location1price = new TextField();
        location2price = new TextField();
        location3price = new TextField();
        warehousePrice = new TextField();
        location1size = new TextField();
        location2size = new TextField();
        location3size = new TextField();
        warehouseSize = new TextField();

        List<TextField> textFieldLocations = new ArrayList<TextField>(
                    Arrays.asList(location1price, location2price, location3price, warehousePrice, 
                    location1size, location2size, location3size,  warehouseSize));
        
        counter = 0;
        for(int a = 0 ; a < textFieldLocations.size()/2 ; a++ ){
            GridPane.setConstraints(textFieldLocations.get(counter), 2, (a*4)+1);
            GridPane.setConstraints(textFieldLocations.get(counter+4), 3, (a*4)+1);
            textFieldLocations.get(counter).setPrefColumnCount(9);
            textFieldLocations.get(counter+4).setPrefColumnCount(9);
            textFieldLocations.get(counter).setPrefWidth(70);
            textFieldLocations.get(counter+4).setPrefWidth(70);
            textFieldLocations.get(counter).setPromptText("Price");
            textFieldLocations.get(counter+4).setPromptText("Size");
            counter++;
        }


        //ChoiceBoxes
        Integer[] itemProcNum = {1000, 3000, 5000, 8000, 12000, 20000, 30000, 40000, 
                            60000, 80000, 100000, 120000};
        
        item1loc1proc = new ChoiceBox<>();
        item2loc1proc = new ChoiceBox<>();
        item3loc1proc = new ChoiceBox<>();

        item1loc2proc = new ChoiceBox<>();
        item2loc2proc = new ChoiceBox<>();
        item3loc2proc = new ChoiceBox<>();
        
        item1loc3proc = new ChoiceBox<>();
        item2loc3proc = new ChoiceBox<>();
        item3loc3proc = new ChoiceBox<>();

 
        List<ChoiceBox<Integer>> chBoxLst = new ArrayList<ChoiceBox<Integer>>(
                                Arrays.asList(item1loc1proc, item2loc1proc, item3loc1proc,
                                item1loc2proc, item2loc2proc, item3loc2proc, item1loc3proc, 
                                item2loc3proc, item3loc3proc));
 
        
        counter = 0;
        for(int i = 2 ; i <= chBoxLst.size()+3 ; i++){
            chBoxLst.get(counter).getItems().addAll(itemProcNum);
            if(i==5 || i==9){
                continue;
            }
            GridPane.setConstraints(chBoxLst.get(counter), 3, i);
            addListener(chBoxLst.get(counter));
            chBoxLst.get(counter).setValue(1000);
            counter++;
        }

        grid.getChildren().addAll(budgetI, budgetL, totalBudget, extraOrDeficit, extraOrDeficitO, loc1, loc2, loc3, warehouse,
                            location1price, location2price, location3price, warehousePrice, 
                            location1size, location2size, location3size,  warehouseSize, 
                            item1loc1, item2loc1, item3loc1, item1loc2, item2loc2, item3loc2, item1loc3, item2loc3, item3loc3,  
                            item1loc1proc, item2loc1proc, item3loc1proc, item1loc2proc, item2loc2proc,
                            item3loc2proc, item1loc3proc, item2loc3proc, item3loc3proc, budgetAmount
                            );
        
        return grid;
    }
    
    //Loan centerScene
    private GridPane loan(){
        Label amountL, interestL, dayL, loanTypeL, totalLoanL, payPerDayL, payEndL, totalLoanO, payPerDayO, payEndO;
        ComboBox<Integer> amount;
        ChoiceBox<String> loanType;
        TextField interest, day;
        
        GridPane loan = new GridPane();
        loan.setPadding(new Insets(10,10,10,10));
        loan.setHgap(10);
        loan.setVgap(10);
        loan.setStyle("-fx-background-color:#13242E");
        loan.setGridLinesVisible(false);

        amountL = new Label("Loan Amount");
        interestL = new Label("Interest (%)");
        dayL = new Label("Amount of days");
        loanTypeL = new Label("Type of loan");
        totalLoanL = new Label("Total loan amount");
        payPerDayL = new Label("Amount to pay each day");
        payEndL = new Label("Last day payment");

        totalLoanO = new Label("a");
        payPerDayO = new Label("b");
        payEndO = new Label("c");
        
        List<Label> loanLabel = new ArrayList<Label>(
            Arrays.asList(amountL, interestL, dayL, loanTypeL, totalLoanL, payPerDayL, payEndL, totalLoanO, payPerDayO, payEndO));
        
        for(int i = 0; i < loanLabel.size() ; i++){
            loanLabel.get(i).setTextFill(Color.web("#ffffff"));
            if(i>=7){
                loanLabel.get(i).setMaxWidth(Double.MAX_VALUE);
                loanLabel.get(i).setAlignment(Pos.CENTER);
                GridPane.setConstraints(loanLabel.get(i), 2, i-3);
                continue;
            }
            GridPane.setConstraints(loanLabel.get(i), 1, i);
        }

        amount = new ComboBox<>();
        amount.getItems().addAll(100000, 300000, 600000, 1000000, 2000000, 3000000);
        amount.setEditable(true);
        amount.setPrefSize(120, 10);
        GridPane.setConstraints(amount, 2, 0);

        interest = new TextField("0");
        interest.setPrefSize(120, 10);
        GridPane.setConstraints(interest, 2, 1);
        day = new TextField("0");
        day.setPrefSize(120, 10);
        GridPane.setConstraints(day, 2, 2);

        loanType = new ChoiceBox<>();
        loanType.getItems().addAll("Fully Amortized", "Interest Only");
        loanType.setPrefSize(120, 10);
        GridPane.setConstraints(loanType, 2, 3);


        loan.getChildren().addAll(amountL, interestL, dayL, loanTypeL, totalLoanL, payPerDayL, payEndL, totalLoanO, payPerDayO, 
                                payEndO, amount, loanType, interest, day);
        return loan;
    }

    //autoBudget centerScene
    private GridPane autoBudget(){
        
        Label budgetI, budgetSaveL, locationL, itemL, locPercentL, itPercentL, locMoneyL, itMoneyL, 
            loc1pL, loc2pL, loc3pL, daypL, locPercentMoney, priority1Loc, priority2Loc, priority3Loc,
            it1pL, it2pL, it3pL, discpL, itPercentMoney, priority1It, priority2It, priority3It,
            loc1PriceL, loc2PriceL, loc3PriceL, item1PriceL, item2PriceL, item3PriceL, 
            vendor1DiscL, vendor2DiscL,clocation1DiscL, location2DiscL, location3DiscL, warehouseDiscL, 
            location1SizeL, location2SizeL, location3SizeL, warehouseSizeL,
            item1Loc1L, item2Loc1L, item3Loc1L, item1Loc2L, item2Loc2L, item3Loc2L, item1Loc3L, item2Loc3L, item3Loc3L,
            location1SizeO, location2SizeO, location3SizeO, warehouseSizeO,
            item1Loc1O, item2Loc1O, item3Loc1O, item1Loc2O, item2Loc2O, item3Loc2O, item1Loc3O, item2Loc3O, item3Loc3O;
        TextField saveBudgetTF, locPercentTF, itPercentTF, locMoneyTF, itMoneyTF,
                locPriority1percent, locPriority2percent, locPriority3percent, itPriority1percent, itPriority2percent, itPriority3percent,
                loc1PriceTF, loc2PriceTF, loc3PriceTF, item1PriceTF, item2PriceTF, item3PriceTF, 
                vendor1DiscAmt1TF, vendor1DiscAmt2TF, vendor1DiscAmt3TF, vendor2DiscAmt1TF, vendor2DiscAmt2TF, vendor2DiscAmt3TF,
                loc1DiscAmt1TF, loc1DiscAmt2TF, loc1DiscAmt3TF, loc2DiscAmt1TF, loc2DiscAmt2TF, loc2DiscAmt3TF, 
                loc3DiscAmt1TF, loc3DiscAmt2TF, loc3DiscAmt3TF, warehouseDiscAmt1TF, warehouseDiscAmt2TF, warehouseDiscAmt3TF;
        RadioButton loc1p1RB, loc2p1RB, loc3p1RB, loc1p2RB, loc2p2RB, loc3p2RB, loc1p3RB, loc2p3RB, loc3p3RB,
                    item1p1RB, item2p1RB, item3p1RB, item1p2RB, item2p2RB, item3p2RB, item1p3RB, item2p3RB, item3p3RB;
        CheckBox priority1DiscCB, priority2DiscCB, priority3DiscCB;
        ChoiceBox<String> priority1DiscBox, priority2DiscBox, priority3DiscBox;
        Slider percentage;

        GridPane auto = new GridPane();
        auto.setPadding(new Insets(10,10,10,10));
        auto.setHgap(10);
        auto.setVgap(10);
        auto.setStyle("-fx-background-color:#13242E");
        auto.setGridLinesVisible(false);

        budgetI = new Label("Starting cash");
        budgetI.setTextFill(Color.web("#ffffff"));
        GridPane.setConstraints(budgetI, 2, 0, 2, 1);
        budgetAmount = new TextField();
        budgetAmount.setPromptText("Amount of money you want to save");
        GridPane.setConstraints(budgetAmount, 4, 0, 2, 1);    

        budgetSaveL = new Label("Cash on hand saved");
        budgetI.setTextFill(Color.web("#ffffff"));
        GridPane.setConstraints(budgetSaveL, 2, 1, 2, 1);
        saveBudgetTF = new TextField();
        saveBudgetTF.setPromptText("Amount of money you want to save");
        GridPane.setConstraints(saveBudgetTF, 4, 1, 2, 1);

        HBox slide = new HBox();
        slide.setPadding(new Insets(10, 10, 10, 0));
        locationL = new Label("Location");
        locationL.setTextFill(Color.web("#ffffff"));
        percentage = new Slider(0, 100, 50);
        itemL = new Label("Item");
        locationL.setTextFill(Color.web("#ffffff"));
        slide.getChildren().addAll(locationL, percentage, itemL);
        GridPane.setConstraints(slide, 1, 2, 6, 1);

        locPercentL = new Label("Location %");
        itPercentL = new Label("Item %");
        locMoneyL = new Label("Location Budget");
        itMoneyL = new Label("Item Budget");
        List<Label> labelDiv = new ArrayList<Label>(
                    Arrays.asList(locPercentL, itPercentL, locMoneyL, itMoneyL));
        locPercentTF = new TextField();
        itPercentTF = new TextField();
        locMoneyTF = new TextField();
        itMoneyTF = new TextField();
        List<TextField> textfieldDiv = new ArrayList<TextField>(
                        Arrays.asList(locPercentTF, itPercentTF, locMoneyTF, itMoneyTF));
        int counter = 0;
        for(int i = 1 ; i <= 4 ; i+=3){
            for(int j = 3 ; j <= 4 ; j++){
                GridPane.setConstraints(labelDiv.get(counter), i, j);
                GridPane.setConstraints(textfieldDiv.get(counter), i+1, j, 2, 1);
            }
        }

        loc1PriceL = new Label("Location 1 Price");
        loc2PriceL = new Label("Location 2 Price");
        loc3PriceL = new Label("Location 3 Price");
        item1PriceL = new Label("Item 1 Price");
        item2PriceL = new Label("Item 1 Price");
        item3PriceL = new Label("Item 1 Price");
        loc1PriceTF = new TextField();
        loc2PriceTF = new TextField();
        loc3PriceTF = new TextField();
        item1PriceTF  = new TextField();
        item2PriceTF = new TextField();
        item3PriceTF = new TextField();
        List<Label> priceL = new ArrayList<Label>(
            Arrays.asList(loc1PriceL, loc2PriceL, loc3PriceL, item1PriceL, item2PriceL, item3PriceL));
        List<TextField> priceTF = new ArrayList<TextField>(
            Arrays.asList(loc1PriceTF, loc2PriceTF, loc3PriceTF, item1PriceTF, item2PriceTF, item3PriceTF));
        for(int x = 1 ; x <= 5 ; x+=2){
            for(int y = 5 ; y < 7 ; y++){
                GridPane.setConstraints(priceL.get(counter), x, y);
                GridPane.setConstraints(priceTF.get(counter), x, y);
                GridPane.setConstraints(priceL.get(counter+1), x, y);
                GridPane.setConstraints(priceTF.get(counter+1), x, y);
                counter+=2;
            }
        }

        


        return auto;
    }

    private VBox sideMenu(){
        VBox menu = new VBox();
        menu.setPrefHeight(50);
        btManualBudget = new Button();
        btAutoBudget = new Button();
        btLoan = new Button();
        List<Button> menuButtons = new ArrayList<Button>(
            Arrays.asList(btManualBudget, btAutoBudget, btLoan));

        int counter = 0;
        for(Button x : menuButtons) {
            Image temp_img = new Image(Try.class.getResourceAsStream("/src/" + counter + ".png"));
            ImageView temp_showImg = new ImageView(temp_img);
            temp_showImg.setPreserveRatio(true);
            temp_showImg.setFitHeight(45);
            temp_showImg.setFitWidth(45);
            x.setGraphic(temp_showImg);
            x.setStyle("-fx-background-color:#04060C");
            x.setPrefSize(45, 50);
            Pane tempPaneIndicator = new Pane();
            tempPaneIndicator.setPrefSize(5, 50);
            tempPaneIndicator.setStyle("-fx-background-color:#04060C");
            changeColorMenu(x, tempPaneIndicator);
            HBox tempHBox = new HBox(tempPaneIndicator, x);
            menu.getChildren().add(tempHBox);
            counter++;
        }
        menu.setAlignment(Pos.CENTER);
        menu.setStyle("-fx-background-color:#04060C");

        btManualBudget.setOnAction(e -> {
            border.setCenter(manualBudget());
        });
        btAutoBudget.setOnAction(f -> {
            border.setCenter(autoBudget());
            System.out.println("AUTO");
        });
        btLoan.setOnAction(g -> {
            border.setCenter(loan());
            System.out.println("SWITCH");
        });
        return menu;
    }

    private void changeColorMenu(Button b, Pane p){
        b.setOnMouseEntered(e -> {
            b.setStyle("-fx-background-color:black");
            p.setStyle("-fx-background-color:#fbfcfc");
        });
        b.setOnMouseExited(e -> {
            b.setStyle("-fx-background-color:#04060C");
            p.setStyle("-fx-background-color:#04060C");
        });
    }

    public void countBudget(){
        System.out.println("Counted the budget.");
        totalBudget.setText(budgetAmount.getText());

    }

    public void addListener(ChoiceBox<Integer> c){
        c.getSelectionModel().selectedItemProperty().addListener(
            (v, oldValue, newValue) -> countBudget());
    }

    public void closeProgram(){
        if(ConfirmBox.display("Exit", "Are you sure you want to exit?")){
            window.close();
        }
    }
}