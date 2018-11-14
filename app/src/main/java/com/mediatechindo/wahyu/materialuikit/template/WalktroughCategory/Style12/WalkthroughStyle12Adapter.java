package com.mediatechindo.wahyu.materialuikit.template.WalktroughCategory.Style12;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wahyu on 14/11/16.
 */

public class WalkthroughStyle12Adapter extends RecyclerView.Adapter<WalkthroughStyle12Adapter.ItemViewHolder> implements WalkthroughStyle12ItemTouchAdapter {
    private final List<String> mItems = new ArrayList<>();
    private final WalkthroughStyle12OnStartDragListener mDragStartListener;
    private int count = 1;
    private Context context;

    public WalkthroughStyle12Adapter(Context ctx, WalkthroughStyle12OnStartDragListener dragStartListener) {
        mDragStartListener = dragStartListener;
        context = ctx;
        mItems.add(0, "Michael Angelo");
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_walkthrough12, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        String url = BuildConfig.IMAGE_URL + "walkthrough/style-12/Welcome-12.jpg";
        Glide.with(context)
                .load(url)
                .thumbnail(0.01f)
                .centerCrop()
                .into(holder.image);
        if(count > 1) {
            animationCardIn(holder.profilContainer);
        }
    }

    private void animationCardIn(View view){
        int start = 50;
        int duration = 500;

        AlphaAnimation animAlpha = new AlphaAnimation(0.5f, 1.0f);
        animAlpha.setDuration(duration);
        animAlpha.setStartOffset(start);
        animAlpha.setFillAfter(true);

        ScaleAnimation animScale1 = new ScaleAnimation(1.2f, 1f, 0.85f, 1f, Animation.RELATIVE_TO_SELF, (float)0.5, Animation.RELATIVE_TO_SELF, (float)0.5);
        animScale1.setDuration(duration);
        animScale1.setStartOffset(start);
        animScale1.setFillAfter(true);

        AnimationSet animSet = new AnimationSet(false);
        animSet.addAnimation(animAlpha);
        animSet.addAnimation(animScale1);

        view.startAnimation(animSet);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        return false;
    }

    @Override
    public void onItemDismiss(int position) {
        count++;
        mItems.remove(position);
        mItems.add(0, "Michael Angelo");
        notifyItemRemoved(position);
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public final ImageView image;
        public final FrameLayout profilContainer;
        public ItemViewHolder(View itemView) {
            super(itemView);
            profilContainer = (FrameLayout) itemView.findViewById(R.id.profilContainer);
            image = (ImageView) itemView.findViewById(R.id.imageMain);
        }
    }
}
