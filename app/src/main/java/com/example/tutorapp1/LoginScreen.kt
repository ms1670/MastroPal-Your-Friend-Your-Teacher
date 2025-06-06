package com.example.tutorapp1

import android.text.style.UnderlineSpan
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextButton

import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration

@Preview
@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent), // Background of the screen
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .padding(24.dp)
               // .border(2.dp, Color.Black, RoundedCornerShape(0.dp))
                .shadow(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(8.dp),
                    ambientColor = Color.Red, // Custom shadow color
                    spotColor = Color.Red
                )
                .background(
                    color = Color(0xFFBFFFA6),
                    shape = RoundedCornerShape(16.dp)
                )
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    //.clip(RoundedCornerShape(0.dp))
                    .padding(16.dp),
                   // .border(2.dp, Color.Red, RoundedCornerShape(0.dp)),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFBFFFA6)),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 12.dp,
                hoveredElevation = 12.dp,
            )
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        // .background(Color(0xFFFFA6DB)) // Your desired color here
                        .padding(12.dp)
                       // .border(2.dp, Color.Cyan, RoundedCornerShape(12.dp)),
                        .clip(RoundedCornerShape(32.dp))
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.tutor_app_logo_demo),
                            contentDescription = "",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(120.dp)
//                                .background(Color(0xFFEBEBEC))
//                                .padding(16.dp)
                        )
                        Text(
                            text = "Login".uppercase(),
                            fontSize = 24.sp,
                            modifier = Modifier.padding(12.dp)
                        )

                        val username = remember { mutableStateOf("") }
                        val password = remember { mutableStateOf("") }

                        OutlinedTextField(
                            value = username.value,
                            onValueChange = { username.value = it },
                            label = { Text("User Name") },
                            placeholder = { Text("Enter User Name") },
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = AppColors.TextFieldFocusedBorder,
//                            unfocusedBorderColor = AppColors.TextFieldColorsBorder,
                                cursorColor = AppColors.TextFieldCursor,
                                focusedLabelColor = AppColors.TextFieldFocusedBorder,
                                unfocusedLabelColor = Color.Gray,
                                focusedPlaceholderColor = AppColors.Placeholder,
                                unfocusedPlaceholderColor = Color.LightGray
                            ),

                            modifier = Modifier
                                .padding(top = 8.dp, bottom = 4.dp, start = 8.dp, end = 8.dp)
                                .clip(RoundedCornerShape(4.dp))
                        )

                        OutlinedTextField(
                            value = password.value, // Access the value of the state
                            onValueChange = { password.value = it }, // Update the state correctly
                            label = { Text(text = "Password") },
                            visualTransformation = PasswordVisualTransformation(),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            // placeholder = {Text(text = "Password")},
                            modifier = Modifier
                                .padding(top = 8.dp, bottom = 4.dp, start = 8.dp, end = 8.dp)
                            //.clip(RoundedCornerShape(4.dp))
                        )

                        Row(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(horizontal = 16.dp),
//                        horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Button(
                                onClick = { /* Login action */ },
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(8.dp),
                                shape = RoundedCornerShape(8.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = AppColors.Primary, // Gray background
                                    contentColor = AppColors.Background // Text color
                                )
                            ) {
                                Text(
                                    text = "Login".uppercase(),
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.fillMaxWidth()
                                )
                            }

                            Button(
                                onClick = { /* Cancel action */ },
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(8.dp),
                                shape = RoundedCornerShape(8.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent, // Gray background
                                    contentColor = AppColors.Background // Text color
                                )
                            ) {
                                Text(
                                    text = "Cancel".uppercase(),
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.fillMaxWidth()
                                )
                            }
                        } // Button row ended

                        Row (
                            modifier = Modifier
                                .padding(top = 12.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            IconButton(
                                onClick = {""},
                                modifier = Modifier.border(1.dp, AppColors.TextFieldFocusedBorder, RoundedCornerShape(12.dp))
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.google_favicon_logo),
                                    contentDescription = ""
                                )
                            }

                            IconButton(
                                onClick = {""},
                                modifier = Modifier.border(1.dp, AppColors.TextFieldFocusedBorder, RoundedCornerShape(12.dp))
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.linkedin_logo),
                                    contentDescription = ""
                                )
                            }

                            IconButton(
                                onClick = {""},
                                 modifier = Modifier.border(1.dp, AppColors.TextFieldFocusedBorder, RoundedCornerShape(12.dp))
                            ) {
                                Icon(Icons.Filled.Email, contentDescription="")
                            }
                        }

                        Text(
                            text = "No Account?",
                            textAlign = TextAlign.Center,
                            color = AppColors.Error,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp, bottom = 0.dp, start = 8.dp, end = 8.dp),
                        )

                        TextButton(
                            onClick = {/*Sign Up Page Nav*/},
                            modifier = Modifier
                                .padding(top = 0.dp, bottom = 8.dp, start = 8.dp, end = 8.dp),
                            ) {
                            Text(
                                text = "Learn New Things with, SIGN UP!",
                                textDecoration = TextDecoration.Underline,
                            )
                        }
                    }
                }
            }
        }
    }
}



