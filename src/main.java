import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
public class main extends Application  {

	Divisa euro = new Divisa("Euro", 1.0);
	Divisa libra = new Divisa("Libra", 0.8873);
	Divisa dolar = new Divisa("Dolar", 1.2007);
	Divisa yen = new Divisa("Yen", 133.59);
	
	List prueba = Divisa.getListaDivisas();

	
  @Override
  public void start(Stage primaryStage) throws Exception { 

		
	primaryStage.setTitle("Cambio Divisa");

    TextField divisaUna = new TextField();  
    TextField divisaDos = new TextField();
    divisaDos.setEditable(false);
    
    ComboBox comboBox = new ComboBox();
    comboBox.getItems().addAll(prueba);

    ComboBox comboBo = new ComboBox();
    comboBo.getItems().addAll(prueba);
    
    Button botonCalcular = new Button("Calcular");
    comboBox.getSelectionModel().select(0);
    comboBo.getSelectionModel().select(0);
    
    botonCalcular.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
        @Override public void handle(ActionEvent e) {
        	
        	      	
        	String parUna = (String) comboBox.getValue();
        	String parDos = (String) comboBo.getValue();
        	
        	try {
        		Double.parseDouble(divisaUna.getText());
        		double valorParUna = Double.parseDouble(divisaUna.getText());
        		String resFinal = String.valueOf(Divisa.calcular(valorParUna, parUna, parDos));
        		divisaDos.setText(resFinal);
        	} catch (NumberFormatException nfe){

        	    Alert alert = new Alert(Alert.AlertType.WARNING);
        	    alert.setHeaderText(null);
        	    alert.setTitle("Error");
        	    alert.setContentText("El número introducido no es válido.");
        	    alert.showAndWait();
        	    
        	}
        	
        	
        	
        }
    });
    
   
    
    GridPane gridPane = new GridPane();
    gridPane.setMinSize(400, 200);
    gridPane.setPadding(new Insets(10, 10, 10, 10)); 
    gridPane.setVgap(5); 
    gridPane.setHgap(5);
    gridPane.setAlignment(Pos.CENTER); 
    
    gridPane.add(divisaUna, 0, 0); 
    gridPane.add(comboBox, 1, 0); 
    gridPane.add(divisaDos, 0, 1);       
    gridPane.add(comboBo, 1, 1); 
    gridPane.add(botonCalcular, 0, 2);  
    
    Scene scene = new Scene(gridPane);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {

    Application.launch(args);
  }
}