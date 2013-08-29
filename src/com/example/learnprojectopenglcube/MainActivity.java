package com.example.learnprojectopenglcube;

import android.app.Activity;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

public class MainActivity extends Activity {

	private GLSurfaceView glView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
      	super.onCreate(savedInstanceState);
      	glView = new ClearGLSurfaceView(this);
		setContentView(glView);
	}

	@Override
	protected void onResume() {
		super.onResume();
		glView.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
		glView.onPause();
	}

}