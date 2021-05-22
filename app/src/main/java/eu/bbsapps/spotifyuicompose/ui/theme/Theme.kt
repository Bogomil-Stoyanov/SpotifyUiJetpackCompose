package eu.bbsapps.spotifyuicompose.ui.theme

import android.annotation.SuppressLint
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable

@SuppressLint("ConflictingOnColor")
private val ColorPalette = darkColors(
    primary = Black,
    primaryVariant = Gray,
    secondary = Green,
    background = Black,
    surface = Gray,
    onPrimary = Gray,
    onSecondary = Gray,
    onBackground = Gray,
    onSurface = Black,
)

@Composable
fun SpotifyUiTheme(
    content: @Composable() () -> Unit
) {
    val colors = ColorPalette
    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}