package com.excite.mobile.shop.Activities.Home.Promo;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class LinearLayoutPromo extends LinearLayout {
    private float scale = PromoAdapter.BIG_SCALE;

    public LinearLayoutPromo(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LinearLayoutPromo(Context context) {
        super(context);
    }

    public void setScaleBoth(float scale) {
        this.scale = scale;
        this.invalidate();    // If you want to see the scale every time you set
        // scale you need to have this line here,
        // invalidate() function will call onDraw(Canvas)
        // to redraw the view for you
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // The main mechanism to display scale animation, you can customize it
        // as your needs
        int w = this.getWidth();
        int h = this.getHeight();
        canvas.scale(scale, scale, w / 2, h/1.3f);

        super.onDraw(canvas);
    }
}
