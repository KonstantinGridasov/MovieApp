package com.gkreduction.cinemaapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.gkreduction.cinemaapp.R
import com.gkreduction.cinemaapp.theme.CinemaAppTheme
import com.gkreduction.domain.entity.Movie

@Composable
@Preview
fun mainScreen() {
    CinemaAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.lockscreen),
                    contentDescription = "App",
                    modifier = Modifier
                        .size(400.dp)
                        .clip(CircleShape)
                )
                Text(text = "Hello Android!")
                Button(
                    onClick = { },
                    content = {

                    })
            }
        }
    }

}

@Composable
fun MoviesScreen(state: LiveData<MainScreenViewState>) {
    val moviesState = state.observeAsState().value
    moviesState?.let {
        with(it) {
            if (!items.isNullOrEmpty()) MoviesListScreen(movies = items)
        }
    }
}

inline fun <T> LazyListScope.items(
    items: List<T>,
    noinline key: ((item: T) -> Any)? = null,
    crossinline itemContent: @Composable LazyItemScope.(item: T) -> Unit
) = items(items.size, if (key != null) { index: Int -> key(items[index]) } else null) {
    itemContent(items[it])
}


@Composable
fun MoviesListScreen(movies: List<Movie>) {
    val rowSize = 2
    LazyColumn {
        items(items = movies.chunked(rowSize)) { row ->
            Row(
                Modifier
                    .fillParentMaxWidth()
                    .fillParentMaxHeight(.5f),
            ) {
                for ((index, item) in row.withIndex()) {
                    Box(
                        Modifier
                            .fillMaxWidth(1f / (rowSize - index))
                            .padding(1.dp)
                    ) {
                        MovieItem(item)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MovieItem(cinema: Movie) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 7.dp,
        modifier = Modifier
            .shadow(2.dp)

    ) {
        GlideImage(
            model = cinema.imageUrl,
            contentScale = ContentScale.FillBounds,
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
}




