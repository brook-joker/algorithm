package AndroidCommunicate

fun main(args: Array<String>) {
    for (i in 0..9) {
        Thread(Runnable {
            Looper.prepare()
            val handler = Handler()
            val message = Message()
            message.obj = Thread.currentThread().toString() + i
            handler.sendMessgae(message)
            Looper.loop()
        }).start()

    }

}