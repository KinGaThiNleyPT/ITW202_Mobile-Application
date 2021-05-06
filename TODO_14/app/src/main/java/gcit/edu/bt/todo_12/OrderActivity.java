package gcit.edu.bt.todo_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity implements  AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.order_message);
        textView.setText(message);

        Spinner spinner = findViewById(R.id.spinner);
        //call setOnItemselectedListener if spinner is not null
        if(spinner != null){
            spinner.setOnItemSelectedListener(this);
        }
        //Display in xml file
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,R.array.array_level, android.R.layout.simple_dropdown_item_1line);
        if(spinner != null){
            spinner.setAdapter(arrayAdapter);
        }
    }

    public void OrderedItem(View view) {
        boolean itemSelect = ((RadioButton)view).isChecked();

        switch(view.getId()){
            case R.id.same_day:
                displayToast("Same day messenger service");
                break;

            case R.id.next_day:
                displayToast("Same day ground delivery");
                break;

            case R.id.pick_day:
                displayToast("Pick up");
                break;

        }
    }

    private void displayToast(String pick_up) {
        Toast.makeText(getApplicationContext(),pick_up,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String message = parent.getItemAtPosition(position).toString();
        displayToast(message);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}