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

	/**
	 * return source unit
	 */
	@Override
	public String getSourceUnit() {
		return this.sourceUnit;
	}

	/**
	 * return target unit
	 */
	@Override
	public String getTargetUnit() {
		return this.targetUnit;
	}

	/**
	 * return source value
	 */
	@Override
	public double getSource() {
		return this.source;
	}

	/**
	 * return target value
	 */
	@Override
	public double getTarget() {
		return this.target;
	}

	/**
	 * set source unit
	 */
	@Override
	public void setSourceUnit(String sourceUnit) {
		this.sourceUnit = sourceUnit;
	}

	/**
	 * set target unit
	 */
	@Override
	public void setTargetUnit(String targetUnit) {
		this.targetUnit = targetUnit;
	}

	/**
	 * set source value
	 */
	@Override
	public void setSource(double source) {
		this.source = source;
	}

	/**
	 * set target value
	 */
	@Override
	public void setTarget() {
		this.target = this.convert();
	}
	
	/**
	 * method which does the conversion from source to target for the object
	 * @return
	 */
	private double convert()
	{
		double target = 0;
		return target;
	}

	/**
	 * method which resets the converter to initial state
	 */
	@Override
	public void reset() {
		this.sourceUnit = "";
		this.targetUnit = "";
		this.source = 0;
		this.target = 0;
	}
	
	/**
	 * toString method for lengthConverter object
	 * returns the state of the object
	 */
	@Override
	public String toString()
	{
		String message = "Current state:\n"
						 + "source: " + this.source + " " + this.sourceUnit + "\n"
						 + "target: " + this.target + " " + this.targetUnit;
		return message;
		
	}

}
