package com.zxn.animation;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_frame)
public class FrameActivity extends AppCompatActivity {

    @ViewInject(R.id.imageView)
    ImageView imageView;
    private AnimationDrawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
//        anim1();
//        anim2();
//        anim3();
        anim4();
    }

    private void anim4() {
        //AnimationDrawable创建
        drawable = new AnimationDrawable();
        //添加图片资源
        drawable.addFrame(getResources().getDrawable(R.drawable.img00),50);
        drawable.addFrame(getResources().getDrawable(R.drawable.img01),50);
        drawable.addFrame(getResources().getDrawable(R.drawable.img02),50);
        drawable.addFrame(getResources().getDrawable(R.drawable.img03),50);
        drawable.addFrame(getResources().getDrawable(R.drawable.img04),50);
        drawable.addFrame(getResources().getDrawable(R.drawable.img05),50);
        drawable.addFrame(getResources().getDrawable(R.drawable.img06),50);
        drawable.addFrame(getResources().getDrawable(R.drawable.img07),50);
        drawable.addFrame(getResources().getDrawable(R.drawable.img08),50);
        drawable.addFrame(getResources().getDrawable(R.drawable.img09),50);
        drawable.addFrame(getResources().getDrawable(R.drawable.img10),50);
        drawable.addFrame(getResources().getDrawable(R.drawable.img11),50);
        drawable.addFrame(getResources().getDrawable(R.drawable.img12),50);
        drawable.addFrame(getResources().getDrawable(R.drawable.img13),50);
        drawable.addFrame(getResources().getDrawable(R.drawable.img14),50);
        drawable.addFrame(getResources().getDrawable(R.drawable.img15),50);
        drawable.addFrame(getResources().getDrawable(R.drawable.img16),50);
        drawable.addFrame(getResources().getDrawable(R.drawable.img17),50);
        drawable.addFrame(getResources().getDrawable(R.drawable.img18),50);
        drawable.addFrame(getResources().getDrawable(R.drawable.img19),50);
        drawable.addFrame(getResources().getDrawable(R.drawable.img20),50);
        drawable.addFrame(getResources().getDrawable(R.drawable.img21),50);
        drawable.addFrame(getResources().getDrawable(R.drawable.img22),50);
        drawable.addFrame(getResources().getDrawable(R.drawable.img23),50);
        drawable.addFrame(getResources().getDrawable(R.drawable.img24),50);
        //设置是否循环播放
        drawable.setOneShot(false);
        //给控件设置动画背景.
        imageView.setBackground(drawable);
    }

    private void anim3() {
        AnimationDrawable background = (AnimationDrawable) imageView.getBackground();
        drawable = background;
    }

    private void anim2() {
        Drawable drawableTemp = getResources().getDrawable(R.drawable.frame_anim);
        drawable = (AnimationDrawable) drawableTemp;//
        imageView.setBackground(drawable);
    }

    private void anim1() {
        //给图片设置背景动画
        imageView.setBackgroundResource(R.drawable.frame_anim);
        //获取到控件的背景动画
        drawable = (AnimationDrawable) imageView.getBackground();
    }


    @Event(type = View.OnClickListener.class, value = {R.id.start, R.id.stop,})
    private void play(View view) {
        switch (view.getId()) {
            case R.id.start://开始
                if (!drawable.isRunning()) {
                    drawable.start();
                }
                break;
            case R.id.stop://停止
                if (drawable.isRunning()) {
                    drawable.stop();
                }
                break;
        }
    }


}
