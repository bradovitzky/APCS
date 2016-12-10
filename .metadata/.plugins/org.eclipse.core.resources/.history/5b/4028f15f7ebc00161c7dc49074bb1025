package textExcel4;

public class FormulaCell extends Cell
{
	private double formula;
	private Spreadsheet sheet;
	private ExpressionSimplifier mathGod = new ExpressionSimplifier();
	public FormulaCell(String input, Spreadsheet sheet)
	{
		super(input);
		this.sheet = sheet;
	}
	@Override
	public String getDisplayValue()
	{
		formula = mathGod.simplify(getOriginalValue().substring(1, getOriginalValue().length()-1), sheet);
		return "" + formula;
	}

}
