package com.gkreduction.movieapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.gkreduction.movieapp.utils.items
import com.gkreduction.domain.entity.Movie

@Composable
fun MoviesScreen(state: LiveData<MainScreenViewState>) {
    val moviesState = state.observeAsState().value
    moviesState?.let {
        with(it) {
            if (!items.isNullOrEmpty()) MoviesListScreen(movies = items)
        }
    }
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




