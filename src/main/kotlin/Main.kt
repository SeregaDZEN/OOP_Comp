import Attachment.*
fun main() {
    val l = Post.Likes()
    val post = Post(id = null,likes = l, text = null)
   println(WallService.add(post))
    println(WallService.upDate(postNew = Post(1, 3, 4, l,text = null)))
}

object WallService {
    private var posts = mutableListOf<Post>()
    private var counterId = 1

    fun add(post: Post): Post {
        val changePost = post.copy(id = counterId++)
        posts += changePost
        return posts.last()
    }

    fun clear() {
        posts.clear()
        counterId = 1
    }


    fun upDate(postNew: Post): Boolean {

        for ((index, post) in posts.withIndex()) {
            if (post.id == postNew.id) {
                posts[index] = postNew.copy()
                println(postNew)
                return true
            }
        }
        return false
    }
}


data class Post(

    val id: Int ?,
    val ownerId: Int = 3115, //владелец стены
    val fromId: Int = 3003, // владелец записи
    val likes: Likes,
    val text: String ?,
    val friendOnly: Boolean = true, // только для друзей?
    val canPin: Boolean = false, // можешь закрепить запись?
    val isFavorite: Boolean = false, // есть в закладках ?
    val attachments: Array<Attachment> = arrayOf()
) {

    data class Likes(
        val count: Int = 5,
        val userLikes: Boolean = false,
        val canLike: Boolean = true,
        val canPublish: Boolean = false
    )
}
