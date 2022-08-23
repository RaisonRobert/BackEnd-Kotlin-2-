package com.pucpr.puckotlin02

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api")
class Exercicio_02 {
    //    Faça um form/serviço onde o usuário possa entrar com números separados por ';' e o servidor retorne;
//
//
//    Os números em ordem crescente;
//
//    Os números em ordem decrescente;
//
//    Os números pares;
    @GetMapping("number")
    @ResponseBody
    fun number(
        @RequestParam
            (name = "num", required = false, defaultValue = "get") num: String
    ): List<String> {
        val list: MutableList<Int> = convert(num)
        val ordemcrescente = list.sorted()
        val ordemdecrecente = list.sortedDescending()
        val pares = numPar(list)
        return listOf(
            "1-Ordem Crescente $ordemcrescente",
            "2-Ordem Decrescente $ordemdecrecente",
            "3-Números Pares $pares"
        )
    }

    private fun convert(num: String): MutableList<Int> {
        val list: MutableList<Int> = mutableListOf()
        var aux = false
        var number = ""
        num.forEach {
            if (it != ';') {
                number += it
            }else aux = !aux
            if(aux){
                list.add(number.toInt())
                number = ""
                aux = false
            }
        }
        list.add(number.toInt())
        print(list)
        return list
    }

    private fun numPar(list: MutableList<Int>): MutableList<Int> {
        val listaPares: MutableList<Int> = mutableListOf()
        list.forEach{
            if((it%2)==0){
                listaPares.add(it)
            }
        }
        return listaPares
    }
//    @GetMapping("num/{text}")
//    @ResponseBody
//    fun number(@PathVariable text: String): List<Char> {
//                println(text)
//            val list : MutableList<Char> = mutableListOf()
//            text.forEach {
//                if(it != ','){
//                    list.add(it)
//                }
//            }
//        return list.sorted()
//    }

//    fun solution(message: String): String {
//        // write your code in Kotlin 1.3.11 (Linux)
//        var txt: String = ""
//        var caps: Boolean = false
//        message.forEach {
//            if (it == 'C') {
//                caps = !caps
//            }else
//            if (caps) {
//                txt += it.uppercaseChar()
//            }else
//                txt += it
//
//            if (it == 'B') {
//                if (txt.isNotEmpty()) {
//                    txt = txt.take(txt.length - 1)
//                }
//            }
//        }
//            return txt
//
//    }
    }