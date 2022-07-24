package telran.people;

public class SalesPerson extends Employee {
	private static int minPercentPay = 0;
	private static int maxPercentPay = 100;
	private int sales;
	private int percentPay;

	public SalesPerson(long id, int birthYear, String email, int basicSalary, int sales, int percentPay) {
		super(id, birthYear, email, basicSalary);
		setSales(sales);
		setPercentPay(percentPay);
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public void setPercentPay(int percentPay) {
	
		if (percentPay < minPercentPay || percentPay > maxPercentPay) {
			throw new IllegalArgumentException(String.format("%d - wrong Percent, "
					+"should be in range [%d - %d]", percentPay, minPercentPay, maxPercentPay));
		}
		
		this.percentPay = percentPay;
	}

	@Override
	public int computePay() {
		return super.computePay() + sales * percentPay / 100;
	}
}