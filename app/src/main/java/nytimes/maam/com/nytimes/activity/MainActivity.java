package nytimes.maam.com.nytimes.activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import nytimes.maam.com.nytimes.R;
import nytimes.maam.com.nytimes.adapter.NewsAdapter;
import nytimes.maam.com.nytimes.adapter.RecyclerViewOnClickItemListener;
import nytimes.maam.com.nytimes.entity.news.NewsEntity;
import nytimes.maam.com.nytimes.entity.news.ResultsEntity;
import nytimes.maam.com.nytimes.util.network.ApiHandler;
import nytimes.maam.com.nytimes.util.network.ApiHandlerListener;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showLoadingDialog();
        ApiHandler.getInstance(MainActivity.this).
                mostPopular(new MostPopularHandlerListener());
    }

    private class MostPopularHandlerListener implements ApiHandlerListener<NewsEntity>{
        @Override
        public void onSuccess(final NewsEntity response) {
            RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
            LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            rv.setLayoutManager(mLayoutManager);


            RecyclerViewOnClickItemListener listner = new RecyclerViewOnClickItemListener(){
                @Override
                public void recyclerViewListClicked(View v, int position) {
                    showLoadingDialog();
                    ResultsEntity resultsEntity = response.getListOfResultEntity().get(position);
                    Intent activity = new Intent(MainActivity.this, NewsDetailsActivity.class);
                    activity.putExtra("resultsEntity", resultsEntity);
                    startActivity(activity);
                    dismissLoadingDialog();
                }
            };
            NewsAdapter newsAdapter=new NewsAdapter(MainActivity.this,response.getListOfResultEntity(),listner);
            rv.setAdapter(newsAdapter);
            dismissLoadingDialog();
        }

        @Override
        public void onFail(Exception ex) {
            dismissLoadingDialog();
            showMessage(ex.getMessage());
        }
    }
}
