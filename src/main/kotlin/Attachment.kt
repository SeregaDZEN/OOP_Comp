 sealed class Attachment (val type: String){
     data class PhotoAttachment( val photo: Photo = Photo(1, 2, "smile", 200)) : Attachment("Photo")
     data class VideoAttachment( val video : Video = Video(duration = 30)) : Attachment("video")
     data class ContentAttachment( val content: Content =Content(1, 2, "new")) : Attachment("content")
     data class AudioAttachment( val audio : Audio = Audio(title = "dance")) : Attachment("audio")
     data class DocumentAttachment( val doc : Document = Document(1, 22,
         "important", 100)) : Attachment("doc")
 }

data class Audio(val id: Int = 2, val owner: Int = 22, val title: String){
}
data class Content(val id: Int, val owner: Int, val name: String)
data class Video(val id: Int = 10, val owner: Int = 100, val name: String = "null (:", val duration: Int)
data class Photo(val id: Int, val owner: Int, val name: String, val size: Int)
data class Document(val id: Int, val owner: Int, val name: String, val pageCount: Int)

