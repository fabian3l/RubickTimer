package pl.lepsy.solve;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.lepsy.scrambleAlg.ScrambleGenerator;
import pl.lepsy.scrambleAlg.Statistic;
import pl.lepsy.time.Time;
import pl.lepsy.time.TimeService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/solve")
public class SolveController {

    private final SolveService solveService;
    private final TimeService timeService;

    public SolveController(SolveService solveService, TimeService timeService) {
        this.solveService = solveService;
        this.timeService = timeService;
    }

//Pod przyciskiem 'reset' wyswietla wygererowany algorytm mieszajacy z klasy ScrambleGenerator
    @GetMapping("/main")
    public String MainSiteSolve(Model model, HttpServletRequest request, RedirectAttributes redirectModel){

        List<Solve> solveList = solveService.getAll();
        String resetButton = request.getParameter("reset");
        Solve solve = new Solve();

        model.addAttribute("timeValue", new Time());

        model.addAttribute("bestSolve", Statistic.bestTimeOfSolve(solveList));
        model.addAttribute("averageSolve", Statistic.averageTimeOfSolves(solveList));
        model.addAttribute("worstSolve", Statistic.worstTimeOfSolve(solveList));

        if ("newScramble".equals(resetButton)) {
            String srambleAlgorith = ScrambleGenerator.rubickMixAlg();
            solve.setScrambleAlg(ScrambleGenerator.rubickMixAlg());
            model.addAttribute("mixAlg", solve);
            solveService.saveSolve(solve);
        }
        return "mainView";
    }

    //do ostatniego dodanego obiektu Solve dodaje czas który widnieje na stoperze podczas naciskania przycisku 'stop'
    @PostMapping("/add")
    public String saveTime(Time time){
        if (!"00:00.000".equals(time.getTimeValue())){
            List<Solve> solveList = solveService.getAll();
            Solve solve = solveList.get(solveList.size()-1);
            solve.setTime(time);
            timeService.saveTime(time);
            solveService.saveSolve(solve);
        }
        return "redirect:/solve/main";
    }
    //odnosnik do podstrony z wszystkimi ułożeniami
    @RequestMapping("/all")
    public String showAllSolves(Model model){
        model.addAttribute("solves", solveService.getAll());
        return "allSolves";
    }
    //usuwa wybrane ułożenie
    @RequestMapping("/delete/{id}")
    public String deleteSolve(@PathVariable Long id){
        solveService.deleteSolve(id);
        return "redirect:/solve/all";
    }




}
