package eu.bbsapps.spotifyuicompose.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import eu.bbsapps.spotifyuicompose.R

data class LibraryCategory(
    @StringRes val title: Int,
    @StringRes val subtitle: Int = R.string.empty_subtitle,
    @DrawableRes val image: Int
)

val libraryCategoryList = listOf(
    LibraryCategory(R.string.create_playlist,image = R.drawable.im13),
    LibraryCategory(R.string.liked_songs_title,R.string.favourite_songs_count, R.drawable.im8),
    LibraryCategory(R.string.daily_lift_title,R.string.daily_lift_subtitle, R.drawable.im1),
    LibraryCategory(R.string.release_radar_title,R.string.release_radar_subtitle,R.drawable.im9),
    LibraryCategory(R.string.happy_pop_title, R.string.happy_pop_subtitle,R.drawable.im2),
    LibraryCategory(R.string.young_wild_title, R.string.young_wild_subtitle,R.drawable.im3),
    LibraryCategory(R.string.daily_mix_1_title, R.string.daily_mix_1_subtitle,R.drawable.im10),
    LibraryCategory(R.string.mood_booster_title, R.string.mood_booster_subtitle,R.drawable.im4),

)

