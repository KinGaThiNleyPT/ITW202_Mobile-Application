package gcit.edu.bt.todo_16;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView myRecylerview;
    private final LinkedList<String> mWordlist = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i =0; i<20; i++){
            mWordlist.addLast("Word"+i);
        }
        myRecylerview = findViewById(R.id.recyleview);
        ListAdapter mAdapter = new ListAdapter(this,mWordlist);
        myRecylerview.setAdapter(mAdapter);

        LinearLayoutManager obj =new LinearLayoutManager(this);
        myRecylerview.setLayoutManager(obj);

        FloatingActionButton fab =findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wordlistsize = mWordlist.size();
                mWordlist.addLast("word"+wordlistsize);
                myRecylerview.getAdapter().notifyItemInserted(wordlistsize);
                myRecylerview.smoothScrollToPosition(wordlistsize);
            }
        });
    }
}