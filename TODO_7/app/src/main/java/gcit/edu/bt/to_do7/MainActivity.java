package gcit.edu.bt.tod0_7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import gcit.edu.bt.to_do7.R;

public class MainActivity extends AppCompatActivity {
    private int count;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.textView);
        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("mCount");
            mTextView.setText(String.valueOf(count));
        }
    }

    public void count(View view) {
        count++;
        mTextView.setText(String.valueOf(count));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("mCount", count);
    }
}