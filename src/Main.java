import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        printMenu();
        int userInput =scanner.nextInt();
        while (userInput !=0) {
            switch (userInput) {
                case 1:
                System.out.println("Введите месяц от 0 до 11");
                printMonthNamesMenu();
                int month = chooseMonth(scanner);
                System.out.println("Введите номер дня от 1 до 30");
                int day = chooseDay(scanner);
                System.out.println("Введите количество пройденных шагов");
                int stepPerDay = chooseStepPerDay(scanner);
                stepTracker.saveSteps(month, day, stepPerDay);
                break;
                case 2:
                System.out.println("Введите месяц от 0 до 11");
                printMonthNamesMenu();
                month = chooseMonth(scanner);
                stepTracker.allStatisticsForMonth(month);
                break;
                case 3:
                System.out.println("Целевое количество шагов равняется " + stepTracker.stepsGoal);
                System.out.println("Введите новое целевое количество шагов");
                int newStepGoal = scanner.nextInt();
                if (newStepGoal > 0){
                    stepTracker.changeGoal(newStepGoal);
                }else {
                    System.out.println("Значение не может быть отрицательным");
                }
                break;
            }
            printMenu();
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завершена");
    }


    private static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }

    public static void printMonthNamesMenu() {
        for (int i = 0; i < StepTracker.monthNames.length; i++) {
            System.out.println(i + " - " + StepTracker.monthNames[i]);
        }
    }

            public static int chooseMonth (Scanner scanner) {
        int month;
        month = scanner.nextInt();
        while (!(month <= 11 && month >= 0)) {
            month = scanner.nextInt();
            if (month <= 11 && month >= 0) {
                return month;
            } else {
                System.out.println("Нет такой команды, попробуйте снова");
                }
            }
        return month;
    }

    public static int chooseDay(Scanner scanner) {
        int day;
        day = scanner.nextInt();
        while (!(day <= 30 && day >= 1)) {
            day = scanner.nextInt();
            if (day <= 30 && day >= 1) {
                return day;
            } else {
                System.out.println("Нет такой команды, попробуйте снова");
            }
        }
        return day;
    }
    public static int chooseStepPerDay(Scanner scanner){
        int stepPerDay;
        stepPerDay = scanner.nextInt();
                while (true){
                    if (stepPerDay > 0){
                        return stepPerDay;
                    }else {
                        System.out.println("Неверное значение");
                    }
                }
    }
}
