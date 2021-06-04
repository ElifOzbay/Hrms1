package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="activationCodes")
@AllArgsConstructor
@NoArgsConstructor
public class VerificationCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="activationCode")
	private String verificationCode;
	
	
	@Column(name="isConfirmed",columnDefinition="boolean default false")
	private boolean isConfirmed;
	
	@Column(name="confirmedDate")
	private LocalDate confirmedDate=LocalDate.now();
}
