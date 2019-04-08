package nytimes.maam.com.nytimes.entity.base;

import org.json.JSONArray;
import org.json.JSONException;

public abstract class JsonArrayEntity<T> {
	public abstract T getProperties(JSONArray jsonArray)
			throws JSONException;
}
