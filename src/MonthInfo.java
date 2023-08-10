public class MonthInfo {
    public String name;
    public boolean isExpense;
    public int quantity;
    public int unitPrice;

    public MonthInfo(String name, boolean isExpense, int quantity, int unitPrice) {
        this.name = name;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
}
