package com.danieloliveira138.pontointeligente.services

import com.danieloliveira138.pontointeligente.documents.Funcionario
import org.springframework.stereotype.Service

interface FuncionarioService {

    fun persistir(funcionario: Funcionario): Funcionario

    fun buscarPorCpf(cpf: String): Funcionario?

    fun buscarPorEmail(email: Funcionario): Funcionario?

    fun buscarPorId(id: String): Funcionario?

}