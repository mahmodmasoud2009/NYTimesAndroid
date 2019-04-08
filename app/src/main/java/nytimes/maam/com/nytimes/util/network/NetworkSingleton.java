package nytimes.maam.com.nytimes.util.network;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class NetworkSingleton {
    private RequestQueue queue;
    private static NetworkSingleton volleySingleton;
    private static Context mContext;

    private NetworkSingleton() {
        queue = Volley.newRequestQueue(mContext);
    }

    public static synchronized NetworkSingleton getInstance(Context context) {
        mContext = context;
        if (volleySingleton == null) {
            volleySingleton = new NetworkSingleton();
        }
        return volleySingleton;
    }

   public RequestQueue getQueue() {
        return queue;
    }

}