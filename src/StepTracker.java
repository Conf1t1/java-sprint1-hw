public class StepTracker {

    MonthData[] monthToData;
    static String[] monthNames = {"Январь", "Февраль", "Март",
            "Апрель", "Май", "Июнь",
            "Июль", "Август", "Сентябрь",
            "Октябрь", "Ноябрь", "Декабрь"};
    int stepsGoal = 10000;
    Converter converter = new Converter();

    public StepTracker() {
        monthToData = new MonthData[12];

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
            monthToData[i].monthName = monthNames[i];
            for (int j = 0; j < monthToData[i].day.length;j++) {
                monthToData[i].day[j] = 0;
            }
        }
    }

    void printAllSteps(int month) {
        System.out.println(monthToData[month].monthName);
        for (int i = 0; i < monthToData[month].day.length; i++) {// Длина
            System.out.println("День " + (i + 1) + ". Пройдено " + monthToData[month].day[i] + " шагов.");
        }

    }

    void sumSteps(int month) {
        System.out.println("Общее количество шагов за " + monthToData[month].monthName + " " + monthToData[month].countSumSteps() + " шагов.");
    }

    void saveSteps(int month, int day, int stepPerDay) {
        monthToData[month].day[day - 1] = stepPerDay;
        System.out.println("Количество шагов успешно сохранено! " + monthToData[month].monthName + ". День " + day + ". " + monthToData[month].day[day -1] + " шагов.");
    }

    void findMaxSteps(int month) {
        int maxSteps = 0;
        for (int i = 0; i < monthToData[month].day.length; i++) {// Длина
            if (monthToData[month].day[i] > maxSteps) {
                maxSteps = monthToData[month].day[i];
            }
        }
        System.out.println("Максимальное пройденное количество шагов в " + monthToData[month].monthName + " - " + maxSteps + " шагов.");
    }

    void averageSteps(int month) {
        System.out.println("Среднее количество шагов за " + monthToData[month].monthName + " - " + monthToData[month].countAverageSteps() + " шагов.");
    }

    void distanceBySteps(int month) {
        System.out.println("Пройденная дистанция за " + monthToData[month].monthName + " - " + monthToData[month].countDistance(converter) +" км.");
    }

    void caloriesBySteps(int month) {
        System.out.println("Количество сожжённых килокалорий за " + monthToData[month].monthName + " - " + monthToData[month].countCaloriesByStep(converter) +" Ккал.");
    }

    void seriesOfGoal(int month){
        int daysWhenGoal = 0;
        int series = 0;
        for (int i = 0; i < monthToData[month].day.length; i++) {
            if (monthToData[month].day[i] >= stepsGoal) {
                series = series + 1;
                if (daysWhenGoal < series){
                    daysWhenGoal = series;
                }
            }
           else if (monthToData[month].day[i] < stepsGoal) {
                series = 0;
            }
        }
        System.out.println("Лучшая серия за " + monthToData[month].monthName + " - "+ daysWhenGoal + " дней.");
    }

    void changeGoal(int newStepGoal) {
        stepsGoal = newStepGoal;
        System.out.println("Значение целевого количества шагов успешно изменено и равняется " + stepsGoal + " шагов.");
    }

    void allStatisticsForMonth (int month){
        printAllSteps(month);
        sumSteps(month);
        findMaxSteps(month);
        averageSteps(month);
        distanceBySteps(month);
        caloriesBySteps(month);
        seriesOfGoal(month);
    }

}




