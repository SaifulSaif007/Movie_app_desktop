import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ui.DashboardScreen

@Composable
@Preview
fun App() {
    DashboardScreen()
}

fun main() = application {
    Window(
        title = "Movie App",
        icon = painterResource(resourcePath = "drawables/video-camera.png"),
        onCloseRequest = ::exitApplication
    ) {
        App()
    }
}
