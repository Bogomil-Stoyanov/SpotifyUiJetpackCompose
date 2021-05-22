package eu.bbsapps.spotifyuicompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.core.view.WindowCompat
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets
import eu.bbsapps.spotifyuicompose.ui.screens.home.HomeScreen
import eu.bbsapps.spotifyuicompose.ui.screens.splash.SplashScreen
import eu.bbsapps.spotifyuicompose.ui.theme.SpotifyUiTheme
import android.util.DisplayMetrics




class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window,false)

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val width = displayMetrics.widthPixels

        setContent {
            SpotifyUI(width)
        }
    }
}

enum class AppState {
    Splash,
    Home
}

@ExperimentalFoundationApi
@Composable
fun SpotifyUI(screenWidth:Int) {

    ProvideWindowInsets {
        SpotifyUiTheme {
            val (appState, setAppState) = remember { mutableStateOf(AppState.Splash) }

            when (appState) {
                AppState.Splash -> {
                    SplashScreen { setAppState(AppState.Home) }
                }
                AppState.Home -> {
                    HomeScreen(screenWidth)
                }

            }

        }
    }
}
