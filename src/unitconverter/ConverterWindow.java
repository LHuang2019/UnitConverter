package unitconverter;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import javax.swing.*;

@SuppressWarnings("serial")
public class ConverterWindow extends JFrame {

    private String[] converterList = { "", "Length" };
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
        setSize(300, 150);
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

        cbxConverter = new JComboBox<String>(converterList);
        window.add(cbxConverter);

        lblInput = new JLabel("Input value: ", JLabel.LEFT);
        window.add(lblInput);

        tfSource = new JFormattedTextField(new DecimalFormat());
        window.add(tfSource);

        cbxSourceUnit = new JComboBox<String>();
        window.add(cbxSourceUnit);

        lblOutput = new JLabel("Result value: ", JLabel.LEFT);
        window.add(lblOutput);

        tfTarget = new JFormattedTextField(new DecimalFormat());
        window.add(tfTarget);

        cbxTargetUnit = new JComboBox<String>();
        window.add(cbxTargetUnit);
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
