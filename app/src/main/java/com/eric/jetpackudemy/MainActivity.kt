@file:OptIn(ExperimentalMaterial3Api::class)

package com.eric.jetpackudemy

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eric.jetpackudemy.ui.theme.JetpackUdemyTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.compose.AsyncImage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackUdemyTheme {
                UsersApplication()
            }
        }
    }
}

@Composable
fun UsersApplication(userProfiles: List<UserProfile> = userProfileList) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "users_list") {
        composable("users_list") {
            UserListScreen(userProfiles, navController)
        }
        composable(route = "user_detail/{userId}", arguments = listOf(navArgument("userId") {
            type = NavType.IntType
        })) { navBackStackEntry ->
            UserProfileDetailScreen(navBackStackEntry.arguments!!.getInt("userId"), navController )
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UserListScreen(
    userProfiles: List<UserProfile> = userProfileList,
    navController: NavHostController?
) {
    Scaffold(topBar = { AppBar("Users List", Icons.Filled.Person) {} }) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            color = Color.LightGray
        ) {
            LazyColumn {
                items(userProfiles) { userProfile ->
                    ProfileCard(userProfile = userProfile) {
                        navController?.navigate("user_detail/${userProfile.id}")
                    }
                }
            }
        }
    }
}

@Composable
fun AppBar(title: String, icon: ImageVector, clickAction: () -> Unit) {
    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            IconButton(onClick = { clickAction.invoke() }) {
                Icon(imageVector = icon, contentDescription = "BACK")
            }
        }
    )
}

@Composable
fun ProfileCard(userProfile: UserProfile, clickAction: () -> Unit) {
    Card(
        shape = CutCornerShape(topEnd = 20.dp),
        modifier = Modifier
            .padding(top = 8.dp, bottom = 4.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top)
            .clickable(onClick = { clickAction.invoke() }),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            ProfilePicture(userProfile.pictureUrl, userProfile.status, 72.dp)
            ProfileContent(userProfile.name, userProfile.status, Alignment.Start)
        }
    }
}

@Composable
fun ProfilePicture(pictureUrl: String, status: Boolean, imageSize: Dp) {
    Card(
        shape = CircleShape,
        border = BorderStroke(width = 2.dp, color = if (status) Color.Green else Color.Red),
        modifier = Modifier
            .padding(16.dp)
            .size(imageSize),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        AsyncImage(
            model = pictureUrl,
            contentDescription = "profile_pic",
            modifier = Modifier.size(imageSize),
            contentScale = ContentScale.Crop
        )
    }

}

@Composable
fun ProfileContent(name: String, status: Boolean, alignment: Alignment.Horizontal) {
    Column(
        modifier = Modifier
            .padding(8.dp),
        horizontalAlignment = alignment
    ) {
        Text(text = name, style = MaterialTheme.typography.headlineMedium)
        CompositionLocalProvider(LocalContentColor provides MaterialTheme.colorScheme.onSurfaceVariant) {
            Text(
                text = if (status) "Active now" else "Offline",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UserProfileDetailScreen(userId: Int, navController: NavHostController) {
    val userProfile = userProfileList.first { userProfile -> userId == userProfile.id }
    Scaffold(topBar = {
        AppBar(userProfile.name, Icons.Filled.ArrowBack) {
            navController.navigateUp()
        }
    }) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            color = Color.LightGray
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
            ) {
                ProfilePicture(
                    pictureUrl = userProfile.pictureUrl,
                    status = userProfile.status,
                    248.dp
                )
                ProfileContent(
                    name = userProfile.name,
                    status = userProfile.status,
                    Alignment.CenterHorizontally
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserListPreview() {
    JetpackUdemyTheme() {
        UserListScreen(userProfiles = userProfileList, null)
    }
}