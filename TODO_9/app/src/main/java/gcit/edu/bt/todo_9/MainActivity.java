package gcit.edu.bt.todo_9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText text;
    private EditText text1;
    private TextView textView;
    public calulator mcalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.value1);
        text1 = findViewById(R.id.value2);
        textView = findViewById(R.id.result);

        mcalculator = new calulator();
    }

    public void Add(View view) {
        String val = text.getText().toString();
        String val2= text1.getText().toString();
        double result = mcalculator.add(Double.valueOf(val), Double.valueOf(val2));
        textView.setText(String.valueOf(result));
    }

    public void Sub(View view) {
        String val = text.getText().toString();
        String val2= text1.getText().toString();
        double result = mcalculator.sub(Double.valueOf(val), Double.valueOf(val2));
        textView.setText(String.valueOf(result));
    }

    public void Mult(View view) {
        String val = text.getText().toString();
        String val2= text1.getText().toString();
        double result = mcalculator.mul(Double.valueOf(val), Double.valueOf(val2));
        textView.setText(String.valueOf(result));
    }

    public void Div(View view) {
        String val = text.getText().toString();
        String val2= text1.getText().toString();
        double result = mcalculator.div(Double.valueOf(val), Double.valueOf(val2));
        textView.setText(String.valueOf(result));
    }
}