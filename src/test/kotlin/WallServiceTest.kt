import org.junit.Test
import Post.*
import org.junit.Before
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class WallServiceTest {
    private val likes = Likes()
    private val post = Post(likes = likes)

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun updateExisting() {
        // создаём целевой сервис
         WallService
        // заполняем несколькими постами
        WallService.add(post)
        WallService.add(post)
        WallService.add(post)
        // создаём информацию об обновлении
        val result =   WallService.upDate(postNew = Post(3,22,222,likes))



        // проверяем результат (используйте assertTrue или assertFalse)
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
        val result = WallService.upDate(postNew = Post(1,3322,30,likes))

        assertEquals(true, result)

    }
}