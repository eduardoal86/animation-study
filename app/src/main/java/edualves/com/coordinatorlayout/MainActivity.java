package edualves.com.coordinatorlayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

    private LinearLayout container;
    private Button btn;
    private Button hideBtn;
    private Button slideReg;
    private Button slideDec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = (LinearLayout) findViewById(R.id.container_parent);
        btn = (Button) findViewById(R.id.btn);
        slideReg = (Button) findViewById(R.id.btn_slide);
        slideDec = (Button) findViewById(R.id.btn_slide_dec);

        hideBtn = (Button) findViewById(R.id.btn_hide);

    }

    @Override
    protected void onResume() {
        super.onResume();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                container.setVisibility(View.VISIBLE);
                final Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_overshoot);
                container.setAnimation(animation);
            }
        });

        slideReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                container.setVisibility(View.VISIBLE);
                final Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_regular);
                container.setAnimation(animation);
            }
        });

        slideDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                container.setVisibility(View.VISIBLE);
                final Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_decelerate);
                container.setAnimation(animation);
            }
        });

        hideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                container.setVisibility(View.GONE);
            }
        });

    }
}
