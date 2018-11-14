package com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style24;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.tools.ImageViewCircleTransform;
import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class ActivityStyle24Adapter extends RecyclerView.Adapter<ActivityStyle24Adapter.ItemViewHolder> {
    private static ArrayList<ActivityStyle24Model> dataList;
    private LayoutInflater mInflater;
    private Context context;
    private ActivityStyle24ClickListener clicklistener = null;
    private int num = 0;

    public ActivityStyle24Adapter(Context ctx, ArrayList<ActivityStyle24Model> data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView imgProfile;
        private ImageView check;
        private TextView textName;
        private TextView timed;
        private TextView description;
        private CardView dotColor;

        public ItemViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            imgProfile = (ImageView) itemView.findViewById(R.id.imgProfile);
            check = (ImageView) itemView.findViewById(R.id.check);
            textName = (TextView) itemView.findViewById(R.id.textName);
            timed = (TextView) itemView.findViewById(R.id.timed);
            description = (TextView) itemView.findViewById(R.id.description);
            dotColor = (CardView) itemView.findViewById(R.id.dotColor);
        }

        @Override
        public void onClick(View v) {
            check.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_check_gray));
            if (clicklistener != null) {
                clicklistener.itemClicked(v, getAdapterPosition());
            }
        }
    }

    public void setClickListener(ActivityStyle24ClickListener listener) {
        this.clicklistener = listener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_activity24, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {
        holder.textName.setText(dataList.get(position).getName());
        holder.timed.setText(dataList.get(position).getTime());
        holder.description.setText(dataList.get(position).getDescription());

        num++;
        setDotColor(holder, num);
        if(num>=4){
           num = 0;
        }

        Glide.with(context)
                .load(BuildConfig.IMAGE_URL + dataList.get(position).getProfileUrl())
                .transform(new ImageViewCircleTransform(context))
                .into(holder.imgProfile);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    private void setDotColor(ItemViewHolder holder, int i){
        switch (num){
            case 1:
                holder.dotColor.setCardBackgroundColor(ContextCompat.getColor(context, R.color.activity24DotRed));
                break;
            case 2:
                holder.dotColor.setCardBackgroundColor(ContextCompat.getColor(context, R.color.activity24DotYellow));
                break;
            case 3:
                holder.dotColor.setCardBackgroundColor(ContextCompat.getColor(context, R.color.activity24DotBlue));
                break;
            case 4:
                holder.dotColor.setCardBackgroundColor(ContextCompat.getColor(context, R.color.activity24DotGreen));
                break;
            default:
                break;
        }
    }
}
