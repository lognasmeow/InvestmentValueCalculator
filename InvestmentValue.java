import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class InvestmentValue extends Application
{	
	private TextField investmentAmountText = new TextField("Investment Amount");			//text boxes holding preset values for user to change
	private TextField monthlyInterestRateText = new TextField("Monthly Interest Rate");
	private TextField yearsText = new TextField("Number of years");
	private TextField futureValueText = new TextField("Future Value");
	private Button calculateButton = new Button("CALCULATE");			//button that will set off the investment value calculation
	private double investmentAmount = 0;			//amount the user is investing
	private double monthlyInterestRate = 0;			//the monthly interest rate
	private double years = 0;			//how many years the investment will occur
	private double futureValue = 0;		//total value after the years pass
	
	public static void main(String[] args)
	{	
		Application.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		
		primaryStage.setTitle("Investment Value Calculator");
		primaryStage.setResizable(false);		//cannot change size of the application
		
		VBox vb = new VBox();			//create new VBox pane
		vb.setSpacing(15);		//spaces components apart from one another
			
		vb.getChildren().add(investmentAmountText);			//adds the nodes to the pane
		vb.getChildren().add(monthlyInterestRateText);
		vb.getChildren().add(yearsText);
		vb.getChildren().add(calculateButton);
		vb.getChildren().add(futureValueText);
		
		Scene scene = new Scene(vb, 500, 250);			//create new scene instance, including the pane with the object
		
		investmentAmountText.setOnMouseClicked(e -> 
		{
			investmentAmountText.setText("");			//sets the preset text to blank so that the user does not have to bother with erasing it
		});
		monthlyInterestRateText.setOnMouseClicked(e -> 
		{
			monthlyInterestRateText.setText("");
		});
		yearsText.setOnMouseClicked(e -> 
		{
			yearsText.setText("");
		});
		
		calculateButton.setOnAction(e -> 
		{
			try
			{
				investmentAmount = Double.parseDouble(investmentAmountText.getText());		//parse through the text box to receive double value
				monthlyInterestRate = Double.parseDouble(monthlyInterestRateText.getText());
				years = Double.parseDouble(yearsText.getText());
			}
			catch (Exception except)
			{
				futureValueText.setText("ERROR - Please only enter number values");
			}
			
			System.out.println(investmentAmount);			//print out entered values for debugging
			System.out.println(monthlyInterestRate);
			System.out.println(years);
			
			futureValue = investmentAmount * (Math.pow(1 + monthlyInterestRate, years));		//formula to calculate future value of investment after specified years
			
			futureValueText.setText(toString(futureValue));			//sets the future value to the answer of the calculation
		});
		
		primaryStage.setScene(scene);		//set the scene in the stage
		primaryStage.show();			//allow the screen to appear
	}
	
	public String toString(double numValue)		//converts the future value answer calculation from a double to string to enter in the text box
	{
		return "Future Value = " + numValue;
	}
	
}