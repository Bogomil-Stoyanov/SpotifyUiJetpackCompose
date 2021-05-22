package eu.bbsapps.spotifyuicompose.ui.screens.home.components

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import eu.bbsapps.spotifyuicompose.R


@Composable
fun SearchBox(
    modifier: Modifier = Modifier,
    onSearch: (String) -> Unit = {},
    @StringRes hintRes: Int,
    backgroundColor: Color,
    hintColor: Color,
    whiteTextColor: Boolean
) {
    val hint = stringResource(id = hintRes)
    var text by remember { mutableStateOf("") }
    var isHintDisplayed by remember { mutableStateOf(hint != "") }

    Box(modifier) {
        BasicTextField(
            value = text,
            onValueChange = {
                text = it
                onSearch(it)
            },
            maxLines = 1,
            singleLine = true,
            textStyle = when (whiteTextColor) {
                true -> MaterialTheme.typography.subtitle2
                else -> MaterialTheme.typography.subtitle1
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(backgroundColor, RoundedCornerShape(4.dp))
                .padding(horizontal = 20.dp, vertical = 12.dp)
                .onFocusChanged {
                    isHintDisplayed = it != FocusState.Active && text == ""
                }
        )

        if (isHintDisplayed) {
            Row() {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 12.dp),
                    tint = hintColor
                )
                Text(
                    text = hint,
                    color = hintColor,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 12.dp),
                    style = MaterialTheme.typography.subtitle1
                )
            }
        }
    }
}