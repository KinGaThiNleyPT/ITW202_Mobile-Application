package gcit.edu.bt.todo_25;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper mydb;
    public EditText FirstName, LastName, Marks, Enroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirstName=findViewById(R.id.firstname);
        LastName=findViewById(R.id.lastname);
        Marks =findViewById(R.id.marks);
        Enroll =findViewById(R.id.StudentID);

    }

    public void AddData(View view) {
        boolean isInserted = mydb.insertData(Enroll.getText().toString(),
        FirstName.getText().toString(),
        LastName.getText().toString(),
        Marks.getText().toString());

        if (isInserted ==true){
            Toast.makeText(getApplicationContext(),"Data inserted",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Data not inserted",Toast.LENGTH_SHORT).show();
        }


    }
}