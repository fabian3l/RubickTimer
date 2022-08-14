package pl.lepsy.test;

import org.springframework.util.StopWatch;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class TestMain {
    public static void main(String[] args) {
//        ScrambleComponent scrambleComponent = new ScrambleComponent();
//
//        System.out.println(scrambleComponent.rubickMixAlg());

//        System.out.println(actualTime());
//        System.out.println(time());
//        System.out.println(timeDivision(actualTime(), time()));

        StopWatch stopWatch = new StopWatch();

        stopWatch.start();

        for (int i = 0; i <= 1000; i++) {
            int numer = i * i;
        }
// Do something
        stopWatch.stop();

        System.out.println(stopWatch.getTotalTimeMillis());
    }

    public static LocalTime actualTime(){
        LocalTime actualTime;
        actualTime = LocalTime.parse("10:12:03");
        return actualTime;
    }
    public static LocalTime time() {
        LocalTime actualTime = LocalTime.now();
        return actualTime;
    }
    public static String timeDivision(LocalTime timeOne, LocalTime timeTwo){
        String timeBetweenMin = String.valueOf(timeOne.until(timeTwo, ChronoUnit.MINUTES));
        String timeBetweenSec = String.valueOf(timeOne.until(timeTwo, ChronoUnit.SECONDS));
        String timeBetweenMs = String.valueOf(timeOne.until(timeTwo, ChronoUnit.MILLIS));

        String result = timeBetweenMin + ":" + timeBetweenSec.substring(0,2) + "." + timeBetweenMs.substring(0,3);
        return result;
    }

}
