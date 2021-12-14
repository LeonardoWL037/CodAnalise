package com.codanalise.controller;

import com.codanalise.dto.ContatoDTO;
import com.codanalise.model.Aula;
import com.codanalise.model.Pagamento;
import com.codanalise.repository.MentorRepository;
import com.codanalise.repository.PagamentoRepository;
import com.codanalise.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    PagamentoRepository pag;

    @Autowired
    AulaController ac;

    @Autowired
    UsuarioRepository ur;

    @Autowired
    MentorRepository mr;

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
        ContatoDTO contato = new ContatoDTO();
        pagamento.setHora(LocalDateTime.now(ZoneId.of("America/Recife")));
        aula.setPagamento(pagamento);
        aula.setId_mentor(pagamento.getMentor_pag().getId());
        aula.setId_usuario(pagamento.getAluno().getId());
        ac.cadastraAula(aula);




        return pag.save(pagamento);
    }
    }
