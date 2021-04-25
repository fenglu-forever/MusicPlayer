package com.luyuanyuan.muiscplayer.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;

public class IndicatorRadioButton extends androidx.appcompat.widget.AppCompatRadioButton {
    private int mIndicatorColor;
    private int mIndicatorHeight;
    private int mIndicatorMaxWidth = -1;
    private int mIndicatorConner;
    private Paint mPaint;

    public IndicatorRadioButton(Context context) {
        super(context);
        initProperties();
    }

    public IndicatorRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initProperties();
    }

    public IndicatorRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initProperties();
    }

    private void initProperties() {
        mIndicatorColor = Color.parseColor("#ED334A");
        mIndicatorHeight = dpToPx(2);
        mIndicatorConner = dpToPx(1);

        mPaint = new Paint();
        mPaint.setColor(mIndicatorColor);
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isChecked()) {
            return;
        }
        final float width = getWidth();
        final float height = getHeight();
        final float cx = getPaddingLeft() + (width - getPaddingLeft() - getPaddingRight()) / 2f;
        float indicatorWidth = width - getPaddingLeft() - getPaddingRight();
        if (mIndicatorMaxWidth > 0) {
            if (width > mIndicatorMaxWidth) {
                indicatorWidth = mIndicatorMaxWidth;
            }
        }
        float halfIndicatorWidth = indicatorWidth / 2f;
        canvas.drawRoundRect(cx - halfIndicatorWidth,
                height - getPaddingBottom() - mIndicatorHeight,
                cx + halfIndicatorWidth,
                height - getPaddingBottom(),
                mIndicatorConner,
                mIndicatorConner,
                mPaint);
    }

    private int dpToPx(float dpValue) {
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, getResources().getDisplayMetrics()));
    }

    @Override
    public void setChecked(boolean checked) {
        if (isChecked() != checked) {
            super.setChecked(checked);
            invalidate();
        }
    }
}
