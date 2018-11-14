package com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style17;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;
import com.mediatechindo.wahyu.materialuikit.tools.ImageViewCircleTransform;

/**
 * Created by wahyu on 15/11/16.
 */

@SuppressLint("ValidFragment")
public class ActivityStyle17Fragment extends Fragment {
    int wizard_page_position;
    Spannable word;
    Spannable wordTwo;

    public ActivityStyle17Fragment(int position) {
        this.wizard_page_position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layout_id = R.layout.activity17_fragment;
        View view = inflater.inflate(layout_id, container, false);

        setTextDesc((TextView) view.findViewById(R.id.textDescription1), "Gabriella Madelaine"," Added you as her friend.");
        setTextDesc((TextView) view.findViewById(R.id.textDescription2), "Tony Ramirez"," commented on your Post.");
        setTextDesc((TextView) view.findViewById(R.id.textDescription3), "Christina"," loved your photo");
        setTextDesc((TextView) view.findViewById(R.id.textDescription4), "Gabriella Madelaine"," Tagged you in a Post.");
        setTextDesc((TextView) view.findViewById(R.id.textDescription5), "Tony Ramirez"," commented on your Post.");
        setTextDesc((TextView) view.findViewById(R.id.textDescription6), "Gabriella Madelaine"," Added you as her friend");

        ImageView img1 = (ImageView) view.findViewById(R.id.image1);
        ImageView img2 = (ImageView) view.findViewById(R.id.image2);
        String urlPost = BuildConfig.IMAGE_URL + "activity/style-1/Activity-1-img-1.jpg";
        String urlPost2 = BuildConfig.IMAGE_URL + "activity/style-15/Activity-15-img-1.jpg";

        loadImageRequest(img1, urlPost);
        loadImageRequest(img2, urlPost2);

        return view;
    }

    private void setTextDesc(TextView textView, String text1, String text2){
        word = new SpannableString(text1);
        word.setSpan(new StyleSpan(Typeface.BOLD), 0, word.length(), 0);
        textView.setText(word);

        wordTwo = new SpannableString(text2);
        wordTwo.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getActivity(), R.color.activity17fontGray)), 0, wordTwo.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.append(wordTwo);
    }

    private void loadImageCircleRequest(ImageView img, String url){
        Glide.with(getActivity())
                .load(url)
                .transform(new ImageViewCircleTransform(getActivity()))
                .into(img);
    }

    private void loadImageRequest(ImageView bg, String url) {
        Glide.with(getActivity())
                .load(url)
                .thumbnail(0.01f)
                .centerCrop()
                .crossFade()
                .into(bg);
    }
}
