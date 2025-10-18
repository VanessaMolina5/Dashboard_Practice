package com.example.cuartitosa.components

import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cuartitosa.model.Student




@Composable
fun StudentItem(student: Student, onClick:(Student)->Unit){
    Row(modifier=Modifier.padding(8.dp)){
        Image(
            painter = painterResource(id = student.imageResId),
            contentDescription = student.name,
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(8.dp)),

        )
        Spacer(modifier=Modifier.width(12.dp))
        Column{
            Text(student.name, fontWeight=FontWeight.Bold)
            Text(student.description, fontSize=14.sp, color=Color.Gray)
        }
    }
}
