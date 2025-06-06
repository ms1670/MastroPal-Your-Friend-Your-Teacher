package com.example.tutorapp1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.tutorapp1.ui.theme.TutorApp1Theme
import com.google.firebase.FirebaseApp
import com.google.firebase.database.FirebaseDatabase

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FirebaseApp.initializeApp(this)

        //  TEST DB WRITE
        FirebaseDatabase.getInstance().reference
            .child("connection_test")
            .setValue("Connected! + 9")
            .addOnSuccessListener {
                Log.d("FirebaseCheck", "✅ Firebase connected and write successful")
            }
            .addOnFailureListener {
                Log.e("FirebaseCheck", "❌ Firebase write failed: ${it.message}")
            }

        enableEdgeToEdge()
        setContent {
            TutorApp1Theme {
                HomeScreen()

//                Scaffold(
//                    topBar = {
//                        TopAppBar(
//                            title = { Text("Tutor App") },
//                            colors = TopAppBarDefaults.topAppBarColors(
//                                containerColor = AppColors.Surface
//                            )
//                        )
//                    }
//                ) { innerPadding ->
//                    Box(modifier = Modifier.padding(innerPadding)) {
//
//                    }
//                }
            }
        }

    }
}
