package gcit.edu.bt.todo_21;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class simpleAsyncTask  extends AsyncTask<Void, Void, String> {
    private WeakReference<TextView> mTextView;

    public simpleAsyncTask(TextView tv){
        mTextView =new WeakReference<>(tv);
    }

    @Override
    protected String doInBackground(Void... voids) {
        Random ran = new Random();
        int n =ran.nextInt(11);
        int s = n * 200;

        try {
            Thread.sleep(s);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        return "Awake at last after sleeping"+ s +"millstone";
    }

    @Override
    protected void onPostExecute(String s){
        mTextView.get().setText(s);
    }
}
