package com.zxn.animation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_complementary_xml)
public class ComplementaryXmlActivity extends AppCompatActivity {

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
    })
    private void complementary(View view) {
        switch (view.getId()){
            case R.id.btn1://旋转
                imageView
                        .startAnimation(AnimationUtils.loadAnimation(this,R.anim.rotete_anim));
                break;
            case R.id.btn2://平移
                imageView
                        .startAnimation(AnimationUtils.loadAnimation(this,R.anim.translate_anim));
                break;
            case R.id.btn3://透明
                imageView
                        .startAnimation(AnimationUtils.loadAnimation(this,R.anim.alpha_anim));
                break;
            case R.id.btn4://缩放
                imageView.startAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_anim));
                break;
            case R.id.btn5://混合同时执行
                imageView.startAnimation(AnimationUtils.loadAnimation(this,R.anim.set_anim));
                break;
            case R.id.btn6://次序播放
                break;
        }
    }

}
