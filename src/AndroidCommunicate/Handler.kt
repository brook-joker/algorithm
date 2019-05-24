package AndroidCommunicate

class Handler {

    var messageQueue: MessageQueue? = null
     var looper:Looper?

    constructor(){
        looper = Looper.myLooper()
        messageQueue = looper?.sMessageQueue
    }


    fun sendMessgae(message: Message) {
        enqueueMessage(message)
    }

    fun enqueueMessage(message: Message) {
        message.target = this
        messageQueue?.enqueueMessage(message)
    }


    fun dispatchMessage(message: Message) {
        println(message.obj.toString())
    }
}