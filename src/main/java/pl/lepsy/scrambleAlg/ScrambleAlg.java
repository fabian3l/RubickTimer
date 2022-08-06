package pl.lepsy.scrambleAlg;

import javax.persistence.*;

@Entity
@Table(name = ScrambleAlg.TABLE_NAME)
public class ScrambleAlg {

    final static String TABLE_NAME = "scramble_alg";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String scrambleValue;

    public ScrambleAlg(){

    }

    public ScrambleAlg(Long id, String scrambleValue) {
        this.id = id;
        this.scrambleValue = scrambleValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScrambleValue() {
        return scrambleValue;
    }

    public void setScrambleValue(String scramble) {
        this.scrambleValue = scramble;
    }
}
