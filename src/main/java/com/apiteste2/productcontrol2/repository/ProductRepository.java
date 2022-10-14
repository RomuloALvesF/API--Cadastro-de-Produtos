package com.apiteste2.productcontrol2.repository;

import com.apiteste2.productcontrol2.model.ProductModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ProductRepository extends CrudRepository<ProductModel, Integer> {

    //Listar produtos
    List<ProductModel> findAll();

    //pesquisar por codigo
    ProductModel findByCodigo(int codigo);

    //Remover
    void delete(ProductModel produto);

    //Cadastro/Alteração

    <ProdMod extends ProductModel> ProdMod save(ProdMod produto);
}
