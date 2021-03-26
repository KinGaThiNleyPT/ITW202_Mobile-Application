package gcit.edu.bt.to_do6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "gcit.edu.bt.to_do6.MESSAGE";
    public static final int TEXT_REQUEST = 1;

    TextView textView;
    TextView textView1;
    EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, " onCreate ");

        textView = (TextView) findViewById(R.id.textView);
        textView1 = (TextView) findViewById(R.id.textView2);
        editText1 = (EditText) findViewById(R.id.send);

        if(savedInstanceState != null){
            boolean inVisible = savedInstanceState.getBoolean("Header_message");
            if(inVisible){
                textView.setVisibility(View.VISIBLE);
                textView1.setText(savedInstanceState.getString("reply_text"));
                textView1.setVisibility(View.VISIBLE);
            }
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
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
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if(textView.getVisibility() == View.VISIBLE){
            outState.putBoolean("Header_message", true);
            outState.putString("reply_text",textView1.getText().toString());
        }
    }
}

