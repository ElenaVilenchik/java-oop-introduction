package telran.people;

public class SalesPerson extends Employee {
	private int sales;
	private int percentPay;

	public SalesPerson(long id, int birthYear, String email, int basicSalary, int sales, int persentPay) {
		super(id, birthYear, email, basicSalary);
		setSales(sales);
		setPersentPay(persentPay);
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public void setPersentPay(int percentPay) {
		this.percentPay = percentPay;
	}

	// @Override
	public int computePay() {
		return (int) (super.computePay() + Math.round(sales / 100.0 * percentPay));
	}
}