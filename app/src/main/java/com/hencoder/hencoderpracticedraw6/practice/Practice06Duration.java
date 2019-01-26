package com.hencoder.hencoderpracticedraw6.practice;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.hencoder.hencoderpracticedraw6.R;

public class Practice06Duration extends LinearLayout {
    SeekBar durationSb;
    TextView durationValueTv;
    Button animateBt;
    ImageView imageView;
    int translationStateCount = 2;
    int translationState = 0;
    int duration = 300;

    public Practice06Duration(Context context) {
        super(context);
    }

    public Practice06Duration(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice06Duration(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        durationSb = (SeekBar) findViewById(R.id.durationSb);
        durationValueTv = (TextView) findViewById(R.id.durationValueTv);
        durationValueTv.setText(getContext().getString(R.string.ms_with_value, duration));
        durationSb.setMax(10);
        durationSb.setProgress(1);
        durationSb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                duration = progress * 300;
                durationValueTv.setText(getContext().getString(R.string.ms_with_value, duration));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        animateBt = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);
        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO 在这里处理点击事件，执行动画。记得使用 `setDuration(duration)` 来设置动画的时长。
                switch (translationState) {
                    case 0:
                        imageView.animate().translationX(400);
                        imageView.animate().scaleX(1.5f);
                        imageView.animate().rotation(200);
                        imageView.animate().scaleY(1.5f);
                        imageView.animate().alpha(1);
                        imageView.animate().setDuration(duration);
                        break;
                    case 1:
                        imageView.animate().translationX(0);
                        imageView.animate().scaleY(0);
                        imageView.animate().scaleX(0);
                        imageView.animate().alpha(1);
                        imageView.animate().rotation(0);
                        imageView.animate().setDuration(duration);
                        break;
                }
                translationState++;
                if (translationState == translationStateCount) {
                    translationState = 0;
                }
            }
        });
    }
}
