package com.obomprogramador.fatoracao
fun fatorar (numero: Long) : String {
    var resultado : String = ""
    var sinalUltimo = 1
    if (numero == 0L) {
        resultado= "0"
    } else {
        if (numero in 1..2) {
            resultado = numero.toString()
        } else {
            var valor = numero
            if (numero < 0) {
                sinalUltimo = -1
                valor = numero * -1
            }
            var primos : List<Long> = gerarPrimos(valor)
            resultado = calcular(valor, primos, sinalUltimo)
        }
    }

    return resultado
}

fun calcular(numero: Long, primos: List<Long>, sinalUltimo: Int): String {
    val resultado = StringBuilder()
    val it = primos.iterator()
    var primo = it.next()
    var valor = numero
    while (valor > 1) {
        val resto = valor % primo
        if (resto > 0) {
            primo = it.next()
        } else {
            if (resultado.length > 0) {
                resultado.append("x")
            }
            valor /= primo
            if (valor == 1L) {
                primo = primo * sinalUltimo
            }
            resultado.append(primo)
        }
    }
    return resultado.toString()
}
