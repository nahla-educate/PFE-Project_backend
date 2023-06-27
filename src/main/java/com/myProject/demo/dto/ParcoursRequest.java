package com.myProject.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class ParcoursRequest {
    
    private String diplome;
    private String anneediplome;

    private String universitydiplome;

	public String getDiplome() {
		return diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

	public String getAnneediplome() {
		return anneediplome;
	}

	public void setAnneediplome(String anneediplome) {
		this.anneediplome = anneediplome;
	}

	public String getUniversitydiplome() {
		return universitydiplome;
	}

	public void setUniversitydiplome(String universitydiplome) {
		this.universitydiplome = universitydiplome;
	}

  }

  