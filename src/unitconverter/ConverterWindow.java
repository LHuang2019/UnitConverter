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
    private JComboBox<String> cbxConverter;
    private JComboBox<String> cbxSourceUnit;
    private JComboBox<String> cbxTargetUnit;
    
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
        setupFrame();
        setupConverter();
        setupSource();
        setupTarget();
    }
    
    private void setupFrame()
    {
        lblConverterType = new JLabel("Conversion type: ", JLabel.LEFT);
        window.add(lblConverterType);
        
        cbxConverter = new JComboBox(converterList);
        window.add(cbxConverter);
        
        lblInput = new JLabel("Enter your value: ", JLabel.LEFT);
        window.add(lblInput);
        
        tfSource = new JFormattedTextField(new DecimalFormat());
        window.add(tfSource);
        
        lblOutput = new JLabel("Result value: ", JLabel.LEFT);
        window.add(lblOutput);
        
        tfTarget = new JFormattedTextField(new DecimalFormat());
        window.add(tfTarget);
    }
    
    private void setupConverter()
    {
        cbxConverter.setSelectedIndex(0);
        cbxConverter.setPreferredSize(new Dimension(120, cbxConverter.getPreferredSize().height));
        ((JLabel)cbxConverter.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
    }
    
    private void setupSource()
    {
        tfSource.setColumns(10);

    }

    private void setupTarget()
    {
        tfTarget.setColumns(10);
    }
    
    public static void main(String[] args)
    {
        new ConverterWindow();
    }

}
