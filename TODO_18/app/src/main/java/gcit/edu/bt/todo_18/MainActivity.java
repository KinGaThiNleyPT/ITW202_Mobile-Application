package gcit.edu.bt.todo_18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Member variables
    private RecyclerView mRecyclerView;
    private ArrayList<Sport> mSportsData;
    private SportsAdapter mSportsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int gridColumnCount = getResources().getInteger(R.integer.gridColumnCount);

        //Initialize the RecyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.recycleview);

        //Set the layout Manager
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));

        //Initialize the ArrayList that will contain the data
        mSportsData = new ArrayList<>();

        //Initialize the adapter and set it to the RecyclerView
        mSportsAdapter = new SportsAdapter(this,mSportsData);
        mRecyclerView.setAdapter(mSportsAdapter);

        //Get the data
        initializeData();
    }

    private void initializeData() {
        //Get the resources from the XML file
        TypedArray sportsImagesResources = getResources().obtainTypedArray(R.array.sports_images);
        String[] sportsList = getResources().getStringArray(R.array.sports_title);
        String[] spotsInfo = getResources().getStringArray(R.array.sports_info);

        //Clear the existing data (to avoid duplication)
        mSportsData.clear();
        //create the ArrayList of Sports Objects with the titles and information about each sport
        for(int i = 0; i < sportsList.length; i++){
            mSportsData.add(new Sport(sportsList[i],spotsInfo[i],sportsImagesResources.getResourceId(i,0)));
        }
        //Notify the Adapter of the change
        mSportsAdapter.notifyDataSetChanged();
        sportsImagesResources.recycle();
    }
}