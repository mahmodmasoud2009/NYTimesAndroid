package nytimes.maam.com.nytimes.util.network;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.JsonObjectRequest;
import org.json.JSONObject;

public class JsonObjectAuthRequest extends JsonObjectRequest {

	public JsonObjectAuthRequest(String url, Listener<JSONObject> listener,
                                 ErrorListener errorListener) {
		super(url, null, listener, errorListener);
	}

}
