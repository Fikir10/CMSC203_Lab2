import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
public class FXMainPane extends VBox {
	//student Task #2:
		//  declare five buttons, a label, and a textfield
	Button btn1, btn2, btn3, btn4, btn5;
	Label label;
	TextField txt;
		//  declare two HBoxes
		HBox h1;
		HBox h2;
		//student Task #4:
		//  declare an instance of DataManager
		DataManager dataMan;
		/**
		 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
		 * wait to add a component to its containing component until the container has
		 * been created.  This is the only constraint on the order in which the following 
		 * statements appear.
		 */
		 FXMainPane() {
			//student Task #2:
			//  instantiate the buttons, label, and textfield
			btn1=new Button("Hello");
			btn2=new Button("Howdy");
			btn3=new Button("Chinese");
		    btn4=new Button("Clear");
			btn5=new Button("Exit");
			label=new Label("Feedback");
			txt=new TextField();
			//  instantiate the HBoxes
			h1=new HBox();
			h2=new HBox();
			//student Task #4:
			//  instantiate the DataManager instance
			dataMan=new DataManager();
			//  set margins and set alignment of the components
			HBox.setMargin(btn1, new Insets(5));
			HBox.setMargin(btn2, new Insets(5));
			HBox.setMargin(btn3, new Insets(5));
			HBox.setMargin(btn4, new Insets(5));
			HBox.setMargin(btn5, new Insets(5));
			
			h1.setAlignment(Pos.CENTER);
			h2.setAlignment(Pos.CENTER);
			//student Task #3:
			//  add the label and textfield to one of the HBoxes
			h2.getChildren().addAll(label,txt);
			
			//  add the buttons to the other HBox
			h1.getChildren().addAll(btn1,btn2,btn3,btn4,btn5);
			//  add the HBoxes to this FXMainPanel (a VBox)
			getChildren().addAll(h1,h2);
			
			btn1.setOnAction(new ButtonHandler());
			btn2.setOnAction(new ButtonHandler());
			btn3.setOnAction(new ButtonHandler());
			btn4.setOnAction(new ButtonHandler());
			btn5.setOnAction(new ButtonHandler());
		}
		
		//Task #4:
		//  create a private inner class to handle the button clicks
	 class ButtonHandler implements EventHandler<ActionEvent>{
		 
			 public void handle(ActionEvent event) {
				if(event.getTarget()==btn1)
					txt.setText(dataMan.getHello());
				else if(event.getTarget()==btn2)
					txt.setText(dataMan.getHowdy());
				else if(event.getTarget()==btn3)
					txt.setText(dataMan.getChinese());
				else if(event.getTarget()==btn4)
					txt.setText("");
				else if(event.getTarget()==btn5) {
					Platform.exit();
					System.exit(0);
			 }
		 }	 
	 } 
}
