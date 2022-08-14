package pl.lepsy.time;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.lepsy.solve.Solve;

@Controller
@RequestMapping("/time")
public class TimeController {

    private TimeService timeService;

    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    @GetMapping("/add")
    public String addTime(Model model){
        model.addAttribute("time", new Time());
        return "mainView";
    }

    @PostMapping("/add")
    public String addTime(Time time){
        timeService.saveTime(time);

        return "redirect:/solve/main";
    }
}
