package com.example.newjuegobola

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val circuitView = CircuitView(this)
        val ballView = BallView(this, circuitView)

        setContentView(circuitView)
        addContentView(ballView, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
    }
}