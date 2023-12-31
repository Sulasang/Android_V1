package com.lsakee.suwon_sulasang.design_system.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lsakee.suwon_sulasang.design_system.style.color.SulasangColor
import com.lsakee.suwon_sulasang.design_system.style.theme.Suwon_SulasangTheme
import com.lsakee.suwon_sulasang.design_system.style.typography.BodyB2

@Composable
fun HomeChip(
    name: String,
    index: Int = -1,
    isClickable: Boolean = false,
    isSelected: Boolean = false,
    onClick: (Int) -> Unit = {}
) {
    Row(
        modifier = Modifier
            .wrapContentSize()
            .clip(RoundedCornerShape(24.dp))
            .clickable(isClickable) { onClick(index) }
            .background(if (isSelected) SulasangColor.usw_yellow else SulasangColor.g_100)
            .padding(start = 6.dp, end = 7.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.size(4.dp))
        BodyB2(
            text = name,
            color = if (isSelected) SulasangColor.g_700 else SulasangColor.g_300,
            modifier = Modifier
                .padding(top = 5.dp, bottom = 3.dp)
        )

    }
}
@Composable
private fun Chip(
    text: String,
    selected: Boolean,
    modifier: Modifier = Modifier,
    onChipClicked: () -> Unit,
) {
    Surface(
        color = when {
            selected -> SulasangColor.usw_yellow
            else -> SulasangColor.white
        },
        contentColor = SulasangColor.g_100,
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(
            width = 1.dp,
            color = when {
                selected -> SulasangColor.usw_yellow
                else -> SulasangColor.white
            }
        ),
        modifier = modifier
    ) {
        Row(modifier = Modifier) {
            BodyB2(
                text = text,
                modifier = Modifier
                    .padding(8.dp)
                    .clickable { onChipClicked() }
            )

            Image(
                imageVector = Icons.Default.Clear,
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .size(20.dp)
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun HomyChipPreview() {
    Suwon_SulasangTheme {
        HomeChip(
            name = "Sample Chip",
            isSelected = true
        )
    }
}
