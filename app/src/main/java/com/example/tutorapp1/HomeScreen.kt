package com.example.tutorapp1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import android.R.attr.contentDescription
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun HomeScreen(){

    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text("Tutor App") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = AppColors.Surface
                )
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
            ) {

                NavigationBarItem(
                    selected = true,
                    onClick = { /* Navigate to Home */ },
                    icon = {
                        Icon(Icons.Filled.Home, contentDescription = "Home")
                    }
                )

                NavigationBarItem(
                    selected = true,
                    onClick = { /* do something */ },
                    icon = {
                        Icon(Icons.Filled.Create, contentDescription = "Menu")
                    }
                )

                NavigationBarItem(
                    selected = true,
                    onClick = { /* Navigate to Home */ },
                    icon = {
                        Icon(Icons.Filled.Menu, contentDescription = "Home")
                    }
                )

                NavigationBarItem(
                    selected = true,
                    onClick = { /* Navigate to Home */ },
                    icon = {
                        Icon(Icons.Filled.Person, contentDescription = "Home")
                    }
                )

            }
        },
    ) {innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            NotesList()

        }

    }
}