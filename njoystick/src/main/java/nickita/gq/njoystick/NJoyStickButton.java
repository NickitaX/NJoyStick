package nickita.gq.njoystick;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by admin on 26/6/17.
 */
public class NJoyStickButton extends RelativeLayout {

    float dX, dY;
    @Nullable JButtonListener jl;


    public NJoyStickButton(Context context) {
        super(context);
        init();
    }

    public NJoyStickButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NJoyStickButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public NJoyStickButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        inflate(getContext(), R.layout.njoystick_button, this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        RelativeLayout parent = (RelativeLayout)getParent();
        switch (event.getAction()) {

            case MotionEvent.ACTION_UP:
                this.animate()
                        .x(parent.getPivotX()/2)
                        .y(parent.getPivotY()/2)
                        .setDuration(0)
                        .start();
                break;

            case MotionEvent.ACTION_DOWN:

                dX = this.getX() - event.getRawX();
                dY = this.getY() - event.getRawY();
                break;

            case MotionEvent.ACTION_MOVE:
                try{
                jl.JoystickChanged(new JEvent(event.getRawX() + dX,event.getRawY() + dY));
                }catch (NullPointerException e){
                    Log.e("NJoyStick", "Don't forget to set up setJOnMoveListener() for NJoyStick to listen for events");
                }
                this.animate()
                        .x(event.getRawX() + dX)
                        .y(event.getRawY() + dY)
                        .setDuration(0)
                        .start();


//                if(parent.getPivotY()<event.getRawY() + dY){
//                    this.animate()
//                            .x(event.getRawX() + dX)
//                            .setDuration(0)
//                            .start();
//                }else{
//                    if(parent.getPivotX()<event.getRawX() + dX){
//                        this.animate()
//                                .y(event.getRawY() + dY)
//                                .setDuration(0)
//                                .start();
//                    }else{
//                        this.animate()
//                                .x(event.getRawX() + dX)
//                                .y(event.getRawY() + dY)
//                                .setDuration(0)
//                                .start();
//                    }
//                }



                break;
            default:
                return false;
        }
        return true;
    }



}
