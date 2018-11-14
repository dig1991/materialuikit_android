package com.mediatechindo.wahyu.materialuikit.template.NewsCategory.Style3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;
import com.mediatechindo.wahyu.materialuikit.tools.ImageViewCircleTransform;

import java.util.ArrayList;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class NewsStyle3Adapter extends RecyclerView.Adapter<NewsStyle3Adapter.ItemViewHolder> {
    private static ArrayList<NewsStyle3Model> dataList;
    private LayoutInflater mInflater;
    private Context context;
    private NewsStyle3ClickListener clicklistener = null;

    public NewsStyle3Adapter(Context ctx, ArrayList<NewsStyle3Model> data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        private ImageView image, check;
        private TextView title;
        private Button button;

        public ItemViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.imageMain);
            check = (ImageView) itemView.findViewById(R.id.check);
            title = (TextView) itemView.findViewById(R.id.title);
            button = (Button) itemView.findViewById(R.id.button);
        }
    }

    public void setClickListener(NewsStyle3ClickListener listener) {
        this.clicklistener = listener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_news3, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    private static final String TAG = "Music10";

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, int position) {
        Glide.with(context)
                .load(BuildConfig.IMAGE_URL + dataList.get(position).getImageUrl())
                .transform(new ImageViewCircleTransform(context))
                .thumbnail(0.01f)
                .centerCrop()
                .into(holder.image);
        holder.title.setText(dataList.get(position).getTitle());
        holder.button.setActivated(!dataList.get(position).isButtonSelected());
        setButtonStatus(holder);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setButtonStatus(holder);
            }
        });
    }

    private void setButtonStatus(ItemViewHolder holder){
        if(holder.button.isActivated()){
            holder.check.setVisibility(View.GONE);
            holder.button.setActivated(false);
            clicklistener.itemClickedRemove();
        }else{
            holder.check.setVisibility(View.VISIBLE);
            holder.button.setActivated(true);
            clicklistener.itemClickedAdd();
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
