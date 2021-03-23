package gcit.edu.bt.to_do4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "gcit.edu.bt.to_do4.MESSAGE";
    public static final int TEXT_REQUEST = 1;

    TextView textView;
    TextView textView1;
    EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        textView1 = (TextView) findViewById(R.id.textView2);
        editText1 = (EditText) findViewById(R.id.send);
    }

    public void viewSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this,MainActivity2.class);
        String message = editText1.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivityForResult(intent,TEXT_REQUEST);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == TEXT_REQUEST){
            if(resultCode == RESULT_OK){
                String Reply = data.getStringExtra(MainActivity2.EXTRA_REPLY);
                textView.setVisibility(View.VISIBLE);
                textView1.setText(Reply);
                textView1.setVisibility(View.VISIBLE);
            }
        }
    }
}