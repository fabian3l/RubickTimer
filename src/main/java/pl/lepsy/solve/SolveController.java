package pl.lepsy.solve;


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

        ScrambleAlg scrambleAlg = new ScrambleAlg();
        scrambleAlg.setScrambleValue(ScrambleComponent.rubickMixAlg());

        model.addAttribute("scramble", scrambleAlg);

        model.addAttribute("timeValue", new Time());

        String button = request.getParameter("button");
        if ("newScramble".equals(button)) {
            scrambleAlg.setScrambleValue(scrambleComponent.rubickMixAlg());
            model.addAttribute("mixAlg", scrambleAlg);
        }
        scrambleService.saveScramble(scrambleAlg);

        return "mainView";
    }
    @PostMapping("/add")
    public String addTime(Time time){
        timeService.saveTime(time);
        return "mainView";
    }

}
