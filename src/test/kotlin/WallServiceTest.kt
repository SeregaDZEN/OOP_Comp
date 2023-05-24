import org.junit.Test
import Post.*
import org.junit.Before
import kotlin.test.assertEquals
import kotlin.test.assertTrue


class WallServiceTest {
    private val likes = Likes()
    private val post = Post(1, 2, 3, likes, null)
    private val posts = mutableListOf<Post>()

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

        val result = WallService.upDate(postNew = Post(3, 22, 222, likes, text = null))

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
        val result = WallService.upDate(postNew = Post(1, 3322, 30, likes, text = null))
        assertEquals(true, result)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        val post = Post(12, 22, 32, likes, null)
        WallService.add(post)

        val comment = Comment(34312, 2, 3, "lflf")
        println(WallService.createComment(445, comment))
        WallService.createComment(1212, comment)
    }
    @Test(expected = ReportException::class)
    fun shouldThrowSecond() {
        val report = ReportComment(1,2,9)
        println(report)
    }

}



