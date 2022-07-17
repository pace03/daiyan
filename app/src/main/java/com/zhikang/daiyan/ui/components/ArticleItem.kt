package com.zhikang.daiyan.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zhikang.daiyan.model.entity.ArticleEntity

/**
 * 文章列表 item
 * @param article
 * @param modifier
 */
@Composable
fun ArticleItem(article: ArticleEntity,modifier: Modifier=Modifier) {

    Column(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Text(
            text = article.title,
            color = Color(0xFF333333),
            fontSize = 16.sp,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "来源：${article.source}",
                color = Color(0xFF999999),
                fontSize = 12.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = article.timestamp,
                color = Color(0xFF999999),
                fontSize = 12.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
                )
        }

        Spacer(modifier = Modifier.height(8.dp))
        Divider()
    }
}