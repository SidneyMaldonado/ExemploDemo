package com.example.demo.controllers;


import com.example.demo.Mensagem;
import com.example.demo.entities.Cliente;
import com.example.demo.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cliente")
public class ClienteController
{

    @Autowired // instanciar o clienteRepository automaticamente
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listar(){
        List<Cliente> lista = clienteRepository.findBySituacao(true);
        return lista;
    }

    @GetMapping("{id}")
    public Cliente buscar(@PathVariable Integer id ){
        System.out.println("Variavel id recuparada da url: " + id);
        Cliente cliente = clienteRepository.findById(id).get();
        return cliente;
    }

    @PostMapping
    public Mensagem incluir( @RequestBody Cliente cliente ){
        System.out.println("Incluindo cliente:" + cliente.getNome());
        cliente.setIdCliente(0);
        clienteRepository.save(cliente);
        clienteRepository.flush();

        Mensagem msg = new Mensagem();
        msg.setMensagem("OK");
        return msg;
    }

    @PutMapping
    public Mensagem alterar(@RequestBody Cliente cliente){
        System.out.println("alterando cliente: " + cliente.getNome());
        clienteRepository.save(cliente);
        clienteRepository.flush();

        Mensagem msg = new Mensagem();
        msg.setMensagem("OK");
        return msg;
    }

    @DeleteMapping
    public Mensagem deletar(@RequestBody Cliente cliente){

        Cliente excluir = clienteRepository.findById(cliente.getIdCliente()).get();
        excluir.setSituacao(false);
        clienteRepository.save(excluir);
        clienteRepository.flush();

        Mensagem msg = new Mensagem();
        msg.setMensagem("OK");
        return msg;
    }

    @DeleteMapping("{id}")
    public Mensagem deletar(@PathVariable Integer id){

        Cliente excluir = clienteRepository.findById(id).get();
        excluir.setSituacao(false);
        clienteRepository.save(excluir);
        clienteRepository.flush();

        Mensagem msg = new Mensagem();
        msg.setMensagem("OK2");
        return msg;

    }

    public Mensagem buscaNome() {
        Mensagem msg = new Mensagem();
        msg.setMensagem("OK2");
        return msg;
    }
}
