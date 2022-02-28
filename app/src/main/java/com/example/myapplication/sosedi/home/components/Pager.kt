package com.example.myapplication.sosedi.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.JungleGreen
import com.example.myapplication.ui.theme.RegentGray
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Pager(
    pageState: PagerState
) {

    val pages = listOf(
        Place("Feed"),
        Place("Marketplace")
    )

    HorizontalPager(
        count = 2,
        state = pageState,
        modifier = Modifier.fillMaxSize()
    ) { page ->
        PagerUi(place = pages[page])
    }
}

@Composable
fun PagerUi(place: Place) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp, vertical = 0.dp),
    ) {
        Spacer(modifier = Modifier.height(8.dp))

        Filter(place.name == "Feed")

    }
}

@Composable
fun Filter(isFeed: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp)
            .background(Color.White, shape = RoundedCornerShape(12.dp))
            .padding(horizontal = 16.dp, vertical = 0.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (isFeed) {
            ChipItem(text = "Все", color = JungleGreen)
            ChipItem(text = "Обьявления от КСК")
            ChipItem(text = "Жители")
        } else {
            FilterButton()
        }
        
    }
}

@Composable
fun ChipItem(text: String, color: Color = RegentGray) {
    Text(
        text = text,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .height(32.dp)
            .border(width = 1.dp, color = color, shape = RoundedCornerShape(16.dp))
            .padding(horizontal = 12.dp, vertical = 0.dp),
        fontSize = 14.sp,
        color = color
    )
    Spacer(modifier = Modifier.width(8.dp))
}

@Composable
fun FilterButton() {
    Row {
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_filter_gray),
            contentDescription = "filter"
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = "Фильтр")
    }
}

