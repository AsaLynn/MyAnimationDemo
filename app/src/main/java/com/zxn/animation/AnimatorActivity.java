package com.zxn.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_animator)
public class AnimatorActivity extends AppCompatActivity {

    @ViewInject(R.id.iv_complementary)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }

    @Event(type = View.OnClickListener.class, value = {R.id.btn1,
            R.id.btn2,
            R.id.btn3,
            R.id.btn4,
            R.id.btn5,
            R.id.btn6,
            R.id.btn1_code,
            R.id.btn2_code,
            R.id.btn3_code,
            R.id.btn4_code,
    })
    private void complementary(View view) {
        switch (view.getId()) {
            case R.id.btn1://透明渐变效果,xml
                Animator animator = AnimatorInflater
                        .loadAnimator(this, R.animator.object_animator01);
                animator.setTarget(imageView);
                animator.start();
                break;
            case R.id.btn1_code://透明渐变效果,code
                ObjectAnimator alpha = ObjectAnimator
                        .ofFloat(imageView, "alpha", 0.1f, 1.0f);
                alpha.setDuration(2 * 1000);
                alpha.setRepeatCount(1);
                alpha.setRepeatMode(ValueAnimator.REVERSE);
                alpha.setTarget(imageView);
                alpha.setStartDelay(1 * 1000);
                alpha.start();
                break;
            case R.id.btn2://缩放,xml
                Animator scaleAnimator = AnimatorInflater
                        .loadAnimator(this, R.animator.scale_animator);
                scaleAnimator.setTarget(imageView);
                scaleAnimator.start();
                break;
            case R.id.btn2_code://缩放,code
                ObjectAnimator scaleX = ObjectAnimator
                        .ofFloat(imageView, "scaleX", 1.0f, 2.0f);
                scaleX.setDuration(2*1000);
                scaleX.setRepeatCount(1);
                scaleX.setRepeatMode(ValueAnimator.REVERSE);
                scaleX.setTarget(imageView);
                scaleX.start();
                break;
            case R.id.btn3://旋转,xml
                Animator rotation = AnimatorInflater
                        .loadAnimator(this, R.animator.rotation_animator);
                rotation.setTarget(imageView);
                rotation.start();
                break;
            case R.id.btn3_code:
                ObjectAnimator rotationAnimator = ObjectAnimator
                        .ofFloat(imageView, "rotation", 0, 360f);
                rotationAnimator.setDuration(2 *1000);
                rotationAnimator.setTarget(imageView);
                rotationAnimator.setRepeatMode(ValueAnimator.REVERSE);
                rotationAnimator.setRepeatCount(1);
                rotationAnimator.start();
                break;
            case R.id.btn4:
                Animator translationAnimator = AnimatorInflater
                        .loadAnimator(this, R.animator.translation_animator);
                translationAnimator.setTarget(imageView);
                translationAnimator.start();
                break;
            case R.id.btn4_code:
                ObjectAnimator translationYAnimator = ObjectAnimator
                        .ofFloat(imageView, "translationY", 0, -200);
                translationYAnimator.setDuration(2000);
                translationYAnimator.setTarget(imageView);
                translationYAnimator.setRepeatMode(ValueAnimator.REVERSE);
                translationYAnimator.setRepeatCount(1);
                translationYAnimator.start();
                break;
            case R.id.btn5:
                Animator setAnimator = AnimatorInflater
                        .loadAnimator(this, R.animator.set_animator);
                setAnimator.setTarget(imageView);
                setAnimator.start();
                break;
            case R.id.btn6:
                AnimatorSet animatorSet = new AnimatorSet();
                ObjectAnimator xAnimator = ObjectAnimator
                        .ofFloat(imageView, "scaleX", 1.0f, 2.0f);
                xAnimator.setDuration(2000);
                ObjectAnimator yAnimator = ObjectAnimator
                        .ofFloat(imageView, "scaleY", 1.0f, 2.0f);
                yAnimator.setDuration(2000);
                animatorSet.playTogether(xAnimator,yAnimator);
                animatorSet.setTarget(imageView);
                animatorSet.start();
                break;
        }
    }
}
