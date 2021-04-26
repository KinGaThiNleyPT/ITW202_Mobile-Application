package gcit.edu.bt.todo8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
    public static final String tag = MainActivity.class.getName();
    private EditText text;
    private EditText text1;
    private EditText text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.openwebsite);
        text1=findViewById(R.id.openlocation);
        text2=findViewById(R.id.sharetext);

    }
    public void openwebsite(View view){
        String msg = text.getText().toString();
        Uri uri = Uri.parse(msg);
        Intent ob =  new Intent(Intent.ACTION_VIEW,uri);
        if(ob.resolveActivity(getPackageManager()) != null){
            startActivity(ob);
        }
        else{
            Log.d(tag,"Implicit Error");
        }
    }
    public void openlocation(View view){
        String msg = text1.getText().toString();
        Uri loca = Uri.parse("geo:0,0?q=" + msg);
        Intent locatioName = new Intent(Intent.ACTION_VIEW,loca);
        if(locatioName.resolveActivity(getPackageManager()) != null){
            startActivity(locatioName);
        }
        else{
            Log.d(tag,"Implicit error");
        }
    }
    public void sharetext(View view) {
        String txt = text2.getText().toString();

        ShareCompat.IntentBuilder
                .from(this)
                .setType("text/plain")
                .setChooserTitle("Share this text with: ")
                .setText(txt)
                .startChooser();
    }
}