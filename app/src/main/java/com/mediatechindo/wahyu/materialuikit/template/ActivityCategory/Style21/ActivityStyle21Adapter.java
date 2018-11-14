package com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style21;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.tools.ImageViewCircleTransform;
import com.mediatechindo.wahyu.materialuikit.R;
import com.tubb.smrv.SwipeHorizontalMenuLayout;
import com.tubb.smrv.SwipeMenuLayout;
import com.tubb.smrv.listener.SwipeFractionListener;

import java.util.ArrayList;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class ActivityStyle21Adapter extends RecyclerView.Adapter<ActivityStyle21Adapter.ItemViewHolder> {
    private static ArrayList<ActivityStyle21Model> dataList;
    private LayoutInflater mInflater;
    private Context context;
    private ActivityStyle21ClickListener clicklistener = null;

    public ActivityStyle21Adapter(Context ctx, ArrayList<ActivityStyle21Model> data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView imgProfile;
        private SwipeHorizontalMenuLayout sml;
        private ImageView buttonDelete;
        private LinearLayout itemContainer;
        private LinearLayout colorMask;
        private TextView textName,message,timeMesage;

        public ItemViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            imgProfile = (ImageView) itemView.findViewById(R.id.imgProfile);
            sml = (SwipeHorizontalMenuLayout) itemView.findViewById(R.id.sml);
            buttonDelete = (ImageView) itemView.findViewById(R.id.buttonDelete);
            itemContainer = (LinearLayout) itemView.findViewById(R.id.itemContainer);
            colorMask = (LinearLayout) itemView.findViewById(R.id.colorMask);
            textName = (TextView) itemView.findViewById(R.id.textName);
            message = (TextView) itemView.findViewById(R.id.message);
            timeMesage = (TextView) itemView.findViewById(R.id.timeMesage);
            colorMask.setAlpha(0.0f);
            buttonDelete.setOnClickListener(this);

            sml.setSwipeFractionListener(new SwipeFractionListener() {
                @Override
                public void beginMenuSwipeFraction(SwipeMenuLayout swipeMenuLayout, float fraction) {
                }

                @Override
                public void endMenuSwipeFraction(SwipeMenuLayout swipeMenuLayout, float fraction) {
                    colorMask.setAlpha(fraction);
                }
            });

        }

        @Override
        public void onClick(View v) {

            if(v.getId() == R.id.buttonDelete){
                onItemDismiss(getAdapterPosition());
            }else if (clicklistener != null) {
                clicklistener.itemClicked(v, getAdapterPosition());
            }
        }
    }

    public void setClickListener(ActivityStyle21ClickListener listener) {
        this.clicklistener = listener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_activity21, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {
        Glide.with(context)
                .load(BuildConfig.IMAGE_URL + dataList.get(position).getProfileUrl())
                .transform(new ImageViewCircleTransform(context))
                .into(holder.imgProfile);

        boolean swipeEnable = true;
        holder.sml.setSwipeEnable(swipeEnable);

        holder.textName.setText(dataList.get(position).getName());
        holder.message.setText(dataList.get(position).getMessage());
        holder.timeMesage.setText(dataList.get(position).getTime());

    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }

    private void onItemDismiss(int position) {
        dataList.remove(position);
        notifyItemRemoved(position);
    }

}
