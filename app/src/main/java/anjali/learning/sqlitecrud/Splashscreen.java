package anjali.learning.sqlitecrud;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Splashscreen extends AppCompatActivity {
    ImageView tryanimationimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splashscreen);
        tryanimationimg=findViewById(R.id.imgtryanimation);

        Animation anim = AnimationUtils.loadAnimation(this,R.anim.animationsplash);
        tryanimationimg.startAnimation(anim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent rediretToMainPage=new Intent(Splashscreen.this,MainActivity.class);
                startActivity(rediretToMainPage);
            }
        },12000);
    }
}