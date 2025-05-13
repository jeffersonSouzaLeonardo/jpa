package com.algaworks.JpaProjetc.service;

import com.algaworks.JpaProjetc.JpaProjetcApplication;
import com.algaworks.JpaProjetc.jpa.ClienteJpa;
import com.algaworks.JpaProjetc.model.Cliente;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class RemoverClienteMain {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(JpaProjetcApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        ClienteJpa clienteJpa = applicationContext.getBean(ClienteJpa.class);

        clienteJpa.remover(1L);

        Cliente clienteConsultado = new Cliente();
        clienteConsultado = clienteJpa.buscarId(1L);

        System.out.println("Inclusao do Cliente Nome:" + clienteConsultado.getNome());

    }
}
