package com.danieloliveira138.pontointeligente.services

import com.danieloliveira138.pontointeligente.documents.Empresa
import com.danieloliveira138.pontointeligente.repositories.EmpresaRepository
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import java.lang.Exception

@SpringBootTest
@RunWith(SpringRunner::class)
class EmpresaServiceTest {


    @MockBean
    private val empresaRepository: EmpresaRepository? = null

    @Autowired
    val empresaService: EmpresaService? = null

    private val CNPJ = "51463645000100"

    @Before
    @Throws(Exception::class)
    fun setUp() {
        BDDMockito.given(empresaRepository?.findByCnpj(CNPJ)).willReturn(empresa())
        BDDMockito.given(empresaRepository?.save(empresa())).willReturn(empresa())
    }

    @Test
    fun testBuscarEmpresaPorCNPJ() {
        val empresa: Empresa? = empresaService?.buscarPorCnpj(CNPJ)
        Assert.assertNotNull(empresa)
    }

    @Test
    fun testPersistirEmpresa() {
        val empresa: Empresa? = empresaService?.persistir(empresa())
        Assert.assertNotNull(empresa)
    }

    private fun empresa(): Empresa = Empresa("Empresa Test", CNPJ, "1")
}