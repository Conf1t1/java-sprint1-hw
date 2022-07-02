public class MonthData {
    String monthName;
    int[] day = new int[30];


    int countSumSteps() {// Вычисляем сумму шагов
        int sumSteps = 0;
        for (int i = 0; i < day.length; i++) {
            sumSteps = day[i] + sumSteps;
        }
        return sumSteps;
    }

    double countDistance(Converter converter) {
        return converter.stepSmToKm(countSumSteps());
    }
    double countAverageSteps(){
        return countSumSteps() % day.length;

    }
    double countCaloriesByStep(Converter converter){
        return converter.calorieByStepToKiloCalorie(countSumSteps());
    }

}

