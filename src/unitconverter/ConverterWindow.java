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

@SuppressWarnings("serial")
public class ConverterWindow extends JFrame {

	private String[] converterList = { "", "Length" };

	private JPanel panelConverter;
	private JPanel panelSource;
	private JPanel panelTarget;

	private JLabel lblConverterType;
	private JLabel lblInput;
	private JLabel lblOutput;

	private JFormattedTextField tfSource;
	private JFormattedTextField tfTarget;

	private JComboBox<String> cbxConverter;
	private JComboBox<String> cbxSourceUnit;
	private JComboBox<String> cbxTargetUnit;

	private UnitConverter converter;

	public ConverterWindow()
	{
		setTitle("Unit Converter");
		setSize(400, 200);
		setLayout(new GridLayout(3, 1));

		setup();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void setup()
	{
		setupPanel();
		setupComponent();
		setupConverter();
		setupSource();
		setupTarget();
	}

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
						cbxSourceUnit.removeAllItems();
						cbxTargetUnit.removeAllItems();
						break;
					}
				}
			}
		});
	}

	private void setupSource()
	{
		tfSource.setColumns(10);

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

	private void setupTarget()
	{
		tfTarget.setColumns(10);
		tfTarget.setEditable(false);

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

	public static void main(String[] args)
	{
		new ConverterWindow();
	}

}
