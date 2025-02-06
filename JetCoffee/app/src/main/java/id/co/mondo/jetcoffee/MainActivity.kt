 package id.co.mondo.jetcoffee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.co.mondo.jetcoffee.model.Menu
import id.co.mondo.jetcoffee.model.dummyBestSellerMenu
import id.co.mondo.jetcoffee.model.dummyCategory
import id.co.mondo.jetcoffee.model.dummyMenu
import id.co.mondo.jetcoffee.ui.components.CategoryItem
import id.co.mondo.jetcoffee.ui.components.HomeSection
import id.co.mondo.jetcoffee.ui.components.MenuItem
import id.co.mondo.jetcoffee.ui.components.Search
import id.co.mondo.jetcoffee.ui.theme.JetCoffeeTheme

 class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetCoffeeTheme {
                jetCoffeeApp()
            }
        }
    }
}

@Composable
fun jetCoffeeApp() {
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
    ) {
        Banner()
//        SectionText(stringResource(R.string.section_category))
//        CategoryRow()
//        SectionText(stringResource(R.string.section_favorite_menu))
//        MenuRow(dummyMenu)
//        SectionText(stringResource(R.string.section_best_seller_menu))
//        MenuRow(dummyBestSellerMenu)
        HomeSection(
            title = stringResource(R.string.section_category),
            content = { CategoryRow() }
        )
//        cara pertama merupakan Best practice
//        HomeSection(
//            stringResource(R.string.section_favorite_menu), Modifier,{
//                MenuRow(dummyMenu)
//            }
//        ) Cara ke dua
//        HomeSection(
//            stringResource(R.string.section_best_seller_menu)
//        ){
//                MenuRow(dummyBestSellerMenu)
//            } cara ke tiga
        HomeSection(
            title = stringResource(R.string.section_favorite_menu),
            content = { MenuRow(dummyMenu) }
        )
        HomeSection(
            title = stringResource(R.string.section_best_seller_menu),
            content = { MenuRow(dummyBestSellerMenu) }
        )
    }
}

@Composable
fun Banner(
    modifier: Modifier = Modifier,
){
    Box(modifier = modifier){
        Image(
            painter = painterResource(R.drawable.banner),
            contentDescription = "Banner Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(160.dp)
        )
        Search()
    }
}

@Composable
fun CategoryRow(
    modifier: Modifier = Modifier
){
    LazyRow(
//        modifier = modifier.padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
    ) {
        items(dummyCategory, key = { it.textCategory }){
            category ->
            CategoryItem(category)
        }
    }
}

@Composable
fun MenuRow(
    listMenu: List<Menu>,
    modifier: Modifier = Modifier
){
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ){
        items(listMenu, key = { it.title }){ menu ->
            MenuItem(menu)
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun jetCoffeeAppPreview() {
    JetCoffeeTheme {
        jetCoffeeApp()
    }
}

@Composable
@Preview(showBackground = true)
 fun CategoryRowPreview(){
     JetCoffeeTheme {
         CategoryRow()
     }
 }

@Composable
@Preview(showBackground = true)
fun MenuRowPreview(){
    JetCoffeeTheme {
        MenuRow(dummyMenu)
    }
}