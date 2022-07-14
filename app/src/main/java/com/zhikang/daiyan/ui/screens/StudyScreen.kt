package com.zhikang.daiyan.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.zhikang.daiyan.model.entity.VideoEntity
import com.zhikang.daiyan.ui.components.*
import com.zhikang.daiyan.ui.components.TopAppBar
import com.zhikang.daiyan.viewmodel.ArticleViewModel
import com.zhikang.daiyan.viewmodel.MainViewModel
import com.zhikang.daiyan.viewmodel.VideoViewModel

@OptIn(ExperimentalPagerApi::class)
@Composable
fun StudyScreen(
    vm: MainViewModel = viewModel(),
    articleViewModel: ArticleViewModel = viewModel(),
    videoViewModel: VideoViewModel = viewModel()
) {
    Column(modifier = Modifier) {

        //标题栏
        TopAppBar {

            Spacer(modifier = Modifier.width(8.dp))

            //搜索按钮
            Surface(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .weight(1f),
                color = Color(0x33AFFFFF)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        "搜索感兴趣的课程",
                        color = Color.White,
                        fontSize = 16.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            //学习进度
            Text(
                text = "学习\n进度",
                fontSize = 14.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "26%",
                fontSize = 16.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                imageVector = Icons.Filled.Notifications,
                contentDescription = null,
                tint = Color.White
            )
        }

        //分类标签
        TabRow(
            selectedTabIndex = vm.categoryIndex,
            backgroundColor = Color(0x22149EE7),
            contentColor = Color(0xFF149EE7)
        ) {
            vm.categories.forEachIndexed { index, category ->
                Tab(
                    selected = vm.categoryIndex == index,
                    onClick = {
                        vm.updateCategoryIndex(index)
                    },
                    selectedContentColor = Color(0xFF149EE7),
                    unselectedContentColor = Color(0xFF666666)

                ) {
                    Text(
                        text = category.title,
                        modifier = Modifier.padding(vertical = 8.dp),
                        fontSize = 16.sp
                    )
                }
            }
        }

        TabRow(
            selectedTabIndex = vm.currentTypeIndex,
            backgroundColor = Color.Transparent,
            contentColor = Color(0xFF149EE7),
            indicator = {},
            divider = {}
        ) {
            vm.types.forEachIndexed { index, dataType ->
                LeadingIconTab(
                    selected = vm.currentTypeIndex == index,
                    onClick = {
                        vm.updateTypeIndex(index)
                    },
                    selectedContentColor = Color(0xFF149EE7),
                    unselectedContentColor = Color(0xFF666666),
                    icon = {
                        Icon(imageVector = dataType.icon, contentDescription = null)
                    },
                    text = {
                        Text(
                            text = dataType.title,
                            modifier = Modifier.padding(vertical = 8.dp),
                            fontSize = 16.sp
                        )
                    }
                )
            }
        }

        LazyColumn() {

            item {
                //轮播图
                SwiperContent(vm)
            }

            item {
                //通知公告
                NotificationContent(vm)
            }


            if (vm.showArticleList) {
                //通知列表
                items(articleViewModel.list) { article ->
                    ArticleItem(article)
                }
            } else {
                //视频列表
                items(
                    videoViewModel.list
                ) { videoEntity ->
                    VideoItem(videoEntity)
                }
            }
        }
    }
}

@Preview
@Composable
fun StudyScreenPreview() {
    StudyScreen()
}