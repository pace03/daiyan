package com.zhikang.daiyan.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.insets.statusBarsPadding
import com.zhikang.daiyan.ui.components.TopAppBar
import com.zhikang.daiyan.ui.components.appBarHeight

@Composable
fun TaskScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(Color(0xFF149EE7), Color.White)
                )
            )
    ) {
        Row(
            modifier = Modifier
                .statusBarsPadding()
                .height(appBarHeight),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "学习任务",
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 18.sp
            )
        }

    }

}

@Preview
@Composable
fun TaskScreenPreview() {
    TaskScreen()
}