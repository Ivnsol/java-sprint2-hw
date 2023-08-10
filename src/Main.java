import java.time.MonthDay;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MonthlyReport monthlyReport = new MonthlyReport();
        YearReport yearReport = new YearReport();
        Checker checker = new Checker();
//TRUE-трата FALSE-доход





        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                monthlyReport.addMonth("January", "m.202101.csv");

                monthlyReport.addMonth("February", "m.202102.csv");

                monthlyReport.addMonth("March", "m.202103.csv");



            } else if (command == 2) {

                yearReport.addYear("2021", "y.2021.csv");

            } else if (command == 3) {

                checker.check("2021", "January");

            } else if (command == 4) {
                monthlyReport.getTopProduct("January");
                monthlyReport.getLessProduct("January");

                monthlyReport.getTopProduct("February");
                monthlyReport.getLessProduct("February");

                monthlyReport.getTopProduct("March");
                monthlyReport.getLessProduct("March");
            } else if (command == 5) {

                yearReport.profitPerMonth("2021");
                yearReport.expend("2021");
                yearReport.income("2021");

            } else if (command == 1111) {
                return;
            } else {
                return;
            }
        }
    }

    public static void printMenu() {
        System.out.println("Выберите действие");
        System.out.println("1 - Считать все месячные отчеты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("1111 - Закрыть программу");
    }
}

