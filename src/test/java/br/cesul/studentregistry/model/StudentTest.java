package br.cesul.studentregistry.model;

/*
* Passo a passo para desenvolver um teste:
* 1 - Pensar no CONTRATO (o que a entidade deve garantir?).
*       "Ao nascer, Student tem um ID gerado, Strings Vazias, nota 0.0 e ativo = true"
*
* 2 - Escrever o teste primeiro (RED)
*       Expressar este contrato no teste "defaultConstructor_initializeFields"
*       Rodamos o teste e ele falhará por que ainda não temos a classe implementada
*
* 3 - Implementa o mínimo para passar no teste (GREEN)
*       Implemente um Student com o construtor e os getters/setters
*
* 4 - Refatora (Sem mudar comportamento)
*       Refinar, otimizar, nomear melhor, limpar o código, pensar em desempenho...
*       Sempre mantendo os teses passando
*
* Por que testar o model primeiro?
*   - É a parte mais estável e sem dependências (sem UI, banco, threads)
*   - Erros encontrados aqui são fáceis de consertar
*   - Os contratos fechados nas classes de domínio, sustentam os testes das camadas superiores
* */

// Import estático para deixar asserts mais legíveis
import static org.junit.jupiter.api.Assertions.*;

/*
* Padrão AAA para testes:
* - Arrange (Preparar) - Cria dados e contexto necessários para a ação
* - Act (Agir) - Chamamos um comportamento específico do objeto testado
* - Assert (Afirmar) - Compara o resultado obtido com o resultado esperado
*
* Por que é importante deixar apenas uma ação por teste?
* - Para que a falha conte uma história clara
* - Evitar muitas verificações num teste só, ou seja, testes que quebram por múltiplas razões
* */
public class StudentTest {

}
