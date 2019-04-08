package nytimes.maam.com.nytimes.entity.news;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

import nytimes.maam.com.nytimes.entity.base.JsonEntity;

public class ResultsEntity extends JsonEntity<ResultsEntity> implements Serializable{
    private String url;
    private String adx_keywords;
    private String column;
    private String section;
    private String byline;
    private String type;
    private String title;
    private String published_date;
    private String source;
    private String uri;
    private String abstractT;

    @Override
    public ResultsEntity getProperties(JSONObject jsonObject) throws JSONException {
        setUrl(jsonObject.optString("url"));
        setAdx_keywords(jsonObject.optString("adx_keywords"));
        setColumn(jsonObject.optString("column"));
        setSection(jsonObject.optString("section"));
        setByline(jsonObject.optString("byline"));
        setType(jsonObject.optString("type"));
        setTitle(jsonObject.optString("title"));
        setPublished_date(jsonObject.optString("published_date"));
        setSource(jsonObject.optString("source"));
        setUri(jsonObject.optString("uri"));
        setAbstractT(jsonObject.optString("abstract"));
        return this;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAdx_keywords() {
        return adx_keywords;
    }

    public void setAdx_keywords(String adx_keywords) {
        this.adx_keywords = adx_keywords;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublished_date() {
        return published_date;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getAbstractT() {
        return abstractT;
    }

    public void setAbstractT(String abstractT) {
        this.abstractT = abstractT;
    }
}
