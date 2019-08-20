package com.danieloliveira138.pontointeligente.repositories

import com.danieloliveira138.pontointeligente.documents.Lancamento
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.MongoRepository

interface LancamentoRepository : MongoRepository<Lancamento, String> {

    fun findByFuncionarioId(funcionarioId: String, pageRequest: PageRequest): Page<Lancamento>

    fun findOne(id: String): Lancamento?

}