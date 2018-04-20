import java.util.StringJoiner;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
/**
 * 
 * @author Anastasiya
 * 
 */
public class windowSWT 
{
	/**
	 * This word will appear as a sign to correct input value
	 */
	private static String result = "Результат:"; 
	/**
	 * Simple main Display
	 */
	private static Display display;
	/**
	 * Simple shell
	 */
	private static Shell shell;
	/**
	 *  Main title of a programm: "Случайные блуждания"
	 */
	private static Label runWalk;
	/**
	 *  Title to a Text button, for more friendly UI
	 */
	private static Label numberRunWalk;
	/**
	 * Place where we get number to a random walk
	 */
	private static Text getNumber;
	/**
	 * Showing result label
	 */
	private static Label resultLabeL;
	/**
	 * Submit input from getNumber
	 */
	private static Button getData;
	/**
	 * Entry point to handle everything
	 */
	public static void main(String[] args) 
	{
		
		setUI();
		addListener();
		shell.pack();
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
	/**
	 * Set User Interface
	 */
	private static void setUI()
	{
		display = new Display();
		shell = new Shell(display, SWT.SHELL_TRIM & (~SWT.RESIZE) & (~SWT.MAX));
		shell.setLayout(new GridLayout(2, false));
		
		runWalk = new Label(shell, SWT.NONE);
		runWalk.setText("Случайные блуждания");
		
		GridData gridData = new GridData();
		gridData = new GridData(GridData.HORIZONTAL_ALIGN_CENTER);
		gridData.horizontalSpan = 2;
		runWalk.setLayoutData(gridData);
		
		numberRunWalk = new Label(shell, SWT.NONE);
		numberRunWalk.setText("Количество блужданий:");
		
		getNumber = new Text(shell, SWT.BORDER);
		gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		getNumber.setLayoutData(gridData);
		
		resultLabeL = new Label(shell, SWT.NONE);
		resultLabeL.setText(result);
		gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		resultLabeL.setLayoutData(gridData);
		
		getData = new Button(shell, SWT.NONE);
		getData.setText("Получить");
		gridData.horizontalAlignment = SWT.FILL;
		getData.setLayoutData(gridData);
		
		Label bsuir = new Label(shell, SWT.NONE);
		bsuir.setText("Бгуир - знания и стиль жизни!");
		gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		bsuir.setLayoutData(gridData);
		
	}
	/**
	 * add Listener to button(getData)
	 * button is on click - random walk generates
	 */
	private static void addListener()
	{
		
		getData.addListener(SWT.Selection, new Listener()
		{
			public void handleEvent(Event event) 
				{
					String fromText = getNumber.getText(); 
					
					if(fromText.matches("[0-9]+") && fromText.length() > 0)
					{
						int num = Integer.parseInt(fromText); // start of random walk algorithm
						int steps = 0;
						int x = 0, y = 0;
	
						  while (Math.abs(x) < num && Math.abs(y) < num)
						  {
					           	double r = Math.random();
					            if      (r < 0.25) x--;
					            else if (r < 0.50) x++;
					            else if (r < 0.75) y--;
					            else if (r < 1.00) y++;
					            steps++;
					       } 
						String resultData = "" + steps;
						StringJoiner sj1 = new StringJoiner(" ");
						String joined = sj1.add(result).add(resultData ).toString();
						resultLabeL.setText(joined);				
					}
					else resultLabeL.setText("Error");
				}
						
		});
	}
	}
	
