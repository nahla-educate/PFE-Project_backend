package com.myProject.demo.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myProject.demo.model.Partenaire;

@Repository
public interface PartenaireRepository extends JpaRepository<Partenaire, Long>  {

    Optional<Partenaire> findPartenaireById(Long id);
	  
	  @Query(
				value = "SELECT * FROM partenaire WHERE etat= 'valide'",
				nativeQuery = true)
		List<Partenaire> findPartenaireValide();
}