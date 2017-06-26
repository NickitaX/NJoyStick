package nickita.gq.njoystick;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by admin on 26/6/17.
 */
public class NJoyStick extends RelativeLayout {

    private NJoyStickButton NJoyButton;

    public NJoyStick(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public NJoyStick(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public NJoyStick(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NJoyStick(Context context) {
        super(context);
        init();
    }

    private void init(){
        inflate(getContext(), R.layout.njoystick_layout, this);
        NJoyButton = (NJoyStickButton) findViewById(R.id.joy_button);
    }

    public void setJOnMoveListener(JButtonListener l){
        NJoyButton.jl = l;
    }

}
