package com.danieloliveira138.pontointeligente.services

import com.danieloliveira138.pontointeligente.documents.Empresa

interface EmpresaService {

    fun buscarPorCnpj(cnpj: String): Empresa?

    fun persistir(empresa: Empresa): Empresa

}