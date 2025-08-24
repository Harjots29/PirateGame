package com.training.pirategame

import android.R.attr.fontWeight
import android.R.attr.name
import android.content.ContentValues.TAG
import android.icu.text.ListFormatter
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.training.pirategame.ui.theme.PirateGameTheme
import org.intellij.lang.annotations.JdkConstants
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PirateGameTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    PirateGame()
                }
            }
        }
    }
}

@Composable
fun PirateGame() {
    
    var heading by remember { mutableStateOf("Pirate Game") }
    var randomNumber by remember{ mutableStateOf(0) }
    var start by remember { mutableStateOf("Start") }
    var end by remember { mutableStateOf("End") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)) {

        Spacer(modifier = Modifier
            .height(50.dp)
            .fillMaxWidth())

        Row(modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 50.dp)
            .height(60.dp)
            .width(400.dp)
            .background(androidx.compose.ui.graphics.Color.LightGray),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = heading,
                modifier = Modifier
                    .fillMaxWidth(),
                fontSize = 30.sp,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
        }
        Spacer(modifier = Modifier
            .height(50.dp)
            .fillMaxWidth())

        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = start,
                modifier = Modifier.padding(20.dp),
                fontSize = 30.sp,
                textAlign = androidx.compose.ui.text.style.TextAlign.Start,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
            )
            Text(text = end,
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                fontSize = 30.sp,
                textAlign = androidx.compose.ui.text.style.TextAlign.End,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
            )

        }

        Spacer(modifier = Modifier
            .height(50.dp)
            .fillMaxWidth())

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly){
            Button(
                modifier = Modifier
                    .height(80.dp)
                    .width(130.dp)
                    .padding(6.dp),
                onClick = {
                    randomNumber = Random.nextInt(0, 2)
                    Log.e(TAG, "PirateGame: $randomNumber", )
                    if (randomNumber == 0){
                        heading = "Treasure Not Found"
                    }else{
                        heading = "Treasure Found"
                    }
                    start = "NORTH"
                    end = "NORTH"
                }
            ){
                Text("NORTH",
                    fontSize = 18.sp)
            }
        }

        Spacer(modifier = Modifier
            .height(30.dp)
            .fillMaxWidth())

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly){
            Button(
                modifier = Modifier
                    .height(80.dp)
                    .width(120.dp)
                    .padding(6.dp),
                onClick = {
                    randomNumber = Random.nextInt(0, 2)
                    Log.e(TAG, "PirateGame: $randomNumber", )
                    if (randomNumber == 0){
                        heading = "Treasure Not Found"
                    }else{
                        heading = "Treasure Found"
                    }
                    end = "WEST"
                }
            ){
                Text("WEST",
                    fontSize = 18.sp)
            }

            Button(
                modifier = Modifier
                    .height(80.dp)
                    .width(120.dp)
                    .padding(6.dp),
                onClick = {
                    randomNumber = Random.nextInt(0, 2)
                    Log.e(TAG, "PirateGame: $randomNumber", )
                    if (randomNumber == 0){
                        heading = "Treasure Not Found"
                    }else{
                        heading = "Treasure Found"
                    }
                    end = "EAST"
                }
            ){
                Text("EAST",
                    fontSize = 18.sp)
            }
        }

        Spacer(modifier = Modifier
            .height(30.dp)
            .fillMaxWidth())

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly){
            Button(
                modifier = Modifier
                    .height(80.dp)
                    .width(130.dp)
                    .padding(6.dp),
                onClick = {
                    randomNumber = Random.nextInt(0, 2)
                    Log.e(TAG, "PirateGame: $randomNumber", )
                    if (randomNumber == 0){
                        heading = "Treasure Not Found"
                    }else{
                        heading = "Treasure Found"
                    }
                    end = "SOUTH"
                }
            ){
                Text("SOUTH",
                    fontSize = 18.sp)
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GamePreview() {
    PirateGameTheme {
        PirateGame()
    }
}