package com.zhikang.daiyan.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.zhikang.daiyan.ui.theme.Blue200
import com.zhikang.daiyan.ui.theme.Blue700

/**
 * 统一标题栏
 * @param content 标题栏内容
 *
 */
@Composable
fun TopAppBar(content: @Composable () -> Unit) {

    val systemUiController = rememberSystemUiController()
    LaunchedEffect(key1 = Unit){
        systemUiController.setStatusBarColor(Color.Transparent)
    }

    //标题栏高度
    var appBarHeight = 56.dp

    //转换状态栏高度px为dp
    val statusBarHeightDp = with(LocalDensity.current) {
        LocalWindowInsets.current.statusBars.top.toDp()
    }
    Row(
        modifier = Modifier
            .background(
                Brush.linearGradient(
                    listOf(
                        Blue700,
                        Blue200
                    )
                )
            )
            .fillMaxWidth()
            .height(appBarHeight + statusBarHeightDp)
            .padding(top = statusBarHeightDp),
                horizontalArrangement = Arrangement . Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        content()
    }

}

@Preview
@Composable
fun TopAppBarPreview() {
    TopAppBar() {
        Text("标题")
    }
}