import java.util.ArrayList;

public class Checker {
    public MonthlyReport monthlyReport;
    public YearReport yearReport;

    public Checker(MonthlyReport monthlyReport, YearReport yearReport) {
        this.monthlyReport = monthlyReport;
        this.yearReport = yearReport;
    }

    public boolean check(String yearName, String monthName) {
        ArrayList<MonthInfo> month = monthlyReport.monthInclude.get(monthName);
        ArrayList<YearInfo> year = yearReport.yearInclude.get(yearName);
        int profit = 0;
        int waste = 0;
        int monthNumber = 0;
        if (month != null && !month.isEmpty() && year != null && !year.isEmpty()) {
            for (int i = 1; i < month.size(); i++) {
                YearInfo yearInfo = year.get(i);
                if (getMonthNumber(monthName) == yearInfo.month) {
                if (!yearInfo.isExpense || yearInfo.isExpense) { //Проглядел дальнейшее условие *_*
                    profit = yearInfo.amount;
                    waste = yearInfo.amount;
                    if (profit == monthlyReport.getProfit(monthName) || monthlyReport.getWaste(monthName) == waste) {
                    } else {
                        System.out.println("Ошибка в отчетах за " + yearInfo.month + " месяц.");
                    }
                }
                }
            }
            return true;
        } else {
            System.out.println("Список данных пуст");
            return false;
        }
    }

    private int getMonthNumber(String monthName) {
        if (monthName.equalsIgnoreCase("January")) {
            return 1;
        } else if (monthName.equalsIgnoreCase("February")) {
            return 2;
        } else if (monthName.equalsIgnoreCase("March")) {
            return 3;
        }
        return -1;
    }
}