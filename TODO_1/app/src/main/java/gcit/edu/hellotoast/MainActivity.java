package gcit.edu.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView show;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show = (TextView) findViewById(R.id.textView);
    }
    public void view(View view) {
        Toast t = Toast.makeText(this,"Hello Toast"+"",Toast.LENGTH_LONG);
        t.show();
    }
    public void count(View view) {
        count++;
        show.setText(Integer.toString(count));
    }
}