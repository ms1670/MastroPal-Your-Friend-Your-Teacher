package com.example.tutorapp1

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Colors
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notes
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.google.firebase.Firebase
import com.google.firebase.database.database


@Composable
fun UserID(userEmail: String) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column {
            Text(
                text = "Profile Section",
                style = MaterialTheme.typography.subtitle1
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "User ID: $userEmail",
                style = MaterialTheme.typography.body1,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun UserProfile(
    userEmail: String, userPhone: String
){
    val verticalScrollState = rememberScrollState()
    val horizontalScrollState = rememberScrollState()

    val database = Firebase.database
    val notesList = remember { mutableStateListOf<String>() }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.Surface)
            .verticalScroll(verticalScrollState)
        //   .horizontalScroll(horizontalScrollState)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(AppColors.Background)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(R.drawable.user_png),
                            contentDescription = "",
                            modifier = Modifier
                                .width(120.dp)
                                .border(width = 0.5.dp,
                                    color = AppColors.Placeholder, // or AppColors.BorderColor
                                    shape = RoundedCornerShape(16.dp)
                                )
                        )

                       Column(
                           modifier = Modifier.padding(start = 8.dp)
                       ) {
                           Text(
                               text = "Ajay",
                               fontWeight = FontWeight.SemiBold,
                               fontSize = 18.sp,
                               modifier = Modifier
                                   .padding(8.dp)
                                   .fillMaxWidth()
                           )
                           Text(
                               text = "#001",
                               fontSize = 16.sp,
                               modifier = Modifier
                                   .padding(8.dp)
                                   .fillMaxWidth()
                           )
                       }
                    }

                }
            }

            Box(
                modifier = Modifier
                    .padding(start = 0.dp, bottom = 8.dp, top = 8.dp, end = 0.dp)
                    .background(AppColors.OnSurface)
            ) {
                Column(
                    modifier = Modifier
                        .padding(0.dp)
                        .border(1.dp, AppColors.Placeholder, RoundedCornerShape(8.dp)),
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(start = 8.dp, bottom = 4.dp, top = 4.dp, end = 8.dp)
                            .fillMaxWidth()
                    ) { //User Details
                        TextWithIcon(
                            iconValue = Icons.Filled.Info,
                            labelValue = "User Details"
                        )
                        TextAfterIcon(
                            NormalText = "User Details"
                        )
                    }//User

                    Card(
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 4.dp,
                        ),
                        colors = CardDefaults.cardColors(
                            containerColor = AppColors.Background
                        ),
                        modifier = Modifier
                            .padding(8.dp)
                            // .padding(start = 0.dp, bottom = 8.dp, top = 8.dp, end = 0.dp)
                            .fillMaxWidth()
                        //  .border(1.dp, AppColors.Placeholder, RoundedCornerShape(8.dp)),
                    ) { // email card
                        Column {
                            Text(
                                text = "Email",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.subtitle1,
                                color = Color.Black,
                                modifier = Modifier.padding(
                                    start = 16.dp,
                                    bottom = 2.dp,
                                    top = 8.dp,
                                    end = 8.dp
                                )
                            )
                            Text(
                                text = userEmail,
                                fontSize = 16.sp,
                                style = MaterialTheme.typography.body1,
                                color = Color.Black,
                                modifier = Modifier.padding(
                                    start = 16.dp,
                                    bottom = 8.dp,
                                    top = 2.dp,
                                    end = 8.dp
                                )
                            )
                        }
                    } // email card

                    Card(
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 4.dp,
                        ),
                        colors = CardDefaults.cardColors(
                            containerColor = AppColors.Background
                        ),
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                    ) { // Phone Number Card
                        Column {
                            Text(
                                text = "Phone Number",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.subtitle1,
                                color = Color.Black,
                                modifier = Modifier.padding(
                                    start = 16.dp,
                                    bottom = 2.dp,
                                    top = 8.dp,
                                    end = 8.dp
                                )
                            )

                            Text(
                                text = userPhone,
                                fontSize = 16.sp,
                                style = MaterialTheme.typography.body1,
                                color = if(userPhone == "Not Available") AppColors.Placeholder else AppColors.Black,
                                fontStyle = if (userPhone == "Not Available") FontStyle.Italic else FontStyle.Normal,
                                modifier = Modifier.padding(
                                    start = 16.dp,
                                    bottom = 8.dp,
                                    top = 2.dp,
                                    end = 8.dp
                                )
                            )
                        }
                    } // Phone Number card
                }
            }

            Box {
                Column(
                    modifier = Modifier
                        .padding(0.dp)
                        .background(AppColors.Surface)
                        .border(1.dp, AppColors.Placeholder, RoundedCornerShape(8.dp)),
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(start = 8.dp, bottom = 12.dp, top = 4.dp, end = 8.dp)
                            .fillMaxWidth()
                    ) { //Your Notes
                        TextWithIcon(
                            iconValue = Icons.Filled.Notes,
                            labelValue = "Your Notes"
                        )
                        TextAfterIcon(
                            NormalText = "Your Notes"
                        )
                    }//Your Notes

                    Row(
                        modifier = Modifier
                            .horizontalScroll(horizontalScrollState)
                            .padding(8.dp)
                    ) {
                        notesList.forEachIndexed { index, note ->
                            Card(
                                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                                colors = CardDefaults.cardColors(containerColor = AppColors.OnSurface),
                                shape = RoundedCornerShape(12.dp),
                                modifier = Modifier
                                    .padding(end = 8.dp)
                                    .width(160.dp)
                                    .height(120.dp)
                            ) {
                                Column(
                                    modifier = Modifier.padding(12.dp)
                                ) {
                                    Text(
                                        text = "Note ${index + 1}",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 16.sp
                                    )
                                    Text(
                                        text = note,
                                        modifier = Modifier.padding(top = 8.dp),
                                        maxLines = 3,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }
                        }
                    }

                } // end


            }
        }
    }
}


@Composable
fun TextWithIcon(iconValue: ImageVector, labelValue: String){
    Row(verticalAlignment = Alignment.CenterVertically){
        Icon(
            imageVector = iconValue,
            contentDescription = labelValue,
        )
    }
}

@Composable
fun TextAfterIcon(NormalText: String){
    androidx.compose.material3.Text(
        text = NormalText,
        fontSize = 16.sp,
        color = AppColors.Error,
        textAlign = TextAlign.Start,
        modifier = Modifier.padding(start = 8.dp, bottom = 2.dp, top = 8.dp, end = 0.dp)
    )
}

@Preview
@Composable
fun UserProfileDesign(
   // userEmail: String, userPhone: String
){
    val verticalScrollState = rememberScrollState()
    val horizontalScrollState = rememberScrollState()
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.Surface)
            .verticalScroll(verticalScrollState)
        //   .horizontalScroll(horizontalScrollState)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(AppColors.Background)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(R.drawable.tuton_img),
                            contentDescription = "",
                            modifier = Modifier
                                .width(150.dp)
                        )

                        Text(
                            text = "User Name",
                            fontSize = 16.sp,
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth()
                        )
                    }

                }
            }

            Box(
                modifier = Modifier
                    .padding(start = 0.dp, bottom = 8.dp, top = 8.dp, end = 0.dp)
                    .background(AppColors.OnSurface)
            ) {
                Column(
                    modifier = Modifier
                        .padding(0.dp)
                        .border(1.dp, AppColors.Placeholder, RoundedCornerShape(8.dp)),
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(start = 8.dp, bottom = 4.dp, top = 4.dp, end = 8.dp)
                            .fillMaxWidth()
                    ) { //User Details
                        TextWithIcon(
                            iconValue = Icons.Filled.Info,
                            labelValue = "User Details"
                        )
                        TextAfterIcon(
                            NormalText = "User Details"
                        )
                    }//User

                    Card(
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 4.dp,
                        ),
                        colors = CardDefaults.cardColors(
                            containerColor = AppColors.Surface
                        ),
                        modifier = Modifier
                            .padding(8.dp)
                            // .padding(start = 0.dp, bottom = 8.dp, top = 8.dp, end = 0.dp)
                            .fillMaxWidth()
                        //  .border(1.dp, AppColors.Placeholder, RoundedCornerShape(8.dp)),
                    ) { // email card
                        Column {
                            Text(
                                text = "Email",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.subtitle1,
                                color = Color.Black,
                                modifier = Modifier.padding(
                                    start = 16.dp,
                                    bottom = 2.dp,
                                    top = 8.dp,
                                    end = 8.dp
                                )
                            )
                            Text(
                                text = "userEmail",
                                fontSize = 16.sp,
                                style = MaterialTheme.typography.body1,
                                color = Color.Black,
                                modifier = Modifier.padding(
                                    start = 16.dp,
                                    bottom = 8.dp,
                                    top = 2.dp,
                                    end = 8.dp
                                )
                            )
                        }
                    } // email card

                    Card(
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 4.dp,
                        ),
                        colors = CardDefaults.cardColors(
                            containerColor = AppColors.Surface
                        ),
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                    ) { // Phone Number Card
                        Column {
                            Text(
                                text = "Phone Number",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.subtitle1,
                                color = Color.Black,
                                modifier = Modifier.padding(
                                    start = 16.dp,
                                    bottom = 2.dp,
                                    top = 8.dp,
                                    end = 8.dp
                                )
                            )

                            Text(
                                text = "userPhone",
                                fontSize = 16.sp,
                                style = MaterialTheme.typography.body1,
                                color = Color.Black,
                                modifier = Modifier.padding(
                                    start = 16.dp,
                                    bottom = 8.dp,
                                    top = 2.dp,
                                    end = 8.dp
                                )
                            )
                        }
                    } // Phone Number card
                }
            }

            Box {
                Column(
                    modifier = Modifier
                        .padding(0.dp)
                        .background(AppColors.Surface)
                        .border(1.dp, AppColors.Placeholder, RoundedCornerShape(8.dp)),
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(start = 8.dp, bottom = 4.dp, top = 4.dp, end = 8.dp)
                            .fillMaxWidth()
                    ) { //Your Notes
                        TextWithIcon(
                            iconValue = Icons.Filled.Notes,
                            labelValue = "Your Notes"
                        )
                        TextAfterIcon(
                            NormalText = "Your Notes"
                        )
                    }//Your Notes

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(start = 8.dp, bottom = 4.dp, top = 4.dp, end = 8.dp)
                            .fillMaxWidth()
                            .horizontalScroll(horizontalScrollState)

                    ) {
                        Card (
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 12.dp,
                            ),
                            colors = CardDefaults.cardColors(
                                containerColor = AppColors.OnSurface
                            ),
                            modifier = Modifier
                                .padding(top = 4.dp, bottom = 4.dp, start = 8.dp, end = 8.dp)
                                .height(120.dp)
                                .width(160.dp)
                                .clip(RoundedCornerShape(12.dp)),
                        ){
                            Column {
                                Text(
                                    //text = note,
                                    text = "note 1",
                                    modifier = Modifier
                                        .padding(8.dp)
                                        .fillMaxWidth()
                                )
                            }
                        }

                    }
                }

            }
        }
    }
}

