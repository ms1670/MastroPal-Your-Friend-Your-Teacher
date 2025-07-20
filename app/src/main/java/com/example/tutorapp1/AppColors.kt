package com.example.tutorapp1

import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

object AppColors{
    val Primary = Color(0xFF4CAF50)
    val PrimaryVariant = Color(0xFFB18BFF)
    val Secondary = Color(0xFFC2FFC5)
    val Background = Color(0xFFFFFFFF)
    val Surface = Color(0xFFF1F1F1)
    val CardBG = Color(0xFFDBE2E8)
    val SurfaceDark = Color(0xFFEFEFEF)
    val Error = Color(0xFF404040)
    val OnPrimary = Color(0xFFEFEFEF)
    val OnSecondary = Color.Black
    val OnBackground = Color.Black
    val OnSurface = Color(0xFFF8F8F8)
    val OnSurfaceS = Color(0xFFF0F9FD)
    val OnError = Color.White

    //Regular colors
    val White = Color(0xFFFFFFFF)
    val Black = Color(0xFF000000)
    // Custom colors
    val TextFieldFocusedBorder = Color(0xFF4CAF50)
    val TextFieldCursor = Color(0xFF388E3C)
    val Placeholder = Color(0xFF9E9E9E)
    val TextFieldColorsBorder = Color(0x78747DFF)

}

@Immutable
data class CustomColors(
    val Primary: Color = Color.Unspecified, // Main brand color for primary buttons, toggles, active elements
    val OnPrimary: Color = Color.Unspecified, // Text/icons displayed on primary background

    val Secondary: Color = Color.Unspecified, // Used for accents, chips, FABs, secondary actions
    val OnSecondary: Color = Color.Unspecified, // Text/icons on secondary color backgrounds

    val Tertiary: Color = Color.Unspecified, // Optional accent color used for highlighting or alternate buttons
    val OnTertiary: Color = Color.Unspecified, // Text/icons on tertiary backgrounds

    val PrimaryContainer: Color = Color.Unspecified, // Used for larger containers/cards using the primary color
    val OnPrimaryContainer: Color = Color.Unspecified, // Text/icons shown on top of primary container

    val SecondaryContainer: Color = Color.Unspecified, // Backgrounds of chips/cards using secondary
    val OnSecondaryContainer: Color = Color.Unspecified, // Text/icons on secondary container

    val TertiaryContainer: Color = Color.Unspecified, // Tertiary-colored cards or chips
    val OnTertiaryContainer: Color = Color.Unspecified, // Text/icons on tertiary container

    val Error: Color = Color.Unspecified, // Used for validation errors, danger alerts, etc.
    val OnError: Color = Color.Unspecified, // Text/icons on error background

    val ErrorContainer: Color = Color.Unspecified, // Container for error messages (e.g., filled snackbar)
    val OnErrorContainer: Color = Color.Unspecified, // Text/icons on error container
    val errorVariant: Color = Color.Unspecified, // Optional subtle error highlight or border for inputs

    val background: Color = Color.Unspecified, // App main background color (behind all content)
    val onBackground: Color = Color.Unspecified, // Text/icons displayed over background

    val PrimaryFixed: Color = Color.Unspecified, // Used for surfaces always matching primary color (in fixed elevation)
    val PrimaryFixedDim: Color = Color.Unspecified, // Dimmed version for less prominent fixed elements
    val OnPrimaryFixed: Color = Color.Unspecified, // Text/icons on primary fixed
    val OnPrimaryFixedVariant: Color = Color.Unspecified, // Slight variant of onPrimaryFixed (e.g., secondary emphasis)

    val SecondaryFixed: Color = Color.Unspecified, // Same as above but for secondary color
    val SecondaryFixedDim: Color = Color.Unspecified, // Dim version for background elements
    val OnSecondaryFixed: Color = Color.Unspecified, // Text/icons on secondary fixed
    val OnSecondaryFixedVariant: Color = Color.Unspecified, // Variant for less contrast

    val TertiaryFixed: Color = Color.Unspecified, // For tertiary fixed surfaces
    val TertiaryFixedDim: Color = Color.Unspecified, // Dim version of tertiary fixed
    val OnTertiaryFixed: Color = Color.Unspecified, // Text/icons over tertiary fixed
    val OnTertiaryFixedVariant: Color = Color.Unspecified, // Slight contrast version

    val Surface: Color = Color.Unspecified, // Default color for components: cards, sheets, menus
    val SurfaceDim: Color = Color.Unspecified, // Dim version for background surface when not focused
    val SurfaceBright: Color = Color.Unspecified, // Bright version of surface (e.g., highlighted sheets)
    val SurfaceContainer: Color = Color.Unspecified, // Base surface container (used for padding areas)
    val SurfaceContainerLow: Color = Color.Unspecified, // Used in slightly elevated containers (e.g., list items)
    val SurfaceContainerLowest: Color = Color.Unspecified, // Flat background containers (bottom layer)
    val SurfaceContainerHigh: Color = Color.Unspecified, // More elevated container (cards/dialogs)
    val SurfaceContainerHighest: Color = Color.Unspecified, // Highest elevation background (modals)

    val OnSurface: Color = Color.Unspecified, // Primary text/icons on surfaces
    val OnSurfaceVariant: Color = Color.Unspecified, // Secondary text/icons on surfaces // Text/icons on surface variant
    val SurfaceVariant: Color = Color.Unspecified, // Used for surface backgrounds with visual separation

    val InverseSurface: Color = Color.Unspecified, // Used in dark themes or inverse backgrounds (e.g., bottom nav bar)
    val InverseOnSurface: Color = Color.Unspecified, // Text/icons on inverse surface
    val InversePrimary: Color = Color.Unspecified, // Used to emphasize primary color over inverse surfaces

    val Outline: Color = Color.Unspecified, // Borders, outlines for inputs/cards/dialogs
    val OutlineVariant: Color = Color.Unspecified, // Softer outlines for low-emphasis elements
    val Scrim: Color = Color.Unspecified, // Used behind modal surfaces to block interaction
    val Shadow: Color = Color.Unspecified, // Used for elevation shadows (rarely customized)
)

val LightColorScheme = CustomColors(
    Primary = Color(0xFF6750A4), // Used for primary buttons, top bars, etc.
    OnPrimary = Color(0xFFFFFFFF), // Text/icon color on Primary

    Secondary = Color(0xFF625B71), // Used for secondary actions (chips, buttons)
    OnSecondary = Color(0xFFFFFFFF), // Text/icon on Secondary

    Tertiary = Color(0xFF7D5260), // Optional accent
    OnTertiary = Color(0xFFFFFFFF),

    PrimaryContainer = Color(0xFFEADDFF), // Background container for primary
    OnPrimaryContainer = Color(0xFF21005D),

    SecondaryContainer = Color(0xFFE8DEF8),
    OnSecondaryContainer = Color(0xFF1D192B),

    TertiaryContainer = Color(0xFFFFD8E4),
    OnTertiaryContainer = Color(0xFF31111D),

    Error = Color(0xFFB3261E),
    OnError = Color(0xFFFFFFFF),
    ErrorContainer = Color(0xFFF9DEDC),
    OnErrorContainer = Color(0xFF410E0B),
    errorVariant = Color(0xFFEF5350), // Optional darker shade

    background = Color(0xFFFFFBFE), // App background
    onBackground = Color(0xFF1C1B1F),

    PrimaryFixed = Color(0xFFD0BCFF),
    PrimaryFixedDim = Color(0xFF6750A4),
    OnPrimaryFixed = Color(0xFF381E72),
    OnPrimaryFixedVariant = Color(0xFFEADDFF),

    SecondaryFixed = Color(0xFFCCC2DC),
    SecondaryFixedDim = Color(0xFF625B71),
    OnSecondaryFixed = Color(0xFF332D41),
    OnSecondaryFixedVariant = Color(0xFFE8DEF8),

    TertiaryFixed = Color(0xFFEFB8C8),
    TertiaryFixedDim = Color(0xFF7D5260),
    OnTertiaryFixed = Color(0xFF492532),
    OnTertiaryFixedVariant = Color(0xFFFFD8E4),

    Surface = Color(0xFFFFFBFE),
    SurfaceDim = Color(0xFFDED8E1),
    SurfaceBright = Color(0xFFFFFBFE),
    SurfaceContainer = Color(0xFFF3EDF7),
    SurfaceContainerLow = Color(0xFFF7F2FA),
    SurfaceContainerLowest = Color(0xFFFFFFFF),
    SurfaceContainerHigh = Color(0xFFE6E0E9),
    SurfaceContainerHighest = Color(0xFF1C1B1F),

    OnSurface = Color(0xFF1C1B1F),
    OnSurfaceVariant = Color(0xFF49454F),
    SurfaceVariant = Color(0xFFE7E0EC),

    InverseSurface = Color(0xFF313033),
    InverseOnSurface = Color(0xFFF4EFF4),
    InversePrimary = Color(0xFFD0BCFF),

    Outline = Color(0xFF79747E),
    OutlineVariant = Color(0xFFC4C7C5),

    Scrim = Color(0x66000000),
    Shadow = Color(0xFF000000)
)

val DarkColorScheme = CustomColors(
    Primary = Color(0xFF6750A4), // Used for primary buttons, top bars, etc.
    OnPrimary = Color(0xFFFFFFFF), // Text/icon color on Primary

    Secondary = Color(0xFF625B71), // Used for secondary actions (chips, buttons)
    OnSecondary = Color(0xFFFFFFFF), // Text/icon on Secondary

    Tertiary = Color(0xFF7D5260), // Optional accent
    OnTertiary = Color(0xFFFFFFFF),

    PrimaryContainer = Color(0xFFEADDFF), // Background container for primary
    OnPrimaryContainer = Color(0xFF21005D),

    SecondaryContainer = Color(0xFFE8DEF8),
    OnSecondaryContainer = Color(0xFF1D192B),

    TertiaryContainer = Color(0xFFFFD8E4),
    OnTertiaryContainer = Color(0xFF31111D),

    Error = Color(0xFFB3261E),
    OnError = Color(0xFFFFFFFF),
    ErrorContainer = Color(0xFFF9DEDC),
    OnErrorContainer = Color(0xFF410E0B),
    errorVariant = Color(0xFFEF5350), // Optional darker shade

    background = Color(0xFFFFFBFE), // App background
    onBackground = Color(0xFF1C1B1F),

    PrimaryFixed = Color(0xFFD0BCFF),
    PrimaryFixedDim = Color(0xFF6750A4),
    OnPrimaryFixed = Color(0xFF381E72),
    OnPrimaryFixedVariant = Color(0xFFEADDFF),

    SecondaryFixed = Color(0xFFCCC2DC),
    SecondaryFixedDim = Color(0xFF625B71),
    OnSecondaryFixed = Color(0xFF332D41),
    OnSecondaryFixedVariant = Color(0xFFE8DEF8),

    TertiaryFixed = Color(0xFFEFB8C8),
    TertiaryFixedDim = Color(0xFF7D5260),
    OnTertiaryFixed = Color(0xFF492532),
    OnTertiaryFixedVariant = Color(0xFFFFD8E4),

    Surface = Color(0xFFFFFBFE),
    SurfaceDim = Color(0xFFDED8E1),
    SurfaceBright = Color(0xFFFFFBFE),
    SurfaceContainer = Color(0xFFF3EDF7),
    SurfaceContainerLow = Color(0xFFF7F2FA),
    SurfaceContainerLowest = Color(0xFFFFFFFF),
    SurfaceContainerHigh = Color(0xFFE6E0E9),
    SurfaceContainerHighest = Color(0xFF1C1B1F),

    OnSurface = Color(0xFF1C1B1F),
    OnSurfaceVariant = Color(0xFF49454F),
    SurfaceVariant = Color(0xFFE7E0EC),

    InverseSurface = Color(0xFF313033),
    InverseOnSurface = Color(0xFFF4EFF4),
    InversePrimary = Color(0xFFD0BCFF),

    Outline = Color(0xFF79747E),
    OutlineVariant = Color(0xFFC4C7C5),

    Scrim = Color(0x66000000),
    Shadow = Color(0xFF000000)
)

object AppColor1 {
    val light = LightColorScheme
    val dark = DarkColorScheme // Define similar to above if needed
}

//usage
//Text(
//text = "Hello",
//color = AppColors.light.OnPrimary
//)

