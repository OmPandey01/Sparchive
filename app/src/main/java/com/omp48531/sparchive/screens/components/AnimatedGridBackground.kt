package com.omp48531.sparchive.screens.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import kotlin.math.PI
import kotlin.math.sin

@Composable
fun AnimatedGridBackground(
    modifier: Modifier = Modifier,
    gridSize: Float = 60f, // Distance between lines
    gridColor: Color = Color.White.copy(alpha = 0.3f),
    dotColor: Color = Color.White.copy(alpha = 0.8f)
) {
    // 1. The Gradient Background (Blue to White)
    val backgroundBrush = Brush.linearGradient(
        colors = listOf(
//            Color(0xFF1E3C72), // Deep Blue
            Color(0xFF2A5298), // Lighter Blue
            Color(0xFFFFFFFF)  // White bottom
        ),
        start = Offset.Zero,
        end = Offset.Infinite
    )

    // 2. The Animation Clock
    // We animate a float from 0 to 2*PI endlessly.
    // This drives the sine wave for the "breathing" effect.
    val infiniteTransition = rememberInfiniteTransition(label = "grid-animation")
    val time by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 2f * PI.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(4000, easing = LinearEasing), // 4 seconds per cycle
            repeatMode = RepeatMode.Restart
        ),
        label = "time-flow"
    )

    // Convert dp to pixels for drawing
    val density = LocalDensity.current
    val strokeWidth = with(density) { 1.dp.toPx() }
    val baseDotRadius = with(density) { 2.dp.toPx() }
    val maxDotGrowth = with(density) { 3.dp.toPx() }

    Box(
        modifier = modifier
            .background(backgroundBrush)
            .fillMaxSize()
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val width = size.width
            val height = size.height

            // 3. Draw Vertical Lines
            for (x in 0..width.toInt() step gridSize.toInt()) {
                drawLine(
                    color = gridColor,
                    start = Offset(x.toFloat(), 0f),
                    end = Offset(x.toFloat(), height),
                    strokeWidth = strokeWidth
                )
            }

            // 4. Draw Horizontal Lines
            for (y in 0..height.toInt() step gridSize.toInt()) {
                drawLine(
                    color = gridColor,
                    start = Offset(0f, y.toFloat()),
                    end = Offset(width, y.toFloat()),
                    strokeWidth = strokeWidth
                )
            }

            // 5. Draw "Popping" Dots at Intersections
            for (x in 0..width.toInt() step gridSize.toInt()) {
                for (y in 0..height.toInt() step gridSize.toInt()) {

                    // We generate a "pseudo-random" offset based on the x,y coordinates.
                    // This ensures every dot has a different rhythm, but it's deterministic
                    // (we don't need to store state for every dot).
                    val offset = (x + y) * 0.05f

                    // Sine wave math: Result is between -1 and 1
                    val sineValue = sin(time + offset)

                    // Normalize to 0..1 range
                    val normalizedPulse = (sineValue + 1) / 2

                    // Calculate current radius
                    val currentRadius = baseDotRadius + (maxDotGrowth * normalizedPulse)

                    // Optimization: Only draw if the dot is large enough to be seen
                    if (currentRadius > 1f) {
                        drawCircle(
                            color = dotColor,
                            radius = currentRadius,
                            center = Offset(x.toFloat(), y.toFloat())
                        )
                    }
                }
            }
        }
    }
}