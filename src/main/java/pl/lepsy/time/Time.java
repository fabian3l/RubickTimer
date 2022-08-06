package pl.lepsy.time;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = Time.TABLE_NAME)
@Data
public class Time {

    final static String TABLE_NAME = "time";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String timeValue;

    public Time() {
    }

    public Time(Long id, String timeValue) {
        this.id = id;
        this.timeValue = timeValue;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTimeValue() {
        return timeValue;
    }

    public void setTimeValue(String timeValue) {
        this.timeValue = timeValue;
    }
}
