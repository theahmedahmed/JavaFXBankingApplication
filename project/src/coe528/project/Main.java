package coe528.project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author Ahmed Ahmed
 */
public class Main extends Application {
    BankApp app = new BankApp();
    Scene scene1,scene2,scene3,scene4,scene5,scene6,scene7,scene8,scene9,scene10;
    Label label7 = new Label("");
    
    @Override
    public void start(Stage primaryStage) {
        //For scene 1
        Label label1 = new Label("Login as Manager or Customer?");
        Button btn1 = new Button("Manager");
        btn1.setOnAction(e -> primaryStage.setScene(scene2));
        Button btn2 = new Button("Customer");
        btn2.setOnAction(e -> primaryStage.setScene(scene3));
        
        //For scene 2
        Label label2 = new Label("Enter the username and password.\n\nUsername");
        TextField user = new TextField();
        Label label3 = new Label("Password");
        TextField pass = new TextField();
        Button btn3 = new Button("Login");
        btn3.setOnAction(e -> {
            if(app.managerLogin(user.getText(),pass.getText())){
                primaryStage.setScene(scene4);
                user.clear();
                pass.clear();
            }
            else
                AlertBox.display("Error", "The username and/or password is invalid.");
        });
        Button btn5 = new Button("Back");
        btn5.setOnAction(e -> primaryStage.setScene(scene1));
        
        
        //For scene 3
        //Same label2,user,label3,pass,btn5
        Label label23 = new Label("Enter the username and password.\n\nUsername");
        TextField user3 = new TextField();
        Label label33 = new Label("Password");
        TextField pass3 = new TextField();
        Button btn4 = new Button("Login");
        btn4.setOnAction(e -> {
            if(app.customerLogin(user3.getText(),pass3.getText())){
                //label7 = new Label("Customer: " + app.getUsername() + "Level: " + app.getLevel());
                label7.setText("Customer: " + app.getUsername() + " " + "Level: " + app.getLevel());
                primaryStage.setScene(scene7);
                user3.clear();
                pass3.clear();
            }
            else
                AlertBox.display("Error", "The username and/or password is invalid.");
        });
        Button btn53 = new Button("Back");
        btn53.setOnAction(e -> primaryStage.setScene(scene1));
        
        //For scene 4
        Label label4 = new Label("Manager: admin");
        Button btn6 = new Button("Add Customer");
        btn6.setOnAction(e -> primaryStage.setScene(scene5));
        Button btn7 = new Button("Delete Customer");
        btn7.setOnAction(e -> primaryStage.setScene(scene6));
        Button btn8 = new Button("Logout");
        btn8.setOnAction(e -> primaryStage.setScene(scene1));
        
        //For scene 5
        //Use label2,user,label3,pass
        Label label5 = new Label("Enter the username and password.\n\nUsername");
        Label label52 = new Label("Password");
        TextField user5 = new TextField();
        TextField pass5 = new TextField();
        Button btn9 = new Button("Add Customer");
        Button btn11 = new Button("Back");
        btn9.setOnAction(e -> {
            if(app.addcustomer(user5.getText(), pass5.getText())){
                primaryStage.setScene(scene4);
                user5.clear();
                pass5.clear();
            }
            else
                AlertBox.display("Error", "Username entered is already used.");
        });
        btn11.setOnAction(e -> primaryStage.setScene(scene4));
        
        //For scene 6
        TextField user6 = new TextField();
        Label label6 = new Label("Enter username to be deleted.\n\nUsername");
        Button btn10 = new Button("Delete Customer");
        btn10.setOnAction(e -> {
            if(app.deletecustomer(user6.getText())){
                primaryStage.setScene(scene4);
                user6.clear();
            }
            else
                AlertBox.display("Error", "Username entered does not exist.");
        });
        Button btn112 = new Button("Back");
        btn112.setOnAction(e -> primaryStage.setScene(scene4));
        
        //For scene 7
        //label7 = new Label("Customer: " + app.getUsername());
        Button btn12 = new Button("Deposit");
        btn12.setOnAction(e -> primaryStage.setScene(scene8));
        Button btn13 = new Button("Withdraw");
        btn13.setOnAction(e -> primaryStage.setScene(scene9));
        Button btn14 = new Button("Get Balance");
        btn14.setOnAction(e -> AlertBox.display("Balance", "Your balance is: " + String.format("%.2f", app.getBalance())));
        Button btn15 = new Button("Do Online Purchases");
        btn15.setOnAction(e -> primaryStage.setScene(scene10));
        Button btn16 = new Button("Logout");
        btn16.setOnAction(e -> primaryStage.setScene(scene1));
        
        //For scene 8
        Label label8 = new Label("Enter the amount you want to deposit.");
        TextField user8 = new TextField();
        Button btn17 = new Button("Deposit");
        btn17.setOnAction(e -> {
            try{
                if(app.deposit(Double.parseDouble(user8.getText()))){
                    label7.setText("Customer: " + app.getUsername() + " " + "Level: " + app.getLevel());
                    primaryStage.setScene(scene7);
                    user8.clear();
                }
                
                else
                    AlertBox.display("Error", "The amount entered was negative.");
            }
            catch(NumberFormatException | NullPointerException ex){
                AlertBox.display("Error", "Enter a number.");
            }
        });
        Button btn20 = new Button("Back");
        btn20.setOnAction(e -> primaryStage.setScene(scene7));
        
        //For scene 9
        Label label9 = new Label("Enter the amount you want to withdraw.");
        TextField user9 = new TextField();
        Button btn18 = new Button("Withdraw");
        btn18.setOnAction(e -> {
            try{
                if(app.withdraw(Double.parseDouble(user9.getText()))){
                    label7.setText("Customer: " + app.getUsername() + " " + "Level: " + app.getLevel());
                    primaryStage.setScene(scene7);
                    user9.clear();
                }
                
                else
                    AlertBox.display("Error", "The amount entered was more than the balance or negative.");
            }
            catch(NumberFormatException | NullPointerException ex){
                AlertBox.display("Error", "Enter a number.");
            }
        });
        Button btn201 = new Button("Back");
        btn201.setOnAction(e -> primaryStage.setScene(scene7));
        
        //For scene 10
        Label label10 = new Label("Enter the amount.");
        TextField user10 = new TextField();
        Button btn19 = new Button("Pay");
        btn19.setOnAction(e -> {
            try{
                if(app.doOnlinePurchase(Double.parseDouble(user10.getText()))){
                    label7.setText("Customer: " + app.getUsername() + " " + "Level: " + app.getLevel());
                    primaryStage.setScene(scene7);
                    user10.clear();
                }
                
                else
                    AlertBox.display("Error", "The amount entered was less than 50, more than the balance, or negative.");
            }
            catch(NumberFormatException | NullPointerException ex){
                AlertBox.display("Error", "Enter a number.");
            }
        });
        Button btn202 = new Button("Back");
        btn202.setOnAction(e -> primaryStage.setScene(scene7));
        
        //Scene 1
        HBox root = new HBox(10);
        root.getChildren().addAll(label1, btn1, btn2);
        scene1 = new Scene(root, 400, 60);
        
        //Scene 2
        VBox layout2 = new VBox(10);
        layout2.getChildren().addAll(label2,user,label3,pass,btn3,btn5);
        scene2 = new Scene(layout2, 300, 300);
        
        
        //Scene 3
        VBox layout3 = new VBox(10);
        layout3.getChildren().addAll(label23,user3,label33,pass3,btn4,btn53);
        scene3 = new Scene(layout3, 300, 300);
        
        //Scene 4
        VBox layout4 = new VBox(10);
        layout4.getChildren().addAll(label4,btn6,btn7,btn8);
        scene4 = new Scene(layout4, 300, 300);
        
        //Scene 5
        VBox layout5 = new VBox(10);
        layout5.getChildren().addAll(label5,user5,label52,pass5,btn9,btn11);
        scene5 = new Scene(layout5, 300, 300);
        
        //Scene 6
        VBox layout6 = new VBox(10);
        layout6.getChildren().addAll(label6,user6,btn10,btn112);
        scene6 = new Scene(layout6, 300, 300);
        
        //Scene 7
        VBox layout7 = new VBox(10);
        layout7.getChildren().addAll(label7,btn12,btn13,btn14,btn15,btn16);
        scene7 = new Scene(layout7, 300, 300);
        
        //Scene 8
        VBox layout8 = new VBox(10);
        layout8.getChildren().addAll(label8,user8,btn17,btn20);
        scene8 = new Scene(layout8, 300, 300);
        
        //Scene 9
        VBox layout9 = new VBox(10);
        layout9.getChildren().addAll(label9,user9,btn18,btn201);
        scene9 = new Scene(layout9, 300, 300);
        
        //Scene 10
        VBox layout10 = new VBox(10);
        layout10.getChildren().addAll(label10,user10,btn19,btn202);
        scene10 = new Scene(layout10, 300, 300);
        
        primaryStage.setTitle("Bank Application");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

/*
        Button btn = new Button("Say 'Hello World'");
        btn.setOnAction(e -> {
            System.out.println("Hello World!");
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 300);
        
        primaryStage.setTitle("Bank Application");
        primaryStage.setScene(scene);
        primaryStage.show();
*/