package com.wanglijun.android_study_2020.canvasView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/**
 * @author： wlj
 * @Date: 2020-04-21
 * @email: wanglijundev@gmail.com
 * @desc:
 */
public class View01 extends View {
    private Paint mPaint;

    public View01(Context context) {
        super(context);
        init();
    }

    public View01(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public View01(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        //设置绘制模式 FILL 填充, STROKE 画线 和 FILL_AND_STROKE 填充并且画线
        mPaint.setStyle(Paint.Style.STROKE);
        //设置画笔颜色
        mPaint.setColor(Color.RED);
        //设置线条宽度 在STROKE 和 FILL_AND_STROKE模式下
        mPaint.setStrokeWidth(10f);
        //设置文字大小
        mPaint.setTextSize(20f);
        //设置抗锯齿开关
        mPaint.setAntiAlias(true);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画圆
//        canvas.drawCircle(100, 100, 50, mPaint);

        //画矩形
//        mPaint.setStyle(Paint.Style.FILL);
//        canvas.drawRect(700,500,1200,500,mPaint);

        /**
         * 画点 基本上和画圆一样，还可以画方形的点
         * 圆头 (ROUND)、平头 (BUTT) 和方头 (SQUARE) 三种
         */
//        mPaint.setStyle(Paint.Style.FILL);
//        mPaint.setStrokeWidth(20f);
//        mPaint.setStrokeCap(Paint.Cap.SQUARE);
//        canvas.drawPoint(200, 200, mPaint);

        //画四个点
//        float[] points = {0, 0, 50, 50, 50, 100, 100, 50, 100, 100, 150, 50, 150, 100};
//        // 绘制四个点：(50, 50) (50, 100) (100, 50) (100, 100)
//        canvas.drawPoints(points, 2 /* 跳过两个数，即前两个 0 */,
//                8 /* 一共绘制 8 个数（4 个点）*/, mPaint);

        //画椭圆 左边左边、顶部坐标、右边坐标、底部坐标
//        canvas.drawOval(50,50,350,200,mPaint);
        // 也可以把坐标参数封装进 RectF里面直接设置
//        RectF rectF = new RectF(50,50,350,200);
//        mPaint.setStyle(Paint.Style.FILL);
//        canvas.drawOval(rectF,mPaint);

        //画线 startX, startY, stopX, stopY 分别是线的起点和终点坐标。
//        canvas.drawLine(200, 200, 800, 500, mPaint);
        //批量的画线
//        float[] points = {20, 20, 120, 20, 70, 20, 70, 120, 20, 120, 120, 120, 150, 20, 250, 20, 150, 20, 150, 120, 250, 20, 250, 120, 150, 120, 250, 120};
//        canvas.drawLines(points, mPaint);

        //画圆角矩形，left, top, right, bottom 是四条边的坐标，rx 和 ry 是圆角的横向半径和纵向半径。
//        canvas.drawRoundRect(100,100,300,300,50,50,mPaint);

        //画一个扇形或者弧形的线 left, top, right, bottom 描述的是这个弧形所在的椭圆；
        // startAngle 是弧形的起始角度（x 轴的正向，即正右的方向，是 0 度的位置；顺时针为正角度，逆时针为负角度），
        // sweepAngle 是弧形划过的角度；
        // useCenter 表示是否连接到圆心，如果不连接到圆心，就是弧形，如果连接到圆心，就是扇形
//        mPaint.setStyle(Paint.Style.STROKE);
//        canvas.drawArc(200,200,600,600,0,90,false,mPaint);

        //这是一组颜色的集合，可以做出来渐变色的矩形等 比如按钮背景颜色
        Shader shader = new LinearGradient(100, 100, 500, 500, Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);
        mPaint.setShader(shader);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);
        canvas.drawRoundRect(100,100,600,200,50,50,mPaint);

        //这是一组颜色的集合，可以做出来渐变色的矩形等 比如按钮背景颜色，空心的按钮
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawRoundRect(100,400,600,500,50,50,mPaint);
        //渐变的文字
        Shader shaderText = new LinearGradient(100, 800, 300, 900, Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);
        mPaint.setShader(shaderText);
        mPaint.setTextSize(80);
        canvas.drawText("我是王丽君",100,800,mPaint);
        //给文字加阴影
        mPaint.setShadowLayer(10,0,0,Color.RED);
        canvas.drawText("我是王丽君",100,900,mPaint);
    }
}
