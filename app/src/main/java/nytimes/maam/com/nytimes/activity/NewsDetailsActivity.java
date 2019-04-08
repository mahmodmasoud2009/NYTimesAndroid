package nytimes.maam.com.nytimes.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import nytimes.maam.com.nytimes.R;
import nytimes.maam.com.nytimes.entity.news.ResultsEntity;

public class NewsDetailsActivity extends BaseActivity {
    private ResultsEntity resultsEntity;
    private TextView titleTv,pubDateTv,autherTv,detailsTv;
    private Button openBrowserButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getIntent().getExtras();
        resultsEntity=(ResultsEntity) b.getSerializable("resultsEntity");
        setContentView(R.layout.activity_news_details);
        init();
        setData();
    }

    void init()
    {
        titleTv=(TextView)findViewById(R.id.titleTv);
        pubDateTv=(TextView)findViewById(R.id.pubDateTv);
        autherTv=(TextView)findViewById(R.id.autherTv);
        detailsTv=(TextView)findViewById(R.id.detailsTv);
        openBrowserButton=(Button)findViewById(R.id.openBrowserButton);
    }
    void setData()
    {
        titleTv.setText(resultsEntity.getTitle());
        pubDateTv.setText(resultsEntity.getPublished_date());
        autherTv.setText(resultsEntity.getByline());
        detailsTv.setText(resultsEntity.getAbstractT());

        openBrowserButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(resultsEntity.getUrl()));
                startActivity(browserIntent);
            }
        });

    }
}
