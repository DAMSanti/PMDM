package com.example.newjuegobola

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.caverock.androidsvg.SVG

class CircuitView(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {
    private val paint = Paint().apply {
        color = Color.BLACK
        style = Paint.Style.STROKE
        //strokeWidth = 5f // Ajusta el strokeWidth aquí
    }
    private var circuitBitmap: Bitmap? = null
    private var circuitPath: Path? = null

    init {
        val svg = SVG.getFromInputStream(context.resources.openRawResource(R.raw.montmelo))
        circuitBitmap = Bitmap.createBitmap(svg.documentWidth.toInt(), svg.documentHeight.toInt(), Bitmap.Config.ARGB_8888)
        val canvas = Canvas(circuitBitmap!!)
        svg.renderToCanvas(canvas)

        // Create a path from the SVG
        circuitPath = Path()
        svg.renderToCanvas(object : Canvas() {
            override fun drawPath(path: Path, paint: Paint) {
                circuitPath?.addPath(path)
            }
        })
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        circuitBitmap?.let {
            val matrix = getTransformationMatrix()
            canvas.concat(matrix)
            canvas.drawBitmap(it, 0f, 0f, paint)
        }
    }

    fun checkCollision(x: Float, y: Float): Boolean {
        val ballRadius = 20f
        val pathMeasure = PathMeasure(circuitPath, false)
        val pathLength = pathMeasure.length
        val pos = FloatArray(2)
        val precision = 1 // Increase for more precision

        // Crear una matriz inversa para revertir las transformaciones
        val matrix = getTransformationMatrix()
        val inverseMatrix = Matrix()
        matrix.invert(inverseMatrix)

        // Transformar las coordenadas de la bola
        val ballCoords = floatArrayOf(x, y)
        inverseMatrix.mapPoints(ballCoords)

        for (distance in 0..pathLength.toInt() step precision) {
            pathMeasure.getPosTan(distance.toFloat(), pos, null)
            val dx = pos[0] - ballCoords[0]
            val dy = pos[1] - ballCoords[1]
            if (dx * dx + dy * dy <= ballRadius * ballRadius + paint.strokeWidth * paint.strokeWidth) { // Ajusta el strokeWidth aquí
                Log.d("CircuitView", "Collision detected at position ($x, $y)")
                invalidate() // Redraw the view to show the collision point
                return true
            }
        }

        return false
    }

    private fun getTransformationMatrix(): Matrix {
        val matrix = Matrix()
        matrix.postRotate(90f, (circuitBitmap!!.height / 2).toFloat(), (circuitBitmap!!.width / 2).toFloat())
        matrix.postScale(2.5f, 2.5f, (circuitBitmap!!.width / 2).toFloat(), (circuitBitmap!!.height / 2).toFloat())
        matrix.postTranslate((width - circuitBitmap!!.height * 1.5f) / 4, (height - circuitBitmap!!.width * 5.5f) / 5)
        return matrix
    }
}