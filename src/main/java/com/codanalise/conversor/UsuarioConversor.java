package com.codanalise.conversor;

import com.codanalise.dto.UsuarioDTO;
import com.codanalise.dto.UsuarioNomeDTO;
import com.codanalise.model.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioConversor {

    public UsuarioDTO usuarioParaDTO(Usuario usuario){
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setSobrenome(usuario.getSobrenome());
        dto.setEmail(usuario.getEmail());

        return dto;
    }

    public List<UsuarioDTO> usuarioParaDTO(List<Usuario> usuario){
        return  usuario.stream().map(x -> usuarioParaDTO(x)).collect(Collectors.toList());
    }



    public Usuario dtoParaUsuario(UsuarioDTO dto){
        Usuario usu = new Usuario();
        usu.setId(dto.getId());
        usu.setNome(dto.getNome());
        usu.setSobrenome(dto.getSobrenome());
        usu.setEmail(dto.getEmail());

        return usu;
    }


    public List<Usuario> dtoParaUsuario(List<UsuarioDTO> dto){
        return dto.stream().map(x -> dtoParaUsuario(x)).collect(Collectors.toList());
    }


    public UsuarioNomeDTO usuarioParaDtoNome(Usuario usuario){
        UsuarioNomeDTO dto = new UsuarioNomeDTO();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setSobrenome(usuario.getSobrenome());

        return dto;
    }

    public List<UsuarioNomeDTO> usuarioNomeDTOList(List<Usuario> usuario){
        return usuario.stream().map(x -> usuarioParaDtoNome(x)).collect(Collectors.toList());
    }


    public Usuario usuarioNomeDtoParaUsuario(UsuarioNomeDTO nomeDTO){
        Usuario usuario = new Usuario();
        usuario.setId(nomeDTO.getId());
        usuario.setNome(nomeDTO.getNome());
        usuario.setSobrenome(nomeDTO.getSobrenome());
        return usuario;
    }

    public List<Usuario> usuarioNomeDtoParaUsuarioList(List<UsuarioNomeDTO> nomeDTO){
        return nomeDTO.stream().map(x -> usuarioNomeDtoParaUsuario(x)).collect(Collectors.toList());
    }

}
