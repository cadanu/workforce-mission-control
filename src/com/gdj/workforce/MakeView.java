/*
 * WorkForce: Mission Control
 */
package com.gdj.workforce;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 *
 * @author G.D. Joyce
 * MakeView.java: 'View' BorderPane GUI for JavaFX application ' WorkForce: Mission Control '
 */

public class MakeView {
    // field declarations
    // pane
    protected BorderPane pane = new BorderPane();
    // nodes
    private VBox viewCenterBox = new VBox();
    private VBox viewSideBoxR = new VBox();  
    // leaves    
    Label idShow = new Label();
    private TextField fnameTxt = new TextField();
    private TextField lnameTxt = new TextField();
    private TextField streetTxt = new TextField();
    private TextField cityTxt = new TextField();
    private TextField rateDbl = new TextField();
    private TextField hrsDbl = new TextField();
    private TextField overtimeDbl = new TextField();
    private TextField ppDbl = new TextField();
    protected Button createIt = new Button("Create Record");
    protected Label status = new Label();
    protected Button exit = new Button();
    // common elements of gui
    //protected FXMain common = new FXMain();
    
    // Node getters
    public String getFnameTxt() {
        return fnameTxt.getText();
    }
    public String getLnameTxt() {
        return lnameTxt.getText();
    }
    public String getStreetTxt() {
        return streetTxt.getText();
    }
    public String getCityTxt() {
        return cityTxt.getText();
    }
    public String getRateDbl() {
        return rateDbl.getText();
    }
    public String getHrsDbl() {
        return hrsDbl.getText();
    }
    public String getOvertimeDbl() {
        return overtimeDbl.getText();
    }
    public String getPpDbl() {
        return ppDbl.getText();
    }
    
    // this method returns a Scene object to a primaryStage
    public Scene fillPane() {
        // call node methods
        makeCenterBox();
        makeSideBoxR();
        
        // set nodes in pane
        pane.setCenter(viewCenterBox);
        pane.setRight(viewSideBoxR);
        
        // set scene - method returns this        
        Scene sc = new Scene(pane, 768, 600);
        return sc;
    }
    
    // center ////////////////////////////////////////////////////////////////// center //
    protected VBox makeCenterBox() {
        
        viewCenterBox.setSpacing(12);
        viewCenterBox.setPadding(new Insets(22));
        viewCenterBox.minWidth(200);
        viewCenterBox.minHeight(500);
        
        // employee profile 
        Label profileLbl = new Label("Profile");
            profileLbl.setFont(Font.font(20));// Label
        
        HBox idRow = new HBox();            idRow.setSpacing(30);
        Label ID = new Label("Employee ID: "); 
        idRow.getChildren().addAll(ID, idShow);
        
        HBox nameRow = new HBox();          nameRow.setSpacing(40);
        Label name = new Label("First Name: "); 
        nameRow.getChildren().addAll(name, fnameTxt);
        
        HBox lnameRow = new HBox();         lnameRow.setSpacing(42);
        Label lname = new Label("Last Name: "); 
        lnameRow.getChildren().addAll(lname, lnameTxt);
        
        HBox streetRow = new HBox();        streetRow.setSpacing(21);
        Label street = new Label("Street Address: "); 
        streetRow.getChildren().addAll(street, streetTxt);
        
        HBox cityRow = new HBox();          cityRow.setSpacing(77);
        Label city = new Label("City: "); 
        cityRow.getChildren().addAll(city, cityTxt);
        
                
        // employee wage profile
        Label wageLbl  = new Label("Accounting"); 
            wageLbl.setFont(Font.font(20));// Label
            
        HBox rateRow = new HBox();          rateRow.setSpacing(38);
        Label rate = new Label("Rate of Pay: "); 
        rateRow.getChildren().addAll(rate, rateDbl);
        
        HBox hrsRow = new HBox();           hrsRow.setSpacing(24);
        Label hrsWorked = new Label("Hours worked: "); 
        hrsRow.getChildren().addAll(hrsWorked, hrsDbl);
        
        HBox overtimeRow = new HBox();      overtimeRow.setSpacing(20);
        Label overtime = new Label("Overtime hours:"); 
        overtimeRow.getChildren().addAll(overtime, overtimeDbl);
        
        HBox ppRow = new HBox();            ppRow.setSpacing(20);
        Label payPeriod = new Label("Pay this period: "); 
        ppRow.getChildren().addAll(payPeriod, ppDbl);
        
        viewCenterBox.getChildren().addAll(profileLbl, idRow, nameRow, lnameRow, streetRow, cityRow);
        viewCenterBox.getChildren().addAll(wageLbl, rateRow, hrsRow, overtimeRow, ppRow);
        
        return viewCenterBox;// VBox
    }
    
    // right side ////////////////////////////////////////////////////////////// right-side
    protected VBox makeSideBoxR() {
        viewSideBoxR.setAlignment(Pos.BASELINE_LEFT);
            viewSideBoxR.setPadding(new Insets(340, 160, 0, 0));
        
            createIt.setPadding(new Insets(15, 25, 15, 25));
        
        viewSideBoxR.getChildren().addAll(createIt);        
        return viewSideBoxR;// VBox
    }    
}// end MakeView class