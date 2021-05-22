package eu.bbsapps.spotifyuicompose.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import eu.bbsapps.spotifyuicompose.R
import eu.bbsapps.spotifyuicompose.ui.theme.*

data class SearchCategory(@StringRes val title:Int, @DrawableRes val image:Int, val color:Color)

val topGenresList = listOf(
    SearchCategory(R.string.pop, R.drawable.im2, color1),
    SearchCategory(R.string.kpop, R.drawable.im5, color6),
    SearchCategory(R.string.hip_hop, R.drawable.im7, color4),
    SearchCategory(R.string.rnb, R.drawable.im6, color3)
)

val allGenresList = listOf(
    SearchCategory(R.string.genre_1, R.drawable.im12, color2),
    SearchCategory(R.string.genre_2, R.drawable.im6, color5),
    SearchCategory(R.string.genre_3, R.drawable.im4, color4),
    SearchCategory(R.string.genre_4, R.drawable.im10, color3),
    SearchCategory(R.string.genre_5, R.drawable.im5, color2),
    SearchCategory(R.string.genre_6, R.drawable.im3, color1),
    SearchCategory(R.string.genre_7, R.drawable.im7, color6),
    SearchCategory(R.string.genre_8, R.drawable.im2, color4)
)