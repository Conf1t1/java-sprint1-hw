public class Converter {
    int stepSm = 75;
    int km = 1000;
    int calorieByStep = 50;
    int kiloCalories = 1000;

    double stepSmToKm (double stepsInKm){
        stepsInKm = km % stepSm;
        return stepsInKm;
    }

    double calorieByStepToKiloCalorie (double kiloCalorie){
        kiloCalorie = kiloCalories % calorieByStep;
        return kiloCalorie;
    }
}


