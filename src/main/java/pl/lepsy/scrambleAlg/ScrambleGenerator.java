package pl.lepsy.scrambleAlg;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
//Klasa losująca algorytm mieszający, składający się z 19-tu losowych ruchów kostką
public class ScrambleGenerator {
    public static String rubickMixAlg(){


        //tablica ruchów kostką, podzielona na grupy, według ścianek kostki
        //F - frontowa
        //R - prawa
        //L - lewa
        //U - górna
        //D - dolna
        String[] rubickFMoves = {"F", "F'", "F2"};
        String[] rubickRMoves = {"R", "R'", "R2"};
        String[] rubickLMoves = {"L", "L'", "L2"};
        String[] rubickUMoves = {"U", "U'", "U2"};
        String[] rubickDMoves = {"D", "D'", "D2"};

        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        List<Integer> randomList = randomArrayNumbers();

        //Przypisanie wylosowanej cyfry do ruchu kostką
        for(int randomNumber :randomList){
            int randomMove = random.nextInt(3);
            switch (randomNumber) {
                case 0:
                    String chosenFMove = rubickFMoves[randomMove];
                    sb.append(chosenFMove).append(" ");
                    break;
                case 1:
                    String chosenRMove = rubickRMoves[randomMove];
                    sb.append(chosenRMove).append(" ");
                    break;
                case 2:
                    String chosenLMove = rubickLMoves[randomMove];
                    sb.append(chosenLMove).append(" ");
                    break;
                case 3:
                    String chosenUMove = rubickUMoves[randomMove];
                    sb.append(chosenUMove).append(" ");
                    break;
                case 4:
                    String chosenDMove = rubickDMoves[randomMove];
                    sb.append(chosenDMove).append(" ");
                    break;
            }
        }

        String result = sb.toString();
        return result;
    }

    //zwaraca listę 19 cyfr (0-4), tak żeby takie same numery nie były obok siebie
    private static List<Integer> randomArrayNumbers(){
        Random random = new Random();
        List<Integer> result = new ArrayList<>();
        int firstRandomNumber = random.nextInt(5);
        result.add(firstRandomNumber);
        int i = 0;
        while (result.size() <= 19){
            int randomMoveGroup = random.nextInt(5);
            if (result.get(i) != randomMoveGroup) {
                result.add(randomMoveGroup);
                i++;
            }
        }
        return result;
    }
}
