package com.example.creditcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.creditcard.ui.theme.CreditCardTheme
import com.example.creditcard.ui.theme.bodyBackgroundColor
import com.example.creditcard.ui.theme.color_one_gradient
import com.example.creditcard.ui.theme.text
import com.example.creditcard.ui.theme.titleIconRowColor
import com.example.creditcard.ui.theme.titleTextRowBackground
import com.example.creditcard.ui.theme.titleTextRowColor
import com.example.creditcard.ui.theme.usdText

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      CreditCardTheme {
        Surface(
          modifier = Modifier
            .fillMaxSize(),
        ) {
          ShowUi()
        }
      }
    }
  }
}

@Composable
fun ShowUi() {
  Column(
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    CreditCard(name = "$2,456,557.00")
    SimpleCard()
  }
}

@Composable
fun CreditCard(name: String) {
  Row(
    modifier = Modifier
      .wrapContentSize(),
    horizontalArrangement = Arrangement.Center,
    verticalAlignment = Alignment.CenterVertically
  ) {
    Card(
      modifier = Modifier
        .width(300.dp)
        .height(110.dp)
        .padding(10.dp),
      shape = RoundedCornerShape(20.dp)
    ) {
      Row(
        modifier = Modifier
          .fillMaxSize()
          .background(color_one_gradient)
          .padding(horizontal = 16.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Column(
          modifier = Modifier
            .fillMaxHeight()
            .wrapContentWidth(),
          verticalArrangement = Arrangement.SpaceBetween,
          horizontalAlignment = Alignment.Start
        ) {
          Row(
            modifier = Modifier.wrapContentSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom
          ) {
            Text(
              text = "All accounts",
              color = Color.White,
              fontSize = 12.sp,
              fontFamily = FontFamily.SansSerif
            )
            Spacer(modifier = Modifier.size(5.dp))
            Text(
              modifier = Modifier.wrapContentSize(),
              text = " Total balance",
              color = text,
              fontSize = 12.sp,
            )
          }
          Text(
            text = name,
            color = Color.White,
            fontSize = 19.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif
          )
        }
        Column(
          Modifier
            .fillMaxHeight()
            .wrapContentWidth(),
          verticalArrangement = Arrangement.SpaceBetween
        ) {
          Image(
            painter = painterResource(id = R.drawable.mastercard_1),
            contentDescription = "masterCard"
          )
          Text(
            text = "USD",
            color = usdText,
            fontFamily = FontFamily.SansSerif,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
          )
        }
      }
    }
  }
}

@Composable
fun SimpleCard() {
  Column(
    modifier = Modifier
      .height(200.dp)
      .width(200.dp)
      .clip(shape = RoundedCornerShape(10.dp))
  ) {
    TitleView()
  }
}

@Composable
fun TitleView() {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .height(50.dp)
      .background(color = titleTextRowBackground),
    horizontalArrangement = Arrangement.Start,
    verticalAlignment = Alignment.CenterVertically
  ) {
    Icon(
      modifier = Modifier.padding(start = 10.dp),
      imageVector = Icons.Filled.Done,
      contentDescription = "done",
      tint = titleIconRowColor
    )
    Spacer(modifier = Modifier.width(15.dp))
    TitleText(title = "Bills paid")
  }
  BodyView()
}

@Composable
fun BodyView() {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .background(color = bodyBackgroundColor),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.SpaceEvenly
  ) {
    TitleText(title = "Total bills paid")
    RoundedOutlineNumber()
    TitleText(title = "Latest bill paid: 27.01.2023")
  }
}

@Composable
fun TitleText(title: String) {
  Text(
    text = title,
    color = titleTextRowColor,
    fontSize = 14.sp
  )
}

@Composable
fun RoundedOutlineNumber() {
  OutlinedButton(
    modifier = Modifier
      .size(60.dp)
      .background(bodyBackgroundColor),
    shape = CircleShape,
    border = BorderStroke(2.dp, color = titleIconRowColor),
    onClick = { /*TODO*/ },
    colors = ButtonDefaults.buttonColors(backgroundColor = bodyBackgroundColor)
  ) {
    Text(
      fontSize = 22.sp,
      fontWeight = FontWeight.Bold,
      color = Color.White,
      text = "10"
    )
  }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  CreditCardTheme {
    ShowUi()
  }
}