package AndroidCommunicate

import kotlin.contracts.contract

//p1 == null || p2 == null
inline fun <T1, T2> ifAnyNull(p1: T1?, p2: T2?, block: (T1?, T2?) -> (Unit)) {
    if (p1 != null && p2 != null) return
    block(p1, p2)
}

inline fun <T1, T2, T3> ifAnyNull(p1: T1?, p2: T2?, p3: T3?, block: (T1?, T2?, T3?) -> (Unit)) {
    if (p1 != null && p2 != null && p3 != null) return
    block(p1, p2, p3)
}


inline fun <T1, T2> ifNonNull(p1: T1?, p2: T2?, block: (T1, T2) -> (Unit)) {
    if (p1.isNullOrEmptyString()) return
    if (p2.isNullOrEmptyString()) return
    block(p1, p2)
}


inline fun <T> T?.isNullOrEmptyString(): Boolean {
    contract {
        returns(false) implies (this@isNullOrEmptyString != null)
    }

    return if (this is String) {
        this.isBlank() || this == "null"
    } else {
        this == null
    }
}


inline fun <T1, T2, T3> ifNonNull(p1: T1?, p2: T2?, p3: T3?, block: (T1, T2, T3) -> (Unit)) {
    if (p1.isNullOrEmptyString()) return
    if (p2.isNullOrEmptyString()) return
    if (p3.isNullOrEmptyString()) return
    block(p1, p2, p3)
}

inline fun <T1, T2, T3, T4> ifNonNull(p1: T1?, p2: T2?, p3: T3?, p4: T4, block: (T1, T2, T3, T4) -> (Unit)) {
    if (p1.isNullOrEmptyString()) return
    if (p2.isNullOrEmptyString()) return
    if (p3.isNullOrEmptyString()) return
    if (p4.isNullOrEmptyString()) return
    block(p1, p2, p3, p4)
}


inline fun <T1, T2, T3, T4, T5> ifNonNull(
    p1: T1?,
    p2: T2?,
    p3: T3?,
    p4: T4?,
    p5: T5?,
    block: (T1, T2, T3, T4, T5) -> (Unit)
) {
    if (p1.isNullOrEmptyString()) return
    if (p2.isNullOrEmptyString()) return
    if (p3.isNullOrEmptyString()) return
    if (p4.isNullOrEmptyString()) return
    if (p5.isNullOrEmptyString()) return
    block(p1, p2, p3, p4, p5)
}


//fun <T> ifNonNull(vararg t: T, block: (Array<out T>) -> (Unit)) {
//    for (param in t) {
//        if (param == null)
//            return
//    }
//    block(t)
//}


data class A(
    val a: String?,
    val b: B? = null
)

data class B(
    val c: String? = null
)

fun main(args: Array<String>) {
    val a = A("test", B())
    val b = 2
    val c = 1

    ifAnyNull(b,c){ i: Int?, i1: Int? ->
        println("hello,world")
    }

//    ifNonNull(a, a.b) { p1, p2 ->
//        println(p1)
//        println(p2)
//    }

//    ifNonNull(a, a.a, a.b) { a: A, s: String, b: B ->
//        println(a)
//        println(s)
//        println(b)
//    }
//
//    ifNonNull(a, a.a, a.b, a.b?.c) { a: A, s: String, b: B, s1: String? ->
//        println(a)
//        println(s)
//        println(b)
//        println(s1)
//    }

//    for (i in 0..9) {
//        Thread(Runnable {
//            Looper.prepare()
//            val handler = Handler()
//            val message = Message()
//            message.obj = Thread.currentThread().toString() + i
//            handler.sendMessgae(message)
//            Looper.loop()
//        }).start()
//
//    }

}