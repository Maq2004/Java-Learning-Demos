package day_16_接口计算器;

public class Calculator implements Calc {

	@Override
	public CalculationResult add(Double x ,Double y) {
		// TODO 自动生成的方法存根
		return CalculationResult.success(x+y);
	}

	@Override
	public CalculationResult del(Double x ,Double y) {
		// TODO 自动生成的方法存根
		return CalculationResult.success(x-y);
	}

	@Override
	public CalculationResult mul(Double x ,Double y) {
		// TODO 自动生成的方法存根
		return CalculationResult.success(x*y);
	}

	@Override
	public CalculationResult div(Double x ,Double y) {
		// TODO 自动生成的方法存根
		if(y  == 0) {
		return CalculationResult.error("除数不能为零");	
		}
		return CalculationResult.success(x/y);	
		
	}
	
	

}
