package gcit.edu.bt.todo_18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public RecyclerView mRecyleView;
    private ArrayList<Sport> mSportsData;
    private SportsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyleView = findViewById(R.id.recycleview);
        mRecyleView.setLayoutManager(new LinearLayoutManager(this));

        mSportsData = new ArrayList<>();
        mAdapter = new SportsAdapter(this, mSportsData);
        mRecyleView.setAdapter(mAdapter);

        //Get the data
        initializeData();
        TypedArray sportsImageResources = getResources().obtainTypedArray(R.array.sports_images);

    }

    private void initializeData() {
        String[] sportList =getResources().getStringArray(R.array.sports_title);
        String[] sportInfo =getResources().getStringArray(R.array.sports_info);

        mSportsData.clear();

        //Create the ArrayList of Sports objects with the titles and information about each sport
        for(int i=0;i<sportList.length;i++){
            mSportsData.add(new Sport(sportList[i],sportInfo[i], imageResource));
        }
        //Notify the adapter of the change
        mAdapter.notifyDataSetChanged();
        for(int i=0;i<sportList.length;i++){
            mSportsData.add(new Sport(sportList[i],sportInfo[i],
                    sportsImageResources.getResourceId(i,0)));
        }
        sportsImageResources.recycle();
    }
}