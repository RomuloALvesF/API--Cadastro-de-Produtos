package com.apiteste2.productcontrol2.controller;

import com.apiteste2.productcontrol2.model.ProductModel;
import com.apiteste2.productcontrol2.model.ReturnModel;
import com.apiteste2.productcontrol2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    //Ações
    @Autowired
    private ProductRepository action;

    //Listar produtos
    @RequestMapping(value = "/produtos", method = RequestMethod.GET)
    public @ResponseBody List<ProductModel> listar() {
        return action.findAll();
    }

    //Cadastrar
    @RequestMapping(value = "/produtos", method = RequestMethod.POST)
    public @ResponseBody ProductModel cadastrar(@RequestBody ProductModel produto) {
        return action.save(produto);
    }

    //Filtrar
    @RequestMapping(value = "/produtos/{cod}", method = RequestMethod.GET)
    public @ResponseBody ProductModel filtrar(@PathVariable Integer cod) {
        return action.findByCodigo(cod);
    }

    //Alterar
    @RequestMapping(value = "/produtos", method = RequestMethod.PUT)
    public @ResponseBody ProductModel alterar(@RequestBody ProductModel produto) {
        return action.save(produto);
    }

    //Remover
    @RequestMapping(value = "/produtos/{cod}", method = RequestMethod.DELETE)
    public @ResponseBody ReturnModel remover(@PathVariable Integer cod) {
        ReturnModel resposta = new ReturnModel();

        try {
            ProductModel produto = filtrar(cod);
            this.action.delete(produto);
            resposta.setMessenger("Produto Removido");
        } catch (Exception erro) {
            resposta.setMessenger("Falha ao remover!" + erro.getMessage());
        }
        return resposta;
    }
}
