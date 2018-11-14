package com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style18;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
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
public class ActivityStyle18Adapter extends RecyclerView.Adapter<ActivityStyle18Adapter.ItemViewHolder> {
    private static ArrayList<ActivityStyle18Model> dataList;
    private LayoutInflater mInflater;
    private Context context;

    public ActivityStyle18Adapter(Context ctx, ArrayList<ActivityStyle18Model> data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgProfile;
        private TextView textName;

        public ItemViewHolder(View itemView) {
            super(itemView);

            imgProfile = (ImageView) itemView.findViewById(R.id.imgProfile);
            textName = (TextView) itemView.findViewById(R.id.textName);
        }

    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_activity18, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {
        Spannable word = new SpannableString(dataList.get(position).getName());
        word.setSpan(new StyleSpan(Typeface.BOLD), 0, word.length(), 0);
        holder.textName.setText(word);

        Spannable wordTwo = new SpannableString(" " + dataList.get(position).getComment());
        holder.textName.append(wordTwo);

        Glide.with(context)
                .load(BuildConfig.IMAGE_URL + dataList.get(position).getProfileUrl())
                .transform(new ImageViewCircleTransform(context))
                .into(holder.imgProfile);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
