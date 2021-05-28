package gcit.edu.bt.todo_22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView instruction, title, author;
    EditText book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instruction =findViewById(R.id.instruction);
        title =findViewById(R.id.titleText);
        author=findViewById(R.id.authorText);
        book =findViewById(R.id.bookInput);
    }

    public void SearchBooks(View view) {
        String queryString = book.getText().toString();

        new FetchBook(title, author).execute(queryString);
        ConnectivityManager connMgr = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected() && queryString.length()!=0) {
            new FetchBook(title, author).execute(queryString);
            title.setText("");
            author.setText("loading");
        }

        else {
            if (queryString.length() == 0) {
                author.setText("");
                title.setText("Please enter a search term");
            } else {
                title.setText("");
                author.setText("Please check your network connection and try again.");
            }
        }
    }
}