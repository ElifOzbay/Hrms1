package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="jobAdvertisement")
public class JobAdvert {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="jobAdvertName")
	private String jobAdvertName;
	
	@Column(name = "jobDescription")
	private String jobDescription;
	
	@Column(name="minPayment")
	private int minPayment;
	
	@Column(name="maxPayment")
	private int maxPayment;
	
	@Column(name="openPositionCount")
	private int openPositionCount;
	
	@Column (name="applicationDeadline")
	private LocalDate applicationDeadline;
	
	@Column(name="releaseDate")
	private LocalDate releaseDate;
	
	@Column(name="isActive",columnDefinition="boolean default true")
	private boolean isActive;
	
	@ManyToOne()
	@JoinColumn(name = "jobPositionId")
	private JobPosition jobPosition;
	
	@ManyToOne()
	@JoinColumn(name = "cityId")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name = "employerId")
	private Employer employer;


	
}
