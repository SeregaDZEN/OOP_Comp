import Attachment.*


fun main() {
    val comment = Comment(34312, 2, 3, "lflf")
    println(WallService.createComment(1, comment))


    val l = Post.Likes()
    val post = Post(id = null, likes = l, text = null)
    println(WallService.add(post))
    println(WallService.upDate(postNew = Post(1, 3, 4, l, text = null)))
    aunTest(PhotoAttachment())

}

fun aunTest(test: Attachment) = when (test) {
    is ContentAttachment -> println("кон")
    is AudioAttachment -> println("a")
    is VideoAttachment -> println("dbltj")
    is DocumentAttachment -> println("sdfs")
    is PhotoAttachment -> println()
}


object WallService {


    private var comments = mutableListOf<Comment>()
    private var posts = mutableListOf<Post>()
    private var reports = mutableListOf<ReportComment>()
    private var counterId = 1

    fun add(post: Post): Post {
        val changePost = post.copy(id = counterId++)
        posts += changePost
        return posts.last()
    }

    fun createReport(report : ReportComment, id : Int) : ReportComment{
        for ((i, post) in posts.withIndex()) {
            if (report.reason !in 1..8) {
                throw ReportException(" не допустимый номер причины")
            } else  if (id == report.commentId){
                reports += report
            }
        }
        return report
    }

    fun clear() {
        posts.clear()
        counterId = 1
    }

    fun createComment(postId: Int, comment: Comment): Comment {
        for ((i, post) in posts.withIndex()) {
            if (postId == post.id) {
                comments += comment
            }
            return comment
        }
        throw PostNotFoundException("нет такого айди")
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

    val id: Int?,
    val ownerId: Int = 3115, //владелец стены
    val fromId: Int = 3003, // владелец записи
    val likes: Likes,
    val text: String?,
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

