package com.example.beefriendzone.presentation.sign_in

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.beefriendzone.R
import com.example.beefriendzone.ui.theme.Itim

@Composable
fun SignInScreen(
    state: SignInState,
    onSignInClick: () -> Unit
) {
    val context = LocalContext.current
    LaunchedEffect(key1 = state.signInError) {
        state.signInError?.let { error ->
            Toast.makeText(
                context,
                error,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    val buttonWidth = 240.dp
    val buttonHeight = 48.dp
    val borderRadius = 24.dp
    val shadowElevation = 4.dp

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        contentAlignment = Alignment.BottomCenter,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text = "by",
                fontFamily = Itim,
                fontSize = 20.sp,
                color = Color(211,58,84,255),
                textAlign = TextAlign.Center
            )
            Text(
                text = "LIOT",
                fontFamily = Itim,
                fontSize = 20.sp,
                color = Color(211,58,84,255),
                textAlign = TextAlign.Center
            )
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ){
            Box(
                modifier = Modifier
                    .size(240.dp, 300.dp)
                    .background(color = Color.White),
                contentAlignment = Alignment.CenterStart
            ){
                Column(
                    horizontalAlignment  = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 16.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo_beefriendzone_signin),
                        contentDescription = "Logo Beefriendzone",
                        modifier = Modifier
                            .size(250.dp)
                    )
                    Text(
                        text = "BFRIENDZONE",
                        fontFamily = Itim,
                        fontSize = 32.sp,
                        color = Color(143,201,195,255),
                        textAlign = TextAlign.Left
                    )
                }
            }
            Spacer(modifier = Modifier.height(25.dp))
            Box(
                modifier = Modifier
                    .size(buttonWidth, buttonHeight)
                    .shadow(elevation = shadowElevation, shape = RoundedCornerShape(borderRadius))
                    .background(color = Color.White)
                    .clickable(onClick = onSignInClick),
                contentAlignment = Alignment.CenterStart
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 15.dp)
                ) {
                    Text(
                        text = "Seguir con Google",
                        fontFamily = Itim,
                        fontSize = 22.sp,
                        color = Color(111,77,45,255),
                        textAlign = TextAlign.Left
                    )
                    Spacer(modifier = Modifier.width(13.dp))
                    Image(
                        painter = painterResource(id = R.drawable.logo_google_signin),
                        contentDescription = "Google Logo",

                        modifier = Modifier
                            .size(30.dp)
                    )
                }
            }

        }

    }

}
@Preview
@Composable
fun PreviewSignInScreen() {
    SignInScreen(state = SignInState(false,""), onSignInClick = {})
}