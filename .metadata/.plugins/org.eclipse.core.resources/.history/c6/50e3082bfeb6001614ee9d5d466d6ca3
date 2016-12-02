package textExcel3;

public class FormulaCell extends Cell
{
	private double formula;
	private ExpressionSimplifier mathGod = new ExpressionSimplifier();
	public FormulaCell(String input)
	{
		super(input);
		formula = mathGod.simplify(input);
	}
	@Override
	public String getDisplayValue()
	{
		return "" + formula;
	}

}
