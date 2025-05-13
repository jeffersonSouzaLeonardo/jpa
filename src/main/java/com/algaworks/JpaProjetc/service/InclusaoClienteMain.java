package com.algaworks.JpaProjetc.service;

import com.algaworks.JpaProjetc.JpaProjetcApplication;
import com.algaworks.JpaProjetc.jpa.ClienteJpa;
import com.algaworks.JpaProjetc.model.Cliente;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class InclusaoClienteMain {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(JpaProjetcApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        ClienteJpa clienteJpa = applicationContext.getBean(ClienteJpa.class);


        Cliente cliente = new Cliente();
        cliente.setNome("Maria Cristina");

        Cliente clienteNovo = clienteJpa.salvar(cliente);
        System.out.println("Inclusao do Cliente id:" + clienteNovo.getId());

    }
}
