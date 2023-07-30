package com.soulcode.vendas.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soulcode.vendas.models.Venda;
import com.soulcode.vendas.models.dtos.VendaDTO;
import com.soulcode.vendas.repositories.VendaRepository;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    // Criar venda
    public VendaDTO save(VendaDTO dto) {
        Venda venda = VendaDTO.convert(dto);
        for(int i = 0; i < venda.getItens().size(); i++) {
            venda.getItens().get(i).setVenda(venda);
        }
        venda = this.vendaRepository.save(venda);
        return new VendaDTO(venda);
    }

    // Buscar venda por Id
    public VendaDTO findById(Long id) {
        Optional<Venda> venda = this.vendaRepository.findById(id);
        if(venda.isEmpty()) {
            throw new RuntimeException("Não foi encontrada nenhuma venda");
        } else {
            return new VendaDTO(venda.get());
        }
    }
    
    // Buscar todas as vendas
    public List<VendaDTO> findAll() {
        List<Venda> venda = this.vendaRepository.findAll();
        return venda.stream().map(VendaDTO::new).collect(Collectors.toList());
    }
}
