package com.hrishistudio.devstudio3331.carouselexample;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hrishistudio.devstudio3331.carouselview.CarouselView;


public class DemoActivity extends AppCompatActivity {

    private CarouselView myCarouselView1;
    private static final String PROMOTION1 = "https://firebasestorage.googleapis.com/v0/b/quickguru-ddd55.appspot.com/o/test%2FSimple%20Work%20LinkedIn.png?alt=media&token=81004ca6-2ed6-47b8-83d9-10eb59aa4471";
    private static final String PROMOTION2 = "https://firebasestorage.googleapis.com/v0/b/quickguru-ddd55.appspot.com/o/test%2FSimple%20Work%20LinkedIn(3).png?alt=media&token=df378d48-16ad-41f0-9b8c-932ba182e684";
    private static final String PROMOTION3 = "https://firebasestorage.googleapis.com/v0/b/quickguru-ddd55.appspot.com/o/test%2FSimple%20Work%20LinkedIn(2).png?alt=media&token=e90b23de-045c-4803-93d5-82c58dc4521f";
    private static final String PROMOTION4 = "https://firebasestorage.googleapis.com/v0/b/quickguru-ddd55.appspot.com/o/test%2FSimple%20Work%20LinkedIn(1).png?alt=media&token=89330588-bca1-42b0-a6fd-669beef48193";
    private static final String PROMOTION5 = "https://firebasestorage.googleapis.com/v0/b/quickguru-ddd55.appspot.com/o/test%2Fcarousel5.png?alt=media&token=2f95e2d1-a445-4b23-95c2-b8ba57067b96";
    private static final String PROMOTION6 = "https://firebasestorage.googleapis.com/v0/b/quickguru-ddd55.appspot.com/o/test%2Fcarousel6.png?alt=media&token=6a14eaf2-bdfa-4987-956f-21754e1dcdaa";
    private static final String PROMOTION7 = "https://firebasestorage.googleapis.com/v0/b/quickguru-ddd55.appspot.com/o/test%2Fcarousel7.png?alt=media&token=691cdf58-fa47-40a9-87d5-322f0e1df4cb";
    private static final String PROMOTION8 = "https://firebasestorage.googleapis.com/v0/b/quickguru-ddd55.appspot.com/o/test%2Fcarousel9.png?alt=media&token=dab99fc7-a1d3-47cf-8438-870048dae269";
    private static final String[] PROMOTIONS = new String[]{PROMOTION1, PROMOTION2, PROMOTION3, PROMOTION4,PROMOTION5, PROMOTION6, PROMOTION7, PROMOTION8};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        myCarouselView1 = (CarouselView)findViewById(R.id.my_carousel1);
        switch (getIntent().getIntExtra("key", 0)){
            case 0:
                viewCarousel1();
                break;

            case 1:
                viewCarousel2();
                break;

            case 2:
                viewCarousel3();
                break;
        }
    }

    public void viewCarousel1(){
        myCarouselView1.setLength(4);
        for (String promo : PROMOTIONS){
            myCarouselView1.addPromotion(promo);
        }
        myCarouselView1.setColorActive(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent));
        myCarouselView1.setColorInActive(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
        myCarouselView1.enableDots();
        myCarouselView1.showCarousel(getSupportFragmentManager());
    }

    public void viewCarousel2(){
        myCarouselView1.setLength(6);
        for (String promo : PROMOTIONS){
            myCarouselView1.addPromotion(promo);
        }
        myCarouselView1.disableDots();
        myCarouselView1.showCarousel(getSupportFragmentManager());
    }

    public void viewCarousel3(){
        myCarouselView1.setLength(5);
        for (String promo : PROMOTIONS){
            myCarouselView1.addPromotion(promo);
        }
        myCarouselView1.setColorActive(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent));
        myCarouselView1.setColorInActive(Color.WHITE);
        myCarouselView1.enableDots();
        myCarouselView1.overlapDotsonImage();
        myCarouselView1.showCarousel(getSupportFragmentManager());
    }

}