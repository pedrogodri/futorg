package com.br.futorg.api.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.br.futorg.api.model.Aluno;
import com.br.futorg.api.model.Endereco;
import com.br.futorg.api.model.Mensagem;
import com.br.futorg.api.repositories.AlunoRepository;
import com.br.futorg.api.repositories.EnderecoRepository;
import com.br.futorg.api.services.interfaces.IAlunoService;

@Service
public class AlunoService implements IAlunoService{

    @Autowired
    private Mensagem mensagem;

    @Autowired
    private AlunoRepository repository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public ResponseEntity<?> listar() {
        try {
            var lista = repository.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            mensagem.setMensagem("Não foi possível listar os alunos.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);  
        }
    }

    @Override
    public ResponseEntity<?> cadastrar(Aluno aluno) {
        try {
            if(aluno.getEndereco() != null){
                boolean existeEmailAluno = repository.findByEmail(aluno.getEmail());
                boolean existeCpfAluno = repository.findByCpf(aluno.getCpf());
                if(existeCpfAluno){
                    mensagem.setMensagem("CPF já cadastrado!");
                    return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
                }
                if(existeEmailAluno){
                    mensagem.setMensagem("E-mail já cadastrado!");
                    return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
                }
                if(aluno.getNome() == null || aluno.getNome().isEmpty()){
                    mensagem.setMensagem("O nome do aluno é obrigatório!");
                    return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
                }
                 
                if(aluno.getDataNascimento() != null && !aluno.getDataNascimento().isBefore(LocalDate.now())){
                    mensagem.setMensagem("A data de nascimento do aluno é obrigatório!");
                    return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
                }
                if(aluno.getEmail() == null || aluno.getEmail().isEmpty()){
                    mensagem.setMensagem("O e-mail do aluno é obrigatório!");
                    return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
                }
                if(aluno.getEndereco().getPais() == null || aluno.getEndereco().getPais().isEmpty()) {
                    mensagem.setMensagem("O nacionalidade do aluno é obrigatório");
                    return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
                }
                if(aluno.getEndereco().getUf() == null || aluno.getEndereco().getUf().isEmpty()) {
                    mensagem.setMensagem("O estado do aluno é obrigatório");
                    return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
                } 
                if (aluno.getPosicoes() == null || aluno.getPosicoes().isEmpty()) {
                    mensagem.setMensagem("O aluno precisa ter no mínimo uma posição.");
                    return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
                }
                if(aluno.getSubDivisao().isEmpty() || aluno.getSubDivisao().size() <= 0 || aluno.getSubDivisao() == null) {
                    mensagem.setMensagem("O aluno precisa ter no minímo uma sub divisão.");
                    return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
                }
                if (aluno.getPernaRuim() == null || aluno.getPernaRuim() < 0) {
                    mensagem.setMensagem("O aluno precisa ter uma nota em perna ruim.");
                    return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
                }
                if(aluno.getPernaBoa() == null) {
                    mensagem.setMensagem("O aluno precisa ter uma perna boa.");
                    return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
                }
                if(aluno.getFintas() < 0 || aluno.getFintas() == null) {
                    mensagem.setMensagem("O aluno precisa ter uma nota em fintas.");
                    return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
                }
                if(aluno.getAltura() < 0 || aluno.getAltura() == null){
                    mensagem.setMensagem("O aluno precisa ter uma altura.");
                    return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
                }
                if(aluno.getPeso() < 0 || aluno.getPeso() == null){
                    mensagem.setMensagem("O aluno precisa ter um peso");
                    return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
                }
    
                enderecoRepository.save(aluno.getEndereco());
                repository.save(aluno);
            
                return new ResponseEntity<>(aluno, HttpStatus.CREATED);
            }
            else {
                mensagem.setMensagem("O endereço do aluno está incorreto/inválido.");
                return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            mensagem.setMensagem("Ocorreu um erro ao salvar o aluno: " + e.getMessage());
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        
    }

    @Override
    public ResponseEntity<?> editar(Aluno aluno) {
        throw new UnsupportedOperationException("Unimplemented method 'editar'");
    }

    @Override
    public ResponseEntity<?> deletar(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'deletar'");
    }

    @Override
    public ResponseEntity<?> editarEndereco(Long id, Endereco endereco) {
        throw new UnsupportedOperationException("Unimplemented method 'editarEndereco'");
    }
    
}
