package expo.modules.devmenu.compose.primitives

import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import expo.modules.devmenu.compose.theme.Theme

@Composable
fun Divider() {
  HorizontalDivider(
    thickness = Theme.sizing.borderRadius.hairlineWidth,
    color = Theme.colors.border.default
  )
}
