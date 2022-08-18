package pl.lepsy.solve;
import lombok.Data;
import pl.lepsy.algorithms.pll.Pll;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = Solve.TABLE_NAME)
@Data
public class Solve {

    final static String TABLE_NAME = "solves";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "solve_id")
    private Long solveId;
    @Column(name = "scramble_alg")
    private String scrambleAlg;
    @Column(name = "time_value")
    private String timeValue;
    @ManyToOne
    @JoinColumn(name = "pll_id")
    private Pll pll;


    public Solve(){

    }

    public Solve(Long solveId, String scrambleAlg, String timeValue, Pll pll) {
        this.solveId = solveId;
        this.scrambleAlg = scrambleAlg;
        this.timeValue = timeValue;
        this.pll = pll;
    }

    public Long getSolveId() {
        return solveId;
    }

    public void setSolveId(Long solveId) {
        this.solveId = solveId;
    }

    public String getScrambleAlg() {
        return scrambleAlg;
    }

    public void setScrambleAlg(String scrambleAlg) {
        this.scrambleAlg = scrambleAlg;
    }

    public String getTimeValue() {
        return timeValue;
    }

    public void setTimeValue(String timeValue) {
        this.timeValue = timeValue;
    }

    public Pll getPll() {
        return pll;
    }

    public void setPll(Pll pll) {
        this.pll = pll;
    }
}
