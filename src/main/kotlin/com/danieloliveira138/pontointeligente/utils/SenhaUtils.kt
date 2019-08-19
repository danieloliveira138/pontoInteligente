package com.danieloliveira138.pontointeligente.utils

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class SenhaUtils {

    fun gerarBcript(senha: String): String = BCryptPasswordEncoder().encode(senha)

}