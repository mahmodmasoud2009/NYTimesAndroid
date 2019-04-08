package nytimes.maam.com.nytimes.entity.base;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class JsonEntity<T> {
	public abstract T getProperties(JSONObject jsonObject) throws JSONException;
}
