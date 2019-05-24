package ktexpense

class LocalFunctions {

    /**
     * 这样写会生成一个Function对象
     * 每次test被调用的时候都会new Function
     */
//    fun test(a: Int): Int {
//        fun sumSquare(b: Int) = (a + b) * (a + b)
//        return sumSquare(1) + sumSquare(2)
//    }


    /**
     * 不会每次调用都去newFunction对象
     * 只会在static块new一次
     */
    fun goodTest(a: Int): Int {
        fun sumSquare(a: Int, b: Int) = (a + b) * (a + b)
        return sumSquare(a, 1) + sumSquare(a, 2)
    }


}