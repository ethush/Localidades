package com.digepo.localidades;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;


/**
 * Clase Flip3dAnimation. Animación para dar efectos de giro en 3D a botones.
 */
public class Flip3dAnimation  extends Animation {
		
		/** Punto inicial de giro. */
		private final float mFromDegrees;
		
		/** Punto final de giro. */
		private final float mToDegrees;
		
		/** Punto de sujeción X. */
		private final float mCenterX;
		
		/** Punto de sujeción Y. */
		private final float mCenterY;
		
		/** Responsable de la animación.. */
		private Camera mCamera;

		/**
		 * Crea una nueva clase de tipo flip3d.
		 *
		 * @param fromDegrees Float. Punto inicial de giro - Límite 260 grados.
		 * @param toDegrees Float. Punto final de giro (desde
		 * @param centerX Float. Punto de sujeción de giro X
		 * @param centerY Float. Punto de sujeción de giro Y
		 * */
		public Flip3dAnimation(float fromDegrees, float toDegrees,
		   float centerX, float centerY) {
			mFromDegrees = fromDegrees;
			mToDegrees = toDegrees;
			mCenterX = centerX;
			mCenterY = centerY;
		}
		
		/* (non-Javadoc)
		 * @see android.view.animation.Animation#initialize(int, int, int, int)
		 */
		@Override
		public void initialize(int width, int height, int parentWidth, int parentHeight) {
			super.initialize(width, height, parentWidth, parentHeight);
			
			mCamera = new Camera();
		}

		/* (non-Javadoc)
		 * @see android.view.animation.Animation#applyTransformation(float, android.view.animation.Transformation)
		 */
		@Override
		protected void applyTransformation(float interpolatedTime, Transformation t) {
			final float fromDegrees = mFromDegrees;
			float degrees = fromDegrees + ((mToDegrees - fromDegrees) * interpolatedTime);
	
			final float centerX = mCenterX;
			final float centerY = mCenterY;
			final Camera camera = mCamera;
	
			final Matrix matrix = t.getMatrix();
	
			camera.save();
	
			camera.rotateY(degrees);
	
			camera.getMatrix(matrix);
			camera.restore();
	
			matrix.preTranslate(-centerX, -centerY);
			matrix.postTranslate(centerX, centerY);
			
			
		}
		
}
