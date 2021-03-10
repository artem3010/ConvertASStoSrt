import javax.persistence.*;

@Entity
@Table(name = "phrases")
public class Phrase {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "hours_begin")
    int hoursBegin;
    @Column(name = "minutes_begin")
    int minutesBegin;
    @Column(name = "seconds_begin")
    int secondsBegin;
    @Column(name = "mseconds_begin")
    int msecondsBegin;
    @Column(name = "hours_end")
    int hoursEnd;
    @Column(name = "minutes_end")
    int minutesEnd;
    @Column(name = "seconds_end")
    int secondsEnd;
    @Column(name = "mseconds_end")
    int msecondsEnd;
    @Column(name = "phrase")
    String phrase;

    public Phrase() {

    }

    public Phrase(int id, int hoursBegin, int minutesBegin, int secondsBegin, int msecondsBegin, int hoursEnd, int minutesEnd, int secondsEnd, int msecondsEnd, String phrase) {
        this.id = id;
        this.hoursBegin = hoursBegin;
        this.minutesBegin = minutesBegin;
        this.secondsBegin = secondsBegin;
        this.msecondsBegin = msecondsBegin;
        this.hoursEnd = hoursEnd;
        this.minutesEnd = minutesEnd;
        this.secondsEnd = secondsEnd;
        this.msecondsEnd = msecondsEnd;
        this.phrase = phrase;
    }

    public int getMsecondsBegin() {
        return msecondsBegin;
    }

    public void setMsecondsBegin(int msecondsBegin) {
        this.msecondsBegin = msecondsBegin;
    }

    public int getMsecondsEnd() {
        return msecondsEnd;
    }

    public void setMsecondsEnd(int msecondsEnd) {
        this.msecondsEnd = msecondsEnd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public void setHoursBegin(int hoursBegin) {
        this.hoursBegin = hoursBegin;
    }

    public void setMinutesBegin(int minutesBegin) {
        this.minutesBegin = minutesBegin;
    }

    public void setSecondsBegin(int secondsBegin) {
        this.secondsBegin = secondsBegin;
    }

    public void setHoursEnd(int hoursEnd) {
        this.hoursEnd = hoursEnd;
    }

    public void setMinutesEnd(int minutesEnd) {
        this.minutesEnd = minutesEnd;
    }

    public void setSecondsEnd(int secondsEnd) {
        this.secondsEnd = secondsEnd;
    }

    public String toSRTFormat() {
        return "";
    } //Do later

    public String getPhrase() {
        return phrase;
    }

    public int getHoursBegin() {
        return hoursBegin;
    }

    public int getMinutesBegin() {
        return minutesBegin;
    }

    public int getSecondsBegin() {
        return secondsBegin;
    }

    public int getHoursEnd() {
        return hoursEnd;
    }

    public int getMinutesEnd() {
        return minutesEnd;
    }

    public int getSecondsEnd() {
        return secondsEnd;
    }
}


