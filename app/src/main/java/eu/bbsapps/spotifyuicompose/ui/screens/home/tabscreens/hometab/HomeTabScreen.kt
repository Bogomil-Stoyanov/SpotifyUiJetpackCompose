package eu.bbsapps.spotifyuicompose.ui.screens.home.tabscreens.hometab

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import eu.bbsapps.spotifyuicompose.data.HomeCategory
import eu.bbsapps.spotifyuicompose.data.HomeEntry
import eu.bbsapps.spotifyuicompose.data.homeCategoriesList

@Composable
fun HomeTabScreen() {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        item { Spacer(modifier = Modifier.height(32.dp)) }
        items(homeCategoriesList) {
            HomeCategory(homeCategory = it)
        }
        item { Spacer(modifier = Modifier.height(100.dp)) }
    }
}

@Composable
fun HomeCategory(homeCategory: HomeCategory) {
    Column {
        Box(modifier = Modifier.padding(horizontal = 16.dp)) {
            Text(
                text = stringResource(id = homeCategory.title),
                color = Color.White,
                style = MaterialTheme.typography.h5
            )
        }
        LazyRow() {
            items(homeCategory.entries) {
                HomeCategoryEntry(homeEntry = it)
            }
        }
    }
}

@Composable
fun HomeCategoryEntry(homeEntry: HomeEntry) {
    Box(Modifier.width(180.dp)) {
        Column(Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = homeEntry.image),
                contentDescription = null,
                modifier = Modifier.size(180.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = stringResource(id = homeEntry.title),
                color = Color.White,
                style = MaterialTheme.typography.subtitle1
            )
            Text(
                text = stringResource(id = homeEntry.subtitle),
                maxLines = 2,
                color = Color.White.copy(0.7f),
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}