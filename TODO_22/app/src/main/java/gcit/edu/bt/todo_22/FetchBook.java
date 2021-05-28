package gcit.edu.bt.todo_22;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;

public class FetchBook extends AsyncTask<String,Void,String> {
    private WeakReference <TextView> mTitleText;
    private WeakReference <TextView>  mAuthorText;

    public FetchBook(TextView mTitleText, TextView mAuthorText) {
        this.mTitleText = new WeakReference<>(mTitleText);
        this.mAuthorText = new WeakReference<>(mAuthorText);
    }

    @Override
    protected String doInBackground(String... params) {
        return NetworkUtils.getBookInfo(params[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray itemsArray =jsonObject.getJSONArray("items");
            int i =0;
            String title = null;
            String author = null;

            while (i< itemsArray.length() && (author ==null && title == null)){
                JSONObject book = itemsArray.getJSONObject(i);
                JSONObject volumeInfo = book.getJSONObject("volumeInfo");
                //getting title and author from items

                try {
                    title = volumeInfo.getString("title");
                    author = volumeInfo.getString("author");
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                i++;
                if (title != null && author !=null){
                    mTitleText.get().setText(title);
                    mAuthorText.get().setText(author);
                }
                else {
                    mTitleText.get().setText("No result found");
                    mAuthorText.get().setText("No result found");
                }
            }
        }
        catch (JSONException ex){
            //if postExecution failed to recieve proper json sting
            ex.printStackTrace();
        }
    }
}
