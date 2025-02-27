package com.periya.composearc

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun WelcomeUser(uiModel: MainUIModel, onUserClick : (String) -> Unit){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Cyan),
        contentAlignment = Alignment.Center
        ){

        Column {

            LazyColumn(modifier = Modifier.weight(1F)) {
                items(uiModel.userList){
                    Text(text = it, Modifier.padding(10.dp).clickable {
                        //To pass result back to UI prefer lambda callback approach
                        onUserClick.invoke(it)
                    })
                }
            }

            Button(onClick = {
                uiModel.onLoadClick?.invoke()
            }) {
                Text(text = "Load Users")
            }

        }
    }
}