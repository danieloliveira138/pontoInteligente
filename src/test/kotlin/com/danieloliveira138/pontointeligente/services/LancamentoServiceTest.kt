package com.danieloliveira138.pontointeligente.services

import com.danieloliveira138.pontointeligente.documents.Lancamento
import com.danieloliveira138.pontointeligente.enums.TipoEnum
import com.danieloliveira138.pontointeligente.repositories.LancamentoRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import java.util.Date
import kotlin.collections.ArrayList
import java.lang.Exception

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@RunWith(SpringJUnit4ClassRunner::class)
class LancamentoServiceTest {

    @MockBean
    private val lancamentoRepository: LancamentoRepository? = null

    @Autowired
    private val lancamentoService: LancamentoService? = null

    private val id = "1"

    @Before
    @Throws(Exception::class)
    fun setUp() {
        BDDMockito.given<Page<Lancamento>>(lancamentoRepository?.findByFuncionarioId(id, PageRequest(0,10)))
                .willReturn(PageImpl(ArrayList<Lancamento>()))
        BDDMockito.given(lancamentoRepository?.findOne(id)).willReturn(lancamento())
        BDDMockito.given(lancamentoRepository?.save(Mockito.any(Lancamento::class.java))).willReturn(lancamento())
    }

    @Test
    fun testBucarLancamentoPorFuncionarioPorId() {
        val lancamento: Page<Lancamento>? = lancamentoService?.buscarPorFuncionarioId(id, PageRequest(0, 10))
    }

    fun lancamento() = Lancamento(Date(), TipoEnum.INICIO_TRABALHO, id)
}