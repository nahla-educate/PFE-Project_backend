package com.myProject.demo.model;



import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table
public class Notification {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @Column(name = "value", nullable = false) 
		private String value;
	    
	    //@Column(name = "checkOn",columnDefinition="BOOLEAN DEFAULT false")
	    @Column(name = "statut")
	    private boolean statut;
	    
	    @Column(name = "created_on")
	    private Date createdDate = new Date(System.currentTimeMillis());
	         
	    @ManyToOne(cascade = CascadeType.ALL)
	 	@JoinColumn( name = "id_condidat", referencedColumnName = "id")
	 	private User candidat;
	    
	    @NotBlank
	    private String username;
	    
	    @Column(name = "poste")
	    private String poste;
	    
	    @Column(name = "dateDebut")
	    private String dateDebut;
	     
	     
	    @Column(name = "society")
	    private String society;

		public Notification() {
			super();
		}


		

			public Notification(Long id, String value, boolean statut, Date createdDate, User candidat,
				@NotBlank String username, String poste, String dateDebut, String society) {
			super();
			this.id = id;
			this.value = value;
			this.statut = statut;
			this.createdDate = createdDate;
			this.candidat = candidat;
			this.username = username;
			this.poste = poste;
			this.dateDebut = dateDebut;
			this.society = society;
		}




			public boolean isStatut() {
			return statut;
		}


		public void setStatut(boolean statut) {
			this.statut = statut;
		}


		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public User getCandidat() {
			return candidat;
		}

		public void setCandidat(User candidat) {
			this.candidat = candidat;
		}





		public Date getCreatedDate() {
			return createdDate;
		}





		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}


		public String getUsername() {
			return username;
		}


		public void setUsername(String username) {
			this.username = username;
		}


		public String getPoste() {
			return poste;
		}


		public void setPoste(String poste) {
			this.poste = poste;
		}


		public String getDateDebut() {
			return dateDebut;
		}


		public void setDateDebut(String dateDebut) {
			this.dateDebut = dateDebut;
		}




		public String getSociety() {
			return society;
		}




		public void setSociety(String society) {
			this.society = society;
		}



	
		
	      
   
}