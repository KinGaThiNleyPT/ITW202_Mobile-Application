package gcit.edu.bt.todo_12;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "gcit.edu.todo_12.extra.MESSAGE";

    private String OrderMessage;


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_order:
                Intent intent = new Intent(getApplicationContext(),OrderActivity.class);
                intent.putExtra(EXTRA_MESSAGE,OrderMessage);
                startActivity(intent);
                return true;
            case R.id.action_status:
                displayToast("You Selected Status");
                return true;
            case R.id.action_favourite:
                displayToast("You Selected Favourite");
                return true;
            case R.id.action_contact:
                displayToast("You Selected Contact");
                return true;
            case R.id.action_search:
                displayToast("You Selected search");
                return true;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar =findViewById(R.id.toolbar_action);
        setSupportActionBar(toolbar);

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