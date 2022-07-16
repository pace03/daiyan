package com.zhikang.daiyan.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zhikang.daiyan.R
import com.zhikang.daiyan.ui.components.TopAppBar

@Composable
fun MineScreen() {

    val menus = listOf(
        MenuItem(R.drawable.credit, "学习积分"),
        MenuItem(R.drawable.history, "浏览记录"),
        MenuItem(R.drawable.archives, "学习档案"),
        MenuItem(R.drawable.help, "常见问题"),
        MenuItem(R.drawable.version_info, "版本信息"),
        MenuItem(R.drawable.settings, "个人设置"),
        MenuItem(R.drawable.contact, "联系我们"),
    )

    Column(modifier = Modifier) {
        TopAppBar() {
            Text("我的", fontSize = 18.sp, color = Color.White)
        }
        LazyColumn(modifier = Modifier) {
            //头像部分
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 24.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.daiyan),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(62.dp)
                            .clip(CircleShape)
                    )
                    Column(
                        verticalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .height(62.dp)
                    ) {
                        Text(text = "未登录", color = Color(0xFF333333), fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        Text(text = "已坚持学习8天", color = Color(0xFF999999), fontSize = 14.sp)
                    }

                }
            }

            //菜单部分
            itemsIndexed(menus) { index, menu ->
                if (index == 3) {
                    Box(
                        modifier = Modifier
                            .height(16.dp)
                            .background(Color(0xFFF5F5F5))
                            .fillMaxWidth()
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            vertical = 4.dp,
                            horizontal = 8.dp
                        )
                ) {
                    Icon(
                        painter = painterResource(id = menu.icon),
                        contentDescription = null,
                        tint = Color(0xFF149EE7),
                        modifier = Modifier.size(17.dp)
                    )
                    Column(
                        modifier = Modifier.padding(horizontal = 8.dp)

                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp)
                        ) {
                            Text(
                                text = menu.title,
                                color = Color(0xFF333333),
                                fontSize = 18.sp,
                                modifier = Modifier.weight(1f)
                            )
                            Icon(
                                imageVector = Icons.Default.ArrowForwardIos,
                                contentDescription = null,
                                tint = Color.Gray,
                                modifier = Modifier.width(13.dp)
                            )
                        }

                        Divider()
                    }
                }
            }
        }
    }

}

data class MenuItem(@DrawableRes val icon: Int, val title: String)

@Preview
@Composable
fun MineScreenPreview() {
    MineScreen()
}