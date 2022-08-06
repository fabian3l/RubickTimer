package pl.lepsy.scrambleAlg;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ScrambleService {
    ScrambleRepository scrambleRepository;

    public ScrambleService(ScrambleRepository scrambleRepository) {
        this.scrambleRepository = scrambleRepository;
    }

    public void saveScramble(ScrambleAlg scrambleAlg){
        scrambleRepository.save(scrambleAlg);
    }


}
