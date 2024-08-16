package com.example.myrecipeapp

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import androidx.compose.ui.platform.LocalContext


@Composable
fun CategoryDetailScreen(category: Category){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text=category.strCategory, textAlign = TextAlign.Center)
        Image(
            painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription = "${category.strCategory} Thumbnail",
            modifier = Modifier
                .wrapContentSize()
                .aspectRatio(1f)
        )
        SearchButton(category = category)
        Text(text = category.strCategoryDescription,
            textAlign = TextAlign.Justify,
            modifier = Modifier.verticalScroll(rememberScrollState())
            )
    }
}

@Composable
fun SearchButton(category: Category) {
    val context = LocalContext.current
    Button(
        onClick = {
            val query = "${category.strCategory.toString()}+dish+recipe"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=${query}"))
            context.startActivity(intent)
        },
        modifier = Modifier.fillMaxWidth().padding(bottom = 4.dp)
    ) {
        Text("Find ${category.strCategory.lowercase()} dish recipes in Google")
    }
}