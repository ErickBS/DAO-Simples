/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarefa.pkg05;

import java.io.IOException;
import static java.lang.String.valueOf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Erick Stella
 */
class ListaContatos {

    List<Contato> listarContatos() throws SQLException, IOException, Exception {
        
        List<Contato> lista = new ArrayList<Contato>();
        try (Connection con = ConnectionFactory1.getConnection();
                PreparedStatement stmt = con.prepareStatement(
                "select id, nome, telefone, idade, genero, data_de_nasc from contato ")
                )
        {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Contato contato = new Contato();
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString(2));
                contato.setTelefone(rs.getString("telefone"));
                contato.setIdade(rs.getInt("idade"));
                contato.setGenero(rs.getString("genero"));
                contato.setData_de_nasc(rs.getDate("data_de_nasc").toLocalDate());
                contato.setTelefone(rs.getString("telefone"));
                lista.add(contato);
            }
        }
        return lista;
    }

    void excluirContato(Contato contato) throws SQLException, IOException {
        try (Connection con = ConnectionFactory1.getConnection();
            PreparedStatement stmt = con.prepareStatement(
            "delete from contato where nome = ? ")
            )
        {
            stmt.setString(1, contato.getNome());
            stmt.executeUpdate();
        }

    }

    void alterarDados(Contato contato) throws SQLException, IOException, Exception {
        Scanner sc = new Scanner(System.in);
        int id, idade;
        String opcao = null, coluna = null;
        List<Contato> lista = listarContatos();
        for (Contato rs:lista){
            id = rs.getId();
            String nome = rs.getNome();
            String genero = rs.getGenero();
            idade = rs.getIdade();
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
            System.out.println("\nQual usuario gostaria de alterar?");
            id = sc.nextInt(); 
            System.out.println("\nO que deseja alterar?"
                    + "\n1. Nome."
                    + "\n2. Telefone."
                    + "\n3. Genero."
                    + "\n4. Data de Nascimento.");
            switch (sc.nextInt()) {
                case 1 -> {
                    coluna = "nome";
                    System.out.println("\nPor favor, digite o nome da pessoa.");
                    opcao = sc.next();
                    lista.get(id-1).setNome(opcao);
                }
                case 2 -> {
                    coluna = "telefone";
                    System.out.println("\nPor favor, digite o telefone da pessoa.");
                    opcao = sc.next();
                    lista.get(id-1).setTelefone(opcao);
                }
                case 3 -> {
                    coluna = "genero";
                    System.out.println("\nPor favor, digite o genero da pessoa. (\"M\" ou \"F\").");
                    opcao = sc.next();
                    lista.get(id-1).setGenero(opcao);
                }
                case 4 ->{
                    System.out.println("\nPor favor, digite a data de nascimento da pessoa. (Modelo: AAAA-MM-DD)");
                    opcao = sc.next();
                    lista.get(id-1).setData_de_nasc(LocalDate.parse(opcao));
                    int year = Year.now().getValue();
                    idade = year - lista.get(id-1).getData_de_nasc().getYear();
                    lista.get(id-1).setIdade(idade);
                    coluna = "idade = " + idade + ", data_de_nasc";
                }
                default ->{
                    System.out.println("\nOpcao invalida!");
                }
            }
        try (Connection con = ConnectionFactory1.getConnection();
            PreparedStatement stmt = con.prepareStatement(
            "update contato set " + coluna + " = ? where id = "+ id);
            )
        {
            stmt.setString(1, opcao);
            System.out.println(stmt);
            stmt.executeUpdate();
        }
    }

    void incluirContato(Contato contato) throws SQLException, IOException {

        try (Connection con = ConnectionFactory1.getConnection();
                PreparedStatement stmt = con.prepareStatement(
                "insert into contato (id, nome, telefone, idade, genero, data_de_nasc) VALUES (?, ?, ?, ? ,?, ?)");
                PreparedStatement id = con.prepareStatement (
                "select max(id) as id from contato ")
                )
        {
            ResultSet rs = id.executeQuery();
            while (rs.next()) {
                int newId = rs.getInt("id") + 1; 
                stmt.setString(1, valueOf(newId));
                stmt.setString(2, contato.getNome());
                stmt.setString(3, contato.getTelefone());
                stmt.setString(4, valueOf(contato.getIdade()));
                stmt.setString(5, contato.getGenero());
                stmt.setString(6, valueOf(contato.getData_de_nasc()));
            }
            stmt.executeUpdate();
        }
    }    
}
