package com.mediatechindo.wahyu.materialuikit.template.ContentCategory.Style3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.R;
import com.mediatechindo.wahyu.materialuikit.tools.ImageViewCircleTransform;

import java.util.ArrayList;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class InstagramAdapter extends RecyclerView.Adapter<InstagramAdapter.ItemViewHolder> {
    private static ArrayList<InstagramModel> dataList;
    private LayoutInflater mInflater;
    private Context context;

    public InstagramAdapter(Context ctx, ArrayList<InstagramModel> data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageProfile, mainImage;
        private ImageButton buttonLove;
        private Button buttonShare, buttonOpen;
        private TextView name, username, time, comment, numLove, hashtag, numComment;

        public ItemViewHolder(View itemView) {
            super(itemView);

            imageProfile = (ImageView) itemView.findViewById(R.id.imageProfile);
            mainImage = (ImageView) itemView.findViewById(R.id.mainImage);
            buttonLove = (ImageButton) itemView.findViewById(R.id.buttonLove);
            name = (TextView) itemView.findViewById(R.id.name);
            username = (TextView) itemView.findViewById(R.id.username);
            time = (TextView) itemView.findViewById(R.id.time);
            comment = (TextView) itemView.findViewById(R.id.comment);
            numLove = (TextView) itemView.findViewById(R.id.numLove);
            hashtag = (TextView) itemView.findViewById(R.id.hashtag);
            numComment = (TextView) itemView.findViewById(R.id.numComment);
            buttonShare = (Button) itemView.findViewById(R.id.buttonShare);
            buttonOpen = (Button) itemView.findViewById(R.id.buttonOpen);
        }

    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_instagram, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {
        holder.name.setText(dataList.get(position).getName());
        holder.username.setText(dataList.get(position).getUsername());
        holder.time.setText(dataList.get(position).getTime());
        holder.comment.setText(dataList.get(position).getComment());
        holder.numLove.setText(dataList.get(position).getNumLove());
        holder.hashtag.setText(dataList.get(position).getHashtag());
        holder.numComment.setText(dataList.get(position).getNumComment());

        Glide.with(context)
                .load(dataList.get(position).getProfileUrl())
                .transform(new ImageViewCircleTransform(context))
                .into(holder.imageProfile);

        Glide.with(context)
                .load(dataList.get(position).getMainImageUrl())
                .centerCrop()
                .into(holder.mainImage);

        holder.buttonLove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Button Love clicked!", Toast.LENGTH_SHORT).show();
            }
        });
        holder.buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Button Share clicked!", Toast.LENGTH_SHORT).show();
            }
        });
        holder.buttonOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Button Open clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
