package com.danieloliveira138.pontointeligente.services.impl

import com.danieloliveira138.pontointeligente.documents.Empresa
import com.danieloliveira138.pontointeligente.repositories.EmpresaRepository
import com.danieloliveira138.pontointeligente.services.EmpresaService
import org.springframework.stereotype.Service

@Service
class EmpresaServiceImpl(val empresaRepository: EmpresaRepository) : EmpresaService {

    override fun buscarPorCnpj(cnpj: String): Empresa? = empresaRepository.findByCnpj(cnpj)

    override fun persistir(empresa: Empresa): Empresa = empresaRepository.save(empresa)

}