package expo.modules.devmenu.compose.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.composables.core.Icon
import com.composeunstyled.Button
import expo.modules.devmenu.compose.primitives.Heading
import expo.modules.devmenu.compose.primitives.Text
import expo.modules.devmenu.compose.theme.Theme

data class AppInfoState(
  val appName: String,
  val runtimeVersion: String? = null,
  val sdkVersion: String? = null,
  val onClose: () -> Unit = {},
  val onCopy: () -> Unit = {},
)

@Composable
fun AppInfo(
  state: AppInfoState,
) {
  Row(
    verticalAlignment = Alignment.CenterVertically,
    modifier = Modifier
      .background(color = Theme.colors.background.default)
      .padding(vertical = Theme.spacing.medium)
  ) {
    Spacer(Modifier.size(Theme.spacing.medium))

    Icon(
      Icons.Rounded.CheckCircle,
      contentDescription = "App Icon",
      modifier = Modifier
        .size(Theme.sizing.icon.extraLarge)
    )

    Spacer(Modifier.size(Theme.spacing.small))

    Column {
      Heading(
        state.appName
      )

      if (state.runtimeVersion != null) {
        Text(
          "Runtime version: ${state.runtimeVersion}",
          fontSize = Theme.typography.small,
          color = Theme.colors.text.secondary,
        )
      }

      if (state.sdkVersion != null) {
        Text(
          "SDK version: ${state.sdkVersion}",
          fontSize = Theme.typography.small,
          color = Theme.colors.text.secondary,
        )
      }
    }

    Spacer(Modifier.weight(1f))

    Button(
      onClick = state.onClose,
      indication = ripple(),
      shape = RoundedCornerShape(Theme.sizing.borderRadius.full),
      modifier = Modifier
        .align(Alignment.Top)
    ) {
      Icon(
        Icons.Default.Close,
        contentDescription = "Close",
        tint = Theme.colors.button.ghost.foreground, // TODO(@lukmccall): use a different icon color
        modifier = Modifier
          .padding(Theme.spacing.micro)
          .size(Theme.sizing.icon.small)
      )

    }
    Spacer(Modifier.size(Theme.spacing.medium))
  }
}

@Composable
@Preview(widthDp = 300, showBackground = false)
fun AppInfoPreview() {
  Column {
    AppInfo(
      state = AppInfoState(
        appName = "Expo App",
        runtimeVersion = "1.0.0",
        onClose = {}
      )
    )

    Spacer(Modifier.size(30.dp))

    AppInfo(
      state = AppInfoState(
        appName = "Expo App",
        sdkVersion = "53.0.0",
        onClose = {}
      )
    )
  }
}
