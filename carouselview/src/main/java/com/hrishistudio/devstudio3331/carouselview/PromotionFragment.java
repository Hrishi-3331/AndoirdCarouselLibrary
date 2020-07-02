package com.hrishistudio.devstudio3331.carouselview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PromotionFragment extends Fragment {
    private ImageView promo_image;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.carousel_promo_layout, container, false);
        String promotion_image = getArguments().getString("key");
        promo_image = (ImageView)view.findViewById(R.id.carousel_image);
        Picasso.get().load(promotion_image).into(promo_image);
        return view;
    }
}
