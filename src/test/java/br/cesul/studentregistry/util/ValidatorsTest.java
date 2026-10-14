package br.cesul.studentregistry.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

/*
* O que a VM vai precisar decidir?
* R.: Validar entradas
*   - Nome não pode ser vazio
*   - E-mail tem que ter formato padrão
*   - Nota tem que ser entre 0 e 10
* Como testar funções abertas, com diversas possibilidades?
*   - Para cada função devemos listar vários exemplos de entradas e saídas esperadas.
*     Ao invés de escrever 10 testes iguais, mudando só os valores do arrange, utilizamos
*     um teste PARAMETRIZADO, ou seja, um teste que roda X vezes, mas cada uma com um conjunto
*     de dados diferentes.
* */
public class ValidatorsTest {
    // notBlank -> será true se não é null e tem algo além de espaços

    @ParameterizedTest
    @DisplayName("notBlank deve detectar strings válidas/inválidas")
    @CsvSource(
            value = {
                    // FORMATO DE CADA LINHA: "ENTRADA, RESULTADO_ESPERADO"
                    // Casos válidos (espera = true)
                    "'abc', true", // Exemplo de texto normal
                    "' x', true", // Tem espaços mas também conteúdo

                    // Casos inválidos (espera = false)
                    "'  ', false", // Só espaços
                    "'', false", // Vazio
                    "null, false" // null real
            }, nullValues = {"null"} // Isso transforma a palavra 'null' do CSV em valor null de verdade
    )
    void notBlank_tests(String input, boolean expected) {
        boolean result = Validators.notBlank(input);
        assertEquals(expected, result, () -> "notBlank('" + input + "') deveria ser " + expected);
    }
}
