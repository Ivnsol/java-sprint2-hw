import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {

    public HashMap<String, ArrayList<MonthInfo>> monthInclude = new HashMap<>();


    public void addMonth(String monthName, String fileName){

        ArrayList<MonthInfo> monthInfos = new ArrayList<>();
        FileReader reader = new FileReader();
    ArrayList<String> lines = reader.readFileContents(fileName);
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] parts = line.split(",");
            String name = parts[0];
            Boolean isExpense = Boolean.parseBoolean(parts[1]);
            int quantity = Integer.parseInt(parts[2]);
            int unitPrice = Integer.parseInt(parts[3]);
            MonthInfo monthInfo = new MonthInfo(name, isExpense, quantity,unitPrice);
            monthInfos.add(monthInfo);
        }
        monthInclude.put(monthName, monthInfos);
    }


    public void getTopProduct(String monthName) {
        System.out.println(monthName);
        ArrayList<MonthInfo> getTopProduct = monthInclude.get(monthName);
        int topProduct = 0;
        int maxProductIndex = -1; // Индекс элемента с максимальным значением
        if (getTopProduct!=null && !getTopProduct.isEmpty()) {
            for (int i = 0; i < getTopProduct.size(); i++) {
                MonthInfo monthInfo = getTopProduct.get(i);

                if (monthInfo.unitPrice * monthInfo.quantity >= topProduct && !monthInfo.isExpense) {
                    topProduct = monthInfo.unitPrice * monthInfo.quantity;
                    maxProductIndex = i; // Обновляем индекс максимального элемента
                }
            }

            if (maxProductIndex != -1) {
                MonthInfo maxProductInfo = getTopProduct.get(maxProductIndex);
                System.out.println("Топовый товар: " + maxProductInfo.name + " " + topProduct + " чеканых монет!");
            } else {
                System.out.println("Проверьте список документов -_-");
            }

        }else {
            System.out.println("Список данных пуст");
        }
    }

    public void getLessProduct(String monthName) {
        ArrayList<MonthInfo> getLessProduct = monthInclude.get(monthName);
        int minProduct = 0;
        int minProductIndex = -1;
        if (getLessProduct!=null && !getLessProduct.isEmpty()) {
            for (int i = 0; i < getLessProduct.size(); i++) {
                MonthInfo monthInfo = getLessProduct.get(i);

                if (monthInfo.unitPrice * monthInfo.quantity >= minProduct && monthInfo.isExpense) {
                    minProduct = monthInfo.unitPrice * monthInfo.quantity;
                    minProductIndex = i;
                }
            }

            if (minProductIndex != -1) {
                MonthInfo maxProductInfo = getLessProduct.get(minProductIndex);
                System.out.println("Самый дорогой товар: " + maxProductInfo.name + " " + minProduct + " чеканых монет!");
            } else {
                System.out.println("Проверьте список документов -_-");
            }

        }else {
            System.out.println("Считайте сначала данные");
        }
    }

    public String getProfit(String monthName) { // метод для подсчета выручки
        ArrayList<MonthInfo> getProfit = monthInclude.get(monthName);
        int profit = 0;
            for (int i = 0; i < getProfit.size(); i++) {
                MonthInfo monthInfo = getProfit.get(i);
                if (!monthInfo.isExpense) {
                    profit += monthInfo.unitPrice * monthInfo.quantity;
                }
            }
        return monthName;
    }

    public void getWaste(String monthName) { // метод для подсчета трат
        ArrayList<MonthInfo> getWaste = monthInclude.get(monthName);
        int Waste = 0;
        for (int i = 0; i < getWaste.size(); i++) {
            MonthInfo monthInfo = getWaste.get(i);
            if (monthInfo.isExpense) {
                Waste += monthInfo.unitPrice * monthInfo.quantity;
            }
        }
    }
    }







