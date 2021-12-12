package com.codanalise.repository;

import com.codanalise.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    @Query("select p from Pagamento p where p.mentor_pag = ?1")
    List<Pagamento> findPagamentoByMentor_pag(long id);

    @Query("select p from Pagamento p where p.aluno = ?1")
    List<Pagamento> findPagamentoByAluno(long id);
//    @Query("select pag from Usuario u, pagamento pag, proposta prop, mentor, postagem  post\n" +
//            "where pag.proposta_id = prop.id and prop.mentor_id = mentor.id and post.autor_id = u.id and post.id = 2  and prop.postagem_id = post.id")
//    public List<Pagamento> findPagamentoByUsuario_id();
//    @Query(nativeQuery = true, "select  pag,u.id as uid, u.nome , u.sobrenome, post.id as post_id , mentor.id as mentorId\n" +
//            "from Usuario u, Pagamento as pag, Proposta as prop, Mentor as mentor, Postagem  as post\n" +
//            "where pag.proposta = Proposta and prop.mentor = mentor and post.autor = u and post.id = :id  and prop.postagem_id = post.id")
//    public String PagamentoComRelacionamentos(@Param("id") Long id);

//   public final static String FIND_WITH_QUERY = "select  pag.*,u.id uid, u.nome , u.sobrenome, post.id post_id , mentor.id mentorId\n" +
//           "from Usuario u, pagamento pag, proposta prop, mentor, postagem  post\n" +
//           "where pag.proposta_id = prop.id and prop.mentor_id = mentor.id and post.autor_id = u.id and post.id = 2  and prop.postagem_id = post.id";
//
//    @Query(name = FIND_WITH_QUERY, nativeQuery = true)
//    public String[][] PagamentoComRelacionamentos(@Param("id") Long id);


//        @Query("select  Pagamento\n" +
//                "from Usuario, Pagamento, Proposta , Mentor , Postagem \n" +
//                "where Pagamento.proposta.id = Proposta.id and Proposta.mentor.id = Mentor.id and Postagem.autor.id = Usuario.id and Postagem.id = :id  and Proposta.postagem_id = Postagem.id")
//            public Optional<Pagamento> PagamentoComRelacionamentos(@Param("id") Long id);


}
