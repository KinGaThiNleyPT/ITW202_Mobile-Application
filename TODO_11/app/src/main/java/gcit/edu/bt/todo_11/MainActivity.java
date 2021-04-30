package gcit.edu.bt.todo_11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    public String[] color = {"red", "pink", "purple", "deep_purple",
            "indigo", "blue", "light_blue", "cyan", "teal", "green",
            "light_green", "lime", "yellow", "amber", "orange", "deep_orange",
            "brown", "grey", "blue_grey", "black"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.color);
//        if(savedInstanceState!= null){
//            textView.setTextColor(savedInstanceState.getInt("color"));
//        }
    }

    public void Click(View view) {
        Random randomColor = new Random();
        String mColor = color[randomColor.nextInt(16)];
        int colorResource = getResources().getIdentifier(mColor, "color",getApplicationContext().getPackageName());
        int colorResources = ContextCompat.getColor(this,colorResource);
        textView.setTextColor(colorResources);
    }
}