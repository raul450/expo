package expo.modules.devmenu.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.composables.core.SheetDetent.Companion.Hidden
import expo.modules.devmenu.compose.primitives.Divider
import expo.modules.devmenu.compose.theme.Theme
import expo.modules.devmenu.compose.ui.AppInfo
import expo.modules.devmenu.compose.ui.AppInfoState
import expo.modules.devmenu.compose.ui.BundlerInfo
import expo.modules.devmenu.compose.ui.BundlerInfoState
import expo.modules.devmenu.compose.ui.MenuButton
import expo.modules.devmenu.compose.ui.MenuButtonContainer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DevMenuScreen() {
  val sheetState = rememberBottomSheetState()

  Scaffold(
    floatingActionButton = {
      ExtendedFloatingActionButton(
        text = { Text("Show bottom sheet") },
        icon = { Icon(Icons.Filled.Add, contentDescription = "") },
        onClick = {
          sheetState.jumpTo(Peek)
        }
      )
    }
  ) { padding ->
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .height(56.dp)
        .background(Color.White),
      contentAlignment = Alignment.Center
    ) {
      Text("Dev Menu Screen", color = Theme.colors.text.default)
    }

    BottomSheet(
      state = sheetState,
      header = {
        AppInfo(
          state = AppInfoState(
            appName = "Expo Dev Menu",
            runtimeVersion = "1.0.0",
            onClose = { sheetState.jumpTo(Hidden) },
            onCopy = { /* Handle copy action */ }
          )
        )
      }
    ) {
      Column {
        BundlerInfo(
          state = BundlerInfoState(
            bundlerIp = "http://10.0.2.2:8081"
          )
        )

        MenuButtonContainer {
          MenuButton("Reload")
          Divider()
          MenuButton("Go home")
        }

        MenuButtonContainer {
          MenuButton("Toggle performance monitor")
          Divider()
          MenuButton("Toggle element inspector")
          Divider()
          MenuButton("Open JS debugger")
          // TODO(@lukmccall): add switch to toggle fast refresh
        }
      }

      Spacer(Modifier.size(padding.calculateBottomPadding() + Theme.spacing.medium))
    }
  }
}


@Composable
@Preview(showBackground = false)
fun DevMenuScreenRoot() {
  DevMenuScreen()
}
