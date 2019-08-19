package com.danieloliveira138.pontointeligente.services

import com.danieloliveira138.pontointeligente.documents.Funcionario
import com.danieloliveira138.pontointeligente.enums.PerfilEnum
import com.danieloliveira138.pontointeligente.repositories.FuncionarioRepository
import com.danieloliveira138.pontointeligente.utils.SenhaUtils
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class FuncionarioServiceTest {

    @MockBean
    private val funcionarioRepository: FuncionarioRepository? = null
    
    @Autowired
    private val funcionarioService: FuncionarioService? = null

    private val email = "email@email.com"
    private val cpf = "34234855948"
    private val id: String = "1"
    
    @Before
    @Throws(Exception::class)
    fun setUp() {
        BDDMockito.given(funcionarioRepository?.save(Mockito.any(Funcionario::class.java))).willReturn(funcionario())
        BDDMockito.given(funcionarioRepository?.findByCpf(cpf)).willReturn(funcionario())
        BDDMockito.given(funcionarioRepository?.findByEmail(email)).willReturn(funcionario())
    }

    @Test
    fun testPersistirFuncionario() {
        val funcionario: Funcionario? = this.funcionarioService?.persistir(funcionario())
        Assert.assertNotNull(funcionario)
    }

    @Test
    fun testBuscarPorCpf() {
        val funcionario: Funcionario? = this.funcionarioService?.buscarPorCpf(cpf)
        Assert.assertNotNull(funcionario)
    }

    private fun funcionario(): Funcionario =
            Funcionario("Nome", email, SenhaUtils().gerarBcript("123456"),
                    cpf, PerfilEnum.ROLE_USUARIO, id)
}