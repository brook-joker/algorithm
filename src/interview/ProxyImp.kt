package interview

class ProxyImp : ProxyInterface {
    override fun test(str: String): String {
        println("实现了test$str")
        return "任务完成！"
    }

}