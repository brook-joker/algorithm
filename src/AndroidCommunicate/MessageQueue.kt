package AndroidCommunicate

import java.util.concurrent.ArrayBlockingQueue

class MessageQueue {

    val queue = ArrayBlockingQueue<Message>(10)

    //消息入队列
    fun enqueueMessage(message: Message) {
        queue.put(message)
    }

    //取消息
    fun next(): Message? {
        return queue.take()
    }

}