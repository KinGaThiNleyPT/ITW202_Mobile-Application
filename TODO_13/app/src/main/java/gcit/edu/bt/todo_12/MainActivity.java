package gcit.edu.bt.todo_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "gcit.edu.todo_12.extra.MESSAGE";

    private String OrderMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra(EXTRA_MESSAGE, OrderMessage);
                startActivity(intent);
            }
        });
    }
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void donutorder(View view) {
        OrderMessage = getString(R.string.donut_order_message);
        displayToast(OrderMessage);
    }

    public void iceorder(View view) {
        OrderMessage = getString(R.string.ice_cream_order_message);
        displayToast(OrderMessage);
    }

    public void froyorder(View view) {
        OrderMessage = getString(R.string.froyo_order_message);
        displayToast(OrderMessage);
    }
}