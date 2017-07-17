package edualves.com.coordinatorlayout;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

    private LinearLayout container;
    private LinearLayout target;
    private Button btn;
    private Button hideBtn;
    private Button slideReg;
    private Button slideDec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = (LinearLayout) findViewById(R.id.container_parent);
        target = (LinearLayout) findViewById(R.id.container_target);

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

                final ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 210);
                valueAnimator.setDuration(600);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {

                        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) target.getLayoutParams();
                        layoutParams.setMargins(0, (Integer) valueAnimator.getAnimatedValue(), 0, 0);
                        target.setLayoutParams(layoutParams);
                    }
                });
                valueAnimator.start();


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

                final ValueAnimator valueAnimator = ValueAnimator.ofInt(210, 0);
                valueAnimator.setDuration(600);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {

                        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) target.getLayoutParams();
                        layoutParams.setMargins(0, (Integer) valueAnimator.getAnimatedValue(), 0, 0);
                        target.setLayoutParams(layoutParams);
                    }
                });
                valueAnimator.start();

                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) target.getLayoutParams();
                layoutParams.setMargins(0, 0, 0, 0);
                target.setLayoutParams(layoutParams);
            }
        });

    }
}
