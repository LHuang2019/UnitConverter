package unitconverter;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.text.DecimalFormat;
import javax.swing.*;

@SuppressWarnings("serial")
public class ConverterWindow extends JFrame {

    private String[] converterList = { "Length" };
    private Container window;
    private JLabel lblConverterType;
    private JLabel lblInput;
    private JLabel lblOutput;
    private JFormattedTextField tfSource;
    private JFormattedTextField tfTarget;
    private JComboBox<String> cbConverter;
    private JComboBox<String> cbSourceUnit;
    private JComboBox<String> cbTargetUnit;
    
    private UnitConverter converter;

    public ConverterWindow()
    {
        window = getContentPane();
        window.setLayout(new FlowLayout());
        converter = new LengthConverter();
        
        setup();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Unit Converter");
        setSize(300, 120);
        setVisible(true);
    }

    private void setup()
    {
        setupConverter();
        setupSource();
        setupTarget();
    }
    
    private void setupConverter()
    {
        lblConverterType = new JLabel("Conversion type: ", JLabel.LEFT);
        window.add(lblConverterType);
        
        cbConverter = new JComboBox(converterList);
        cbConverter.setSelectedIndex(0);
        cbConverter.setPreferredSize(new Dimension(120, cbConverter.getPreferredSize().height));
        ((JLabel)cbConverter.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        window.add(cbConverter);
    }
    
    private void setupSource()
    {
        lblInput = new JLabel("Enter your value: ", JLabel.LEFT);
        window.add(lblInput);
        tfSource = new JFormattedTextField(new DecimalFormat());
        tfSource.setColumns(10);
        window.add(tfSource);
    }

    private void setupTarget()
    {
        lblOutput = new JLabel("Result value: ", JLabel.LEFT);
        window.add(lblOutput);
        
        tfTarget = new JFormattedTextField(new DecimalFormat());
        tfTarget.setColumns(10);
        window.add(tfTarget);
    }
    
    public static void main(String[] args)
    {
        new ConverterWindow();
    }

}
