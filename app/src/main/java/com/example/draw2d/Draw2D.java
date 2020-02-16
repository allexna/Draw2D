package com.example.draw2d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class Draw2D extends View {
    private Paint mPaint=new Paint();
    private Rect mRect=new Rect();
    private Bitmap mBitmap;




    public Draw2D(Context context){
        super(context);
        //ресурсы
        Resources res=this.getResources();
        mBitmap=BitmapFactory.decodeResource(res,R.drawable.cat);
    }



    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas){


        super.onDraw(canvas);
        int width=canvas.getWidth();
        int height=canvas.getHeight();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.WHITE);
        canvas.drawPaint(mPaint);
        //sun
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.YELLOW);
        // canvas.drawCircle(950,30,25,mPaint);
        canvas.drawCircle(width-30,30,25,mPaint);
        //green rectangle
        mPaint.setColor(Color.GREEN);
        //canvas.drawRect(20,650,950,680,mPaint);
        canvas.drawRect(0,height-30,width,height,mPaint);

        //blue text
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(32);
        //canvas.drawText("Лужайка только для котиков!",30,648,mPaint);
        canvas.drawText("Лужайка только для котиков!",30,height-32,mPaint);
        //rotate text под углом
        // int x=810;
        int x=width-170;
        int y=190;
        mPaint.setColor(Color.GRAY);
        mPaint.setTextSize(27);
        String str2rotate="Лучик солнца!";
        canvas.save();
        //rectangle for rotate text

        canvas.rotate(-45,x+mRect.exactCenterX(),y+mRect.exactCenterY());
        //text
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawText(str2rotate,x,y,mPaint);

        //recover холст
        canvas.restore();
        //picture

        // canvas.drawBitmap(mBitmap,450,530,mPaint);
        canvas.drawBitmap(mBitmap,width-mBitmap.getWidth(),height-mBitmap.getHeight()-10,mPaint);



    }

}
