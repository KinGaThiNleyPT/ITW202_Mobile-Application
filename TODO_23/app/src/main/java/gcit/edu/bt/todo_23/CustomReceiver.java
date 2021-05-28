package gcit.edu.bt.todo_23;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {
    private static final String ACTION_CUSTOM_BROADCAST = BuildConfig.APPLICATION_ID +"ACTION_CUSTOM_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        if (intentAction!=null){
            String toastMessage ="";
            switch (intentAction){
                case Intent.ACTION_POWER_CONNECTED:
                    toastMessage ="Power connect";
                    break;
                case  Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage="Power Disconnected";
                    break;

                case ACTION_CUSTOM_BROADCAST:
                    toastMessage ="Custom broadcast is receive";
            }
            Toast.makeText(context,toastMessage,Toast.LENGTH_SHORT).show();
        }
    }
}