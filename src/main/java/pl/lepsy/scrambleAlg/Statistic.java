package pl.lepsy.scrambleAlg;

import pl.lepsy.solve.Solve;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Statistic {

    public static String worstTimeOfSolve(List<Solve> solveList){
        if (solveList.size() > 0){
            List<Integer> listOfSolvesInt= new ArrayList<>();

            for (Solve solve : solveList) {
                String itemWithoutSigns = solve.getTimeValue().replace(":", "").replace(".", "");
                int number = Integer.parseInt(itemWithoutSigns);
                listOfSolvesInt.add(number);
            }
            Collections.sort(listOfSolvesInt, Collections.reverseOrder());

            String bestTime = String.valueOf(listOfSolvesInt.get(0));
            String convertedTime = "";
            if(bestTime.length() == 7){
                convertedTime = bestTime;
            }else if(bestTime.length() == 6){
                convertedTime = "0" + bestTime;
            }else if(bestTime.length() == 5){
                convertedTime = "00" + bestTime;
            }else if(bestTime.length() == 4){
                convertedTime = "000" + bestTime;
            }else if(bestTime.length() == 3){
                convertedTime = "0000" + bestTime;
            }else if(bestTime.length() == 2){
                convertedTime = "00000" + bestTime;
            }else if(bestTime.length() == 1){
                convertedTime = "000000" + bestTime;
            }

            String bestTime7Numbers = convertedTime;
            String converted7Numbers = bestTime7Numbers.substring(0, 2) + ":" + bestTime7Numbers.substring(2, 4) + "." + bestTime7Numbers.substring(4,7);

            return converted7Numbers;
        }
        return "";
    }
    public static String averageTimeOfSolves(List<Solve> solveList){
        if (solveList.size() > 0){
            List<Integer> listOfSolvesInt= new ArrayList<>();
            int sumOfAll = 0;
            for (Solve solve : solveList) {
                String itemWithoutSigns = solve.getTimeValue().replace(":", "").replace(".", "");
                int number = Integer.parseInt(itemWithoutSigns);
                sumOfAll += number;
                listOfSolvesInt.add(number);
            }
            int average = sumOfAll/listOfSolvesInt.size();
            String averageString = String.valueOf(average);

            String convertedTime = "";
            if(averageString.length() == 7){
                convertedTime = averageString;
            }else if(averageString.length() == 6){
                convertedTime = "0" + averageString;
            }else if(averageString.length() == 5){
                convertedTime = "00" + averageString;
            }else if(averageString.length() == 4){
                convertedTime = "000" + averageString;
            }else if(averageString.length() == 3){
                convertedTime = "0000" + averageString;
            }else if(averageString.length() == 2){
                convertedTime = "00000" + averageString;
            }else if(averageString.length() == 1){
                convertedTime = "000000" + averageString;
            }

            String bestTime7Numbers = convertedTime;
            String converted7Numbers = bestTime7Numbers.substring(0, 2) + ":" + bestTime7Numbers.substring(2, 4) + "." + bestTime7Numbers.substring(4,7);

            return converted7Numbers;

        }
        return "";
    }

    public static String bestTimeOfSolve(List<Solve> solveList){
        if (solveList.size() > 0){
            List<Integer> listOfSolvesInt= new ArrayList<>();

            for (Solve solve : solveList) {
                String itemWithoutSigns = solve.getTimeValue().replace(":", "").replace(".", "");
                int number = Integer.parseInt(itemWithoutSigns);
                listOfSolvesInt.add(number);
            }
            Collections.sort(listOfSolvesInt);
            String bestTime = String.valueOf(listOfSolvesInt.get(0));
            String convertedTime = "";
            if(bestTime.length() == 7){
                convertedTime = bestTime;
            }else if(bestTime.length() == 6){
                convertedTime = "0" + bestTime;
            }else if(bestTime.length() == 5){
                convertedTime = "00" + bestTime;
            }else if(bestTime.length() == 4){
                convertedTime = "000" + bestTime;
            }else if(bestTime.length() == 3){
                convertedTime = "0000" + bestTime;
            }else if(bestTime.length() == 2){
                convertedTime = "00000" + bestTime;
            }else if(bestTime.length() == 1){
                convertedTime = "000000" + bestTime;
            }

            String bestTime7Numbers = convertedTime;
            String converted7Numbers = bestTime7Numbers.substring(0, 2) + ":" + bestTime7Numbers.substring(2, 4) + "." + bestTime7Numbers.substring(4,7);

            return converted7Numbers;
        }
        return "";
    }
}
