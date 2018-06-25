package com.zxn.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_complementary)
public class ComplementaryActivity extends AppCompatActivity {

    @ViewInject(R.id.iv_complementary)
    ImageView iv_complementary;
    private RotateAnimation animation;
    private TranslateAnimation translateAnimation;
    private AlphaAnimation alphaAnimation;
    private ScaleAnimation scaleAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        init();
    }

    private void init() {
        initRotateAnimation();
        initTranslateAnimation();
        initAlphaAnimation();
        initScaleAnimation();
    }

    private void initScaleAnimation() {
        // ScaleAnimation(float fromX, float toX, float fromY, float toY)
        float fromX = 0;
        float toX = 2f;
        float fromY = 0;
        float toY = 2f;
//                ScaleAnimation scaleAnimation = new ScaleAnimation(fromX,toX,fromY,toY);
        //ScaleAnimation(float fromX, float toX, float fromY, float toY,
        //            int pivotXType, float pivotXValue, int pivotYType, float pivotYValue)
        int pivotXType = ScaleAnimation.RELATIVE_TO_SELF;
        int pivotYType = ScaleAnimation.RELATIVE_TO_SELF;
        float pivotXValue = 0.5f;
        float pivotYValue = 0.5f;
        scaleAnimation = new ScaleAnimation(fromX,
        toX,
        fromY,
        toY,
        pivotXType,
        pivotXValue,
        pivotYType,
        pivotYValue);
        scaleAnimation.setDuration(2 * 1000);
    }

    private void initAlphaAnimation() {
        // AlphaAnimation(float fromAlpha, float toAlpha)
        float fromAlpha = 1;
        float toAlpha = 0;
        alphaAnimation = new AlphaAnimation(fromAlpha,toAlpha);
        alphaAnimation.setDuration(2 * 1000);
    }

    private void initTranslateAnimation() {
        //TranslateAnimation(float fromXDelta, float toXDelta, float fromYDelta, float toYDelta)
        float fromXDelta = 0;
        float toXDelta = 500;
        float fromYDelta = 0;
        float toYDelta = 0;
        translateAnimation = new TranslateAnimation(fromXDelta,toXDelta,fromYDelta,toYDelta);
        translateAnimation.setDuration(2 * 1000);
    }

    private void initRotateAnimation() {
        //释放动画
        //RotateAnimation(float fromDegrees, float toDegrees)
        float fromDegrees = 0;
        float toDegrees = 90;
//                RotateAnimation animation = new RotateAnimation(fromDegrees,toDegrees);
        //RotateAnimation(float fromDegrees, float toDegrees, float pivotX, float pivotY)
//                RotateAnimation animation
//                        = new RotateAnimation(fromDegrees,toDegrees,RotateAnimation.RELATIVE_TO_SELF,RotateAnimation.RELATIVE_TO_SELF);
        //RotateAnimation(float fromDegrees, float toDegrees, int pivotXType, float pivotXValue,
        //            int pivotYType, float pivotYValue)
//                int height = iv_complementary.getHeight();
//                int center = height / 2;
        animation = new RotateAnimation(fromDegrees,
        toDegrees,
        RotateAnimation.RELATIVE_TO_SELF,
        0.5f,
        RotateAnimation.RELATIVE_TO_SELF,0.5f);

        animation.setDuration(3*1000);
        animation.setRepeatCount(3);//重复3次,
        animation.setFillAfter(true);//保持旋转之后的状态.
    }

    @Event(type = View.OnClickListener.class, value = {R.id.btn1,
            R.id.btn2,
            R.id.btn3,
            R.id.btn4,
            R.id.btn5,
            R.id.btn6,
    })
    private void complementary(View view) {
        switch (view.getId()){
            case R.id.btn1://旋转
                iv_complementary.startAnimation(animation);
                break;
            case R.id.btn2://平移

                iv_complementary.startAnimation(translateAnimation);
                break;
            case R.id.btn3://透明

                iv_complementary.startAnimation(alphaAnimation);
                break;
            case R.id.btn4://缩放

                iv_complementary.startAnimation(scaleAnimation);
                break;
            case R.id.btn5://混合同时执行
                AnimationSet animationSet
                        = new AnimationSet(true);
                animationSet.addAnimation(animation);
                animationSet.addAnimation(translateAnimation);
                animationSet.addAnimation(alphaAnimation);
                animationSet.addAnimation(scaleAnimation);
                animationSet.setDuration(2 * 1000);
                iv_complementary.startAnimation(animationSet);
                break;
            case R.id.btn6://次序播放
                //先平移,缩放,旋转,透明
                translateAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        //动画播放结束会至此此方法.
                        //缩放
                        iv_complementary.startAnimation(scaleAnimation);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        //旋转
                        iv_complementary.startAnimation(ComplementaryActivity.this.animation);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        //透明
                        iv_complementary.startAnimation(alphaAnimation);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                iv_complementary.startAnimation(translateAnimation);
                break;
        }
    }

}
