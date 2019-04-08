package nytimes.maam.com.nytimes.util.network;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import nytimes.maam.com.nytimes.entity.news.NewsEntity;

public class ApiHandler {


    private static Context mContext;
    private static ApiHandler apiHandler;
    private ApiHandler() {
    }

    public static synchronized ApiHandler getInstance(Context context) {
        if (apiHandler == null) {
            apiHandler = new ApiHandler();
        }
        mContext = context;
        return apiHandler;
    }

    public void mostPopular(final ApiHandlerListener<NewsEntity> responseListener) {
        String url = ApiPAths.mostpopular();
        JsonObjectAuthRequest jsonObjectRequest = new JsonObjectAuthRequest(url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        NewsEntity loginEntity = new NewsEntity();
                        try {
                            loginEntity.getProperties(jsonObject);
                            responseListener.onSuccess(loginEntity);

                        } catch (JSONException e) {
                            responseListener.onFail(e);
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                responseListener.onFail(new Exception(VolleyErrorHelper.getMessage(error.getMessage(), mContext)));
            }
        });

        NetworkSingleton.getInstance(mContext).getQueue().add(jsonObjectRequest);
    }


}
