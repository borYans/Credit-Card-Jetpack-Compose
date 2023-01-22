package com.example.creditcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.creditcard.ui.theme.CreditCardTheme
import com.example.creditcard.ui.theme.color_one_gradient
import com.example.creditcard.ui.theme.text
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
          CreditCard(name = "$2,456,557.00")
        }
      }
    }
  }
}

@Composable
fun CreditCard(name: String) {
  Row(
    modifier = Modifier
      .fillMaxSize(),
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  CreditCardTheme {
    CreditCard(name = "$2,456,557.00")
  }
}