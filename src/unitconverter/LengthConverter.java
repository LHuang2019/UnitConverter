package unitconverter;

/**
 * Length converter class
 * @author Li Huang
 * @version 4.30.2017
 */
public class LengthConverter implements UnitConverter {

	// variable for conversion
	final static private double KM_TO_METER = 1000;
	final static private double CM_TO_METER = 0.01;
	final static private double MM_TO_METER = 0.001;
	final static private double MILE_TO_METER = 1609.34;
	final static private double YARD_TO_METER = 0.9144;
	final static private double FOOT_TO_METER = 0.3048;
	final static private double INCH_TO_METER = 0.0254;
	final static private double NAUTICAL_MILE_TO_METER = 0.3048;
	
	private String sourceUnit;
	private String targetUnit;
	private double source;
	private double target;
	
	// default constructor
	public LengthConverter()
	{
		this.sourceUnit = "";
		this.targetUnit = "";
		this.source = 0;
		this.target = 0;
	}
	
	// Parameterized constructor
	public LengthConverter(String sourceUnit, String targetUnit, double source)
	{
		this.sourceUnit = sourceUnit;
		this.targetUnit = targetUnit;
		this.source = source;
		this.target = 0;
	}

	@Override
	public String getSourceUnit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTargetUnit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getSource() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTarget() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String setSourceUnit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String setTargetUnit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double setSource() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double setTarget() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double convert() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
