package com.example.newjuegobola

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.util.AttributeSet
import android.util.Log
import android.view.View

class BallView(context: Context, private val circuitView: CircuitView, attrs: AttributeSet? = null) : View(context, attrs), SensorEventListener {
    private val paint = Paint().apply {
        color = Color.RED
    }
    private val pathPaint = Paint().apply {
        color = Color.BLUE
        style = Paint.Style.STROKE
        strokeWidth = 10f
    }
    private var xPos = 100f
    private var yPos = 100f
    private var xVelocity = 0f
    private var yVelocity = 0f
    private val collisionPoints = mutableListOf<PointF>()

    private val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    private val accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

    init {
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_GAME)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // Draw the collision points
        for (point in collisionPoints) {
            canvas.drawCircle(point.x, point.y, 20f, pathPaint)
        }
        // Draw the ball
        canvas.drawCircle(xPos, yPos, 20f, paint)
    }

    override fun onSensorChanged(event: SensorEvent) {
        val slowFactor = 0.4f

        xVelocity += event.values[0] * slowFactor
        yVelocity += event.values[1] * slowFactor

        xPos -= xVelocity
        yPos += yVelocity

        // Detectar colisiones con los límites de la pantalla
        if (xPos < 0) {
            xPos = 0f
            xVelocity = -xVelocity * 0.3f
        } else if (xPos > width) {
            xPos = width.toFloat()
            xVelocity = -xVelocity * 0.3f
        }

        if (yPos < 0) {
            yPos = 0f
            yVelocity = -yVelocity * 0.3f
        } else if (yPos > height) {
            yPos = height.toFloat()
            yVelocity = -yVelocity * 0.3f
        }

        // Detectar colisiones con el circuito
        val collision = circuitView.checkCollision(xPos, yPos)
        Log.d("BallView", "Ball position: ($xPos, $yPos), Collision: $collision")
        if (collision) {
            // Invertir la dirección de la velocidad al colisionar con el circuito
            xVelocity = -xVelocity * 0f
            yVelocity = -yVelocity * 0f

            // Agregar la posición actual a la lista de puntos de colisión
            collisionPoints.add(PointF(xPos, yPos))
        }

        invalidate()
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // Do nothing
    }
}