package com.zhikang.daiyan.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.insets.statusBarsPadding
import com.zhikang.daiyan.ui.components.CircleRing
import com.zhikang.daiyan.ui.components.TopAppBar
import com.zhikang.daiyan.ui.components.appBarHeight
import com.zhikang.daiyan.viewmodel.TaskViewModel

@Composable
fun TaskScreen(taskVM: TaskViewModel = viewModel()) {

    //圆环高度
    var boxWidthDp: Int
    with(LocalConfiguration.current) {
        boxWidthDp = screenWidthDp / 2
    }

    //当学年积分改变时更新学年积分进度百分比
    LaunchedEffect(taskVM.pointOfYear) {
        taskVM.updatePointPercent()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(Color(0xFF149EE7), Color.White)
                )
            )
    ) {
        //标题栏
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
                fontSize = 20.sp
            )
        }

        //
        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
            //学习周期
            item {
                Text(
                    text = taskVM.taskDate,
                    fontSize = 14.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)

                )
            }

            //学习进度
            item {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .height(boxWidthDp.dp)
                        .padding(8.dp)
                ) {
                    //圆环
                    CircleRing(boxWidthDp, taskVM)

                    //进度数据
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            buildAnnotatedString {
                                append(taskVM.pointOfYear.toString())
                                withStyle(
                                    SpanStyle(
                                        fontSize = 14.sp
                                    )
                                ) {
                                    append("分")
                                }
                            },
                            fontSize = 36.sp,
                            color = Color.White
                        )
                        Text(
                            text = "学年积分",
                            fontSize = 14.sp,
                            color = Color.White
                        )
                    }
                }
            }

            item {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                        .offset(y=(-42).dp)
                ) {
                    Column() {
                        Text(
                            text = "${taskVM.totalPointOfYear}分",
                            fontSize = 16.sp,
                            color = Color.White
                        )
                        Text(
                            text = "学年规定积分",
                            fontSize = 12.sp,
                            color = Color.White
                        )
                    }
                    Column() {
                        Text(
                            text = "${taskVM.totalPointOfYear - taskVM.pointOfYear}分",
                            fontSize = 16.sp,
                            color = Color.White
                        )
                        Text(
                            text = "还差",
                            fontSize = 12.sp,
                            color = Color.White
                        )
                    }
                }
            }
        }

    }

}

@Preview
@Composable
fun TaskScreenPreview() {
    TaskScreen()
}