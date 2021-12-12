package com.codanalise.controller;

import com.codanalise.model.Aula;
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

    @Autowired
    AulaController ac;

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
        Aula aula = new Aula();
        pagamento.setHora(LocalDateTime.now(ZoneId.of("America/Recife")));
        aula.setPagamento(pagamento);
        aula.setId_mentor(pagamento.getMentor_pag().getId());
        aula.setId_usuario(pagamento.getAluno().getId());
        ac.cadastraAula(aula);

        return pag.save(pagamento);
    }
    }
