package com.codanalise.controller;

import com.codanalise.model.Pagamento;
import com.codanalise.model.Usuario;
import com.codanalise.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    PagamentoRepository pag;

    @GetMapping
    public List<Pagamento> listarPagamentos(){
        return pag.findAll();
    }

//    @GetMapping("/{id}")
//    public Optional<Pagamento> listarPagamentos(@PathVariable Long id){
//
//
////    return  pag.PagamentoComRelacionamentos(id);
//    }

    @PostMapping
    public Pagamento efetuaPagamento(@RequestBody Pagamento pagamento){
        pagamento.setHora(LocalDateTime.now(ZoneId.of("America/Recife")));

        return pag.save(pagamento);
    }
}
