package com.harman.springboot.demo.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import com.harman.springboot.demo.domain.Country
import com.harman.springboot.demo.domain.State
import com.harman.springboot.demo.repository.CountryRepository
import com.harman.springboot.demo.repository.StateRepository


@Service
class StateService {
	@Autowired
	StateRepository stateRepository
	
	@Autowired
	CountryRepository countryRepository

	def save(State state){
		//Load persistent country entity from db
		Country country=countryRepository.findByCountryId(state.getCountry().getCountryId())
		state.setCountry(country)
		stateRepository.save(state)
	}
	
	def list(){
		return stateRepository.findAll();
	}
	
	def get(Long id){
		return stateRepository.findByStateId(id)
	}
	
	def update(State state){
		stateRepository.save(state)
	}
	
	def delete(Long id){
		State state=stateRepository.findByStateId(id)
		stateRepository.delete(state)
	}
}
