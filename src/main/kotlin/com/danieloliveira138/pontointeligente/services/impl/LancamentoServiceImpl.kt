package com.danieloliveira138.pontointeligente.services.impl

import com.danieloliveira138.pontointeligente.documents.Lancamento
import com.danieloliveira138.pontointeligente.repositories.LancamentoRepository
import com.danieloliveira138.pontointeligente.services.LancamentoService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class LancamentoServiceImpl(val lancamentoRepository: LancamentoRepository) : LancamentoService {

    override fun buscarPorFuncionarioId(funcionarioId: String, pageRequest: PageRequest): Page<Lancamento> =
            lancamentoRepository.findByFuncionarioId(funcionarioId, pageRequest)

    override fun buscarPorId(id: String): Lancamento? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun persistir(lancamento: Lancamento): Lancamento {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun remover(id: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}