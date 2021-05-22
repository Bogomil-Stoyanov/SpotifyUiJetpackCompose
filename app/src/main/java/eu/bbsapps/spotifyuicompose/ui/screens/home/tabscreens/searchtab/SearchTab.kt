package eu.bbsapps.spotifyuicompose.ui.screens.home.tabscreens.searchtab

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import eu.bbsapps.spotifyuicompose.R
import eu.bbsapps.spotifyuicompose.data.SearchCategory
import eu.bbsapps.spotifyuicompose.data.topGenresList
import eu.bbsapps.spotifyuicompose.data.allGenresList
import eu.bbsapps.spotifyuicompose.toDp
import eu.bbsapps.spotifyuicompose.ui.screens.home.components.SearchBox


@ExperimentalFoundationApi
@Composable
fun SearchTab(screenWidth: Int) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        item { Spacer(modifier = Modifier.height(32.dp)) }
        item {
            Text(
                text = stringResource(id = R.string.search),
                color = Color.White,
                style = MaterialTheme.typography.h5
            )
        }

        item {
            SearchBox(
                hintRes = R.string.search_hint,
                backgroundColor = Color.White,
                hintColor = eu.bbsapps.spotifyuicompose.ui.theme.Gray,
                whiteTextColor = false
            )
        }

        item {
            Text(
                text = stringResource(id = R.string.top_genres),
                color = Color.White,
                style = MaterialTheme.typography.subtitle1
            )
            Spacer(Modifier.height(8.dp))
        }

        items(topGenresList.chunked(2)) { row ->
            val first = row.first()
            val second = row.last()
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Row() {
                    SearchItem(searchCategory = first, (screenWidth / 2.3).toInt())
                    Spacer(Modifier.width(8.dp))
                    SearchItem(searchCategory = second, (screenWidth / 2.3).toInt())
                }
            }
        }

        item {
            Text(
                text = stringResource(id = R.string.browse_all),
                color = Color.White,
                style = MaterialTheme.typography.subtitle1
            )
            Spacer(Modifier.height(8.dp))
        }

        items(allGenresList.chunked(2)) { row ->
            val first = row.first()
            val second = row.last()
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Row() {
                    SearchItem(searchCategory = first, (screenWidth / 2.3).toInt())
                    Spacer(Modifier.width(8.dp))
                    SearchItem(searchCategory = second, (screenWidth / 2.3).toInt())
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(100.dp))
        }

    }
}


@Composable
fun SearchItem(searchCategory: SearchCategory, width: Int) {

    Box(
        Modifier
            .size(width = width.toDp.dp, height = 100.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(searchCategory.color)

    ) {
        Column() {
            Text(
                text = stringResource(id = searchCategory.title),
                color = Color.White,
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(8.dp)
            )

            Box(contentAlignment = Alignment.BottomEnd) {
                Row() {
                    Spacer(modifier = Modifier.width(100.dp))
                    Image(
                        painter = painterResource(id = searchCategory.image),
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp)
                            .rotate(30f)
                    )
                }

            }
        }
    }
}