/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarefa.pkg05;

import java.time.LocalDate;
import java.time.Year;
import java.util.Date;
import java.util.Scanner;
import javax.swing.DebugGraphics;

/**
 *
 * @author Erick Stella
 */
class Contato {
    
    public int id, idade;
    String nome, telefone, genero;
    LocalDate data_de_nasc;

    public Contato novoContato() throws Exception {
        
        Scanner sc = new Scanner (System.in);
        System.out.println("\nPor favor, digite o nome da pessoa.");
        setNome(sc.next());

        System.out.println("\nPor favor, digite o telefone da pessoa.");
        setTelefone(sc.next());

        System.out.println("\nPor favor, digite o genero da pessoa. (\"M\" ou \"F\").");
        setGenero(sc.next());

        System.out.println("\nPor favor, digite a data de nascimento da pessoa. (Modelo: AAAA-MM-DD)");
        setData_de_nasc(LocalDate.parse(sc.next()));

        int year = Year.now().getValue();
        setIdade(year - getData_de_nasc().getYear());
        
        return this;
        
    }
    
    public int getId()  {
        return id;
    }

    public void setId(int id) throws Exception {
        if (id <= 0) throw new RuntimeException("Id invalido!");
        this.id = id;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) throws Exception {
        if (idade <= 0) throw new RuntimeException("Idade invalida!");
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        if (nome == null || nome.equals("")) throw new RuntimeException("Por favor, preencha o nome!");
        if (nome.length() > 50) throw new RuntimeException("Nome muito comprido!");
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) throws Exception {
        if (telefone == null || telefone.equals("")) throw new RuntimeException("Por favor, preencha o telefone!");
        if (telefone.length() != 11 && telefone.length() != 10) throw new RuntimeException("Telefone invalido! Digite apenas os numeros, primeiro o DDD e depois o numero.");
        this.telefone = telefone;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) throws Exception {
        if (genero == null || genero.equals("")) throw new RuntimeException("Por favor, preencha o genero!");
        if (genero.length() != 1 || (!genero.equals("M") && !genero.equals("F"))) throw new RuntimeException ("Por favor, digite apenas M ou F");
        this.genero = genero;
    }

    public LocalDate getData_de_nasc() {
        return data_de_nasc;
    }

    public void setData_de_nasc(LocalDate data_de_nasc) throws Exception {
        this.data_de_nasc = data_de_nasc;
    }
    
}
