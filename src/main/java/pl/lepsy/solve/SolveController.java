package pl.lepsy.solve;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.lepsy.algorithms.pll.PllService;
import pl.lepsy.scrambleAlg.ScrambleGenerator;
import pl.lepsy.scrambleAlg.Statistic;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/solve")
public class SolveController {

    private final SolveService solveService;
    private final PllService pllService;


    public SolveController(SolveService solveService, PllService pllService) {
        this.solveService = solveService;
        this.pllService = pllService;
    }


//Pod przyciskiem 'reset' wyswietla wygererowany algorytm mieszajacy z klasy ScrambleGenerator
    @GetMapping("/main")
    public String MainSiteSolve(Model model, HttpServletRequest request){

        List<Solve> solveList = solveService.getAll();
        String resetButton = request.getParameter("reset");
        String lastSolveTime = solveList.get(solveList.size()-1).getTimeValue();


        model.addAttribute("solveValue", new Solve());
        model.addAttribute("bestSolve", Statistic.bestTimeOfSolve(solveList));
        model.addAttribute("averageSolve", Statistic.averageTimeOfSolves(solveList));
        model.addAttribute("worstSolve", Statistic.worstTimeOfSolve(solveList));
        model.addAttribute("lastSolveTime", lastSolveTime);
        model.addAttribute("pllAll", pllService.getAll());

        if ("newScramble".equals(resetButton)) {
            String scrambleAlgorithm = ScrambleGenerator.rubickMixAlg();
            model.addAttribute("mixAlg", scrambleAlgorithm);
        }
        return "mainView";
    }

    //do ostatniego dodanego obiektu Solve dodaje czas który widnieje na stoperze podczas naciskania przycisku 'stop'
    @PostMapping("/add")
    public String saveSolve(Solve solve){

        if (!"".equals(solve.getScrambleAlg()) && !"00:00.000".equals(solve.getTimeValue())){
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
    @GetMapping("/addPll/{id}")
    public String addPllToSove(Model model, @PathVariable Long id){
        model.addAttribute("solve", solveService.getSolveById(id));
        model.addAttribute("pllAll", pllService.getAll());
        return "addPllToSolve";
    }
    @PostMapping("/addPll/{id}")
    public String saveSolveWithPll(@PathVariable Long id, Solve formSolve){
        Solve solve = solveService.getSolveById(id);
        solve.setPll(formSolve.getPll());
        solveService.updateSolve(solve);
        return "redirect:/solve/all";
    }
}
