package com.example.tutorapp1

import android.R.attr.icon
import android.R.id.icon
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun SignUp(){
    Surface (
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.Background)
            .padding(16.dp),
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
            //    .border(1.dp, AppColors.Placeholder, RoundedCornerShape(12.dp))
            //    .background(AppColors.Placeholder)
            ,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

           Box(){
               Column {
                   val interactionSource = remember { MutableInteractionSource() }
                   val isFocused by interactionSource.collectIsFocusedAsState()

                   CallNormalTextFieldText(NormalText = "Name")
                   CallNormalTextField(
                       //iconValue = Icons.Default.AccountBox,
                       iconValue = if (isFocused) Icons.Filled.AccountCircle else Icons.Outlined.AccountCircle,
                       interactionSource = interactionSource,
                       labelValue = stringResource(id = R.string.user_name_input),
                       placeHolderValue = stringResource(id = R.string.user_name_input_placeholder),
                   )

                   CallNormalTextFieldText(NormalText = "Password")
                   CallPasswordTextField(
                       iconValue = if (isFocused) Icons.Filled.Lock else Icons.Outlined.Lock,
                       interactionSource = interactionSource,
                       labelValue = stringResource(id = R.string.password_input),
                       placeHolderValue = stringResource(id = R.string.password_input_placeholder),
                   )
               }
           }
        }
    }
}

@Composable
fun CallNormalTextFieldText(NormalText: String){
    Text(
        text = NormalText,
        fontSize = 16.sp,
        color = AppColors.Error,
        textAlign = TextAlign.Start,
        modifier = Modifier.padding(start = 8.dp, bottom = 0.dp, top = 8.dp, end = 0.dp)
    )
}

@Composable
fun CallNormalTextField(
    iconValue: ImageVector,
    labelValue: String,
    placeHolderValue: String,
    interactionSource: MutableInteractionSource
    ){

    val textValue = remember { mutableStateOf("") }
    val interactionSource = remember { MutableInteractionSource() }

    OutlinedTextField(
        value = textValue.value,
        onValueChange = { textValue.value = it },
//        label = {Text(text = labelValue)},
        placeholder = {Text(text = placeHolderValue)},
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = AppColors.TextFieldFocusedBorder,
            unfocusedBorderColor = AppColors.TextFieldColorsBorder,
            cursorColor = AppColors.TextFieldCursor,
            focusedLabelColor = AppColors.TextFieldFocusedBorder,
            unfocusedLabelColor = Color.Gray,
            focusedPlaceholderColor = AppColors.Placeholder,
            unfocusedPlaceholderColor = Color.LightGray
        ),
        keyboardOptions = KeyboardOptions.Default,

        leadingIcon = {
            Icon(
                imageVector = iconValue,
                contentDescription = labelValue
            )
        },

        modifier = Modifier
            .padding(top = 0.dp, bottom = 8.dp, start = 8.dp, end = 8.dp)
            .clip(RoundedCornerShape(4.dp))
    )
}

@Composable
fun CallPasswordTextField(labelValue: String, placeHolderValue: String, iconValue: ImageVector, interactionSource: MutableInteractionSource){

    val passValue = remember { mutableStateOf("") }
    val interactionSource = remember { MutableInteractionSource() }

    OutlinedTextField(
        value = passValue.value,
        onValueChange = { passValue.value = it },
//        label = {Text(text = labelValue)},
        placeholder = {Text(text = placeHolderValue)},
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = AppColors.TextFieldFocusedBorder,
            unfocusedBorderColor = AppColors.TextFieldColorsBorder,
            cursorColor = AppColors.TextFieldCursor,
            focusedLabelColor = AppColors.TextFieldFocusedBorder,
            unfocusedLabelColor = Color.Gray,
            focusedPlaceholderColor = AppColors.Placeholder,
            unfocusedPlaceholderColor = Color.LightGray
        ),
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),

        leadingIcon = {
            Icon(
                imageVector = iconValue,
                contentDescription = ""
            )
        },
        interactionSource = interactionSource,

        modifier = Modifier
            .padding(top = 0.dp, bottom = 8.dp, start = 8.dp, end = 8.dp)
            .clip(RoundedCornerShape(4.dp))
    )

}