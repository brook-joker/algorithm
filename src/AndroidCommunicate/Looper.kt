package AndroidCommunicate

import java.lang.RuntimeException

class Looper private constructor() {
    val sMessageQueue: MessageQueue = MessageQueue()

    companion object {
        val sThreadLocal = ThreadLocal<Looper>()

        fun loop() {
            val looper = myLooper()
            val messageQueue = looper?.sMessageQueue
            while (true) {
                val message = messageQueue?.next()
                if (message == null) {
                    return
                }

                message.target?.dispatchMessage(message)
            }

        }

        fun prepare() {
            if (sThreadLocal.get() != null) {
                throw RuntimeException("一个线程一个Looper")
            }
            sThreadLocal.set(Looper())
        }

        fun myLooper(): Looper? = sThreadLocal.get()
    }




}