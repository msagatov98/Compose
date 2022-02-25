package com.example.myapplication.sosedi.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.IconDefaultColor
import com.example.myapplication.ui.theme.Primary
import com.example.myapplication.ui.theme.TextPrimaryDark
import com.example.myapplication.ui.theme.ToggleBackgroundFeed
import com.example.myapplication.ui.theme.ToggleBackgroundMarketplace
import com.example.myapplication.ui.theme.ToggleButtonFeed
import com.example.myapplication.ui.theme.ToggleButtonMarketplace
import com.example.myapplication.ui.theme.ToggleTextFeed
import com.example.myapplication.ui.theme.ToggleTextMarketplace
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.runBlocking

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TopBar(
    pageState: PagerState
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(start = 24.dp, top = 24.dp, end = 24.dp, bottom = 20.dp),
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_logo),
                contentDescription = "logo",
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
            )

            Text(text = "Жк Вавилон", color = TextPrimaryDark, fontSize = 14.sp)

            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_bookmark),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .padding(8.dp),
                tint = IconDefaultColor
            )

            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_notification),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .padding(8.dp),
                tint = IconDefaultColor
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp)
                .padding(2.dp),
            backgroundColor = if (pageState.currentPage == 0) {
                ToggleBackgroundFeed
            } else {
                ToggleBackgroundMarketplace
            }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 2.dp)
            ) {
                Button(
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.weight(1.0F),
                    onClick = {
                        runBlocking {
                            pageState.scrollToPage(0)
                        }
                    },
                    colors = if (pageState.currentPage == 0) {
                        ButtonDefaults.buttonColors(backgroundColor = Color.White)
                    } else {
                        ButtonDefaults.buttonColors(backgroundColor = ToggleButtonFeed)
                    }
                ) {
                    Text(
                        text = "Лента Жк",
                        color = if (pageState.currentPage == 0) {
                            ToggleTextFeed
                        } else {
                            Color.White
                        }
                    )
                }

                Button(
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.weight(1.0F),
                    onClick = {
                        runBlocking {
                            pageState.scrollToPage(1)
                        }
                    },
                    colors = if (pageState.currentPage == 0) {
                        ButtonDefaults.buttonColors(backgroundColor = ToggleButtonMarketplace)
                    } else {
                        ButtonDefaults.buttonColors(backgroundColor = Color.White)
                    }
                ) {
                    Text(
                        text = "Маркетплейс",
                        color = if (pageState.currentPage == 0) {
                            Color.White
                        } else {
                            ToggleTextMarketplace
                        }
                    )
                }

            }
        }
    }
}