package com.devsuperior.dspesquisa.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dspesquisa.dto.RecordDTO;
import com.devsuperior.dspesquisa.dto.RecordInsertDTO;
import com.devsuperior.dspesquisa.entities.Game;
import com.devsuperior.dspesquisa.entities.Record;
import com.devsuperior.dspesquisa.repositories.GameRepository;
import com.devsuperior.dspesquisa.repositories.RecordRepository;

@Service
public class RecordService {
	
	@Autowired
	private RecordRepository recordRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional
	public RecordDTO insert(RecordInsertDTO recordInsertDTO) {
		Record entityRecord= new Record();
		entityRecord.setName(recordInsertDTO.getName());
		entityRecord.setAge(recordInsertDTO.getAge());
		entityRecord.setMoment(Instant.now());
		
		Game game= gameRepository.getOne(recordInsertDTO.getGameId());
		entityRecord.setGame(game);
		
		entityRecord= recordRepository.save(entityRecord);
		
		return new RecordDTO(entityRecord);
		
	}
	

}
