package ktexpense

class CompanionObject {
    fun getGoogMan(): String {
        return man
    }
    companion object {
        private val man = "我是最帅的,不接受反驳！"
    }
}