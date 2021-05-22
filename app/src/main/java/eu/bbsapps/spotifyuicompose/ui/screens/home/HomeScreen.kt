package eu.bbsapps.spotifyuicompose.ui.screens.home

import android.graphics.drawable.Icon
import android.media.Image
import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.chrisbanes.accompanist.insets.navigationBarsHeight
import dev.chrisbanes.accompanist.insets.navigationBarsPadding
import eu.bbsapps.spotifyuicompose.R
import eu.bbsapps.spotifyuicompose.ui.screens.home.tabscreens.hometab.HomeTabScreen
import eu.bbsapps.spotifyuicompose.ui.screens.home.tabscreens.librarytab.LibraryScreen
import eu.bbsapps.spotifyuicompose.ui.screens.home.tabscreens.searchtab.SearchTab
import java.util.*

private enum class HomeTabs(@StringRes val titleRes: Int, val icon: ImageVector) {
    Home(R.string.home_home, Icons.Default.Home),
    Search(R.string.home_search, Icons.Default.Search),
    Library(R.string.home_library, Icons.Default.LibraryMusic),
}


@ExperimentalFoundationApi
@Composable
fun HomeScreen(screenWidth:Int) {
    val (selectedTab, setSelectedTab) = remember { mutableStateOf(HomeTabs.Home) }
    val tabs = HomeTabs.values()

    Scaffold(backgroundColor = MaterialTheme.colors.background,
        bottomBar = {
            BottomNavigation(
                Modifier.navigationBarsHeight(additional = 56.dp),
                backgroundColor = MaterialTheme.colors.onBackground,
                elevation = 8.dp
            ) {
                tabs.forEach { navItem ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                navItem.icon,
                                null,
                                Modifier.size(24.dp)
                            )
                        },
                        label = { Text(stringResource(navItem.titleRes).toUpperCase(Locale.ROOT)) },
                        selected = selectedTab == navItem,
                        selectedContentColor = Color.White,
                        unselectedContentColor = Color.White.copy(alpha = 0.4f),
                        modifier = Modifier.navigationBarsPadding(),
                        onClick = {
                            when (navItem) {
                                HomeTabs.Home -> {
                                    setSelectedTab(HomeTabs.Home)
                                }
                                HomeTabs.Search -> {
                                    setSelectedTab(HomeTabs.Search)
                                }
                                HomeTabs.Library -> {
                                    setSelectedTab(HomeTabs.Library)
                                }
                            }
                        }
                    )
                }
            }
        }
    ) {
        when (selectedTab) {
            HomeTabs.Home -> {
                HomeTabScreen()
            }
            HomeTabs.Search -> {
                SearchTab(screenWidth)
            }
            HomeTabs.Library -> {
                LibraryScreen(screenWidth)
            }
        }
    }
}