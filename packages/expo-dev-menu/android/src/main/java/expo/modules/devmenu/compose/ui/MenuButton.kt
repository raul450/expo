package expo.modules.devmenu.compose.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.composables.core.Icon
import com.composeunstyled.Button
import expo.modules.devmenu.compose.primitives.Text
import expo.modules.devmenu.compose.theme.Theme

@Composable
fun MenuButton(
  label: String,
  onClick: () -> Unit = {},
) {
  Button(
    onClick = onClick,
    backgroundColor = Theme.colors.background.default,
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier
        .padding(Theme.spacing.small)
    ) {
      Icon(
        Icons.Default.Settings,
        contentDescription = "Menu Icon",
        tint = Theme.colors.icon.default
      )

      Spacer(Modifier.size(Theme.spacing.small))

      Text(
        label
      )

      Spacer(Modifier.weight(1f))
    }
  }
}

@Composable
fun MenuButtonContainer(
  content: @Composable () -> Unit,
) {
  Row(
    modifier = Modifier
      .padding(Theme.spacing.small)
  ) {
    Surface(
      shape = RoundedCornerShape(Theme.sizing.borderRadius.large)
    ) {
      Column {
        content()
      }
    }
  }
}

@Composable
@Preview(widthDp = 300)
fun MenuButtonPreview() {
  MenuButton(
    label = "Menu Button"
  )
}

