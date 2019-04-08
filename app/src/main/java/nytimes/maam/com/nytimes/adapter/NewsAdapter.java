package nytimes.maam.com.nytimes.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import nytimes.maam.com.nytimes.R;
import nytimes.maam.com.nytimes.entity.news.ResultsEntity;


public class NewsAdapter extends  RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    private List<ResultsEntity> newsEntity= new ArrayList<ResultsEntity>();
    private Context mContext;
    private RecyclerViewOnClickItemListener listner;

    public NewsAdapter(Context mContext, List<ResultsEntity> newsEntity, RecyclerViewOnClickItemListener listner)
    {
        this.newsEntity=newsEntity;
        this.mContext=mContext;
        this.listner=listner;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_card,parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        ResultsEntity news=newsEntity.get(position);
        holder.titleTv.setText(news.getTitle());
        holder.pubDateTv.setText(news.getPublished_date());
        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listner != null)
                    listner.recyclerViewListClicked(view, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsEntity.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTv,pubDateTv;

        public View v;

        public MyViewHolder(View view) {
            super(view);
            v = view;
            titleTv = (TextView) view.findViewById(R.id.titleTv);
            pubDateTv = (TextView) view.findViewById(R.id.pubDateTv);

        }
    }

}
