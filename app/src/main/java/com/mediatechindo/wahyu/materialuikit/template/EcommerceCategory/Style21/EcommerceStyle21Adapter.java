package com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style21;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;
import com.tubb.smrv.SwipeHorizontalMenuLayout;

import java.util.ArrayList;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class EcommerceStyle21Adapter extends RecyclerView.Adapter<EcommerceStyle21Adapter.ItemViewHolder> {
    private static ArrayList<EcommerceStyle21Model> dataList;
    private LayoutInflater mInflater;
    private Context context;
    private EcommerceStyle21ClickListener clicklistener = null;

    public EcommerceStyle21Adapter(Context ctx, ArrayList<EcommerceStyle21Model> data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView imgProduct;
        private SwipeHorizontalMenuLayout sml;
        private CardView buttonMinus,buttonPlus,buttonEdit,buttonDelete;
        private TextView title,numItem,price;

        public ItemViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            title = (TextView) itemView.findViewById(R.id.title);
            price = (TextView) itemView.findViewById(R.id.price);
            numItem = (TextView) itemView.findViewById(R.id.numItem);
            imgProduct = (ImageView) itemView.findViewById(R.id.imgProduct);
            sml = (SwipeHorizontalMenuLayout) itemView.findViewById(R.id.sml);
            buttonMinus = (CardView) itemView.findViewById(R.id.buttonMinus);
            buttonPlus = (CardView) itemView.findViewById(R.id.buttonPlus);
            buttonEdit = (CardView) itemView.findViewById(R.id.buttonEdit);
            buttonDelete = (CardView) itemView.findViewById(R.id.buttonDelete);
            buttonMinus.setOnClickListener(this);
            buttonPlus.setOnClickListener(this);
            buttonEdit.setOnClickListener(this);
            buttonDelete.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.buttonMinus:
                    int num = Integer.parseInt(numItem.getText().toString());
                    if(num > 1) {
                        num--;
                    }
                    numItem.setText(Integer.toString(num));
                    break;
                case R.id.buttonPlus:
                    int num2 = Integer.parseInt(numItem.getText().toString());
                    num2++;
                    numItem.setText(Integer.toString(num2));
                    break;
                case R.id.buttonEdit:
                    Toast.makeText(context, "Button Edit clicked!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.buttonDelete:
                    onItemDismiss(getAdapterPosition());
                    break;
                default:
                    if(clicklistener != null){
                        clicklistener.itemClicked(view, getAdapterPosition());
                    }
                    break;
            }
        }
    }

    public void setClickListener(EcommerceStyle21ClickListener listener) {
        this.clicklistener = listener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_ecommerce21, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {
        boolean swipeEnable = true;
        holder.sml.setSwipeEnable(swipeEnable);

        Glide.with(context)
                .load(BuildConfig.IMAGE_URL + dataList.get(position).getImageProductUrl())
                .thumbnail(0.01f)
                .centerCrop()
                .into(holder.imgProduct);

        holder.title.setText(dataList.get(position).getName());
        holder.price.setText(dataList.get(position).getPrice());
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
