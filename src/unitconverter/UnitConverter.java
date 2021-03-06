package unitconverter;

public interface UnitConverter {

	//Getter methods
	String getSourceUnit();
	String getTargetUnit();
	double getSource();
	double getTarget();
	String[] getUnit();
	
	//Setter methods
	void setSourceUnit(String sourceUnit);
	void setTargetUnit(String targetUnit);
	void setSource(double source);
	void setTarget();
	
	//useful methods
	void reset();
	String toString();
}
