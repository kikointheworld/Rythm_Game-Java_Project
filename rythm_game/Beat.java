package rythm_game;

public class Beat {
    private int time; // dropping time of note
    private String noteName; // S, D, F, Space, J, K, L

    public Beat(int time, String noteName) {
        super();
        this.time = time;
        this.noteName = noteName;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getNoteName() {
        return noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }
}
