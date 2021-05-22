package eu.bbsapps.spotifyuicompose.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import eu.bbsapps.spotifyuicompose.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onSplashCompleted: () -> Unit) {
    Surface(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .padding(16.dp)
        ) {

            LaunchedEffect(Unit){
                delay(1000)
                onSplashCompleted()
            }
            Image(
                painter = painterResource(id = R.drawable.ic_spotify_logo),
                contentDescription = "Logo"
            )
        }
    }
}