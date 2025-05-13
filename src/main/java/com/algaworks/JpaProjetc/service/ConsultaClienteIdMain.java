package com.algaworks.JpaProjetc.service;

import com.algaworks.JpaProjetc.JpaProjetcApplication;
import com.algaworks.JpaProjetc.jpa.ClienteJpa;
import com.algaworks.JpaProjetc.model.Cliente;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaClienteIdMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(JpaProjetcApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        ClienteJpa clienteJpa = applicationContext.getBean(ClienteJpa.class);

        Cliente clienteConsultado = clienteJpa.buscarId(1L);

        System.out.println("Cliente consultado " + clienteConsultado.getId() + " - " + clienteConsultado.getNome());

    }
}
