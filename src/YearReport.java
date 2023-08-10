
import java.util.ArrayList;
import java.util.HashMap;

public class YearReport {
    public HashMap<String, ArrayList<YearInfo>> yearInclude = new HashMap<>();


    public void addYear(String yearName, String fileName){

        ArrayList<YearInfo> yearInfos = new ArrayList<>();
        FileReader reader = new FileReader();
        ArrayList<String> lines = reader.readFileContents(fileName);
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] parts = line.split(",");
            int month = Integer.parseInt(parts[0]);
            int amount = Integer.parseInt(parts[1]);
            Boolean isExpense = Boolean.parseBoolean(parts[2]);
            YearInfo yearInfo = new YearInfo(month, amount, isExpense);
            yearInfos.add(yearInfo);
        }
        yearInclude.put(yearName, yearInfos);
    }


    public void profitPerMonth(String yearName) {
        System.out.println(yearName);
        ArrayList<YearInfo> profitPerMonth = yearInclude.get(yearName);
        int profit = 0;
        int monthNumber = 0;
        if (profitPerMonth!=null && !profitPerMonth.isEmpty()) {
            for (int i = 0; i < profitPerMonth.size(); i++) {
                YearInfo yearInfo = profitPerMonth.get(i);
                if (!yearInfo.isExpense) {
                    profit = yearInfo.amount;
                    monthNumber = yearInfo.month;
                    System.out.println("Прибыль за " + monthNumber + " месяц "+ yearName + " года составила "+profit);
                }
            }
        }else {
            System.out.println("Список данных пуст");
        }
    }

    public void expend(String yearName) {

        ArrayList<YearInfo> expend = yearInclude.get(yearName);
        int expends = 0;
        int index = 0;
        if (expend!=null && !expend.isEmpty()) {
        for (int i = 0; i < expend.size(); i++) {
            YearInfo yearInfo = expend.get(i);
            if (yearInfo.isExpense) {
                index += 1;
                expends += yearInfo.amount;
            }
        }
            if (index != 0) {
                int average = expends / index;
                System.out.println("Средняя cумма трат за месяц - " + average);
            }
        }else {
        }
        }

    public void income(String yearName) {

        ArrayList<YearInfo> income = yearInclude.get(yearName);
        int expends = 0;
        int index = 0;
        if (income!=null && !income.isEmpty()) {
        for (int i = 0; i < income.size(); i++) {
            YearInfo yearInfo = income.get(i);
            if (!yearInfo.isExpense) {
                index += 1;
                expends = expends + yearInfo.amount;
            }
        }
            if (index != 0) {
                int sum = expends / index;
                System.out.println("Средний заработок за месяц - " + sum);
            }
    }else {
    }
    }



}
