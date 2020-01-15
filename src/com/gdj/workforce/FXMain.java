/*
 * WorkForce: Mission Control
 */
package com.gdj.workforce;

import content.Worker;
import content.WorkerFile;  
import java.io.IOException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author G.D. Joyce
 * FXMain.java: main application for JavaFX application ' WorkForce: Mission Control '
 */

public class FXMain extends Application {
    // field declarations
    // pane
    private AnchorPane pane = new AnchorPane();
    // nodes
    private VBox mainBox = new VBox();
    private VBox topBox = new VBox();
    protected VBox sideBoxL = new VBox();
    protected VBox botBox = new VBox();
    protected HBox navButtons = new HBox();
    // leaves
    private HBox logoContainer = new HBox();
    private Label logo = new Label("Mission Control");     
    private Label company = new Label("by WorkForce");
    private HBox btnContainer = new HBox();
    private Button loginBtn = new Button("Login");
    private Button signUpBtn = new Button("Sign up");    
    protected Button createIt = new Button("Create Record");
    protected Label status = new Label();
    protected Button exit = new Button();
    protected Button btnCreate = new Button();
    protected Button btnView = new Button();
    protected Button btnUpdate = new Button();
    protected Button firstRecord = new Button("First");
    protected Button prevRecord = new Button("Previous");
    protected Button nextRecord = new Button("Next");
    protected Button lastRecord = new Button("Last");
    protected Button logout = new Button("Logout");
    protected Shape createLight = new Rectangle(180, 7);
    protected Shape viewLight = new Rectangle(180, 7);
    protected Shape updateLight = new Rectangle(180, 7);
    // Scene objects (GUI)
    private MakeCreate create = new MakeCreate();
    private MakeView view = new MakeView();
    private MakeUpdate update = new MakeUpdate();
    // Worker, WorkerFile objects (Logic)
    private Worker who = new Worker();
    private WorkerFile wFile = new WorkerFile();

    // Alert objects
    Alert error = new Alert(AlertType.ERROR);
    Alert confirmation = new Alert(AlertType.CONFIRMATION);
    Alert information = new Alert(AlertType.INFORMATION);
    Alert warning = new Alert(AlertType.WARNING);
    
    private int countCreate = 0;
    private int countView = 0;
    private int countUpdate = 0;
    
    
    // main signature
    public static void main(String[] args) throws IOException {        
        launch(args);
    }// end main method    

    
    @Override
    public void start(Stage primaryStage) throws IOException {
        // common elements        
        makeTopBox();
        makeSideBoxL();
        makeBotBox();
        
        // style
        mainBox.setAlignment(Pos.CENTER);
        mainBox.setPadding(new Insets(200, 0, 0, 100));
            //
            logoContainer.setAlignment(Pos.CENTER);
            
                logo.setFont(Font.font(60));
                logo.setFont(Font.font("Impact", FontWeight.BOLD, 60));
                company.setFont(Font.font(20));
                company.setPadding(new Insets(20, 0, 0, 0));
            //
            btnContainer.setAlignment(Pos.BASELINE_LEFT);
            btnContainer.setPadding(new Insets(180, 0, 0, 0));
            btnContainer.setSpacing(170);
            
                loginBtn.setPrefSize(200,50);
                signUpBtn.setPrefSize(200, 50);        
        // login screen
        logoContainer.getChildren().addAll(logo, company);
        btnContainer.getChildren().addAll(loginBtn, signUpBtn);
        mainBox.getChildren().addAll(logoContainer, btnContainer);
        pane.getChildren().addAll(mainBox);
        //
        Scene sc = new Scene(pane, 768, 600);
        primaryStage.setScene(sc);     
        primaryStage.setTitle("WorkForce: Mission Control");
        primaryStage.show();
        
        // button actions    
        // login button behaviour
        loginBtn.setOnAction((e) -> {
            try {
                
                
                btnCreate.setDisable(false);
                btnView.setDisable(true);
                btnUpdate.setDisable(false);
                
                createLight.setFill(Color.RED);
                viewLight.setFill(Color.GREENYELLOW);
                updateLight.setFill(Color.RED);                
                
                view.pane.setTop(topBox);
                view.pane.setLeft(sideBoxL);
                view.pane.setBottom(botBox);
                
                if(countView<1) { 
                primaryStage.setScene(view.fillPane());
                countView++;
                System.out.println("login " + countView);
                }
                else {
                    primaryStage.toFront();
                    System.out.println("update view v2 " + countView);
                }
                
            } catch (Exception duplicate) {
                
            }
        });// end button Login action
        
        // create button behaviour
        btnCreate.setOnAction((e) -> {
            try {
                
                btnCreate.setDisable(true);
                btnView.setDisable(false);
                btnUpdate.setDisable(false);
                
                createLight.setFill(Color.GREENYELLOW);
                viewLight.setFill(Color.RED);
                updateLight.setFill(Color.RED);
                
                create.pane.setTop(topBox);
                create.pane.setLeft(sideBoxL);
                create.pane.setBottom(botBox);       
                
                if(countCreate<1) {
                primaryStage.setScene(create.fillPane());
                countCreate++;
                System.out.println("create count " + countCreate);
                }
                else {
                    btnCreate.setDisable(true);
                    btnView.setDisable(false);
                    btnUpdate.setDisable(false);
                
                    createLight.setFill(Color.GREENYELLOW);
                    viewLight.setFill(Color.RED);
                    updateLight.setFill(Color.RED);
                
                    create.pane.setTop(topBox);
                    create.pane.setLeft(sideBoxL);
                    create.pane.setBottom(botBox); 
                    System.out.println("create count v2 " + countCreate);
                    
                    primaryStage.setScene(create.fillPane());
                }
                
            } catch (Exception duplicate) {
                showError(duplicate);
            }
        });// end button Create action
        
        // Create It (in Create Scene) button behaviour
        create.createIt.setOnAction ((e) -> {
            try {
                createItMethod();
            } catch (IOException ioe) {
                status.setText(ioe.getMessage());
            }
        });// end button Create It action
        
        // update button behaviour
        btnUpdate.setOnAction((e) -> {
            try { 
                
                btnCreate.setDisable(false);
                btnView.setDisable(false);
                btnUpdate.setDisable(true);
                
                createLight.setFill(Color.RED);
                viewLight.setFill(Color.RED);
                updateLight.setFill(Color.GREENYELLOW);
                
                update.pane.setTop(topBox);
                update.pane.setLeft(sideBoxL);
                update.pane.setBottom(botBox);
                
                if(countUpdate<1) { 
                primaryStage.setScene(update.fillPane());
                countUpdate++;
                System.out.println("update count " + countUpdate);
                }
                else {
                    btnCreate.setDisable(false);
                    btnView.setDisable(false);
                    btnUpdate.setDisable(true);
                
                    createLight.setFill(Color.RED);
                    viewLight.setFill(Color.RED);
                    updateLight.setFill(Color.GREENYELLOW);
                
                    update.pane.setTop(topBox);
                    update.pane.setLeft(sideBoxL);
                    update.pane.setBottom(botBox);
                    System.out.println("update count v2 " + countUpdate);
                    
                    primaryStage.setScene(update.fillPane());
                }

            } catch (Exception duplicate) {
                showError(duplicate);
            }
        });// end button Update action
        
        // view button behaviour
        btnView.setOnAction((e) -> {
            try {                          
                btnCreate.setDisable(false);
                btnView.setDisable(true);
                btnUpdate.setDisable(false);
                
                createLight.setFill(Color.RED);
                viewLight.setFill(Color.GREENYELLOW);
                updateLight.setFill(Color.RED);
                
                view.pane.setTop(topBox);
                view.pane.setLeft(sideBoxL);
                view.pane.setBottom(botBox);
                
                if(countView<1) {     
                primaryStage.setScene(view.fillPane());
                countView++;
                System.out.println("view count " + countView);
                }
                else {
                    btnCreate.setDisable(false);
                    btnView.setDisable(true);
                    btnUpdate.setDisable(false);
                
                    createLight.setFill(Color.RED);
                    viewLight.setFill(Color.GREENYELLOW);
                    updateLight.setFill(Color.RED);
                
                    view.pane.setTop(topBox);
                    view.pane.setLeft(sideBoxL);
                    view.pane.setBottom(botBox);
                    System.out.println("view count v2 " + countView);
                    
                    primaryStage.toFront();
                }
                
            } catch (Exception duplicate) {
                showError(duplicate);
            }
        });// end button View action
        
        // first button behaviour
        firstRecord.setOnAction((e) -> {
            try {
                
            } catch (Exception nav) {
                
            }            
        });// end button First action
        
        // previous button behaviour
        prevRecord.setOnAction((e) -> {
            try {
                
            } catch (Exception nav) {
                
            }
        });// end button Previous action
        
        // next button behaviour
        nextRecord.setOnAction((e) -> {
            try {
                
            } catch (Exception nav) {
                
            }
        });// end button Next action
        
        // last button behaviour        
        lastRecord.setOnAction((e) -> {
            try {
                
            } catch (Exception nav) {
                
            }
        });// end button Last action
        
        // logout button behaviour
        logout.setOnAction((e) -> {
            try {
                
            } catch (Exception logout) {
                //
            }            
        });
        
        
        // exit button behaviour
        exit.setOnAction((e) -> {
            try {
                System.exit(0);
            } catch (SecurityException exit) {
                //
            }
        });// end button Exit action
    }    
    
    // creates Worker object with values entered
    private void createItMethod() throws IOException {
      // test values
        try {  
            // Strings
            testString(create.getFnameTxt());
            who.setName(create.getFnameTxt());
            
            testString(create.getLnameTxt());
            who.setLastName(create.getLnameTxt());
        
            testString(create.getStreetTxt());
            who.setStreetAddress(create.getStreetTxt());
        
            testString(create.getCityTxt());
            who.setCity(create.getCityTxt());
            // numbers
            testDouble(create.getRateDbl());
            who.setRate(Double.parseDouble(create.getRateDbl()));
        
            testDouble(create.getHrsDbl());
            who.setHours(Double.parseDouble(create.getHrsDbl()));        
            // send Worker object to addWorker method
            wFile.addWorker(who);
            showInformation("created");
            status.setText("Employee record successfully created");            
               
        } catch(Exception e) {
            status.setText("Error: " + e.toString());
            showError(e);
            status.setText("Error: " + e.toString());
      }
    }

    private Exception testString(String str) {
        if(str.isEmpty()) {
            return new IllegalArgumentException();
        }
        else return null;       
    }
    
    private Exception testDouble(String dbl) {
        if(dbl.isEmpty()) {
            throw new IllegalArgumentException();
        }
        else if(!dbl.matches("[0-9]*")) {
            throw new InputMismatchException();
        }
        else return null;
    }
    
    private void showInformation(String info) {
        if(info == "created") {
            information.setHeaderText("Success!");
            information.setContentText("Employee record created.");
        }
        else if(info == "duplicate") {
            information.setTitle("Navigation");
            information.setHeaderText("You are already here");
        }
        information.show();
    }
    
    private void showError(Exception e) {
        IllegalArgumentException iae = new IllegalArgumentException();
        error.setTitle("Error");
        error.setHeaderText("There is a problem with your input!");
        // determine content message
        if(e.toString() == "java.lang.IllegalArgumentException") {
            error.setContentText("All fields are required before you click on 'Create Record'");
            status.setText("Input Error: " + e.getMessage());
        }
        else if (e.toString() == "java.util.InputMismatchException") {
            error.setContentText("Enter numerical values in the 'Rate' and 'Hours worked' fields.");
            status.setText("Input Error: " + e.getMessage());
        }
        else {
            error.setContentText(e.toString());
            status.setText("Input Error: " + e.getMessage());
        }  
        error.show();
    }
    
    // DEFAULT SELECTION 
    /*
    protected Scene defaultScene() {
        makeTopBox();
        makeSideBoxL();
        makeBotBox();
        
        pane.setTop(topBox);
        pane.setLeft(sideBoxL);
        pane.setBottom(botBox);
    }
    */
    // COMMON ELEMENTSs
    
    // top buttons and indicator lights //////////////////////////////////////// top
    protected VBox makeTopBox() {

        // create HBox objects
        HBox buttonBox = new HBox();
        HBox statLight = new HBox();

        // btnCreate declared at top
            btnCreate.setPrefSize(256,60);
            btnCreate.setText("Create New Employee");
        // btnView declared at top
            btnView.setPrefSize(256,60);
            btnView.setText("View Employee Records");
        // btnUpdate declared at top
            btnUpdate.setPrefSize(256,60);
            btnUpdate.setText("Update Employee Information");
        
        // HBox for the 3 lights
        statLight.setSpacing(77);
        statLight.setAlignment(Pos.CENTER);
        statLight.setPadding(new Insets(0, 0, 0, 0));
        // the 3 lights //////////////////////////////////////////////////////// change per Scene (class)
        
        // createLight declared in field            
        // viewLight declared in field            
        // updateLight declared in field
        
            //createLight.setFill();
            //viewLight.setFill();
            //updateLight.setFill();
        
        buttonBox.getChildren().addAll(btnCreate, btnView, btnUpdate);
        statLight.getChildren().addAll(createLight, viewLight, updateLight);        
        topBox.getChildren().addAll(buttonBox, statLight);
        return topBox;// VBox
    }
    
    // left side /////////////////////////////////////////////////////////////// left-side
    protected VBox makeSideBoxL() {        
        
        sideBoxL.setSpacing(22);
        sideBoxL.setPadding(new Insets(30));
        sideBoxL.minWidth(500); sideBoxL.maxWidth(500);
        sideBoxL.minHeight(500);
        
        Button account = new Button("Account");
        Button preferences = new Button ("Preferences");
        // logout declared in field
        sideBoxL.getChildren().addAll(account, preferences, logout);
        return sideBoxL;// VBox
    }
    
    // bottom ////////////////////////////////////////////////////////////////// bottom
    protected VBox makeBotBox() {
        
        botBox.setSpacing(20);
        
        // navButtons declared in field
            navButtons.setSpacing(0); navButtons.setPadding(new Insets(0, 0, 0, 84));
        HBox statusBar = new HBox();      
            statusBar.setSpacing(0);
        
        // firstRecord declared in field
            firstRecord.setPrefSize(150, 30);
        // prevRecord declared in field
            prevRecord.setPrefSize(150, 30);
        // nextRecord declared in field
            nextRecord.setPrefSize(150, 30);        
        // lastRecord declared in field
            lastRecord.setPrefSize(150, 30);
        
        Label timeStamp = new Label();        
            timeStamp.setPrefSize(250,20);
            timeStamp.setPadding(new Insets(2, 0, 0, 20));
            timeStamp.setText(LocalDate.now().toString());
            timeStamp.setFont(Font.font("sans-serif", FontWeight.BOLD, 12));
        // Label status defined in field
            status.setPrefSize(600, 20);
            status.setText("Session load successful.");            
            status.setStyle("-fx-padding: 0 10 0 10;");
        // Label exit defined in field
            exit.setPrefSize(250, 20);
            exit.setText("Exit");
        
        navButtons.getChildren().addAll(firstRecord, prevRecord, nextRecord, lastRecord);
        statusBar.getChildren().addAll(timeStamp, status, exit);
                
        botBox.getChildren().addAll(statusBar);
        return botBox;
    }
}// end FXMain class

/*

// creates Worker object with values entered
    private void createItMethod() throws IOException {
      // test values - main try
        try {
        // try to set values for Worker
        //try {// first name
            testString(create.getFnameTxt());
            who.setName(create.getFnameTxt());
        //} catch (Exception e) {
            //showError(e);
            //create.status.setText("Error: " + e.getMessage() + " in first name field.");
        //}
        //try {// last name
            testString(create.getLnameTxt());
            who.setLastName(create.getLnameTxt());
        //} catch (Exception e) {
            //showError(e);
            //create.status.setText("Error: " + e.getMessage() + " in last name field.");
        //}
        
        //try {// street address
            testString(create.getStreetTxt());
            who.setStreetAddress(create.getStreetTxt());
        //} catch (Exception e) {
            //showError(e);
            //create.status.setText("Error: " + e.getMessage() + " in street address field.");
        //}
        //try {// city
            testString(create.getCityTxt());
            who.setCity(create.getCityTxt());
        //} catch (Exception e) {
            //showError(e);
            //create.status.setText("Error: " + e.getMessage() + " in city field.");
        //}
        //try {// rate
            testDouble(create.getRateDbl());
            who.setRate(Double.parseDouble(create.getRateDbl()));// Doubles
        //} catch (Exception e) {
            //showError(e);
            //create.status.setText("Error: " + e.getMessage() + " in rate field.");
        //}
        //try {//
            testDouble(create.getHrsDbl());
            who.setHours(Double.parseDouble(create.getHrsDbl()));
        //} catch (Exception e) {
            //showError(e);
            //create.status.setText("Error: " + e.getMessage() + " in hours field.");
        //}
            
            //who.setOvertime(Double.parseDouble(create.getOvertimeDbl()));
            
            // send Worker object to addWorker method
            wFile.addWorker(who);
        //create.status.
        
        } catch(Exception e) {
            showError(e);
            common.status.setText("Error: " + e.toString());
      }
    }
*/

