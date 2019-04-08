package nytimes.maam.com.nytimes.entity.news;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import nytimes.maam.com.nytimes.entity.base.JsonEntity;

public class NewsEntity extends JsonEntity<NewsEntity> implements Serializable{

    private String status;
    private String copyright;
    private List<ResultsEntity> listOfResultEntity = new ArrayList<ResultsEntity>();

    @Override
    public NewsEntity getProperties(JSONObject jsonObject) throws JSONException {
        setStatus(jsonObject.optString("status"));
        setCopyright(jsonObject.optString("copyright"));

        for (int i = 0; i < jsonObject.getJSONArray("results").length(); i++) {
            getListOfResultEntity().add(new ResultsEntity()
                    .getProperties(jsonObject.getJSONArray("results").getJSONObject(i)));
        }

        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public List<ResultsEntity> getListOfResultEntity() {
        return listOfResultEntity;
    }

    public void setListOfResultEntity(List<ResultsEntity> listOfResultEntity) {
        this.listOfResultEntity = listOfResultEntity;
    }
}
