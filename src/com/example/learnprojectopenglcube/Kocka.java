package com.example.learnprojectopenglcube;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLU;
import android.opengl.GLSurfaceView.Renderer;

public class Kocka implements ClearGLSurfaceView.Renderer {
	private kocka1 kocka;
	private float speed;
	
	float angleX = 0;   // (NEW)
	float angleY = 0;   // (NEW)
	float speedX = 0;   // (NEW)
	float speedY = 0;   // (NEW)
	float z = -6.0f;    // (NEW)

	public Kocka() {
		kocka = new kocka1();
	}

	public void onSurfaceCreated(GL10 gl, EGLConfig config) {		
		gl.glShadeModel(GL10.GL_SMOOTH);
		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.5f);
		gl.glClearDepthf(1.0f);
		gl.glEnable(GL10.GL_DEPTH_TEST);
		gl.glDepthFunc(GL10.GL_LEQUAL);
		
		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST); 
	}

	public void onDrawFrame(GL10 gl) {
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);	
		gl.glLoadIdentity();
		
		gl.glTranslatef(0.0f, 0.0f, z);   // Translate into the screen (NEW)
		gl.glRotatef(angleX, 1.0f, 0.0f, 0.0f); // Rotate (NEW)
		gl.glRotatef(angleY, 0.0f, 1.0f, 0.0f); // Rotate (NEW)
  		kocka.draw(gl);

		speed += 3.00f;
	    angleX += speedX;  // (NEW)
	    angleY += speedY;  // (NEW)
	}

	public void onSurfaceChanged(GL10 gl, int width, int height) {
		if(height == 0) {
			height = 1;
		}

		gl.glViewport(0, 0, width, height);
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();

		GLU.gluPerspective(gl, 45.0f, (float)width / (float)height, 0.1f, 100.0f);

		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
	}
}
