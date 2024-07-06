/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarefa.pkg05;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Erick Stella
 */
public class Tarefa05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, IOException, Exception {
        
        Contato contato = new Contato();
        ListaContatos contatos = new ListaContatos();

        boolean exit = false;
        int option;
        Scanner sc = new Scanner(System.in);
        
        do {
            System.out.println("\nOla! O que voce gostaria de fazer?\n"
                    + "1. Alterar dados de um contato.\n"
                    + "2. Excluir um contato.\n"
                    + "3. Listar todos os contatos.\n"
                    + "4. Adicionar um contato.\n"
                    + "5. Fechar sistema.");
            option = sc.nextInt();
            switch (option) {
                case 1 -> {
                    System.out.println("\nPor favor, digite o nome da pessoa.");
                    contatos.alterarDados(contato);
                }
                case 2 -> {
                    System.out.println("\nPor favor, digite o nome da pessoa.");
                    contato.setNome(sc.next());
                    contatos.excluirContato(contato);
                }
                case 3 -> {
                    List<Contato> lista = contatos.listarContatos();
                    for (Contato rs:lista){
                        int id = rs.getId();
                        String nome = rs.getNome();
                        String genero = rs.getGenero();
                        int idade = rs.getIdade();
                        String telefone = rs.getTelefone();
                        LocalDate data_de_nasc = rs.getData_de_nasc();
                        System.out.println("id:"+id);
                        System.out.println("Nome: "+nome);
                        System.out.println("Telefone: "+telefone);
                        System.out.println("Idade: "+idade);
                        System.out.println("Genero: "+genero);
                        System.out.println("Data de Nascimento: "+data_de_nasc);
                        System.out.println("==========");
                    }
                }
                case 4 -> {
                    contato.novoContato();
                    contatos.incluirContato(contato);
                }
                case 5 -> {
                    System.out.println("Bye!");
                    exit = true;
                }
                default -> {
                    System.out.println("Opcao invalida!");
                }
            }
        } while (!exit);
        /*try (Connection con = ConnectionFactory1.getConnection();
                PreparedStatement stmt = con.prepareStatement(
                "select id, nome, genero from contato ")
                )
        {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString(2);
                String gender = rs.getString("genero");
                System.out.println("id:"+id);
                System.out.println("Nome:"+name);
                System.out.println("Genero:"+gender);
                System.out.println("==========");
            }
        }*/
        /*PreparedStatement stmt = con.prepareStatement(
            "select employee_id, first_name, gender from employee_demographics "
                    + "where gender = ?");
        stmt.setString(1, "Female");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("employee_id");
            String name = rs.getString(2);
            String gender = rs.getString("gender");
            System.out.println("id:"+id);
            System.out.println("Nome:"+name);
            System.out.println("Gender:"+gender);
            System.out.println("==========");
        }*/
        
        /*PreparedStatement stmt = con.prepareStatement(
            "update employee_demographics set gender=? "
            + "where employee_id = ?");
        stmt.setString (1, "Female");
        stmt.setLong(2, 1);
        stmt.executeUpdate();*/
        
        /*PreparedStatement stmt = con.prepareStatement(
            "delete from employee_demographics where first_name = ? ");
        stmt.setString(1, "Leslie");
        
        stmt.executeUpdate();
        
        stmt.close();
        con.close();
        */
        System.out.println("Alteracao feita");
    }
    
}
