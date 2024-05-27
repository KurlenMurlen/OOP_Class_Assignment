package model;

import java.util.Date;
import java.util.Scanner;

public class Admin extends Pessoa {
//crystofer ama benga preta
    public Admin(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    @Override
    public String capturarDados() {
        return "Nome: " + getNome() + "\n" +
                "E-mail: " + getEmail() + "\n";
    }


    public static Admin capturarInformacoesAdmin(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        return new Admin(nome, email, senha);
    }

    private static Date parseDate(String dateStr) {
        return new Date();
    }
}

