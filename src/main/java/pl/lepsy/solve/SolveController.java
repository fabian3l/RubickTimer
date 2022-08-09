package pl.lepsy.solve;


import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.lepsy.scrambleAlg.ScrambleAlg;
import pl.lepsy.scrambleAlg.ScrambleComponent;
import pl.lepsy.scrambleAlg.ScrambleService;
import pl.lepsy.time.Time;
import pl.lepsy.time.TimeService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Controller
@RequestMapping("/solve")
public class SolveController {

    private SolveService solveService;
    private ScrambleService scrambleService;
    private TimeService timeService;
    private ScrambleComponent scrambleComponent;

    public SolveController(SolveService solveService, ScrambleService scrambleService, TimeService timeService) {
        this.solveService = solveService;
        this.scrambleService = scrambleService;
        this.timeService = timeService;
    }

    @RequestMapping("/all")
    @ResponseBody
    public String getAllSolves(){
        return solveService.getAll().toString();
    }

    @GetMapping("/main")
    public String MainSiteSolve(Model model, HttpServletRequest request){
        String resetButton = request.getParameter("reset");
        ScrambleAlg scrambleAlg = new ScrambleAlg();

        model.addAttribute("timeValue", new Time());

        if ("newScramble".equals(resetButton)) {
            scrambleAlg.setScrambleValue(scrambleComponent.rubickMixAlg());
            model.addAttribute("mixAlg", scrambleAlg);
            scrambleService.saveScramble(scrambleAlg);
        }

        return "mainView";
    }

    @GetMapping("/add")
    public String addTime(Model model){
        model.addAttribute("timeValue", new Time());
        return "addTime";
    }
    @PostMapping("/add")
    public String saveTime(Time time){
        timeService.saveTime(time);
        return "redirect:/solve/main";
    }
}
