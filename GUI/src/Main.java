import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



import java.awt.event.ActionListener;

public class Main extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage ) throws Exception {
        window = primaryStage;
        window.setTitle("Login");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel, 0, 0);

        TextField nameInput = new TextField("Name");
        GridPane.setConstraints(nameInput, 1,0);

        Button loginButton = new Button("Log In");
        GridPane.setConstraints(loginButton, 1, 2);
        loginButton.setOnAction(e -> mainMenu());

        Button createAccount = new Button("CreateAccount");
        GridPane.setConstraints(createAccount, 1,3);

        grid.getChildren().addAll(nameLabel,nameInput, loginButton, createAccount);

        Scene scene = new Scene(grid, 300, 200);
        window.setScene(scene);

        window.show();
    }

    public void mainMenu() {
        window.setTitle("Main Menu");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        Button viewStock = new Button("View Stock");
        GridPane.setConstraints(viewStock, 1, 1);
        viewStock.setOnAction(e -> viewStock());


        Button viewBalance = new Button("Balance");
        GridPane.setConstraints(viewBalance, 1,2);
        viewBalance.setOnAction(e -> viewBalance());

        Button buyStock = new Button("Buy Stock");
        GridPane.setConstraints(buyStock, 1,3);
        buyStock.setOnAction(e -> buyStock());

        Button sellStock = new Button("Sell Stock");
        GridPane.setConstraints(sellStock, 1,4);
        sellStock.setOnAction(e -> sellStock());

        grid.getChildren().addAll(viewStock,viewBalance, buyStock, sellStock);

        Scene scene = new Scene(grid, 300, 200);
        window.setScene(scene);

        window.show();
    }

    public void viewStock() {
        window.setTitle("View Stock");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        grid.add(new Label("Stock"), 0, 0);
        grid.add(new Label("Qty Owned"), 1, 0);
        grid.add(new Label("Bought Price"), 2, 0);
        grid.add(new Label("Current Price"), 3, 0);

        for (int i = 0; i <= 3; i++) {
            ColumnConstraints con = new ColumnConstraints();
            // Here we set the pref height of the row, but you could also use .setPercentHeight(double) if you don't know much space you will need for each label.
            con.setPrefWidth(200);
            grid.getColumnConstraints().add(con);
        }

        //insert code for adding data here using labels.

        Button back = new Button("Back");
        GridPane.setConstraints(back, 0,30);
        back.setOnAction(e -> mainMenu());

        grid.getChildren().addAll(back);

        Scene scene = new Scene(grid, 400, 300);
        window.setScene(scene);

        window.show();
    }
    public void viewBalance(){
        window.setTitle("View Balance");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        grid.add(new Label("User"), 0, 0);
        grid.add(new Label(""), 1, 0); //insert username here
        grid.add(new Label("Balance"), 0, 1);
        grid.add(new Label(""), 1, 1);// insert user balance here
        grid.add(new Label("Profit"), 0, 2);
        grid.add(new Label(""), 1, 2);//insert user profit here

        Button back = new Button("Back");
        GridPane.setConstraints(back, 0,20);
        back.setOnAction(e -> mainMenu());

        grid.getChildren().addAll(back);

        Scene scene = new Scene(grid, 400, 300);
        window.setScene(scene);

        window.show();
    }

    public void buyStock(){

        window.setTitle("Buy Stock");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        ChoiceBox<String> stockChoice = new ChoiceBox<>();
        GridPane.setConstraints(stockChoice, 0, 0);
        ChoiceBox<Integer> qtyChoice = new ChoiceBox<>();
        GridPane.setConstraints(qtyChoice, 0, 1);
        Button buy = new Button("Buy");
        GridPane.setConstraints(buy, 0,2);
        // insert buy action here buy.setOnAction(e -> );

        Button back = new Button("Back");
        GridPane.setConstraints(back, 0,20);
        back.setOnAction(e -> mainMenu());

        grid.getChildren().addAll(stockChoice, qtyChoice, buy, back);

        Scene scene = new Scene(grid, 400, 300);
        window.setScene(scene);

        window.show();

    }

    public void sellStock(){
        window.setTitle("Sell Stock");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        ChoiceBox<String> stockChoice = new ChoiceBox<>();
        GridPane.setConstraints(stockChoice, 0, 0);
        ChoiceBox<Integer> qtyChoice = new ChoiceBox<>();
        GridPane.setConstraints(qtyChoice, 0, 1);
        Button sell = new Button("Sell");
        GridPane.setConstraints(sell, 0,2);
        // insert buy action here buy.setOnAction(e -> );

        Button back = new Button("Back");
        GridPane.setConstraints(back, 0,20);
        back.setOnAction(e -> mainMenu());

        grid.getChildren().addAll(stockChoice, qtyChoice, sell, back);

        Scene scene = new Scene(grid, 400, 300);
        window.setScene(scene);

        window.show();
    }
}
