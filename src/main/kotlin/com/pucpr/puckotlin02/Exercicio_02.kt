package com.pucpr.puckotlin02

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.websocket.server.PathParam
import javax.xml.stream.events.Characters


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
    fun number (@RequestParam
                    (name = "num", required = false, defaultValue = "get") num: String): List<String>{
    val list : MutableList<Char> = mutableListOf()
    num.forEach {
        if(it !=';'){
            list.add(it)
        }
    }
    val ordemcrescente = list.sorted()
    val ordemdecrecente = list.sortedDescending()
    val pares = numPar(list)
    val result = listOf("1-Ordem Crescente $ordemcrescente","2-Ordem Decrescente $ordemdecrecente", "3-Números Pares $pares")
    return result
    }

    private fun numPar(list: MutableList<Char>): MutableList<Char> {
        val listaPares: MutableList<Char> = mutableListOf()
        list.forEach{
            if((Character.digit(it,10)%2)==0){
                listaPares.add(it)
            }
        }
        print(listaPares)
        print(list)
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