import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.*;
import javafx.scene.image.*;
import javafx.geometry.*;
import java.util.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Main extends Application {

	Stage window;
    Scene mainScene, adminScene, userScene;
    String prevScene = "";
    GridPane border;
    //Admin's
    BorderPane adminBorderPane;
    Button createCategory, createItem, orderList, logoutAdmin;
    //User's
    BorderPane userBorderPane;
    Button rentItem, rentList, logoutUser; 

    public static void main(String[] args) {
         Application.launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Toys Rent | Home Page");

        border = new GridPane();
        border.setStyle("-fx-background-color:#4cbcd4");
        border.setAlignment(Pos.CENTER);
        border.getChildren().addAll(homePage());
        mainScene = new Scene(border, 500, 500);
        
        window.setScene(mainScene);
        window.show();
    }

    //Starting Page
    private VBox homePage(){
        VBox labelbutton = new VBox(10);
        HBox buttongrid = new HBox(75);
        labelbutton.setAlignment(Pos.CENTER);
        buttongrid.setAlignment(Pos.CENTER);
        labelbutton.setStyle("-fx-background-color:#4cbcd4");

        //Welcome text, prompt log-in
        Text welcome = new Text("Welcome to Toys Rent");
        welcome.setFont(Font.font("Abel", FontWeight.BOLD, 20));
        welcome.setFill(Color.WHITE);
        Text login = new Text("Who would you log-in as?");
        login.setFont(Font.font("Abel", FontWeight.BOLD, 20));
        login.setFill(Color.WHITE);

        Button anggota = new Button("Anggota");
        anggota.setPrefSize(75, 5);
        Button admin = new Button("Admin");
        admin.setPrefSize(75, 5);

        buttongrid.getChildren().addAll(anggota, admin);
        labelbutton.getChildren().addAll(welcome, login, buttongrid);

        //for back button
        prevScene = "HomePage";

        //Action Handling
        anggota.setOnAction(e -> {
            loginUser();
        });
        admin.setOnAction(e -> {
            loginAdmin();
        });
        
        return labelbutton;
    }
    
    //Logged in as Admin
    private void loginAdmin(){
        adminScene = new Scene(adminPage(), 500, 500);
        window.setHeight(500);
        window.setWidth(500);
        window.setScene(adminScene);
    }

    //Admin Borderpane in preparation for sidemenu and scenes 
    private BorderPane adminPage(){
        adminBorderPane = new BorderPane();
        adminBorderPane.setLeft(topMenuAdmin());
        adminBorderPane.setCenter(adminScene());      
        return adminBorderPane;
    }

    //The side-menu
    private VBox topMenuAdmin(){
        VBox menu = new VBox();
        menu.setPrefWidth(125);
        
        Text adminHello = new Text("Admin\nPage");
        adminHello.setFont(Font.font("Abel", FontWeight.SEMI_BOLD, 20));
        adminHello.setFill(Color.WHITE);
        adminHello.setStyle("-fx-background-color:white");
        menu.getChildren().add(adminHello);
        
        //Buttons so it could be pressed
        createCategory = new Button();
        createItem = new Button();
        orderList = new Button();
        logoutAdmin = new Button();
        List<Button> menuButtons = new ArrayList<Button>(
            Arrays.asList(createCategory, createItem, orderList, logoutAdmin));
        
        //Labels to inform people
        Label createCategoryText = new Label("Create Category");
        Label createItemText = new Label("Create Item");
        Label orderListText = new Label("Order List");
        Label logoutText = new Label("Log out");
        List<Label> buttonText = new ArrayList<Label>(
            Arrays.asList(createCategoryText, createItemText, orderListText, logoutText));

        //To set up images, labels, and Indicator
        HBox createCategoryBox = new HBox();
        HBox createItemBox = new HBox();
        HBox orderListBox = new HBox();
        HBox logoutBox = new HBox();
        List<HBox> boxes = new ArrayList<HBox>(
            Arrays.asList(createCategoryBox, createItemBox, orderListBox, logoutBox));
        
        
        //set up the buttons, images, and Labels 
        for(Button x : menuButtons) {
            Integer counter = menuButtons.indexOf(x);
            Image temp_img = new Image(Main.class.getResourceAsStream("/src/AdminWhite" + counter + ".png"));
            ImageView temp_showImg = new ImageView(temp_img);
            temp_showImg.setFitHeight(25);
            temp_showImg.setFitWidth(25);
            
            x.setGraphic(temp_showImg);
            x.setStyle("-fx-background-color:#3c4b5a");
            x.setPrefSize(20, 25);
            
            Pane tempPaneIndicator = new StackPane();
            tempPaneIndicator.setPrefSize(5, 25);
            tempPaneIndicator.setStyle("-fx-background-color:#3c4b5a");
            Label counts = new Label(" ");
            tempPaneIndicator.getChildren().add(counts);
            
            Label temp_text = buttonText.get(counter);
            temp_text.setTextFill(Color.WHITE);
            temp_text.setFont(Font.font("Abel", FontWeight.SEMI_BOLD, 10));
            
            boxes.get(counter).setAlignment(Pos.CENTER_LEFT);
            boxes.get(counter).getChildren().addAll(tempPaneIndicator, x, temp_text);
            //Indicator creation
            changeColorMenu(boxes.get(counter), x, tempPaneIndicator, temp_text, counter);
            menu.getChildren().add(boxes.get(counter));
        }

        menu.setAlignment(Pos.TOP_CENTER);
        menu.setStyle("-fx-background-color:#3c4b5a");

        //Action Handling
        createCategoryBox.setOnMouseClicked(e -> {
            adminBorderPane.setCenter(adminCreateCategory());
        });
        createItemBox.setOnMouseClicked(e -> {
            adminBorderPane.setCenter(adminCreateItem());
        });
        orderListBox.setOnMouseClicked(e -> {
            adminBorderPane.setCenter(adminOrderList());
        });


        logoutBox.setOnMouseClicked(e -> {
            window.setTitle("Toys Rent | Home Page");
            window.setScene(mainScene);
            window.setWidth(500);
            window.setHeight(500);
        });

        return menu;
    }

    //Color changer setter for the indicator in side menu
    private void changeColorMenu(HBox box, Button b, Pane p, Label x, int counter){
        box.setOnMouseEntered(e -> {
            box.setStyle("-fx-background-color:#465869");
            b.setStyle("-fx-background-color:#465869");
            x.setStyle("-fx-background-color:#465869");
            p.setStyle("-fx-background-color:#fbfcfc");
        });
        box.setOnMouseExited(e -> {
            box.setStyle("-fx-background-color:#3c4b5a");
            b.setStyle("-fx-background-color:#3c4b5a");
            x.setStyle("-fx-background-color:#3c4b5a");
            p.setStyle("-fx-background-color:#3c4b5a");
        });
    }

    //Admin's homepage
    private GridPane adminScene(){
        window.setTitle("Toys Rent | Admin Panel");
        GridPane temp = new GridPane();
        temp.setStyle("-fx-background-color:#4cbcd4");

        //Welcome text
        Text welcome = new Text("Welcome to the Administrator Page!\nUse the button on the left for activity.");
        welcome.setFont(Font.font("Abel", FontWeight.SEMI_BOLD, 20));
        welcome.setFill(Color.WHITE);
        welcome.setTextAlignment(TextAlignment.CENTER);

        temp.setAlignment(Pos.CENTER);
        temp.getChildren().add(welcome);
        return temp;
    }

    //Admin Create Category Scene
    private GridPane adminCreateCategory(){
        window.setTitle("Admin | Create Category Panel");
        GridPane catCreate = new GridPane();
        catCreate.setPadding(new Insets(10, 10, 10, 10));
        catCreate.setHgap(10);
        catCreate.setVgap(10);
        catCreate.setStyle("-fx-background-color:#4cbcd4");
        catCreate.setAlignment(Pos.CENTER_LEFT);

        //Labels and TextFields
        Text createNewCat = new Text("Create a new Category");
        createNewCat.setFont(Font.font("Abel", FontWeight.SEMI_BOLD, 20));
        createNewCat.setFill(Color.WHITE);

        Label name = new Label("Name ");
        name.setFont(Font.font("Abel", FontWeight.SEMI_BOLD, 12));
        name.setTextFill(Color.WHITE);

        TextField nameField = new TextField();

        Button create = new Button("Create Category");
        Button back = new Button("Back");
        catCreate.setHalignment(back, HPos.RIGHT);

        Label added = new Label("Category has been added");
        setTextWhite12(added);
        added.setAlignment(Pos.CENTER);
        Label exist = new Label("Category already exist");
        setTextWhite12(exist);
        exist.setAlignment(Pos.CENTER);

        //Positioning
        catCreate.setConstraints(createNewCat, 0, 0, 3, 1);
        catCreate.setConstraints(name, 0, 1);
        catCreate.setConstraints(nameField, 1, 1, 2, 1);
        catCreate.setConstraints(create, 0, 2, 2, 1);
        catCreate.setConstraints(back, 2, 2);

        //Action Handling
        back.setOnAction(e -> {
            goBack();
            prevScene = "AdminCreateCategory";
        });
        create.setOnAction(e -> {
            //Remove the labels, if needed add them back again
            catCreate.getChildren().remove(added);
            catCreate.getChildren().remove(exist);
            if(Admin.createKategori(nameField.getText())){
                catCreate.setConstraints(added, 0, 3, 3, 1);
                catCreate.getChildren().add(added);
                nameField.clear();
            } else {
                catCreate.setConstraints(exist, 0, 3, 3, 1);
                catCreate.getChildren().add(exist);
            }
        });
        
        catCreate.getChildren().addAll(createNewCat, name, nameField, create, back);
        return catCreate;
    }

    //Admin Create Item Scene
    private GridPane adminCreateItem(){
        window.setTitle("Admin | Create Item Panel");
        GridPane itCreate = new GridPane();
        itCreate.setPadding(new Insets(10, 10, 10, 10));
        itCreate.setHgap(10);
        itCreate.setVgap(10);
        itCreate.setStyle("-fx-background-color:#4cbcd4");
        itCreate.setAlignment(Pos.CENTER_LEFT);
        
        //Text, Labels, comboBox, TextFields, and  Buttons
        Text createNewCat = new Text("Create a new Item");
        createNewCat.setFont(Font.font("Abel", FontWeight.SEMI_BOLD, 20));
        createNewCat.setFill(Color.WHITE);

        Label categoryL = new Label("Category");
        setTextWhite12(categoryL);
        Label nameL = new Label("Name");
        setTextWhite12(nameL);
        
        ComboBox<String> categoryCB = new ComboBox<String>();
        categoryCB.getItems().addAll(Admin.getNamaKategori());
        categoryCB.getSelectionModel().selectFirst();
        TextField nameTF = new TextField();

        Button create = new Button("Create Item");
        Button back = new Button("Back");
        itCreate.setHalignment(back, HPos.RIGHT);

        Label added = new Label("Item has been added");
        setTextWhite12(added);
        added.setAlignment(Pos.CENTER);
        Label exist = new Label("Item already exist");
        setTextWhite12(exist);
        exist.setAlignment(Pos.CENTER);

        //Action Handling
        back.setOnAction(e -> {
            goBack();
            prevScene = "AdminCreateItem";
        });
        create.setOnAction(e -> {
            //Remove the labels. If needed, add them back again
            itCreate.getChildren().remove(added);
            itCreate.getChildren().remove(exist);
            if(Admin.createBarang(categoryCB.getValue(), nameTF.getText())){
                itCreate.setConstraints(added, 0, 4, 3, 1);
                itCreate.getChildren().add(added);
                nameTF.clear();
            } else {
                itCreate.setConstraints(exist, 0, 4, 3, 1);
                itCreate.getChildren().add(exist);
            }
        });

        itCreate.setConstraints(createNewCat, 0, 0, 3, 1);
        itCreate.setConstraints(categoryL, 0, 1);
        itCreate.setConstraints(categoryCB, 1, 1, 2, 1);
        itCreate.setConstraints(nameL, 0, 2);
        itCreate.setConstraints(nameTF, 1, 2, 2, 1);
        itCreate.setConstraints(create, 0, 3, 2, 1);
        itCreate.setConstraints(back, 2, 3);
        itCreate.getChildren().addAll(createNewCat, categoryL, categoryCB, nameL,
                                    nameTF, create, back);
        return itCreate;
    }

    //Admins Order List Scene
    private GridPane adminOrderList(){
        window.setTitle("Admin | Order List Panel");
        GridPane oList = new GridPane();
        oList.setPadding(new Insets(10, 10, 10, 10));
        oList.setHgap(10);
        oList.setVgap(10);
        oList.setStyle("-fx-background-color:#4cbcd4");
        oList.setAlignment(Pos.CENTER_LEFT);

        //Labels and Buttons
        Label categoryL = new Label("Category");
        setTextWhite12(categoryL);
        Label itemL = new Label("Item");
        setTextWhite12(itemL);
        Label acceptL = new Label("Accept");
        setTextWhite12(acceptL);
        Label declineL = new Label("Decline");
        setTextWhite12(declineL);

        oList.setConstraints(categoryL, 0, 0);
        oList.setConstraints(itemL, 1, 0);
        oList.setConstraints(acceptL, 2, 0);
        oList.setConstraints(declineL, 3, 0);

        //Table of orders with buttons to either acccept or decline
        int counter = 1;
        for(Barang x : Admin.getPendingBarang()){
            Label temp_category = new Label(x.getNamaKategori());
            Label temp_nama = new Label(x.getNama());
            setTextWhite12(temp_category);
            setTextWhite12(temp_nama);
            oList.setConstraints(temp_category, 0, counter);
            oList.setConstraints(temp_nama, 1, counter);
            Button temp_acc = new Button("Accept");
            Button temp_dec = new Button("Decline");
            oList.setConstraints(temp_acc, 2, counter);
            oList.setConstraints(temp_dec, 3, counter);

            //Action Handling
            temp_acc.setOnAction(e -> {
                accepted(x, temp_acc, temp_dec);
            });
            temp_dec.setOnAction(e -> {
                declined(x, temp_acc, temp_dec);
            });
            
            oList.getChildren().addAll(temp_category, temp_nama, temp_acc, temp_dec);
            counter++;
        }
        
        //Preparation for back button
        prevScene = "AdminOrderList";

        oList.getChildren().addAll(categoryL, itemL, acceptL, declineL);
        return oList;
    }

    //In case the admin accepts the order, remove the order from orderlist as it get replaced with acceptedOrder
    private void accepted(Barang x, Button accept, Button decline){
        for(int index = 0; index < Anggota.getListPemesanan().size(); index ++){
            if(Anggota.getListPemesanan().get(index).getBarang().equals(x)){
                Anggota.getListPemesanan().remove(Anggota.getListPemesanan().get(index));
            }
        }
        x.changeStatusDipinjam();
        Anggota.addPemesananBerhasil(x);
        Admin.getPendingBarang().remove(x);
        accept.setDisable(true);
        decline.setDisable(true);
    }

    //In case the admin declines the order, remove the order from orderlist as it get replaced with declinedOrder
    private void declined(Barang x, Button accept, Button decline){
        for(int index = 0; index < Anggota.getListPemesanan().size(); index ++){
            if(Anggota.getListPemesanan().get(index).getBarang().equals(x)){
                Anggota.getListPemesanan().remove(Anggota.getListPemesanan().get(index));
            }
        }
        x.changeStatusDisewakan();
        Anggota.addPemesananDitolak(x);
        Admin.getPendingBarang().remove(x);
        accept.setDisable(true);
        decline.setDisable(true);
    }

    //Beautifier setter
    private void setTextWhite12(Label l){
        l.setFont(Font.font("Abel", FontWeight.SEMI_BOLD, 12));
        l.setTextFill(Color.WHITE);
    }

    //Log-in as a User
    private void loginUser(){
        userScene = new Scene(userPage(), 500, 500);
        window.setHeight(500);
        window.setWidth(500);
        window.setScene(userScene);
    }

    //User Home Page setup for sidemenu and scenes
    private BorderPane userPage(){
        userBorderPane = new BorderPane();
        userBorderPane.setLeft(topMenuUser());
        userBorderPane.setCenter(userScene());      
        return userBorderPane;
    }

    //User's Home Page
    private GridPane userScene(){        
        window.setTitle("Toys Rent | User Panel");
        GridPane temp = new GridPane();
        temp.setStyle("-fx-background-color:#4cbcd4");

        //Information and Instructions
        Text welcome = new Text("Welcome to the User Page!\nUse the button on the left for activity.");
        welcome.setFont(Font.font("Abel", FontWeight.SEMI_BOLD, 20));
        welcome.setFill(Color.WHITE);
        welcome.setTextAlignment(TextAlignment.CENTER);

        temp.setAlignment(Pos.CENTER);
        temp.getChildren().add(welcome);
        return temp;
    }

    //User's Side menu
    private VBox topMenuUser(){
        VBox menu = new VBox();
        menu.setPrefWidth(125);
        
        //Greeting for user
        Text userHello = new Text("User\nPage");
        userHello.setFont(Font.font("Abel", FontWeight.SEMI_BOLD, 20));
        userHello.setFill(Color.WHITE);
        userHello.setStyle("-fx-background-color:white");
        menu.getChildren().add(userHello);
        
        //Buttons, Labels, and HBox for the images, Indicator, and Labels
        rentItem = new Button();
        rentList = new Button();
        logoutUser = new Button();
        List<Button> menuButtons = new ArrayList<Button>(
            Arrays.asList(rentItem, rentList, logoutUser));
        
        Label rentItemText = new Label("Rent Item");
        Label rentListText = new Label("Order List");
        Label logoutText = new Label("Log out");
        List<Label> buttonText = new ArrayList<Label>(
            Arrays.asList(rentItemText, rentListText, logoutText));

        HBox rentItemBox = new HBox();
        HBox rentListBox = new HBox();
        HBox logoutBox = new HBox();
        List<HBox> boxes = new ArrayList<HBox>(
            Arrays.asList(rentItemBox, rentListBox, logoutBox));
        
        //Creation for the sideMenu Buttons
        for(Button x : menuButtons) {
            Integer counter = menuButtons.indexOf(x);
            Image temp_img = new Image(Main.class.getResourceAsStream("/src/userWhite" + counter + ".png"));
            ImageView temp_showImg = new ImageView(temp_img);
            temp_showImg.setFitHeight(25);
            temp_showImg.setFitWidth(25);
            
            x.setGraphic(temp_showImg);
            x.setStyle("-fx-background-color:#3c4b5a");
            x.setPrefSize(20, 25);
            
            Pane tempPaneIndicator = new StackPane();
            tempPaneIndicator.setPrefSize(5, 25);
            tempPaneIndicator.setStyle("-fx-background-color:#3c4b5a");
            Label counts = new Label(" ");
            tempPaneIndicator.getChildren().add(counts);
            
            Label temp_text = buttonText.get(counter);
            temp_text.setTextFill(Color.WHITE);
            temp_text.setFont(Font.font("Abel", FontWeight.SEMI_BOLD, 10));
            
            boxes.get(counter).setAlignment(Pos.CENTER_LEFT);
            boxes.get(counter).getChildren().addAll(tempPaneIndicator, x, temp_text);
            //Indicator setter
            changeColorMenu(boxes.get(counter), x, tempPaneIndicator, temp_text, counter);
            menu.getChildren().add(boxes.get(counter));
        }

        menu.setAlignment(Pos.TOP_CENTER);
        menu.setStyle("-fx-background-color:#3c4b5a");

        //Action Handling
        rentItemBox.setOnMouseClicked(e -> {
            userBorderPane.setCenter(userRentItem());
        });
        rentListBox.setOnMouseClicked(e -> {
            userBorderPane.setCenter(userOrderList());
        });
        logoutBox.setOnMouseClicked(e -> {
            window.setTitle("Toys Rent | Home Page");
            window.setScene(mainScene);
            window.setWidth(500);
            window.setHeight(500);
        });

        return menu;
    }

    //getter for Item's name for ListView items
    public ObservableList<String> getNamaBarang(Kategori cat){
        ObservableList<String> items = FXCollections.observableArrayList();
        if(cat.getListBarang().isEmpty()) return null;
        for(Barang y : cat.getListBarang()){
            if(y.isDisewakan())items.add(y.getNama());
        }
        return items;
    }

    //User's Rent Item Scene
    private GridPane userRentItem(){
        window.setTitle("User | Rent Item Panel");
        GridPane itRent = new GridPane();
        itRent.setPadding(new Insets(10, 10, 10, 10));
        itRent.setHgap(10);
        itRent.setVgap(10);
        itRent.setStyle("-fx-background-color:#4cbcd4");
        itRent.setAlignment(Pos.CENTER_LEFT);
        
        //Text and Buttons for User Input
        Text chooseItem = new Text("Select an Item");
        chooseItem.setFont(Font.font("Abel", FontWeight.SEMI_BOLD, 20));
        chooseItem.setFill(Color.WHITE);
        
        Button rentItem = new Button("Rent Item");
        Button back = new Button("Back");
        
        //Creation of Multiple Table and its items
        int count = 0;
        ArrayList<ListView<String>> tableList = new ArrayList<ListView<String>>();
        if(Admin.getListKategori()!=null){
            for(Kategori category : Admin.getListKategori()){
                Label cat = new Label(category.getNama());
                setTextWhite12(cat);
                ListView<String> temp_table = new ListView<String>();
                temp_table.setItems(getNamaBarang(category));
                temp_table.setPrefWidth(100);
                tableList.add(temp_table);
                itRent.setConstraints(cat, count, 2);
                itRent.setConstraints(temp_table, count, 3);
                itRent.getChildren().addAll(temp_table, cat);
                count++;
            }
            //Enable multiple selections
            for(ListView<String> tables : tableList){
                tables.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            }
        }

        //Action Handling
        back.setOnAction(e -> {
            goBack();
            prevScene = "UserRentItem";
        });
        rentItem.setOnAction(e -> processRentItem(tableList));
        itRent.setConstraints(rentItem, 0, 4);
        itRent.setConstraints(back, 1, 4);
        itRent.setConstraints(chooseItem, 0, 1, 3, 1);
        itRent.getChildren().addAll(chooseItem, rentItem, back);
        return itRent;
    }

    //Process the user input for items they want to rent
    private void processRentItem(ArrayList<ListView<String>> tableList){
        for(int index = 0; index < tableList.size(); index++){
            ListView<String> tables = tableList.get(index);
            Kategori currentCat = Admin.getListKategori().get(index);       //Category index = Table Index
            ObservableList<String> allItem, selectedItem;
            allItem = tables.getItems();                                    //Whole items in the table(ListView)
            selectedItem = tables.getSelectionModel().getSelectedItems();   //Obtain selected items
            for(String itemName : currentCat.getNamaBarangDisewakan()){
                for(String selectedName : selectedItem){
                    if(itemName.equals(selectedName)){
                        Barang item = currentCat.findBarang(selectedName);  //changes the item's status
                        item.changeStatusMenunggu();
                        Admin.getPendingBarang().add(item);                 //add the item to Admin's orderList
                        Anggota.getListPemesanan().add(new Pemesanan(item, item.getStatus()));  //add the item to the 'cart'
                    }
                }
            }
        }
        refreshTable(tableList);    //updates the table's items
    }

    //To Update the items within the table
    private void refreshTable(ArrayList<ListView<String>> tableList){
        for(int index = 0; index < tableList.size(); index++){
            ListView<String> tables = tableList.get(index);
            Kategori currentCat = Admin.getListKategori().get(index);
            tables.setItems(getNamaBarang(currentCat));
        }
    }
    
    //User's cart
    private GridPane userOrderList(){
        window.setTitle("User | Rent List Panel");
        GridPane userOrderList = new GridPane();
        userOrderList.setPadding(new Insets(10, 10, 10, 10));
        userOrderList.setHgap(10);
        userOrderList.setVgap(10);
        userOrderList.setStyle("-fx-background-color:#4cbcd4");
        userOrderList.setAlignment(Pos.CENTER_LEFT);

        //Labels and positions
        Label categoryL = new Label("Category");
        setTextWhite12(categoryL);
        Label itemL = new Label("Item");
        setTextWhite12(itemL);
        Label statusL = new Label("Status");
        setTextWhite12(statusL);

        userOrderList.setConstraints(categoryL, 0, 0);
        userOrderList.setConstraints(itemL, 1, 0);
        userOrderList.setConstraints(statusL, 2, 0);

        Button back = new Button("Back");
        
        //Creation of the Tablec consisting items and its status
        int counter = 1;
        for(Pemesanan x : Anggota.getListPemesanan()){
            Label temp_category = new Label(x.getBarang().getNamaKategori());
            Label temp_nama = new Label(x.getBarang().getNama());
            Label temp_status = new Label(x.getStatus());
            setTextWhite12(temp_category);
            setTextWhite12(temp_nama);
            setTextWhite12(temp_status);
            userOrderList.setConstraints(temp_category, 0, counter);
            userOrderList.setConstraints(temp_nama, 1, counter);
            userOrderList.setConstraints(temp_status, 2, counter);
            userOrderList.getChildren().addAll(temp_category, temp_nama, temp_status);
            counter++;
        }
        
        //Action Handling
        back.setOnAction(e -> {
            goBack();
            prevScene = "UserOrderList";
        });
        
        userOrderList.setConstraints(back, 0, counter);
        userOrderList.getChildren().addAll(categoryL, itemL, statusL, back);
        return userOrderList;
    }

    //the back button commands
    private void goBack(){
        if(prevScene.equals("HomePage")){
            window.setScene(mainScene);
        } else if(prevScene.equals("AdminCreateCategory")){
            window.setScene(adminScene);
            adminBorderPane.setCenter(adminCreateCategory());
        } else if(prevScene.equals("AdminCreateItem")){
            window.setScene(adminScene);
            adminBorderPane.setCenter(adminCreateItem());
        } else if(prevScene.equals("AdminOrderList")){
                window.setScene(adminScene);
                adminBorderPane.setCenter(adminOrderList());
        } else if(prevScene.equals("UserRentItem")){
                window.setScene(userScene);
                userBorderPane.setCenter(userRentItem());
        } else if(prevScene.equals("UserOrderList")){
                window.setScene(userScene);
                userBorderPane.setCenter(userOrderList());
        }   
    }
}