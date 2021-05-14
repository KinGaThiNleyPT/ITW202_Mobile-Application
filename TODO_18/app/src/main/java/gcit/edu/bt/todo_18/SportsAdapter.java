package gcit.edu.bt.todo_18;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class SportsAdapter extends RecyclerView.Adapter<SportsAdapter.ViewHolder> {
    private ArrayList<Sport> mSportsData;
    private Context mContext;

    SportsAdapter(Context context, ArrayList<Sport> sportsData) {
        this.mSportsData = sportsData;
        this.mContext = context;
    }


    @NonNull
    @Override
    public SportsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SportsAdapter.ViewHolder holder, int position) {
        //Get current sport
        Sport currentSport = mSportsData.get(position);
        //Populate the textviews with data
        holder.bindTo(currentSport);
    }

    @Override
    public int getItemCount() {
        return mSportsData.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title, info,news;
        public ImageView mSportsImage;
        public SportsAdapter sportsAdapter;
        public ViewHolder(@NonNull View itemView ) {
            super(itemView);
            mSportsImage = (ImageView) itemView.findViewById(R.id.sportsImage);
            title =(TextView)itemView.findViewById(R.id.text1);
            info =(TextView)itemView.findViewById(R.id.text2);
            news =(TextView)itemView.findViewById(R.id.text3);
        }

        public void bindTo(Sport currentSport) {
            //Populate the textviews with data
            title.setText(currentSport.getTitle());
            info.setText(currentSport.getInfo());
        }
    }
}
