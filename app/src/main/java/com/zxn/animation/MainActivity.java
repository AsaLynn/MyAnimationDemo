package com.zxn.animation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.x;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }

    @Event(type = View.OnClickListener.class, value = {R.id.btn_frame_animation,
            R.id.btn_complementary_animation,
            R.id.btn_complementary_xml_animation,
            R.id.btn_animator_animation,

    })
    private void animationClick(View view) {
        switch (view.getId()) {
            case R.id.btn_frame_animation:
                startActivity(new Intent(this, FrameActivity.class));
                break;
            case R.id.btn_complementary_animation:
                startActivity(new Intent(this, ComplementaryActivity.class));
                break;
            case R.id.btn_complementary_xml_animation:
                startActivity(new Intent(this, ComplementaryXmlActivity.class));
                break;
            case R.id.btn_animator_animation:
                startActivity(new Intent(this, AnimatorActivity.class));
                break;
        }
    }

}
