package com.tasnimulhasan.appname.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.adaptive.WindowAdaptiveInfo
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.tasnimulhasan.designsystem.component.AppnameTopAppBar
import com.tasnimulhasan.designsystem.component.MmNavigationSuiteScaffold
import com.tasnimulhasan.designsystem.icon.AppnameIcons
import com.tasnimulhasan.appname.navigation.AppnameNavHost
import com.tasnimulhasan.appname.navigation.TopLevelDestination
import com.tasnimulhasan.ui.NavRoutes.SETTINGS_ROUTE
import com.tasnimulhasan.designsystem.R as Res
import com.tasnimulhasan.settings.R as settingsR

@Composable
fun AppnameApp(
    appState: AppnameAppState,
    modifier: Modifier = Modifier,
    windowAdaptiveInfo: WindowAdaptiveInfo = currentWindowAdaptiveInfo(),
) {
    val shouldShowGradientBackground = appState.currentTopLevelDestination == TopLevelDestination.HOME
    var showSettingsDialog by rememberSaveable { mutableStateOf(false) }

    AppnameApp(
        appState = appState,
        modifier = modifier,
        showSettingsDialog = showSettingsDialog,
        onSettingsDismissed = { showSettingsDialog = false },
        onTopAppBarActionClick = { showSettingsDialog = true },
        windowAdaptiveInfo = windowAdaptiveInfo,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun AppnameApp(
    appState: AppnameAppState,
    modifier: Modifier = Modifier,
    showSettingsDialog: Boolean,
    onSettingsDismissed: () -> Unit,
    onTopAppBarActionClick: () -> Unit,
    windowAdaptiveInfo: WindowAdaptiveInfo = currentWindowAdaptiveInfo(),
) {
    // Getting the reference for current destination
    val currentDestination = appState.currentDestination

    // Determine if the current destination is a top-level destination
    val isTopLevelDestination = appState.topLevelDestination.any { destination ->
        currentDestination?.route?.contains(destination.name, true) == true
    }

    // Determine the title for the current destination.
    val currentTitleRes = when (currentDestination?.route) {
        SETTINGS_ROUTE -> settingsR.string.feature_settings_title
        else -> Res.string.app_name
    }

    // Set the navigation icon based on the current destination.
    val navigationIcon = if (isTopLevelDestination) AppnameIcons.NavigationMenu
    else AppnameIcons.NavigationBack

    // Set the navigation icon content description.
    val navigationIconContentDescription = if (isTopLevelDestination) stringResource(id = Res.string.navigation_icon_content_description)
    else stringResource(id = Res.string.navigation_back_content_description)

    Scaffold(
        containerColor = Color.Transparent,
        contentColor = MaterialTheme.colorScheme.onBackground,
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
    ) { padding ->
        Column(
            modifier.fillMaxSize()
                .padding(padding)
                .consumeWindowInsets(padding)
                .windowInsetsPadding(WindowInsets.safeDrawing.only(WindowInsetsSides.Horizontal))
        ) {
            // Showing the top app bar for all destinations.
            AppnameTopAppBar(
                titleRes = currentTitleRes,
                navigationIcon = navigationIcon,
                navigationIconContentDescription = navigationIconContentDescription,
                actionIcon = AppnameIcons.ActionMore,
                actionIconsContentDescription = stringResource(id = settingsR.string.feature_settings_title),
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.Transparent),
                onActionClick = { onTopAppBarActionClick() },
                onNavigationClick = {
                    if (!isTopLevelDestination) appState.navigateBack()
                    else Toast.makeText(appState.navController.context, "Menu Icon", Toast.LENGTH_SHORT).show()
                }
            )

            // Showing the navigation suite for only top-level destinations.
            if (isTopLevelDestination)
                MmNavigationSuiteScaffold(
                    navigationSuiteItems = {
                        appState.topLevelDestination.forEach { destination ->
                            item(
                                selected = currentDestination.isTopLevelDestinationInHierarchy(destination),
                                onClick = { appState.navigateToTopLevelDestination(destination) },
                                icon = { Icon(imageVector = destination.unSelectedIcon, contentDescription = null) },
                                selectedIcon = { Icon(imageVector = destination.selectedIcon, contentDescription = null) },
                                label = { Text(stringResource(destination.iconTextId)) },
                            )
                        }
                    },
                    windowAdaptiveInfo = windowAdaptiveInfo,
                ) { GetContent(appState = appState) }
            else GetContent(appState = appState)
        }
    }
}

@Composable
private fun GetContent(appState: AppnameAppState) {
    Box(modifier = Modifier.consumeWindowInsets(WindowInsets.safeDrawing.only(WindowInsetsSides.Top))) {
        AppnameNavHost(
            appState = appState,
            navigateToInsert = { appState.navigateToInsertIncomeExpense() }
        )
    }
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any { it.route?.contains(destination.name, true) ?: false } ?: false