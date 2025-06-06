package com.example.tutorapp1

import android.widget.GridLayout
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database

@Preview()
@Composable
fun NotesList() {
    Surface(
        modifier = Modifier
            .background(AppColors.Background)
            .padding(8.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        // Write a message to the database
        val database = Firebase.database
        //val myRef = database.getReference("message")
        //   myRef.setValue("Hello, World!")

        val context = LocalContext.current
        var expanded by remember { mutableStateOf(false) }
        val NotesEntered = remember { mutableStateOf("") }
        val notesRef = database.getReference("Notes List")

        val notesList = remember { mutableStateListOf<String>() }

        // Listen to Firebase data changes
        LaunchedEffect(Unit) {
            notesRef.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    notesList.clear()
                    snapshot.children.forEach { child ->
                        val note = child.getValue(String::class.java)
                        note?.let { notesList.add(it) }
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(context, "Error loading notes", Toast.LENGTH_SHORT).show()
                }
            })
        }

        Box(
            modifier = Modifier
                //.background(AppColors.Primary)
                .padding(8.dp)
        ) {
            Column {
                Card(
                    modifier = Modifier
                        .background(AppColors.Surface)
                        .padding(8.dp)
                        // .clip(RoundedCornerShape(0.dp))
                        .fillMaxWidth()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(
                            text = "Card",
                            modifier = Modifier
                                //   .background(AppColors.Primary)
                                .padding(8.dp)
                                // .clip(RoundedCornerShape(8.dp))
                                .weight(1f)
                        )

                        Box {
                            IconButton(
                                onClick = { expanded = true }
                            ) {
                                Icon(Icons.Filled.MoreVert, contentDescription = "More")
                            }
                            DropdownMenu(
                                expanded = expanded,
                                onDismissRequest = { expanded = false },
                                modifier = Modifier
                                    .align(Alignment.TopEnd)
                            ) {
                                DropdownMenuItem(
                                    text = { Text("Edit") },
                                    onClick = {
                                        Toast.makeText(context, "Load", Toast.LENGTH_SHORT).show()
                                    }
                                )
                                DropdownMenuItem(
                                    text = { Text("Delete") },
                                    onClick = {
                                        Toast.makeText(context, "Save", Toast.LENGTH_SHORT).show()
                                    }
                                )
                            }
                        }
                    }

                    OutlinedTextField(
                        value = NotesEntered.value,
                        onValueChange = { NewNotesEntered -> NotesEntered.value = NewNotesEntered },
                        label = { Text(text = "Enter your notes") },
                        modifier = Modifier
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                            .fillMaxWidth()
                            .heightIn(min = 56.dp), // Ensures at least 2 lines visible
                        minLines = 2,
                        maxLines = Int.MAX_VALUE // Expands as content grows
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 8.dp, start = 8.dp, end = 8.dp)
                            .fillMaxWidth()
                    )
                    {
                        Button(
                            onClick = {
                                //   val notesRef = database.reference.child("Notes List")
                                //val notes = notesRef.child(NotesEntered)
//                                notesRef.setValue(NotesEntered.value)
                                notesRef.push().setValue(NotesEntered.value)

                                NotesEntered.value = ""
                                Toast.makeText(context, "Notes Saved", Toast.LENGTH_LONG).show()
                            }
                        ) {
                            Text(
                                text = "Submit",
                            )
                        }
                    }
                }

                // UI
                    notesList.forEach { note ->
                        Box (
                            modifier = Modifier
                                .padding(8.dp)
                                .background(Color(0xFFE8E8E8))
                        ){
                            Column {
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 8.dp, bottom = 0.dp, start = 8.dp, end = 8.dp)
                                        .clip(RoundedCornerShape(4.dp)),
                                       // .background(AppColors.Surface)
                                            colors = CardDefaults.cardColors(
                                                //containerColor = AppColors.Surface
                                                containerColor = (Color(0xFFF8F8F8))
                                            ) // Override default
                                ) {
                                    Text(
                                        text = note,
                                        modifier = Modifier
                                            .padding(16.dp)
                                          //  .background(AppColors.Surface)
                                    )
                                }

                                Row (
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Absolute.SpaceBetween,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 0.dp, bottom = 8.dp, start = 8.dp, end = 8.dp)
                                ) {
                                    Text(
                                        text = "note id",
                                        modifier = Modifier
                                            //.fillMaxWidth()
                                            .padding(vertical = 8.dp, horizontal = 8.dp)
                                    )

                                    IconButton(
                                        onClick = { }
                                    ) {
                                        Icon(Icons.Filled.Create, contentDescription = "More")
                                    }
                                }
                            }
                        }
                    }
            }
        }
    }
}


