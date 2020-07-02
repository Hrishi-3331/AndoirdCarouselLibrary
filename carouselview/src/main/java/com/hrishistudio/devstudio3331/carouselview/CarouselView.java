//
//Developed by : Hrishikesh Ugale
//Developer contact : hrishikeshugle3331@gmail.com
//

package com.hrishistudio.devstudio3331.carouselview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.ImageViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CarouselView extends LinearLayout {

    private View root;
    private LinearLayout dot_holder;
    private ViewPager carousel_pager;
    private String promotions[];
    private int length = 8;
    private int pointer = 0;
    private boolean autoscroll = false;
    private ImageView[] dots;
    private boolean showDots = true;
    private int colorActive = Color.RED;
    private int colorInActive = Color.BLUE;
    private Context context;

    public CarouselView(Context context) {
        super(context);
        initialize(context);
    }

    public CarouselView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    public CarouselView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context);
    }

    public CarouselView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initialize(context);
    }

    private void initialize(Context context){
        this.context = context;
        root = inflate(context, R.layout.carousel_root_layout, this);
        ImageView dot1 = (ImageView) root.findViewById(R.id.carousel_dot1);
        ImageView dot2 = (ImageView) root.findViewById(R.id.carousel_dot2);
        ImageView dot3 = (ImageView) root.findViewById(R.id.carousel_dot3);
        ImageView dot4 = (ImageView) root.findViewById(R.id.carousel_dot4);
        ImageView dot5 = (ImageView) root.findViewById(R.id.carousel_dot5);
        ImageView dot6 = (ImageView) root.findViewById(R.id.carousel_dot6);
        ImageView dot7 = (ImageView) root.findViewById(R.id.carousel_dot7);
        ImageView dot8 = (ImageView) root.findViewById(R.id.carousel_dot8);
        dot_holder = (LinearLayout)root.findViewById(R.id.carousel_dots);
        carousel_pager = (ViewPager)root.findViewById(R.id.carousel_pager);
        dots = new ImageView[]{dot1, dot2, dot3, dot4, dot5, dot6, dot7, dot8};
        promotions = new String[length];
        root.setVisibility(GONE);
    }

    public void enableDots(){
        dot_holder.setVisibility(VISIBLE);
        showDots = true;
    }

    public void disableDots(){
        dot_holder.setVisibility(GONE);
        showDots = false;
    }

    public void setLength(int length){
        this.length = length;
        promotions = new String[length];
        for (ImageView dot: dots){
            dot.setVisibility(VISIBLE);
        }
        for(int i = length; i < 8; i++){
            dots[i].setVisibility(GONE);
        }
    }

    public void setColorActive(int color) {
        this.colorActive = color;
    }

    public void setColorInActive(int color) {
        this.colorInActive = color;
    }

    public void addPromotion(String key){
        if (pointer < length) {
            promotions[pointer] = key;
            pointer++;
        }
    }

    private void setDots(){
        for (int i = 0; i < length; i++){
            ImageViewCompat.setImageTintList(dots[i], ColorStateList.valueOf(colorInActive));
            //ContextCompat.getColor(getApplicationContext(), R.color.colorSecondary)
        }
    }

    public void overlapDotsonImage() {
        final float scale = context.getResources().getDisplayMetrics().density;
        int pixel =  (int)(50 * scale + 0.5f);
        ViewGroup.MarginLayoutParams Mparams =(ViewGroup.MarginLayoutParams)dot_holder.getLayoutParams();
        Mparams.setMargins(Mparams.leftMargin,-pixel,Mparams.rightMargin,Mparams.bottomMargin);
        dot_holder.setLayoutParams(Mparams);
    }

    public void showCarousel(FragmentManager manager){
        setDots();
        ImageViewCompat.setImageTintList(dots[0], ColorStateList.valueOf(colorActive));
        carousel_pager.setAdapter(new CarouselAdapter(manager));
        carousel_pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                setDots();
                ImageViewCompat.setImageTintList(dots[i], ColorStateList.valueOf(colorActive));
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        root.setVisibility(VISIBLE);
    }

    public class CarouselAdapter extends FragmentPagerAdapter {

        public CarouselAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            PromotionFragment promotion = new PromotionFragment();
            Bundle bundle = new Bundle();
            bundle.putString("key", promotions[i]);
            promotion.setArguments(bundle);
            return promotion;
        }

        @Override
        public int getCount() {
            return length;
        }
    }

}