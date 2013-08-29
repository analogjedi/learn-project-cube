package com.example.learnprojectopenglcube;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

public class ClearGLSurfaceView extends GLSurfaceView {
	Kocka mRenderer;
	private final float TOUCH_SCALE_FACTOR = 180.0f / 320.0f;
	private float previousX;
	private float previousY;
	
	public ClearGLSurfaceView(Context context) {
        super(context);
        mRenderer = new Kocka();
        setRenderer(mRenderer);
    }

    public boolean onTouchEvent(final MotionEvent event) {
        float currentX = event.getX();
        float currentY = event.getY();
        float deltaX, deltaY;
        switch (event.getAction()) {
	        case MotionEvent.ACTION_MOVE:
	                deltaX = currentX - previousX;
	                deltaY = currentY - previousY;
	                mRenderer.angleX += deltaY * TOUCH_SCALE_FACTOR;
	                mRenderer.angleY += deltaX * TOUCH_SCALE_FACTOR;
	                Log.i("DELTAY:", "\"" +deltaY * TOUCH_SCALE_FACTOR +"\"");
	                Log.i("DELTAX:", "\"" +deltaX * TOUCH_SCALE_FACTOR +"\"");
        }

        // Save current x, y
        previousX = currentX;
        previousY = currentY;
        return true;  // Event handled
    }
}