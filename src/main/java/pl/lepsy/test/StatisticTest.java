package pl.lepsy.test;

import org.springframework.stereotype.Controller;
import pl.lepsy.solve.Solve;
import pl.lepsy.solve.SolveController;
import pl.lepsy.solve.SolveService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class StatisticTest {


    public static void main(String[] args) {


        List<Integer> listOfSolvesInt= new ArrayList<>();

        for (int i = 0; i < listOfSolvesInt.size(); i++){

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
