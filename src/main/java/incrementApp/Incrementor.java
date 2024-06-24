package incrementApp;

import java.io.Serializable;

public class Incrementor implements Serializable {

    private Long value;


    public Incrementor() {
        this.value = 0L;
    }

    public Long increment() {
        return ++value;
    }

    public void reset() {
        value = 0l;
    }

    public Long getValue() {
        return value;
    }
}
