package br.cesul.studentregistry.util;

/*
* Final é para indicar que não será herdada, ou seja,
* é só um conjunto de funções puras
* */
public final class Validators {
    // Denota que esta classe é escrita e não precisa de instâncias
    private Validators(){}

    /*
    * 1 - Checar null
    * 2 - Remover espaços das pontas
    * 3 - Verifico se sobrou algo
    * */
    public static boolean notBlank(String s) {
        return s != null && !s.trim().isEmpty();
    }
}
