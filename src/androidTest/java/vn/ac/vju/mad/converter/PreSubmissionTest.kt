package vn.ac.vju.mad.converter

import androidx.compose.ui.test.assertContentDescriptionEquals
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onChildAt
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onLast
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.TestCase.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class PreSubmissionTest {
    @get:Rule
    val rule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testTitle() {
        val title = rule.activity.title.toString()
        assertEquals("Currency Converter", title)
    }

    @Test
    fun testText() {
        rule.onNodeWithText("Convert JPY to VND")
            .assertIsDisplayed()
    }

    @Test
    fun testViewTree() {
        rule.onRoot().assertIsDisplayed()
        rule.onRoot().onChildren().assertCountEquals(3)
        rule.onRoot().onChildAt(0).assertTextEquals("Convert JPY to VND")
        rule.onRoot().onChildAt(1).assertIsDisplayed()
        rule.onRoot().onChildAt(2).assertIsDisplayed()

        val card1 = rule.onRoot().onChildAt(1)
        card1.onChildren().assertCountEquals(3)
        card1.onChildAt(0).assertContentDescriptionEquals("The Vietnam flag")
        card1.onChildAt(1).assertIsNotDisplayed()
        card1.onChildAt(2).assertTextEquals("VND")

        val card2 = rule.onRoot().onChildAt(2)
        card2.onChildren().assertCountEquals(3)
        card2.onChildAt(0).assertContentDescriptionEquals("The Japan flag")
        card2.onChildAt(1).assertIsDisplayed()
        card2.onChildAt(2).assertTextEquals("JPY")
    }

    @Test
    fun textTextField() {
        rule.onAllNodesWithText("").assertCountEquals(2)
        rule.onAllNodesWithText("").onLast().performTextInput("100")
        rule.onNodeWithText("100").assertIsDisplayed()
    }
}
