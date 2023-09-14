package com.lsakee.suwon_sulasang.design_system.style.typography

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.lsakee.design_system.R
import com.lsakee.suwon_sulasang.design_system.style.color.SulasangColor
import com.lsakee.suwon_sulasang.design_system.style.modifier.sulasangClickable

internal val SulasangFontFamily = FontFamily(
    Font(R.font.pretendard_bold, FontWeight.Bold),
    Font(R.font.pretendard_medium, FontWeight.Medium),
)

object SulasangTypography {

    @Stable
    val title = TextStyle(
        fontFamily = SulasangFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 26.sp,
        lineHeight = 38.sp,
    )

    @Stable
    val headline = TextStyle(
        fontFamily = SulasangFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = 26.sp,
    )

    @Stable
    val subhead = TextStyle(
        fontFamily = SulasangFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = 28.sp,
    )

    @Stable
    val body_b = TextStyle(
        fontFamily = SulasangFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 24.sp,
    )

    @Stable
    val body_b2 = TextStyle(
        fontFamily = SulasangFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = 22.sp,
    )

    @Stable
    val body_m = TextStyle(
        fontFamily = SulasangFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
    )

    @Stable
    val caption = TextStyle(
        fontFamily = SulasangFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        lineHeight = 16.sp,
    )

}

@Composable
fun Title(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = SulasangColor.g_700,
    rippleEnabled: Boolean = false,
    onClick: (() -> Unit)? = null,
    textAlign: TextAlign = TextAlign.Start,
) {
    Text(
        modifier = modifier.sulasangClickable(
            rippleEnabled = rippleEnabled,
            onClick = onClick,
            runIf = onClick != null,
        ),
        text = text,
        style = SulasangTypography.title,
        color = color,
        textAlign = textAlign,
    )
}

@Composable
fun HeadLine(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = SulasangColor.g_700,
    rippleEnabled: Boolean = false,
    onClick: (() -> Unit)? = null,
    textAlign: TextAlign = TextAlign.Start,
) {
    Text(
        modifier = modifier.sulasangClickable(
            rippleEnabled = rippleEnabled,
            onClick = onClick,
            runIf = onClick != null,
        ),
        text = text,
        style = SulasangTypography.headline,
        color = color,
        textAlign = textAlign,
    )
}

@Composable
fun SubHead(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = SulasangColor.g_700,
    rippleEnabled: Boolean = false,
    onClick: (() -> Unit)? = null,
    textAlign: TextAlign = TextAlign.Start,
) {
    Text(
        modifier = modifier.sulasangClickable(
            rippleEnabled = rippleEnabled,
            onClick = onClick,
            runIf = onClick != null,
        ),
        text = text,
        style = SulasangTypography.subhead,
        color = color,
        textAlign = textAlign,
    )
}

@Composable
fun BodyB(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = SulasangColor.g_700,
    rippleEnabled: Boolean = false,
    onClick: (() -> Unit)? = null,
    textAlign: TextAlign = TextAlign.Start,
) {
    Text(
        modifier = modifier.sulasangClickable(
            rippleEnabled = rippleEnabled,
            onClick = onClick,
            runIf = onClick != null,
        ),
        text = text,
        style = SulasangTypography.body_b,
        color = color,
        textAlign = textAlign,
    )
}

@Composable
fun BodyB2(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = SulasangColor.g_700,
    rippleEnabled: Boolean = false,
    onClick: (() -> Unit)? = null,
    textAlign: TextAlign = TextAlign.Start,
) {
    Text(
        modifier = modifier.sulasangClickable(
            rippleEnabled = rippleEnabled,
            onClick = onClick,
            runIf = onClick != null,
        ),
        text = text,
        style = SulasangTypography.body_b2,
        color = color,
        textAlign = textAlign,
    )
}

@Composable
fun BodyM(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = SulasangColor.g_700,
    rippleEnabled: Boolean = false,
    onClick: (() -> Unit)? = null,
    textAlign: TextAlign = TextAlign.Start,
) {
    Text(
        modifier = modifier.sulasangClickable(
            rippleEnabled = rippleEnabled,
            onClick = onClick,
            runIf = onClick != null,
        ),
        text = text,
        style = SulasangTypography.body_m,
        color = color,
        textAlign = textAlign,
    )
}

@Composable
fun Caption(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = SulasangColor.g_700,
    rippleEnabled: Boolean = false,
    onClick: (() -> Unit)? = null,
    textAlign: TextAlign = TextAlign.Start,
) {
    Text(
        modifier = modifier.sulasangClickable(
            rippleEnabled = rippleEnabled,
            onClick = onClick,
            runIf = onClick != null,
        ),
        text = text,
        style = SulasangTypography.caption,
        color = color,
        textAlign = textAlign,
    )
}


// Set of Material typography styles to start with

/* Other default text styles to override
titleLarge = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Normal,
    fontSize = 22.sp,
    lineHeight = 28.sp,
    letterSpacing = 0.sp
),
labelSmall = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Medium,
    fontSize = 11.sp,
    lineHeight = 16.sp,
    letterSpacing = 0.5.sp
)
*/
