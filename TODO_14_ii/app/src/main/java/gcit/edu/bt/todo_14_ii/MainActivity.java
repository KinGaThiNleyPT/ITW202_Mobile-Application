package gcit.edu.bt.todo_14_ii;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void alart(View view) {
        AlertDialog.Builder myAlart = new  AlertDialog.Builder(MainActivity.this);
        myAlart.setTitle("Alert");
        myAlart.setMessage("Click ok to continue, or Cancel to stop:");

        myAlart.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Pressed ok",Toast.LENGTH_SHORT).show();
            }
        });
      myAlart.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
              Toast.makeText(getApplicationContext(),"pressed Cancel", Toast.LENGTH_SHORT).show();
          }
      });
              myAlart.setNeutralButton("pause", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"pressed pause", Toast.LENGTH_SHORT).show();
            }
        });
        myAlart.show();
    }

}