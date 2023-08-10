import java.lang.reflect.Array;
import java.util.ArrayList;

public class Checker {
    MonthlyReport monthlyReport = new MonthlyReport();
    YearReport yearReport = new YearReport();

    public void check(String yearName, String monthName) {
        ArrayList<YearInfo> checkYear = yearReport.yearInclude.get(yearName);
        ArrayList<MonthInfo> checkMonth = monthlyReport.monthInclude.get(monthName);

        if (null != checkYear && checkYear.isEmpty() && null != checkMonth && checkMonth.isEmpty()) {

                for (int i = 0; i < checkYear.size(); i++) {
                    YearInfo yearInfo = checkYear.get(i);
                    if (Integer.parseInt(monthlyReport.getProfit(monthName)) == yearInfo.amount) {

                    } else {
                        System.out.println("ошибка в считывание " + monthName);
                    }
                }
            }
    }
}

//        if ((checkYear && checkMonth).isEmpty())
//            if (null != (checkYear && checkMonth)) {
//                for (int i = 0; i < checkYear.size(); i++) {
//                YearInfo yearInfo = checkYear.get(i);
//
//                    for (int i = 0; i < checkMonth.size(); i++) {
//                        MonthInfo monthInfo = checkMonth.get(i);
//
//                        if (monthName == "January" && yearInfo.month == 01)
//                            YearInfo.contains(monthlyReport.getProfit(monthName));
//
//
//                    }
//            } else {
//                System.out.println("Cначала считайте данные отчетов");
//            }
//    }

/*Сверить отчёты — по сохранённым данным проверить, сходятся ли отчёты за месяцы и за год.*/