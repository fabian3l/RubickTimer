package pl.lepsy.time;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.lepsy.solve.Solve;

import java.util.List;

@Service
@Transactional
public class TimeService {
    private final TimeRepository timeRepository;

    public TimeService(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }
    public List<Time> getAll(){
        return timeRepository.findAll();
    }
    public Time getTimeById(Long id){
        return timeRepository.getOne(id);
    }
    public void saveTime(Time time){
        timeRepository.save(time);
    }
    public void updateTime(Time time){
        timeRepository.save(time);
    }
    public void deletTime(Long id){
        timeRepository.deleteById(id);
    }
}
