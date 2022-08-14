package pl.lepsy.solve;
import lombok.Data;
import pl.lepsy.time.Time;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = Solve.TABLE_NAME)
@Data
public class Solve {

    final static String TABLE_NAME = "solves";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "solveId_PK")
    private Long solveId;
    private String scrambleAlg;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "solveTime_FK")
    private Time time;


    public Solve(){

    }

    public Solve(Long solveId, String scramble, Time time) {
        this.solveId = solveId;
        this.scrambleAlg = scramble;
        this.time = time;
    }

    public Long getId() {
        return solveId;
    }

    public void setId(Long id) {
        this.solveId = id;
    }

    public String getScrambleAlg() {
        return scrambleAlg;
    }

    public void setScrambleAlg(String scrambleAlg) {
        this.scrambleAlg = scrambleAlg;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
