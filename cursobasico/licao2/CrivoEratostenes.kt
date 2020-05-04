package com.obomprogramador.fatoracao
fun gerarPrimos (limite: Long) : MutableList<Long> {
    val lprimos: MutableList<Long> = mutableListOf<Long>()
    for (x in 2..limite) {
        lprimos.add(x.toLong())
    }
    var p: Long = 2
    while ((p*p) <= limite) {
        var m = 2
        while ((m*p) <= limite) {
            for (primo in lprimos) {
                if (primo == (m * p)) {
                    lprimos.remove(primo)
                    break
                }
            }
            m++
        }
        for (primo in lprimos) {
            if (primo > p) {
                p = primo
                break
            }
        }
    }
    return lprimos

}
