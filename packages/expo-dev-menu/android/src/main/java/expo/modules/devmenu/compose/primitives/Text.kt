package expo.modules.devmenu.compose.primitives

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import expo.modules.devmenu.compose.theme.FontSize
import expo.modules.devmenu.compose.theme.Theme

@Composable
fun Text(
  text: String,
  fontSize: FontSize = Theme.typography.size16,
  color: Color = Theme.colors.text.default,
  maxLines: Int = Int.MAX_VALUE,
) {
  BasicText(
    text,
    maxLines = maxLines,
    style = fontSize.font.merge(
      color = color,
    )
  )
}

@Composable
fun Heading(
  text: String,
  fontSize: FontSize = Theme.typography.size18,
  color: Color = Theme.colors.text.default,
  maxLines: Int = Int.MAX_VALUE,
  ) {
  BasicText(
    text,
    maxLines = maxLines,
    style = fontSize.font.merge(
      color = color,
      fontWeight = FontWeight.SemiBold
    )
  )
}

@Composable
@Preview(showBackground = true)
fun TextPreview() {
  Column {
    Text("Hello, World!")
    Text("Hello, World!", fontSize = Theme.typography.size25)
  }
}

@Composable
@Preview(showBackground = true)
fun HeadingPreview() {
  Heading("Hello, World!")
}
