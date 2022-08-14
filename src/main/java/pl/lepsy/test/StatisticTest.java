package pl.lepsy.test;

import org.springframework.stereotype.Controller;
import pl.lepsy.solve.Solve;
import pl.lepsy.solve.SolveController;
import pl.lepsy.solve.SolveService;
import pl.lepsy.time.Time;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class StatisticTest {


    public static void main(String[] args) {


        Time time1 = new Time();
        time1.setId(1l);
        time1.setTimeValue("02:16.001");

        Time time2 = new Time();
        time2.setId(2l);
        time2.setTimeValue("01:00.112");

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

        System.out.println(solveList);

        List<Integer> listOfSolvesInt= new ArrayList<>();

        for (int i = 0; i < solveList.size(); i++){
            String itemWithoutSigns = solveList.get(i).getTime().getTimeValue().replace(":","").replace(".","");
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

        System.out.println(converted7Numbers);

    }
}
