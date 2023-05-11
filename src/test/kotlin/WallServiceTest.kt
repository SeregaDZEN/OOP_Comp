import org.junit.Test
import Post.*
import org.junit.Before
import kotlin.test.assertEquals
import kotlin.test.assertTrue


class WallServiceTest {
    private val likes = Likes()
    private val post = Post(1,2,3,likes,null)

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun updateExisting() {
         WallService

        WallService.add(post)
        WallService.add(post)
        WallService.add(post)

        val result =   WallService.upDate(postNew = Post(3,22,222,likes, text = null))

        assertTrue(result)
    }

    @Test
    fun add() {
        val result = WallService.add(post)
        assertEquals(1, result.id)
    }

    @Test
    fun upDate() {
        val result = WallService.upDate(post)
        assertEquals(false, result)
    }

    @Test
    fun upDateTwo() {
        WallService.add(post)
        val result = WallService.upDate(postNew = Post(1,3322,30,likes, text = null))
        assertEquals(true, result)
    }
}