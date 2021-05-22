package eu.bbsapps.spotifyuicompose.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import eu.bbsapps.spotifyuicompose.R

data class HomeCategory(
    @StringRes val title: Int,
    @StringRes val subtitle: Int = R.string.empty_subtitle,
    val entries: List<HomeEntry>
)

data class HomeEntry(
    @StringRes val title: Int,
    @StringRes val subtitle: Int= R.string.empty_subtitle,
    @DrawableRes val image: Int
)

val homeCategoriesList =
    listOf(
        HomeCategory(
            title = R.string.recently_played_title, entries = listOf(
                HomeEntry(R.string.daily_lift_title, R.string.daily_lift_subtitle, R.drawable.im1),
                HomeEntry(R.string.happy_pop_title, R.string.happy_pop_subtitle, R.drawable.im2),
                HomeEntry(R.string.young_wild_title, R.string.young_wild_subtitle, R.drawable.im3),
                HomeEntry(R.string.mood_booster_title, R.string.mood_booster_subtitle, R.drawable.im4)
            )
        ),
        HomeCategory(
            title = R.string.uniquely_yours_title, entries = listOf(
                HomeEntry(R.string.time_capsule_title, R.string.time_capsule_subtitle, R.drawable.im5),
                HomeEntry(R.string.repeat_title, R.string.repeat_subtitle, R.drawable.im6),
                HomeEntry(R.string.repeat_rewind_title, R.string.repeat_rewind_subtitle, R.drawable.im7),
                HomeEntry(R.string.liked_songs_title, R.string.empty_subtitle, R.drawable.im8)
            )
        ),
        HomeCategory(
            title = R.string.made_for_you_title, entries = listOf(
                HomeEntry(R.string.release_radar_title, R.string.repeat_subtitle, R.drawable.im9),
                HomeEntry(R.string.daily_mix_1_title, R.string.daily_mix_1_subtitle, R.drawable.im10),
                HomeEntry(R.string.daily_mix_2_title, R.string.daily_mix_2_subtitle, R.drawable.im11),
                HomeEntry(R.string.daily_mix_3_title, R.string.daily_mix_3_subtitle, R.drawable.im12),
            )
        )
    )



