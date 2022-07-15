package com.zhikang.daiyan.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zhikang.daiyan.viewmodel.TaskViewModel

@Composable
fun CircleRing(boxWidthDp: Int,vm:TaskViewModel) {

    val strokeWidth = 31f
    Canvas(
        modifier = Modifier.size(boxWidthDp.dp)
    ) {
        drawArc(
            Color(0, 0, 0, 15),
            startAngle = 160f,
            sweepAngle = 220f,
            useCenter = false,
            style = Stroke(strokeWidth, cap = StrokeCap.Round)
        )
        drawArc(
            Color.White,
            startAngle = 160f,
            sweepAngle = vm.pointOfYearPercent,
            useCenter = false,
            style = Stroke(strokeWidth, cap = StrokeCap.Round)
        )

    }
}