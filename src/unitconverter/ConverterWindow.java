package unitconverter;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import javax.swing.*;

/**
 * The GUI for the converter
 * @author Li Huang
 * @version 5.28.2017
 */
@SuppressWarnings("serial")
public class ConverterWindow extends JFrame {

	
	private String[] converterList = { "", "Length" };	// list of converters

	/**
	 * Represent 3 different panels inside the JFrame
	 */
	private JPanel panelConverter;
	private JPanel panelSource;
	private JPanel panelTarget;

	/**
	 * The label for converter list, input, and output
	 */
	private JLabel lblConverterType;
	private JLabel lblInput;
	private JLabel lblOutput;

	/**
	 * Text fields for showing input and output number
	 */
	private JFormattedTextField tfSource;
	private JFormattedTextField tfTarget;

	/**
	 * The combo box for:
	 * 		type of converter
	 * 		input unit
	 *		output unit
	 */
	private JComboBox<String> cbxConverter;
	private JComboBox<String> cbxSourceUnit;
	private JComboBox<String> cbxTargetUnit;

	private UnitConverter converter; // the converter object that does the conversion

	/**
	 * The constructor for setting up the GUI
	 */
	public ConverterWindow()
	{
		setTitle("Unit Converter");
		setSize(400, 200);
		setLayout(new GridLayout(3, 1));

		setup();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * The setup method that wraps all the settings for the GUI
	 */
	private void setup()
	{
		setupPanel();
		setupComponent();
		setupConverter();
		setupSource();
		setupTarget();
	}

	/**
	 * Set up the three different panels for the JFrame
	 * 		converter panel
	 * 		input panel
	 * 		output panel
	 */
	private void setupPanel()
	{
		panelConverter = new JPanel();
		panelConverter = new JPanel();
		panelConverter.setLayout(new FlowLayout());

		panelSource = new JPanel();
		panelSource = new JPanel();
		panelSource.setLayout(new FlowLayout());

		panelTarget = new JPanel();
		panelTarget = new JPanel();
		panelTarget.setLayout(new FlowLayout());

		add(panelConverter);
		add(panelSource);
		add(panelTarget);
	}

	/**
	 * Set up the components for each panel and adds it to panel
	 * include: label, text field, and combo box
	 */
	private void setupComponent()
	{
		lblConverterType = new JLabel("Conversion type: ", JLabel.LEFT);
		panelConverter.add(lblConverterType);

		cbxConverter = new JComboBox<String>(converterList);
		panelConverter.add(cbxConverter);

		lblInput = new JLabel("Input value: ", JLabel.LEFT);
		panelSource.add(lblInput);

		tfSource = new JFormattedTextField(new DecimalFormat());
		panelSource.add(tfSource);

		cbxSourceUnit = new JComboBox<String>();
		panelSource.add(cbxSourceUnit);

		lblOutput = new JLabel("Result value: ", JLabel.LEFT);
		panelTarget.add(lblOutput);

		tfTarget = new JFormattedTextField(new DecimalFormat());
		panelTarget.add(tfTarget);

		cbxTargetUnit = new JComboBox<String>();
		panelTarget.add(cbxTargetUnit);
	}

	/**
	 * Set up the converter for conversion
	 * Create event handler that configures converter based on converter combo box
	 */
	private void setupConverter()
	{
		cbxConverter.setSelectedIndex(0);
		cbxConverter.setPreferredSize(new Dimension(120, cbxConverter.getPreferredSize().height));
		((JLabel)cbxConverter.getRenderer()).setHorizontalAlignment(JLabel.CENTER);

		cbxConverter.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED) {
					switch (cbxConverter.getSelectedItem().toString()) 
					{
					case "Length" :
						converter = new LengthConverter();
						tfSource.setEditable(true);
						cbxSourceUnit.removeAllItems();
						cbxTargetUnit.removeAllItems();
						for (int i = 0; i < converter.getUnit().length; i++)
						{
							cbxSourceUnit.addItem(converter.getUnit()[i]);
							cbxTargetUnit.addItem(converter.getUnit()[i]);
						}
						break;
					default :
						converter = null;
						tfSource.setEditable(false);
						cbxSourceUnit.removeAllItems();
						cbxTargetUnit.removeAllItems();
						break;
					}
				}
			}
		});
	}

	/**
	 * Set up event handler for source unit combo box
	 * Set up event handler for calculate output based on input text field
	 */
	private void setupSource()
	{
		tfSource.setColumns(10);
		tfSource.setEditable(false);

		((JLabel)cbxSourceUnit.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
		
		cbxSourceUnit.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED) {
					converter.setSourceUnit(cbxSourceUnit.getSelectedItem().toString());
					converter.setTarget();
					tfTarget.setText(Double.toString(converter.getTarget()));
				}
			}
		});

		tfSource.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				converter.setSource(Double.parseDouble(tfSource.getText()));
				converter.setTarget();
				tfTarget.setText(Double.toString(converter.getTarget()));
			}
		});
	}

	/**
	 * Set up event handler for output unit combo box
	 */
	private void setupTarget()
	{
		tfTarget.setColumns(10);
		tfTarget.setEditable(false);

		((JLabel)cbxTargetUnit.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
		
		cbxTargetUnit.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED) {
					converter.setTargetUnit(cbxTargetUnit.getSelectedItem().toString());
					converter.setTarget();
					tfTarget.setText(Double.toString(converter.getTarget()));
				}
			}
		});
	}

	/**
	 * Main method that runs the constructor for testing purposes
	 * @param args
	 */
	public static void main(String[] args)
	{
		new ConverterWindow();
	}

}
