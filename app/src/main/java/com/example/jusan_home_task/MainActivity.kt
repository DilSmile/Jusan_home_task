package com.example.jusan_home_task

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jusan_home_task.data.Post

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // Call your PostsPage here
                PostsPage(posts = samplePosts)
            }
        }
    }
}

val samplePosts = listOf(
    Post("Post Title 1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit."),
    Post("Post Title 2", "Aliquam molestie nisi ac faucibus blandit."),
    Post("Post Title 3", "Donec quis nulla quis quam vestibulum egestas at eget velit."),
    Post("Post Title 4", "Praesent nec ex quis nisl ullamcorper euismod."),
    Post("Post Title 5", "Vestibulum accumsan arcu vel vehicula scelerisque.")
)

@Composable
fun PostsPage(posts: List<Post>) {
    LazyColumn(
        modifier = Modifier.padding(16.dp)
    ) {
        items(posts) { post ->
            PostCard(post)
        }
    }
}

@Composable
fun PostCard(post: Post) {
    Card(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = post.title, style = MaterialTheme.typography.titleMedium)
            Text(text = post.content, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MaterialTheme {
        PostsPage(posts = samplePosts)
    }
}
