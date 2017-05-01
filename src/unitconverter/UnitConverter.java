package unitconverter;

public interface UnitConverter {

	//Getter methods
	String sourceUnitGetter();
	String targetUnitGetter();
	double sourceGetter();
	double targetGetter();
	
	//Setter methods
	String sourceUnitSetter();
	String targetUnitSetter();
	double sourceSetter();
	double targetSetter();
	
	//Conversion
	double convert();
	
	//useful methods
	void clear();
	String toString();
}
