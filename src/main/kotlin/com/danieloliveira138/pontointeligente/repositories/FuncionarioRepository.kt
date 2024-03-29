package com.danieloliveira138.pontointeligente.repositories

import com.danieloliveira138.pontointeligente.documents.Funcionario
import org.springframework.data.mongodb.repository.MongoRepository

interface FuncionarioRepository : MongoRepository<Funcionario, String> {

    fun findByEmail(email: String): Funcionario

    fun findByCpf(cpf: String): Funcionario

    fun findOne(id: String): Funcionario?

}