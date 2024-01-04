package ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import util.loadNetworkImage

@Composable
fun PagerContent(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    Column(modifier.padding(10.dp)) {
        Image(
            bitmap = loadNetworkImage(imageUrl),
            contentDescription = null,
            modifier = Modifier.sizeIn(maxHeight = 440.dp, minWidth = 600.dp).padding(20.dp).clip(
                RoundedCornerShape(12.dp)
            ),
            contentScale = ContentScale.FillWidth
        )
    }

}

@Preview
@Composable
private fun PreviewPagerContent() {
    PagerContent(
        imageUrl = "https://image.tmdb.org/t/p/" + "w342" + "/fmmRFQtsRrNOpmcfoxVIyE1LxxT.jpg",
    )
}