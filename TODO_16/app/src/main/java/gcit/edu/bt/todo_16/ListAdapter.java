package gcit.edu.bt.todo_16;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.WorldViewHolder>{
    private final LinkedList<String> mWordlist;
    private LayoutInflater  mInflater;

    public ListAdapter(Context context,LinkedList<String> mWordlist) {
        mInflater =LayoutInflater.from(context);
        this.mWordlist = mWordlist;
    }

    @NonNull
    @Override
    public ListAdapter.WorldViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItem = mInflater.inflate(R.layout.activity_main2,parent,false);
        return new WorldViewHolder(mItem,this);
    }
    @Override
    public void onBindViewHolder(@NonNull ListAdapter.WorldViewHolder holder, int position) {
        String mCurrent = mWordlist.get(position);
        holder.mword.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mWordlist.size();
    }

    public class WorldViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView mword;
        final ListAdapter mAdapter;

        public WorldViewHolder(@NonNull View itemView, ListAdapter mAdapter) {
            super(itemView);
            mword = itemView.findViewById(R.id.word);
            this.mAdapter = mAdapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int mPosition= getLayoutPosition();
            String element = mWordlist.get(mPosition);
            mWordlist.set(mPosition ,"Click"+element);
        }
    }
}
