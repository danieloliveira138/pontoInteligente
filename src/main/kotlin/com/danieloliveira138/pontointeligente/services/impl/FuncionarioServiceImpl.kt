package com.danieloliveira138.pontointeligente.services.impl

import com.danieloliveira138.pontointeligente.documents.Funcionario
import com.danieloliveira138.pontointeligente.repositories.FuncionarioRepository
import com.danieloliveira138.pontointeligente.services.FuncionarioService
import org.springframework.stereotype.Service

@Service
class FuncionarioServiceImpl(val funcionarioRepository: FuncionarioRepository) : FuncionarioService {

    override fun persistir(funcionario: Funcionario): Funcionario =
            funcionarioRepository.save(funcionario)

    override fun buscarPorCpf(cpf: String): Funcionario? = funcionarioRepository.findByCpf(cpf)

    override fun buscarPorEmail(email: Funcionario): Funcionario? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun buscarPorId(id: String): Funcionario? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}