package pl.lepsy.scrambleAlg;

import pl.lepsy.solve.Solve;
import pl.lepsy.time.Time;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Statistic {
    public static void main(String[] args) {
        Time time1 = new Time();
        time1.setId(1l);
        time1.setTimeValue("00:20.000");

        Time time2 = new Time();
        time2.setId(2l);
        time2.setTimeValue("01:10.000");

        Solve solve1 = new Solve();
        solve1.setSolveId(1l);
        solve1.setScrambleAlg("XYZ");
        solve1.setTime(time1);

        Solve solve2 = new Solve();
        solve2.setId(2l);
        solve2.setScrambleAlg("XTZTZT");
        solve2.setTime(time2);

        List<Solve> solveList = new ArrayList<>();
        solveList.add(solve1);
        solveList.add(solve2);

        System.out.println(worstTimeOfSolve(solveList));
    }
    public static String worstTimeOfSolve(List<Solve> solveList){
        if (solveList.size() > 0){
            List<Integer> listOfSolvesInt= new ArrayList<>();

            for (Solve solve : solveList) {
                String itemWithoutSigns = solve.getTime().getTimeValue().replace(":", "").replace(".", "");
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
                String itemWithoutSigns = solve.getTime().getTimeValue().replace(":", "").replace(".", "");
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
                String itemWithoutSigns = solve.getTime().getTimeValue().replace(":", "").replace(".", "");
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
