package day_16_½Ó¿Ú¼ÆËãÆ÷;

public class CalculationResult {

	
	private final boolean success;
	private final Double value;
	private final  String errorMessage;
	
	
	private CalculationResult( boolean success , Double value , String errorMessage) {
		
		this.success = success;
		this.value = value;
		this.errorMessage = errorMessage;
	}
	
	public boolean isSuccess() {
		return success;
	}

	public double getValue() {
		return value;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	
	
	public static CalculationResult success( Double value ) {
		
		return new CalculationResult (true,value,null );
		
		
	}
	
	
	public static CalculationResult error( String errorMessage ) {
		
		return new CalculationResult (false, null , errorMessage );
		
		
	}
	
		
	}
	
	

