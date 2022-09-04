package jomrepspring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jomrepspring.domain.Socios;
import jomrepspring.repository.SociosRepository;

@Service
public class SociosService {

	//D.I
	@Autowired
	private SociosRepository repository;

	public List<Socios> buscarTodos() {
		return this.repository.findAll();
	}
}