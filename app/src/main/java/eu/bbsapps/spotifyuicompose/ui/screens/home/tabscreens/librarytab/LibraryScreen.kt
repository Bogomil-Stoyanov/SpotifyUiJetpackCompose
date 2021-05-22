package eu.bbsapps.spotifyuicompose.ui.screens.home.tabscreens.librarytab

import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import eu.bbsapps.spotifyuicompose.R
import eu.bbsapps.spotifyuicompose.data.LibraryCategory
import eu.bbsapps.spotifyuicompose.data.libraryCategoryList
import eu.bbsapps.spotifyuicompose.toDp
import eu.bbsapps.spotifyuicompose.ui.screens.home.components.SearchBox

private enum class LibraryTabs(
    @StringRes val titleRes: Int,
) {
    Music(R.string.music),
    Podcast(R.string.podcast),
}

private enum class CategoryTabs(
    @StringRes val titleRes: Int,
) {
    Playlists(R.string.playlists),
    Artists(R.string.artists),
    Albums(R.string.albums)
}

@ExperimentalFoundationApi
@Composable
fun LibraryScreen(screenWidth: Int) {
    val (selectedTab, setSelectedTab) = remember { mutableStateOf(LibraryTabs.Music) }
    val tabs = LibraryTabs.values()
    LazyColumn() {

        item {
            TabRow(
                selectedTabIndex = selectedTab.ordinal,
                Modifier.padding(horizontal = 16.dp),
                backgroundColor = Color.Transparent,
                indicator = {},
                divider = {}
            ) {
                tabs.forEachIndexed { index, tab ->
                    val isSelected = index == selectedTab.ordinal
                    Tab(
                        selected = isSelected,
                        selectedContentColor = Color.White,
                        unselectedContentColor = Color.White.copy(
                            alpha = ContentAlpha.disabled
                        ),
                        onClick = { setSelectedTab(LibraryTabs.values()[index]) }
                    ) {
                        val tabName = stringResource(tab.titleRes)
                        Text(
                            tabName,
                            Modifier.paddingFromBaseline(top = 64.dp, bottom = 8.dp),
                            style = MaterialTheme.typography.h5
                        )
                    }
                }
            }
        }


        stickyHeader {
            val (selectedTabCategory, setSelectedTabCategory) = remember {
                mutableStateOf(
                    CategoryTabs.Playlists
                )
            }
            val tabsCategory = CategoryTabs.values()

            TabRow(
                selectedTabIndex = selectedTabCategory.ordinal,
                Modifier
                    .padding(horizontal = 16.dp)
                    .background(eu.bbsapps.spotifyuicompose.ui.theme.Black),
                backgroundColor = Color.Transparent,
                indicator = {},
                divider = {}
            ) {
                tabsCategory.forEachIndexed { index, tab ->
                    val isSelected = index == selectedTabCategory.ordinal
                    Tab(
                        selected = isSelected,
                        selectedContentColor = Color.White,
                        unselectedContentColor = Color.White.copy(
                            alpha = ContentAlpha.disabled
                        ),
                        onClick = { setSelectedTabCategory(CategoryTabs.values()[index]) }
                    ) {
                        val tabName = stringResource(tab.titleRes)
                        Column(horizontalAlignment = CenterHorizontally) {
                            Text(
                                tabName,
                                Modifier.paddingFromBaseline(top = 48.dp, bottom = 8.dp),
                                style = MaterialTheme.typography.subtitle1
                            )
                            val width = ((screenWidth / 3) / tabName.length * 24).toDp
                            println("DP IS $width")
                            if (isSelected) Divider(
                                color = MaterialTheme.colors.secondary,
                                thickness = 2.dp,
                                modifier = Modifier.size(width = width.dp, height = 2.dp)
                            )
                        }
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
            Row(Modifier.padding(horizontal = 16.dp)) {
                SearchBox(
                    hintRes = R.string.library_hint,
                    backgroundColor = eu.bbsapps.spotifyuicompose.ui.theme.Gray,
                    hintColor = Color.White.copy(0.7f),
                    modifier = Modifier
                        .weight(4f)
                        .height(48.dp),
                    whiteTextColor = true
                )
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = {}, modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .fillMaxWidth()
                        .weight(1.5f)
                        .height(48.dp), colors = ButtonDefaults.buttonColors(
                        backgroundColor = eu.bbsapps.spotifyuicompose.ui.theme.Gray,
                    )
                ) {
                    Text(
                        text = stringResource(id = R.string.filters),
                        color = Color.White.copy(0.7f),
                        style = MaterialTheme.typography.subtitle1
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }

        items(libraryCategoryList) {
            Spacer(modifier = Modifier.height(4.dp))
            LibraryEntry(libraryEntry = it)
            Spacer(modifier = Modifier.height(4.dp))
        }

        item {
            Spacer(modifier = Modifier.height(100.dp))
        }


    }
}

@Composable
fun LibraryEntry(libraryEntry: LibraryCategory) {
    Row {
        Spacer(modifier = Modifier.width(16.dp))
        Image(
            painter = painterResource(id = libraryEntry.image),
            contentDescription = null,
            modifier = Modifier.size(75.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Spacer(modifier = Modifier.width(14.dp))
            Text(
                text = stringResource(id = libraryEntry.title),
                color = Color.White,
                style = MaterialTheme.typography.subtitle1
            )
            Text(
                text = stringResource(id = libraryEntry.subtitle),
                maxLines = 2,
                color = Color.White.copy(0.7f),
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}


