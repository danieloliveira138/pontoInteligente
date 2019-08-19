package com.danieloliveira138.pontointeligente.utils

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class SenhaUtilsTest {

    private val SENHA = "123456"
    private val bCryptEncoder = BCryptPasswordEncoder()

    @Test
    fun testGerarHashSenha() {
        val hash = SenhaUtils().gerarBcript(SENHA)
        Assert.assertTrue(bCryptEncoder.matches(SENHA, hash))
    }

}