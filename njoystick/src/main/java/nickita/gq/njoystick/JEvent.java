package nickita.gq.njoystick;

/**
 * Created by admin on 26/6/17.
 */
public class JEvent {

    private float jx;
    private float jy;

    public JEvent(float jx, float jy) {
        this.jx = jx;
        this.jy = jy;
    }

    public float getJx() {
        return jx;
    }

    public void setJx(float jx) {
        this.jx = jx;
    }

    public float getJy() {
        return jy;
    }

    public void setJy(float jy) {
        this.jy = jy;
    }
}
